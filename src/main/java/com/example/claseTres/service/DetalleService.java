package com.example.claseTres.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.claseTres.dao.Todo;
import com.example.claseTres.daoImpl.DetalleDaoImpl;
import com.example.claseTres.entity.Detalles;

@Service
public class DetalleService implements Todo<Detalles>{

	@Autowired
	private DetalleDaoImpl detalleDaoImpl;
	
	@Override
	public int create(Detalles t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Map<String, Object>> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Detalles read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Detalles t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
