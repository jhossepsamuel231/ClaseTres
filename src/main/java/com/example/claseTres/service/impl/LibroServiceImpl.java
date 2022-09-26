package com.example.claseTres.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.claseTres.daoImpl.LibroDaoImpl;
import com.example.claseTres.entity.Detalles;
import com.example.claseTres.entity.Libros;
import com.example.claseTres.service.LibroService;
import com.example.claseTres.utils.Constantes;

@Service
public class LibroServiceImpl implements LibroService {
	
	
	
	@Autowired
	private LibroDaoImpl libroDao;

	@Override
	public Boolean verificarLibroPrestado(List<Detalles> detalles) {
		
		boolean verificar = false;
		
		for(Detalles detalle: detalles) {
			
			Libros libroEncontrado = libroDao.traerLibro(detalle.getIdLibro());
			verificar = libroEncontrado.getEstado() == Constantes.LIBRO_PRESTADO;
			
		}
		
		return verificar;
		
	}

}
