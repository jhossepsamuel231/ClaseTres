package com.example.claseTres.dao;

import com.example.claseTres.entity.Libros;

public interface LibroDao {
	
	Libros traerLibro(int idLibro);
	
	int actualizarLibro(int idLibro, int estado);

}
