package controller;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import model.Persona;
import service.AccesoService;


@RestController
public class PersonaController {
	@Autowired
	AccesoService accesoService;

	@GetMapping(value="/personas/{nombre}/{email}/{edad}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Persona> altaNueva(@PathVariable("nombre") String nombre,
						@PathVariable("email") String email, 
						@PathVariable("edad") int edad){
		Persona persona=new Persona(nombre,email,edad);
		//realiza dos llamadas al servicio remoto, la primera para agregar una nueva persona
		//y la segunda para recuperar las personas existentes
		CompletableFuture<List<Persona>> resultado = accesoService.devolverPersona(persona);
		for(int i=0; i<50; i++) {
			System.out.println("Esperando...");
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		List<Persona> personas = null;
		try {
			personas = resultado.get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return personas;
	}
	/*@GetMapping(value="/personas/{edad1}/{edad2}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Persona> buscarEdades(@PathVariable("edad1") int edad1, @PathVariable("edad2") int edad2){
		Persona[] personas=template.getForObject(urlBase+"/contactos", Persona[].class);
		return Arrays.stream(personas)
			.filter(p->p.getEdad()>=edad1&&p.getEdad()<=edad2)
			.collect(Collectors.toList());
	}*/
}


