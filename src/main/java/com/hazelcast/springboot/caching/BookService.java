package com.hazelcast.springboot.caching;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.hazelcast.core.HazelcastInstance;

@Service
public class BookService {

	@Autowired
	private HazelcastInstance instance; // autowire hazel cast instance

	@Cacheable(value = "books", key = "#isbn")
	public String getBookNameByIsbn(String isbn) {
		return getValue(isbn);
	}

	@CachePut(value = "books", key = "#isbn")
	public String postBookNameByIsbn(String data, String isbn) {
		System.out.println("cache updated::"+isbn);
		instance.getMap("books").put(isbn, data);
		return  getValue(isbn);
	}

	private String getValue(String key) {
		java.util.Map<String,String> map  = instance.getMap("books");
		return map.get(key);
	}
	/*
	@Bean
	private void loadDefaults(){
		java.util.Map<String,String> map  = instance.getMap("books");
		map.put("key1", "abu1");
		map.put("key2", "thalha2");
	}*/
}
