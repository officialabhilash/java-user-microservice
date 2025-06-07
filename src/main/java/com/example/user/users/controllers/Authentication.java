package com.example.user.users.controllers;

import com.example.user.core.security.JwtUtility;
import com.example.user.users.dto.AuthTokenDto;
import com.example.user.users.dto.UserAuthenticationDto;
import com.example.user.users.dto.UserDto;
import com.example.user.users.entities.UserEntity;
import com.example.user.users.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
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

    //    @Operation(summary = "Authenticate using user credentials", description = "Returns refresh and access tokens.")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Successfully logged in."),
//            @ApiResponse(responseCode = "400", description = "Invalid credentials")
//    })
    @PostMapping("authenticate/")
    public ResponseEntity<?> authenticate(@RequestBody UserAuthenticationDto userDto) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userDto.getUsername(),
                            userDto.getPassword()));

            UserDetails userDetails = userService.loadUserByUsername(userDto.getUsername());
            String jwt = jwtUtility.generateToken(userDetails.getUsername());
            return new ResponseEntity<>(Map.of("access", jwt), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("error occurred");
            return new ResponseEntity<>("Bad Credentials provided.", HttpStatus.BAD_REQUEST);
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
    public ResponseEntity<UserDto> forgotPassword(@RequestBody UserAuthenticationDto userDto) {
        return new ResponseEntity(Map.of("message", "success"), HttpStatus.OK);
    }
}
