package com.example.claseTres.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Detalles implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idDetalle;
	private int estado;
	private int idLibro;
	private int idPrestamo;
}
