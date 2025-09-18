package com.atesteme.resource;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import com.atesteme.entity.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/auth")
public class AuthResource {
    
    private static final String SECRET = "minhaChaveSecretaMuitoLongaParaJWT1234567890";

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
    }


    @POST
    @Path("/login")
    public Response login(User user) {
        User found = User.find("email", user.email).firstResult();

        if (found != null && found.password.equals(user.password)) {
            String token = Jwts.builder()
                    .setSubject(String.valueOf(found.id))
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 3600_000)) // 1 hora de validade
                    .signWith(getSigningKey())
                    .compact();

            return Response.ok()
                    .header("Authorization", "Bearer " + token)
                    .entity("SUCESSO! VOCÊ ESTÁ LOGADO")
                    .build();
        }

        return Response.status(Response.Status.UNAUTHORIZED)
                .entity("Credenciais inválidas")
                .build();
    }
}
