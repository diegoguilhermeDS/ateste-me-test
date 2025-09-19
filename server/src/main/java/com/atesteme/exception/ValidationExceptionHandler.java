package com.atesteme.exception;

import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ValidationExceptionHandler implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException exception) {
        // Mapeia os erros para uma lista de mensagens
        var errors = exception.getConstraintViolations()
                              .stream()
                              .map(cv -> cv.getPropertyPath() + ": " + cv.getMessage())
                              .toList();

        // Retorna um JSON com status 400 e os erros
        return Response.status(Response.Status.BAD_REQUEST)
                       .entity(errors)
                       .build();
    }
}
