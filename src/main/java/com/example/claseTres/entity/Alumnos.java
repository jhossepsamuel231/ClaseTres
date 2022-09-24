package com.example.claseTres.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alumnos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idAlumnos;
	private String codigo;
	private String nombres;
	private String apellidos;
}
