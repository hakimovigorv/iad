package com.itmo.iad.controller;


import com.itmo.iad.payload.JwtAuthentication;
import com.itmo.iad.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class Controller {

    private final AuthService authService;

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("hello/user")
    public ResponseEntity<String> helloUser() {
        final JwtAuthentication authInfo = authService.getAuthInfo();
        return ResponseEntity.ok("Hello user " + authInfo.getPrincipal() + "!");
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("hello/admin")
    public ResponseEntity<String> helloAdmin() {
        final JwtAuthentication authInfo = authService.getAuthInfo();
        return ResponseEntity.ok("Hello admin " + authInfo.getPrincipal() + "!");
    }

}