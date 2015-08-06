package com.dantait.lazyboy.core;

import java.util.List;

import com.dantait.lazyboy.api.Cluster;

public interface IClusterService {
	
	public String addCluster(Cluster cluster);
	public Cluster getClusterById(String id);
	public List<Cluster> getClusters();
	
}
