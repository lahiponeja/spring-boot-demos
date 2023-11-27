package service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

import model.Persona;

public interface AccesoService {

	@Async
	CompletableFuture<List<Persona>> devolverPersona(Persona persona);

}