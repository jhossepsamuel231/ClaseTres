package com.example.claseTres.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empleados implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idEmpleado;
	private String usuario;
	private String clave;
	private int estado;
}