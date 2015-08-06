package com.dantait.lazyboy.core;

import java.util.List;

import com.dantait.lazyboy.api.Suite;

public interface ISuiteService {

	public String addSuite(Suite suite);
	public Suite getSuiteById(String id);
	public List<Suite> getSuites();
}
