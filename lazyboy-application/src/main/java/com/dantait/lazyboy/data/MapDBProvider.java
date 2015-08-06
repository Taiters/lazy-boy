package com.dantait.lazyboy.data;

import java.io.File;

import org.mapdb.DB;
import org.mapdb.DBMaker;

import com.dantait.lazyboy.config.MapDBConfiguration;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class MapDBProvider implements IMapDBProvider {

	private final DB db;
	
	@Inject
	public MapDBProvider(MapDBConfiguration config) {
		File dir = new File(config.getPath());
		dir.mkdirs();
		
		db = DBMaker.fileDB(new File(dir, "db"))
				.closeOnJvmShutdown()
				.make();
	}
	
	@Override
	public DB getDB() {
		return db;
	}

}
