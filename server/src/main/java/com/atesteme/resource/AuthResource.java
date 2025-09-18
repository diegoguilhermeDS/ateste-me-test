package com.atesteme.resource;

import com.atesteme.dto.AuthRequestDTO;
import com.atesteme.dto.AuthResponseDTO;
import com.atesteme.entity.User;
import com.atesteme.service.AuthService;

import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/auth")
public class AuthResource {
    private final AuthService authService;

    @Inject
    public AuthResource(AuthService authService) {
        this.authService = authService;
    }

    @POST
    public Response login(AuthRequestDTO dto) {
        
        String token = authService.authenticate(dto);

        if (token != null) {
            return Response.ok()
                    .entity(new AuthResponseDTO(token))
                    .build();
        }

        return Response.status(Response.Status.UNAUTHORIZED)
                .entity("Credenciais inválidas")
                .build();
    }
        
}
