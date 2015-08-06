package com.dantait.lazyboy.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import com.dantait.lazyboy.api.Cluster;

public class MapDBClusterStore extends MapDBStore implements IClusterStore {

	private static final String STORE_NAME = "clusters";
	
	@Override
	protected String getStoreName() {
		return STORE_NAME;
	}
	
	@Override
	public boolean add(Cluster cluster) {
		String serializedCluster = serialize(cluster);
		
		if (serializedCluster == null)
			return false;
		
		map.put(cluster.getId(), serializedCluster);
		dbProvider.getDB().commit();
		
		return true;
	}

	@Override
	public Cluster get(String id) {
		return deserialize(map.get(id), Cluster.class);
	}

	@Override
	public List<Cluster> get() {
		Collection<String> clusterData = map.values();
		ArrayList<Cluster> clusters = new ArrayList<Cluster>();
		
		Iterator<String> it = clusterData.iterator();
		while(it.hasNext()) {
			clusters.add(deserialize(it.next(), Cluster.class));
		}
		
		return clusters;
	}
}
