package com.itmo.iad.model;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@RequiredArgsConstructor
public enum ERole implements GrantedAuthority {

    ADMIN("ADMIN"),
    USER("USER"), CERTIFIED("CERTIFIED");

    private final String value;

    @Override
    public String getAuthority() {
        return value;
    }

}
