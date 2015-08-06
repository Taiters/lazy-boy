package com.dantait.lazyboy.data;

import java.io.IOException;
import java.util.concurrent.ConcurrentNavigableMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;

import io.dropwizard.jackson.Jackson;

public abstract class MapDBStore {
	
	protected static String name;
	protected IMapDBProvider dbProvider;
	protected ConcurrentNavigableMap<String, String> map;
	
	@Inject
	private void setupMapDBStore(IMapDBProvider dbProvider) {
		this.dbProvider = dbProvider;
		map = dbProvider.getDB().treeMap(getStoreName());
	}
	
	protected String serialize(Object obj) {
		ObjectMapper mapper = Jackson.newObjectMapper();
		
		try {
			return mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	protected <T> T deserialize(String data, Class<T> cls) {
		ObjectMapper mapper = Jackson.newObjectMapper();
		
		try {
			return mapper.readValue(data, cls);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	protected abstract String getStoreName();
}
