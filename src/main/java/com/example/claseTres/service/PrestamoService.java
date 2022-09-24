package com.example.claseTres.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.claseTres.dao.Todo;
import com.example.claseTres.daoImpl.PrestamoDaoImpl;
import com.example.claseTres.entity.Prestamos;

@Service
public class PrestamoService implements Todo<Prestamos>{

	@Autowired
	private PrestamoDaoImpl prestamoDaoImpl;
	
	@Override
	public int create(Prestamos t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Map<String, Object>> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Prestamos read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Prestamos t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
