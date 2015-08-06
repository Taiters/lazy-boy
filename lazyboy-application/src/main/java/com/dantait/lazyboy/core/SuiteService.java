package com.dantait.lazyboy.core;

import java.util.List;
import java.util.UUID;

import com.dantait.lazyboy.api.Suite;
import com.dantait.lazyboy.data.ISuiteStore;
import com.google.inject.Inject;

public class SuiteService implements ISuiteService {

	private final ISuiteStore suiteStore;
	
	@Inject
	public SuiteService(ISuiteStore suiteStore) {
		this.suiteStore = suiteStore;
	}
	
	@Override
	public String addSuite(Suite suite) {
		String id = UUID.randomUUID().toString();
		suite.setId(id);
		
		if (suiteStore.add(suite))
			return id;
		
		return null;
	}

	@Override
	public Suite getSuiteById(String id) {
		return suiteStore.get(id);
	}

	@Override
	public List<Suite> getSuites() {
		return suiteStore.get();
	}

}
