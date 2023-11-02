package com.cursos;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureMockMvc
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class ApplicationTests {

	@Autowired
	MockMvc mock;
	
	@Test
	@Order(2)
	void testAltaCurso() throws Exception {
		mock.perform(post("/curso")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"nombre\":\"Angular 10\",\"duracion\":40,\"horario\":\"tarde\"}"))
				.andDo(print());
	}
	
	@Test
	@Order(3)
	void testActualizacionCurso() throws Exception {
		mock.perform(put("/curso")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"nombre\":\"Angular 10\",\"duracion\":80,\"horario\":\"mañana\"}"))
				.andDo(print());
	}


	@Test
	@Order(4)
	void testCursos() throws Exception {
		mock.perform(get("/cursos")).andDo(print());
	}
	
	@Test
	@Order(1)
	void testGetCurso() throws Exception {
		mock.perform(get("/cursos/Spring")).andDo(print());
	}
	
	@Test
	@Order(0)
	void testEliminarCurso() throws Exception {
		mock.perform(delete("/curso/Spring")).andDo(print());
	}
	


}
