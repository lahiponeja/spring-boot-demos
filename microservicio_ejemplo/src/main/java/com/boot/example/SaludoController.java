package com.boot.example;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {
	
	@GetMapping(value="saludo", produces = MediaType.TEXT_PLAIN_VALUE)
	public String saludo() {
		return "Micro Servicio Spring Boot";
	}

	@GetMapping(value="/saludo/{name}", produces = MediaType.TEXT_PLAIN_VALUE)
			public String saludoPersonalizado(@PathVariable("name") String nombre) {
			return "Bienvenido a Spring Boot sra: "+ nombre;
	}
	
	@GetMapping(value="/saludopersonalizado", produces = MediaType.TEXT_PLAIN_VALUE)
	public String saludoPersonalizado(@RequestParam("name") String nombre,@RequestParam("age") int edad) {
	return "Bienvenido a Spring Boot sra: "+ nombre+", tienes "+ edad+" años";
	}
}
