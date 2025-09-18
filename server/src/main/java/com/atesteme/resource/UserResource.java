package com.atesteme.resource;

import com.atesteme.entity.User;
import com.atesteme.security.Secured;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @GET
    @Path("/{id}")
    @Secured
    public User findById(@PathParam("id") Long id) {
        return User.findById(id);
    }

    @POST
    @Transactional
    public User create(User user) {
        user.persist();
        return user;
    }
}
