package com.dantait.lazyboy.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.dantait.lazyboy.api.Suite;

public class MapDBSuiteStore extends MapDBStore implements ISuiteStore {
	
	@Override
	protected String getStoreName() {
		return "suites";
	}
	
	@Override
	public boolean add(Suite suite) {
		String serializedSuite = serialize(suite);
		
		if (serializedSuite == null)
			return false;
		
		map.put(suite.getId(), serializedSuite);
		dbProvider.getDB().commit();
		
		return true;
	}

	@Override
	public Suite get(String id) {
		return deserialize(map.get(id), Suite.class);
	}

	@Override
	public List<Suite> get() {
		Collection<String> suiteData = map.values();
		ArrayList<Suite> suites = new ArrayList<Suite>();
		
		Iterator<String> it = suiteData.iterator();
		while(it.hasNext()) {
			suites.add(deserialize(it.next(), Suite.class));
		}
		
		return suites;
	}

}
