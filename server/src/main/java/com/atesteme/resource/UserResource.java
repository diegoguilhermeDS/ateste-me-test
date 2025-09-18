package com.atesteme.resource;

import com.atesteme.entity.User;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {
    @GET
    @Path("/{id}")
    public User findById(@PathParam("id") Long id) {
        return User.findById(id);
    }

    @POST
    @Transactional
    public User create(User user) {
        user.persist();
        return user;
    }

    @POST
    @Path("/login")
    public String login(User user) {
        User found = User.find("email", user.email).firstResult();
        if (found != null && found.password.equals(user.password)) {
            return "SUCESSO! VOCÊ ESTÁ LOGADO";
        }
        throw new WebApplicationException("Credenciais inválidas", 401);
    }
}
