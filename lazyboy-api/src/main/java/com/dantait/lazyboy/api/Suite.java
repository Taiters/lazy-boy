package com.dantait.lazyboy.api;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Suite {
	
	private List<Cluster> clusters;
	private String name;
	private String id;
	
	public Suite() {}
	
	public Suite(String name, List<Cluster> clusters) {
		this.name = name;
		this.clusters = clusters;
	}
	
	public Suite(String id, String name, List<Cluster> clusters) {
		this.id = id;
		this.name = name;
		this.clusters = clusters;
	}

	public List<Cluster> getClusters() {
		return clusters;
	}

	@JsonProperty
	public void setClusters(List<Cluster> clusters) {
		this.clusters = clusters;
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
