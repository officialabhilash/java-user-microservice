package com.example.user.users.controllers;

import com.example.user.core.base.utils.SetCookiesUtil;
import com.example.user.core.security.JwtUtility;
import com.example.user.users.dto.AuthTokenDto;
import com.example.user.users.dto.UserAuthenticationDto;
import com.example.user.users.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.header.Header;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/authentication")
@Tag(name = "Authentication", description = "APIs for managing authentication.")
public class Authentication {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtility jwtUtility;

    @Autowired
    private Environment environment;

    //    @Operation(summary = "Authenticate using user credentials", description = "Returns refresh and access tokens.")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Successfully logged in."),
//            @ApiResponse(responseCode = "400", description = "Invalid credentials")
//    })
    @PostMapping("authenticate/")
    public ResponseEntity<Map<String, String>> authenticate(@RequestBody UserAuthenticationDto userDto, HttpServletResponse response) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userDto.getUsername(),
                            userDto.getPassword()));

            UserDetails userDetails = userService.loadUserByUsername(userDto.getUsername());
            String access = jwtUtility.generateToken(userDetails.getUsername());
            String accessCookieName = StringUtils.hasText(environment.getProperty("app.jwt.access-cookie-name")) ? environment.getProperty("app.jwt.access-cookie-name") : "JAccess";
            int accessJwtLifetime = Integer.parseInt(StringUtils.hasText(environment.getProperty("spring.application.jwt.access-token-lifetime")) ? environment.getProperty("spring.application.jwt.access-token-lifetime") : "5");
            // Set cookies now
            ResponseCookie responseCookie = SetCookiesUtil.setCookie(accessCookieName, access, (accessJwtLifetime) * 60);
            return ResponseEntity
                    .ok()
                    .header(HttpHeaders.SET_COOKIE, responseCookie.toString())
                    .body(Map.of("token", access));

        } catch (Exception e) {
            System.out.println("error occurred:- ");
            for (StackTraceElement trace : e.getStackTrace()) {
                System.out.println(trace.toString());
            }
            return ResponseEntity
                    .badRequest()
                    .body(Map.of("detail","Bad Credentials provided."));
        }
    }

    @PostMapping("refresh/")
    public ResponseEntity<?> refreshToken(@RequestBody AuthTokenDto authTokenDto) {
        try {
            String jwt = jwtUtility.refreshToken(authTokenDto.getRefresh());
            authTokenDto.setAccess(jwt);
            return new ResponseEntity<>(authTokenDto, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("error occurred");
            return new ResponseEntity<>("Bad Credentials provided.", HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Forgot password", description = "Changes password for the logged in user.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Email Successfully sent."),
            @ApiResponse(responseCode = "400", description = "Invalid credentials")
    })
    @PostMapping("forgot-password/")
    public ResponseEntity<Map<String, String>> forgotPassword(@RequestBody UserAuthenticationDto userDto) {
        return new ResponseEntity<>(Map.of("message", "success"), HttpStatus.OK);
    }
}
