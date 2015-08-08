package com.dantait.lazyboy;

import java.util.ArrayList;
import java.util.List;

import com.dantait.lazyboy.ioc.DBModuleResolver;
import com.dantait.lazyboy.ioc.CoreModule;
import com.dantait.lazyboy.resources.ClustersResource;
import com.dantait.lazyboy.resources.SuitesResource;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class LazyBoyApplication extends Application<LazyBoyConfiguration>
{
	public static void main(String[] args) throws Exception {
        new LazyBoyApplication().run(args);
    }

    @Override
    public String getName() {
        return "lazy-boy";
    }

    @Override
    public void run(LazyBoyConfiguration configuration,
                    Environment environment) {
        Injector injector = createInjector(configuration);
        
        environment.jersey().register(injector.getInstance(ClustersResource.class));
        environment.jersey().register(injector.getInstance(SuitesResource.class));
    }
    
    private Injector createInjector(final LazyBoyConfiguration conf) {
    	DBModuleResolver resolver = new DBModuleResolver(conf);
    	List<AbstractModule> modules = new ArrayList<AbstractModule>();
    	modules.add(new CoreModule(conf));
    	
    	AbstractModule dbModule = resolver.resolve();
    	if(dbModule != null) {
    		modules.add(dbModule);
    	}
    	
    	return Guice.createInjector(modules);
    }
}
