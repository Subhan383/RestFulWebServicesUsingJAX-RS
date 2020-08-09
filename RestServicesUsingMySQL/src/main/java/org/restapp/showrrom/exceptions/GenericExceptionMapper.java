package org.restapp.showrrom.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import org.restapp.showrrom.model.ErrorPayLoad;

public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable exception) {
		ErrorPayLoad error = new ErrorPayLoad(500, "Internal Server Error Occured");
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(error).build();
	}

}
