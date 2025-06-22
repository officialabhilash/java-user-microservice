package com.example.user.core.filters;

import com.example.user.authentication.services.AuthenticationService;
import com.example.user.authentication.services.SessionService;
import com.example.user.core.exceptions.SessionStillActiveException;
import com.example.user.core.security.JwtUtility;
import com.example.user.users.entities.UserEntity;
import com.example.user.users.repository.UserRepository;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private JwtUtility jwtUtility;

    @Autowired
    private SessionService sessionService;

    @Autowired
    private Environment environment;

    @Autowired
    private UserRepository userRepository;

    private void validateSubjectSessionFromDb(UserDetails userDetails){
        // TODO: Complete this method to fetch session details from DB
        UserEntity userEntity = (UserEntity) userDetails;
        if (sessionService.isUserSessionActive(userEntity)) {
            authenticationService.closeUserSession(userDetails);
            userEntity.setIsEnabled(false);
            userRepository.save(userEntity);
            throw new SessionStillActiveException("Your session was active on another machine, hence your account is " +
                    "temporarily blocked for access. Contact Admin for further actions");
        }
    }

    private void loadSecurityContextOnValidSubject(String subject, HttpServletRequest request){
        if (subject != null) {
            // Token is valid, hence  get the user details from username
            UserDetails userDetails = authenticationService.loadUserByUsername(subject);
            // Check whether the session in db is valid or not, else throw error and close all sessions
            validateSubjectSessionFromDb(userDetails);
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                    userDetails,
                    null,
                    userDetails.getAuthorities()
            );
            ((UserEntity) auth.getPrincipal()).setPassword("");
            auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
    }

    private void authorizeViaAuthHeaders(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        String rawToken = null;
        String jwt = null;
        String subject = null;

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            rawToken = authHeader.substring(7); // "Bearer "
            Claims claims = jwtUtility.extractAllSignedClaims(rawToken).orElseThrow(() -> new ValidationException("Bad Token"));
            subject = claims.getSubject();
            System.out.println(subject);
        }
        loadSecurityContextOnValidSubject(subject, request);
    }

    private void authorizeViaCookies(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String accessCookieName = StringUtils.hasText(environment.getProperty("app.jwt.access-cookie-name")) ? environment.getProperty("app.jwt.access-cookie-name") : "JAccess";
        Optional<Cookie> authCookieValue = Arrays.stream(request.getCookies()).filter(x -> x.getName().equals(accessCookieName)).findFirst();
        String subject = null;

        if (authCookieValue.isPresent()) {
            Claims claims = jwtUtility.extractAllSignedClaims(authCookieValue.get().getValue()).orElseThrow(() -> new ValidationException("Bad Token"));
            subject = claims.getSubject();
        }
        loadSecurityContextOnValidSubject(subject, request);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        authorizeViaAuthHeaders(request, response, filterChain);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth instanceof AnonymousAuthenticationToken) {
            authorizeViaCookies(request, response, filterChain);
        }
        filterChain.doFilter(request, response);
    }
}
