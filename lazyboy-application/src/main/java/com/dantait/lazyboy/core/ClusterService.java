package com.dantait.lazyboy.core;

import java.util.List;
import java.util.UUID;

import com.dantait.lazyboy.api.Cluster;
import com.dantait.lazyboy.data.IClusterStore;
import com.google.inject.Inject;

public class ClusterService implements IClusterService {

	private final IClusterStore clusterStore;
	
	@Inject
	public ClusterService(IClusterStore clusterStore) {
		this.clusterStore = clusterStore;
	}
	
	@Override
	public String addCluster(Cluster cluster) {
		String id = UUID.randomUUID().toString();
		cluster.setId(id);
		
		if (clusterStore.add(cluster))
			return id;
		
		return null;
	}

	@Override
	public Cluster getClusterById(String id) {
		return clusterStore.get(id);
	}

	@Override
	public List<Cluster> getClusters() {
		return clusterStore.get();
	}

}
