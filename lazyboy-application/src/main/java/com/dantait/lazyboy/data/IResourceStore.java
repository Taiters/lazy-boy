package com.dantait.lazyboy.data;

import java.util.List;

public interface IResourceStore<T> {
	public boolean add(T cluster);
	public T get(String id);
	public List<T> get();
}
