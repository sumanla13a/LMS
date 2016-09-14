package edu.mum.cs.cs401.dataaccess;

import java.util.Collection;

public interface DataAccess<K, V> {
	public V add(K key, V value);
	public V update(K key, V value);
	public Collection<V> get();
	public V get(K key);
	public V delete(K key);
}
