package com.example.claseTres.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.claseTres.entity.Prestamos;
import com.example.claseTres.service.PrestamoService;
import com.example.claseTres.service.impl.LibroServiceImpl;

@RestController
@RequestMapping("/api/prestamos/")
// http://cpp-kbro.com/api/prestamos
public class PrestamoController {
	
	@Autowired
	private LibroServiceImpl libroService;
	
	@Autowired
	private PrestamoService prestamoService;
	
	//http://cpp-kbro.com/api/prestamos/saludar
	@GetMapping("/saludar")
	public String saludar() {		
		return "hola";
	}

	/**
	 * Creación, Logeo, Editar siempre es por un @RueqestBody
	 */
	@PostMapping("/crear")
	public ResponseEntity< ? > crearPrestamo(@RequestBody Prestamos prestamo) {
		
		Integer idPrestamo = null;
		
		//TODO verifficar que solo venga 2 libros osea detalles		
		if ( prestamo.getDetalles().size() > 2 ) {
			return new ResponseEntity<String>(
					"No puede emprestar mas de 2 libros", 
					HttpStatus.BAD_REQUEST
			);
		}
		
		//TODO verificar que el libro entrante no esté en estado de prestado		
		if(libroService.verificarLibroPrestado(prestamo.getDetalles())) {
			return new ResponseEntity<String>(
					"Algún libro está prestado", 
					HttpStatus.BAD_REQUEST
			);
		}
		
		//TODO ...
		
		try {
			
			//TODO Crear prestamo 		
			//TODO crear detalle
			idPrestamo = prestamoService.create(prestamo);
			
		} catch (Exception e) {
			return new ResponseEntity<String>(
					"Oops, pasó algo en el servidor: => " + e.getMessage(), 
					HttpStatus.INTERNAL_SERVER_ERROR
			);
		}
		
		//TODO finalizar con la respuesta
		prestamo.setIdPrestamo(idPrestamo);
		
		return new ResponseEntity<Prestamos>(prestamo, HttpStatus.CREATED);
		
	}
	
}
