package com.example.user.users.controllers;

import com.example.user.users.dto.UserAuthenticationDto;
import com.example.user.users.dto.UserDto;
import com.example.user.users.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication")
@Tag(name = "Authentication", description = "APIs for managing authentication.")
public class Authentication {

    @Autowired
    private UserService userService;

    @Operation(summary = "Authenticate using user credentials", description = "Returns refresh and access tokens.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully logged in."),
            @ApiResponse(responseCode = "400", description = "Invalid credentials")
    })
    @PostMapping("/")
    public ResponseEntity<UserAuthenticationDto> authenticate(@RequestBody UserAuthenticationDto userDto){
        return new ResponseEntity(HttpStatus.OK);
    }

    @Operation(summary = "Forgot password", description = "Sends an email to user on their registered email id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Email Successfully sent."),
            @ApiResponse(responseCode = "400", description = "Invalid credentials")
    })
    @PostMapping("forgot-password/")
    public ResponseEntity<UserDto> forgotPassword(@RequestBody UserDto userDto){
        return new ResponseEntity(HttpStatus.OK);
    }
}
