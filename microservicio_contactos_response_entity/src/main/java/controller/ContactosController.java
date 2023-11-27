package controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import exceptions.MyException;
import model.Contacto;
import service.AgendaService;
@CrossOrigin(origins = "*") //permite recibir peticiones desde cualquier origen
@RestController
public class ContactosController {
	@Autowired
	AgendaService service;
	@GetMapping(value="contactos",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Contacto>> recuperarContactos() {
		List<Contacto> contactos = service.recuperarContactos();
		HttpHeaders headers = new HttpHeaders();
		headers.add("total", String.valueOf(headers.size()));
		return new ResponseEntity<List<Contacto>>(contactos, headers, HttpStatus.OK);
	}
	@GetMapping(value="contactos/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Contacto> recuperarContactos(@PathVariable("id") int id) {
		Contacto contacto = service.buscarContacto(id);
		return new ResponseEntity<Contacto>(contacto, HttpStatus.OK);
	}
	
	@PostMapping(value="contactos",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> guardarContacto(@RequestBody Contacto contacto) throws Exception {	
		try{
			service.agregarContacto(contacto); 
			return new ResponseEntity<Void>(HttpStatus.OK);
		}catch(MyException e) {			
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
			
		}
	}
	
	@PutMapping(value="contactos",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> actualizarContacto(@RequestBody Contacto contacto) {		
		try{
			service.actualizarContacto(contacto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}catch(Exception e) {			
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
			
		}
	}
		
	@DeleteMapping(value="contactos/{id}")
	public ResponseEntity<Void> eliminarPorId(@PathVariable("id") int idContacto) {
		try{
			service.eliminarContacto(idContacto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}catch(Exception e) {			
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
			
		}
		
	}
}
