package com.dantait.lazyboy;

import org.hibernate.validator.constraints.NotEmpty;

import com.dantait.lazyboy.config.MapDBConfiguration;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

public class LazyBoyConfiguration extends Configuration {
	@NotEmpty
    private String dbEngine;
	
	private MapDBConfiguration mapDBConfig;

	@JsonProperty
	public String getDbEngine() {
		return dbEngine;
	}

	@JsonProperty
	public void setDbEngine(String dbEngine) {
		this.dbEngine = dbEngine;
	}

	@JsonProperty("fileDB")
	public MapDBConfiguration getMapDBConfiguration() {
		return mapDBConfig;
	}

	@JsonProperty("fileDB")
	public void setMapDBConfiguration(MapDBConfiguration mapDBDatabaseFactory) {
		this.mapDBConfig = mapDBDatabaseFactory;
	}
	
	
}
