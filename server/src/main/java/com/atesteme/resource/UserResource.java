package com.atesteme.resource;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import com.atesteme.dto.UserRequestDTO;
import com.atesteme.dto.UserResponseDTO;
import com.atesteme.entity.User;
import com.atesteme.service.UserService;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    private final UserService userService;

    @Inject
    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GET
    @Path("/me")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Busca o usuário logado")
    @APIResponse(responseCode = "200", description = "Usuário encontrado")
    public Response getLoggedUser(@Context jakarta.ws.rs.core.HttpHeaders headers) {
        String token = null;
        java.util.List<String> authHeaders = headers.getRequestHeader("Authorization");
        if (authHeaders != null && !authHeaders.isEmpty()) {
            token = authHeaders.get(0);
        }
        if (token == null) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        User user = userService.getLoggedUser(token);
        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        UserResponseDTO response = new UserResponseDTO(user);
        return Response.ok(response).build();
    }    
        
    @POST
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Cria um novo usuário")
    @APIResponse(responseCode = "201", description = "Usuário criado com sucesso")
    public Response createUser(@Valid UserRequestDTO dto) {
        return userService.createUser(dto);
    }
}
