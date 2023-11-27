package controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import model.Persona;

@RestController
public class PersonasController {
	@Autowired
	RestTemplate template;
	
	String url="http://localhost:8080";
	@GetMapping(value="/personas/{nombre}/{email}/{edad}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Persona> altaPersona(@PathVariable("nombre") String nombre,
			@PathVariable("email") String email, 
			@PathVariable("edad") int edad){
		
		Persona persona=new Persona(nombre,email,edad);
		
		try {
			//al lanzar la petición post, si la respuesta contiene un código de error
			//diferente a 200, se producirá una excepción
			ResponseEntity<Void> respuesta= template.postForEntity(url+"/contactos", persona, Void.class);
			//si todo ha ido bien, devolvemos como respuesta la lista de persona
			//e indicamos OK como código de estado de respuesta
			HttpHeaders headers = respuesta.getHeaders();
			int total = Integer.parseInt(headers.get("total").get(0));
			if(total==0) {
				return null;
				
			}
			ResponseEntity<Persona[]> personas=template.getForEntity(url+"/contactos", Persona[].class);
			return Arrays.asList(personas.getBody());
		}
		catch(HttpClientErrorException exception) {
			//si hubo error en la llamada al microservicio, enviamos a nuestro cliente final
			//una cabecera con el mensaje de error, una lista vacía de personas en el cuerpo
			//y el código de estado enviado desde el microservicio
			HttpHeaders headers=new HttpHeaders();
			headers.add("error", exception.getResponseBodyAsString());
			return null;
		}
		
	}
	
	@GetMapping(value="/personas/{edad1}/{edad2}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Persona> buscarEdades(@PathVariable("edad1") int edad1, @PathVariable("edad2") int edad2){
		ResponseEntity<Persona[]> personas=template.getForEntity(url+"/contactos", Persona[].class);
		return Arrays.stream(personas.getBody())
			.filter(p->p.getEdad()>=edad1&&p.getEdad()<=edad2)
			.collect(Collectors.toList());
	}
}
