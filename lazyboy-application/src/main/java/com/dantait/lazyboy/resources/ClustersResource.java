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
import com.dantait.lazyboy.api.Cluster;
import com.dantait.lazyboy.core.IClusterService;
import com.google.inject.Inject;

@Path("/clusters")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClustersResource {

	private final IClusterService clusterService;
	
	@Inject
	public ClustersResource(IClusterService clusterService) {
		this.clusterService = clusterService;
	}
	
	@GET
	public List<Cluster> getClusters() {
		return clusterService.getClusters();
	}
	
	@GET
	@Path("/{id}")
	public Cluster getCluster(@PathParam("id") String id) {
		Cluster cluster = clusterService.getClusterById(id);
		
		if (cluster == null)
			throw new NotFoundException();
		
		return cluster;
	}
	
	@POST
	public Response addCluster(Cluster cluster) {
		
		String id = clusterService.addCluster(cluster);
		
		return Response.created(UriBuilder.fromMethod(ClustersResource.class, "getCluster")
										  .build(id))
					   .build();
	}
}
