package com.example.claseTres.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/home/")
public class HomeController {

	@GetMapping("/saludar")
	public String saludar() {		
		return "hola";
	}
	
	
}
