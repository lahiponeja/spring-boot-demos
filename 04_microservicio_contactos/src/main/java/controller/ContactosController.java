package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Contacto;
import service_api.AgendaService;

@CrossOrigin(origins = "*")
@RestController
public class ContactosController {
	
	@Autowired
	AgendaService agendaService;
	
	@GetMapping(value="contactos", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Contacto> devolverContactos(){
		return agendaService.devolverContactos();
		
	}
	
	@GetMapping(value="contactos/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Contacto devolverContacto(@PathVariable("id") int id){
		return agendaService.obtenerContacto(id);
		
	}
	
	@PostMapping(value="contactos", consumes=MediaType.APPLICATION_JSON_VALUE)
	public String crearContacto(@RequestBody Contacto contacto){
		return String.valueOf(agendaService.agregarContacto(contacto));
		
	}
	
	@PutMapping(value="contactos", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void actualizarContacto(@RequestBody Contacto contacto){
		agendaService.actualizarContacto(contacto);
		
	}
	
	@DeleteMapping(value="eliminar/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public void eliminarContacto(@PathVariable("id") int id){
		 agendaService.eliminarContacto(id);
		
	}
	
	
	
	
	
	
	

}
