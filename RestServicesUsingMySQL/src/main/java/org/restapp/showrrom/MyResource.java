package org.restapp.showrrom;

import javax.servlet.ServletContext;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/")
public class MyResource {

	@Context
	UriInfo uri;

	@Context
	ServletContext context;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt() {
		return "Welcome To WebServices Project";
	}
	
	@GET
	@Path("query")
	public Response headerInfo(@HeaderParam("Cache-Control") String header,@HeaderParam("User-Agent") String userAgent  ) {
		String response="Header value for header is:"+header+"Header value for UserAgent is:"+userAgent;
		return Response.status(200).entity(response).build();
	}
	
	@GET
	@Path("/header")
	public String customHeader(@HeaderParam("custom-header") String header,@CookieParam("Cookie-Value") String cookie) {
		return "Header value is:"+header+" "+"Cookie value is:"+cookie;
	}

	@Path("/UriHeaders")
	@Produces(MediaType.TEXT_PLAIN)
	public String getHeaders(@Context HttpHeaders header) {
		return header.getRequestHeaders().keySet().toString();
	}
}
