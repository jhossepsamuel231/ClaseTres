package com.example.claseTres.service;

import java.util.List;

import com.example.claseTres.entity.Detalles;

public interface LibroService {

	Boolean verificarLibroPrestado(List<Detalles> detalles);
	
}
