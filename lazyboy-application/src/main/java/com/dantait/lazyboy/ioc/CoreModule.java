package com.dantait.lazyboy.ioc;

import com.dantait.lazyboy.LazyBoyConfiguration;
import com.dantait.lazyboy.core.ClusterService;
import com.dantait.lazyboy.core.IClusterService;
import com.dantait.lazyboy.core.ISuiteService;
import com.dantait.lazyboy.core.SuiteService;
import com.google.inject.AbstractModule;

public class CoreModule extends AbstractModule {

	private final LazyBoyConfiguration configuration;
	
	public CoreModule(LazyBoyConfiguration configuration) {
		this.configuration = configuration;
	}
	
	@Override
	protected void configure() {
		bind(LazyBoyConfiguration.class).toInstance(configuration);
		
		bind(IClusterService.class).to(ClusterService.class);
		bind(ISuiteService.class).to(SuiteService.class);
	}

}
