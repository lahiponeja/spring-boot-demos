package service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import model.Persona;

@Service
public class AccesoServiceImpl implements AccesoService {
	@Autowired
	RestTemplate template;
	String urlBase="http://localhost:8080";	
	
	@Override
	@Async
	public CompletableFuture<List<Persona>> devolverPersona(Persona persona){
		template.postForLocation(urlBase+"/contactos", persona);
		Persona[] personas=template.getForObject(urlBase+"/contactos", Persona[].class);
		return CompletableFuture.completedFuture(Arrays.asList(personas));
		
	}

}
