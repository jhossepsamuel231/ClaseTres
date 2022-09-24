package com.example.claseTres.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prestamos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idPrestamo;
	private Date fecha_prestamos;
	private Date fecha_Devolucion;
	private int estado;
	private int idEmpleado;
	private int idAlumno;
	
	private List<Detalles> detalles;
	
}
