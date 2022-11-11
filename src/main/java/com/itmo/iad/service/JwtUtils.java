package com.itmo.iad.service;


import com.itmo.iad.payload.JwtAuthentication;
import com.itmo.iad.model.ERole;
import io.jsonwebtoken.Claims;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JwtUtils {

    public static JwtAuthentication generate(Claims claims) {
        final JwtAuthentication jwtInfoToken = new JwtAuthentication();
        jwtInfoToken.setERoles(getRoles(claims));
        jwtInfoToken.setFirstName(claims.get("firstName", String.class));
        jwtInfoToken.setUsername(claims.getSubject());
        return jwtInfoToken;
    }

    private static Set<ERole> getRoles(Claims claims) {
        final List<Map> roles = claims.get("roles", List.class);
        List<String> rolesList= new ArrayList<>();
        for (Map role: roles)
        {
            rolesList.add(role.get("name").toString());
        }

        return rolesList.stream()
                .map(ERole::valueOf)
                .collect(Collectors.toSet());
    }

}
