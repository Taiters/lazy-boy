package com.dantait.lazyboy.ioc;

import com.dantait.lazyboy.LazyBoyConfiguration;
import com.dantait.lazyboy.config.MapDBConfiguration;
import com.dantait.lazyboy.data.IMapDBProvider;
import com.dantait.lazyboy.data.MapDBProvider;
import com.google.inject.AbstractModule;

public class MapDBModule extends AbstractModule {

	private final LazyBoyConfiguration configuration;
	public MapDBModule(LazyBoyConfiguration configuration) {
		this.configuration = configuration;
	}
	
	@Override
	protected void configure() {
		bind(MapDBConfiguration.class).toInstance(configuration.getMapDBConfiguration());
		bind(IMapDBProvider.class).to(MapDBProvider.class);
	}

}
