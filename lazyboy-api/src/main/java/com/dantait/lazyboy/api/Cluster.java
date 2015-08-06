package com.dantait.lazyboy.api;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cluster {

	private List<String> nodeIpAddresses;
	private String name;
	private String id;
	
	public Cluster() {}
	
	public Cluster(String name, List<String> nodeIpAddresses) {
		this.name = name;
		this.nodeIpAddresses = nodeIpAddresses;
	}
	
	public Cluster(String id, String name, List<String> nodeIpAddresses) {
		this.id = id;
		this.name = name;
		this.nodeIpAddresses = nodeIpAddresses;
	}

	public List<String> getNodeIpAddresses() {
		return nodeIpAddresses;
	}

	@JsonProperty
	public void setNodeIpAddresses(List<String> nodeIpAddresses) {
		this.nodeIpAddresses = nodeIpAddresses;
	}

	@JsonProperty
	public String getName() {
		return name;
	}

	@JsonProperty
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty
	public String getId() {
		return id;
	}

	@JsonProperty
	public void setId(String id) {
		this.id = id;
	}
	
	
}
