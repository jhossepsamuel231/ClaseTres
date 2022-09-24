package com.example.claseTres.daoImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.claseTres.dao.Todo;
import com.example.claseTres.entity.Detalles;

@Component
public class DetalleDaoImpl implements Todo<Detalles>{


	private static final Integer DETALLE_INGRESADO = 1;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int create(Detalles t) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO detalles(idprestamo, idlibro, estado) VALUES(?,?,?)";
		
		return jdbcTemplate.update(query, t.getIdPrestamo(), t.getIdLibro(), DETALLE_INGRESADO);
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
