package com.dantait.lazyboy.config;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MapDBConfiguration {

	@NotEmpty
	private String path;

	@JsonProperty
	public String getPath() {
		return path;
	}

	@JsonProperty
	public void setPath(String path) {
		this.path = path;
	}
}
