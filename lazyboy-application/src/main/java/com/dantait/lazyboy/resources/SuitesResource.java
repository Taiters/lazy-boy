package com.dantait.lazyboy.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import com.dantait.lazyboy.api.Suite;
import com.dantait.lazyboy.core.ISuiteService;
import com.google.inject.Inject;

@Path("/suites")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SuitesResource {

	private final ISuiteService suiteService;
	
	@Inject
	public SuitesResource(ISuiteService suiteService) {
		this.suiteService = suiteService;
	}
	
	@GET
	public List<Suite> getSuites() {
		return suiteService.getSuites();
	}
	
	@GET
	@Path("/{id}")
	public Suite getSuite(@PathParam("id") String id) {
		Suite suite = suiteService.getSuiteById(id);
		
		if (suite == null)
			throw new NotFoundException();
		
		return suite;
	}
	
	@POST
	public Response addSuite(Suite suite) {
		String id = suiteService.addSuite(suite);
		
		return Response.created(UriBuilder.fromMethod(SuitesResource.class, "getSuite")
										  .build(id))
						.build();
	}
}
