package com.example.claseTres.dao;

import java.util.List;
import java.util.Map;

public interface Todo<T> {
	int create(T t);
	List<Map<String, Object>> readAll();
	T read(int id);
	int update (T t);
	int delete(int id);
}
