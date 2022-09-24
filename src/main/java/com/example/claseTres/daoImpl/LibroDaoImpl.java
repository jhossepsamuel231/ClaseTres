package com.example.claseTres.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.claseTres.dao.LibroDao;
import com.example.claseTres.entity.Libros;

@Component
public class LibroDaoImpl implements LibroDao {
	
	private final static Integer LIBRO_PRESTADO = 2;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Libros traerLibro(int idLibro) {
		
		String query = "SELECT * FROM libros WHERE idlibro = " + idLibro;
		List<Libros> libros = jdbcTemplate.query(query, new BeanPropertyRowMapper<Libros>(Libros.class));
		return libros.get(0);
		
	}

	@Override
	public int actualizarLibro(int idLibro) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("UPDATE libros SET estado = " + LIBRO_PRESTADO + " WHERE idlibro = " + idLibro);
	}

}
