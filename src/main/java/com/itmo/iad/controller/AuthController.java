package com.itmo.iad.controller;


import com.itmo.iad.model.ERole;
import com.itmo.iad.model.Role;
import com.itmo.iad.model.User;
import com.itmo.iad.payload.request.JwtRequest;
import com.itmo.iad.payload.request.SignUpRequest;
import com.itmo.iad.payload.response.JwtResponse;
import com.itmo.iad.payload.request.RefreshJwtRequest;
import com.itmo.iad.payload.response.MessageResponse;
import com.itmo.iad.service.AuthService;
import com.itmo.iad.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    @PostMapping("login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest authRequest) {
        final JwtResponse token = authService.login(authRequest);
        return ResponseEntity.ok(token);
    }

    @PostMapping("token")
    public ResponseEntity<JwtResponse> getNewAccessToken(@RequestBody RefreshJwtRequest request) {
        final JwtResponse token = authService.getAccessToken(request.getRefreshToken());
        return ResponseEntity.ok(token);
    }

    @PostMapping("refresh")
    public ResponseEntity<JwtResponse> getNewRefreshToken(@RequestBody RefreshJwtRequest request) {
        final JwtResponse token = authService.refresh(request.getRefreshToken());
        return ResponseEntity.ok(token);
    }

    @PostMapping("register")
    public ResponseEntity<?> register(@RequestBody SignUpRequest signUpRequest) {
        if (userService.existsByLogin(signUpRequest.getLogin())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        return ResponseEntity.ok(new MessageResponse(userService.registerUser(User.builder()
                .login(signUpRequest.getLogin())
                .password(signUpRequest.getPassword())
                .firstName(signUpRequest.getFirstName())
                .lastName(signUpRequest.getLastName())
                .certified(false)
                .build()))
        );
    }

}
