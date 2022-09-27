package com.example.claseTres.daoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Jdbc;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;

import com.example.claseTres.dao.Todo;
import com.example.claseTres.entity.Prestamos;
import com.example.claseTres.utils.Constantes;

@Component
public class PrestamoDaoImpl implements Todo<Prestamos>{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public int create(Prestamos t) {
		
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(dataSource);
		GeneratedKeyHolder almacenarClavesGeneradas = new GeneratedKeyHolder();
		
		String query = "INSERT INTO prestamos(fecha_prestamos, fecha_devolucion, estado, idempleado, idalumno) VALUES(now(), :fechaDev, :estado, :idEmpleado, :idAlumno)";
		
		
		Map<String, Object> valores = new HashMap<>();
		valores.put("fechaDev", t.getFecha_Devolucion());
		valores.put("estado", Constantes.PRESTAMOS_INGRESADO);
		valores.put("idEmpleado", t.getIdEmpleado());
		valores.put("idAlumno", t.getIdAlumno());
		
		
		template.update(query, new MapSqlParameterSource(valores), almacenarClavesGeneradas);
		
		return almacenarClavesGeneradas.getKey().intValue();
		
	}

	@Override
	public List<Map<String, Object>> readAll() {
		// TODO Auto-generated method stub
		String query = "SELECT P.fecha_prestamos, P.fecha_devolucion, P.estado, A.nombres, A.apellidos, L.nombre FROM prestamos AS P INNER JOIN alumnos AS A ON P.idalumno=A.idalumno INNER JOIN detalles AS D ON P.idprestamo=D.idprestamo INNER JOIN libros AS L ON D.idlibro=L.idlibro";
		return jdbcTemplate.queryForList(query);
	}

	@Override
	public Prestamos read(int id) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM prestamos WHERE idprestamo=?";
		return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<Prestamos>(Prestamos.class), id);
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
