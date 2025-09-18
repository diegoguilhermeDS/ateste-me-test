package com.atesteme.service;

import com.atesteme.dto.UserRequestDTO;
import com.atesteme.dto.UserResponseDTO;
import com.atesteme.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import org.mindrot.jbcrypt.BCrypt;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

@ApplicationScoped
public class UserService {

    private static final String SECRET = "minhaChaveSecretaMuitoLongaParaJWT1234567890";
    
    @Transactional
    public Response createUser(UserRequestDTO dto) {
        Optional<User> existingUser = User.find("email", dto.getEmail()).firstResultOptional();
        if (existingUser.isPresent()) {
            return Response.status(Response.Status.CONFLICT)
                           .entity("E-mail já cadastrado")
                           .build();
        }

        User user = dto.toEntity();
        user.setPassword(BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt()));
        user.persist();

        // Retorna DTO de resposta sem senha
        UserResponseDTO responseDTO = new UserResponseDTO(user);
        return Response.status(Response.Status.CREATED).entity(responseDTO).build();
    }

    @Transactional
    public User getLoggedUser(String token) {
        if (token == null || !token.startsWith("Bearer ")) {
            return null;
        }

        token = token.substring(7);

        Claims claims = Jwts.parserBuilder()
                .setSigningKey(SECRET.getBytes(StandardCharsets.UTF_8))
                .build()
                .parseClaimsJws(token)
                .getBody();

        Long userId = Long.parseLong(claims.getSubject());
        return User.findById(userId);
    }
}
