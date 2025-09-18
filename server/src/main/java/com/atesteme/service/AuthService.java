package com.atesteme.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import org.mindrot.jbcrypt.BCrypt;

import com.atesteme.dto.AuthRequestDTO;
import com.atesteme.entity.User;

@ApplicationScoped
public class AuthService {

    private static final String SECRET = "minhaChaveSecretaMuitoLongaParaJWT1234567890";
    private static final long EXPIRATION_MS = 3600_000; // 1 hora

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
    }

    @Transactional
    public String authenticate(AuthRequestDTO dto) {
        User found = User.find("email", dto.getEmail()).firstResult();

        if (found != null && BCrypt.checkpw(dto.getPassword(), found.getPassword())) {
            return generateToken(found.id);
        }

        return null;
    }

    private String generateToken(Long userId) {
        return Jwts.builder()
                .setSubject(String.valueOf(userId))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_MS))
                .signWith(getSigningKey())
                .compact();
    }
}
