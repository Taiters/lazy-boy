package com.dantait.lazyboy.core;

import static org.mockito.Mockito.*;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import com.dantait.lazyboy.api.Cluster;
import com.dantait.lazyboy.data.IClusterStore;

public class ClusterServiceTest {

	private ClusterService clusterService;
	private IClusterStore clusterStore;
	
	@Before
	public void setUp() {
		clusterStore = mock(IClusterStore.class);
		clusterService = new ClusterService(clusterStore);
	}
	
	@Test
	public void getClusterById_Calls_ClusterStore_With_Correct_Id() {
		final String id = "testID";
		
		clusterService.getClusterById(id);
		
		verify(clusterStore).get(id);
	}
	
	@Test
	public void getClusters_Calls_ClusterStore() {
		clusterService.getClusters();
		
		verify(clusterStore).get();
	}
	
	@Test
	public void addCluster_Calls_ClusterStore_With_Cluster() {
		ArrayList<String> nodeIpAddresses = new ArrayList<String>();
		nodeIpAddresses.add("192.168.1.1");
		Cluster cluster = new Cluster("a cluster", nodeIpAddresses);	
		when(clusterStore.add(cluster)).thenReturn(true);
		
		clusterService.addCluster(cluster);
		
		verify(clusterStore).add(cluster);
	}
	
	@Test
	public void addCluster_Adds_Generated_Id_To_Cluster() {
		ArrayList<String> nodeIpAddresses = new ArrayList<String>();
		nodeIpAddresses.add("192.168.1.1");
		Cluster cluster = new Cluster("a cluster", nodeIpAddresses);
		cluster.setId(null);
		when(clusterStore.add(cluster)).thenReturn(true);
		
		clusterService.addCluster(cluster);
		
		assertThat(cluster.getId(), notNullValue());
	}
	
	@Test
	public void addCluster_Returns_Generated_Id() {
		ArrayList<String> nodeIpAddresses = new ArrayList<String>();
		nodeIpAddresses.add("192.168.1.1");
		Cluster cluster = new Cluster("a cluster", nodeIpAddresses);
		cluster.setId(null);
		when(clusterStore.add(cluster)).thenReturn(true);
		
		String returnedId = clusterService.addCluster(cluster);
		
		assertThat(returnedId, is(cluster.getId()));
	}
	
	@Test
	public void addCluster_Returns_Null_When_Adding_Fails() {
		ArrayList<String> nodeIpAddresses = new ArrayList<String>();
		nodeIpAddresses.add("192.168.1.1");
		Cluster cluster = new Cluster("a cluster", nodeIpAddresses);
		when(clusterStore.add(cluster)).thenReturn(false);
		
		String returnedId = clusterService.addCluster(cluster);
		
		assertThat(returnedId, nullValue());
	}
}
