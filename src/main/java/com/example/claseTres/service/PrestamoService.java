package com.example.claseTres.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.claseTres.dao.Todo;
import com.example.claseTres.daoImpl.DetalleDaoImpl;
import com.example.claseTres.daoImpl.LibroDaoImpl;
import com.example.claseTres.daoImpl.PrestamoDaoImpl;
import com.example.claseTres.entity.Prestamos;
import com.example.claseTres.utils.Constantes;

@Service
public class PrestamoService implements Todo<Prestamos>{
	
	@Autowired
	private PrestamoDaoImpl prestamoDaoImpl;
	
	@Autowired
	private DetalleDaoImpl detalleDao;
	
	@Autowired
	private LibroDaoImpl libroDao;
	
	@Override
	@Transactional
	public int create(Prestamos t) {
		
		int idGenerado = prestamoDaoImpl.create(t);
		
		t.getDetalles().forEach(x -> {
			x.setIdPrestamo(idGenerado);
			detalleDao.create(x);
			
			// TODO actualizar estado libro
			libroDao.actualizarLibro(x.getIdLibro(), Constantes.LIBRO_PRESTADO);
			
		});
		
		return idGenerado;
		
	}

	@Override
	public List<Map<String, Object>> readAll() {
		// TODO Auto-generated method stub
		return prestamoDaoImpl.readAll();
	}

	@Override
	public Prestamos read(int id) {
		// TODO Auto-generated method stub
		return prestamoDaoImpl.read(id);
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
