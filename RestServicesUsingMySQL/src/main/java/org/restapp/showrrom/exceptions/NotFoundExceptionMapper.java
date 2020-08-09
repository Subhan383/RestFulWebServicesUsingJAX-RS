package org.restapp.showrrom.exceptions;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;

import javax.ws.rs.ext.ExceptionMapper;

import org.restapp.showrrom.model.ErrorPayLoad;

public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {

	@Override
	public Response toResponse(NotFoundException exception) {
		ErrorPayLoad error = new ErrorPayLoad(404, "Not Found Exception");
		return Response.status(javax.ws.rs.core.Response.Status.NOT_FOUND).entity(error).build();
	}

}
