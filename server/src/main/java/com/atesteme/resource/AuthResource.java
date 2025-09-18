package com.atesteme.resource;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import com.atesteme.dto.AuthRequestDTO;
import com.atesteme.dto.AuthResponseDTO;
import com.atesteme.service.AuthService;

import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.MediaType;

@Path("/auth")
public class AuthResource {
    private final AuthService authService;

    @Inject
    public AuthResource(AuthService authService) {
        this.authService = authService;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Autentica um usuário e retorna um token JWT")
    @APIResponse(responseCode = "200", description = "Autenticação bem-sucedida")
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
