package com.joaomanoel.todosimple.security.services;

import com.joaomanoel.todosimple.domain.usecases.TokenGeneratorUseCases;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class JWTService implements TokenGeneratorUseCases {
    private final JwtEncoder encoder;

    public JWTService(JwtEncoder encoder) {
        this.encoder = encoder;
    }

    public String genToken(String username){
        Instant now = Instant.now();
        long expiry = 36000L;

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("todosimple")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiry))
                .subject(username)
                .build();

        return this.encoder.encode(
                        JwtEncoderParameters.from(claims))
                .getTokenValue();
    }
}
