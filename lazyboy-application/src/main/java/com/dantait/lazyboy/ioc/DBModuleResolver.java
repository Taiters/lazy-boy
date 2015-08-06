package com.dantait.lazyboy.ioc;

import com.dantait.lazyboy.LazyBoyConfiguration;
import com.google.inject.AbstractModule;

public class DBModuleResolver {
	
	private enum DBEngine {
		FILEDB
	}

	private final LazyBoyConfiguration configuration;
	
	public DBModuleResolver(LazyBoyConfiguration configuration) {
		this.configuration = configuration;
	}
	
	public AbstractModule resolve() {
		DBEngine engine = DBEngine.valueOf(configuration.getDbEngine().toUpperCase());
		switch(engine) {
			case FILEDB:
				return new MapDBModule(configuration);
			default:
				return null;
		}
	}
}
