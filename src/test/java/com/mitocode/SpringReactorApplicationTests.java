package com.mitocode;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

/*
import com.examen.document.Plato;

import reactor.core.publisher.Mono;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class SpringReactorApplicationTests {

	@Autowired
	private WebTestClient clienteWeb;
	
	@Test
	void listarTest() {
		clienteWeb.get()
		.uri("/platos")
		.accept(MediaType.APPLICATION_STREAM_JSON)
		.exchange()
		.expectStatus().isOk()
		.expectHeader().contentType(MediaType.APPLICATION_STREAM_JSON)
		.expectBodyList(Plato.class)
		.hasSize(10);
	}
	
	@Test
	void registrarTest() {
		Plato plato = new Plato();
		plato.setNombre("PACHAMANCA");
		plato.setPrecio(20);
		
		clienteWeb.post()
		.uri("/platos")
		.accept(MediaType.APPLICATION_STREAM_JSON)
		.body(Mono.just(plato), Plato.class)
		.exchange()
		.expectStatus().isCreated()
		.expectHeader().contentType(MediaType.APPLICATION_STREAM_JSON)
		.expectBody()
		.jsonPath("$.nombre").isNotEmpty()
		.jsonPath("$.precio").isNumber();
	}
	
	@Test
	void modificarTest() {
		Plato plato = new Plato();
		plato.setId("5e63cc5ec1db205821412ad3");
		plato.setNombre("SECO A LA NORTEÑA");
		plato.setPrecio(15);
		
		clienteWeb.put()
		.uri("/platos")
		.accept(MediaType.APPLICATION_STREAM_JSON)
		.body(Mono.just(plato), Plato.class)
		.exchange()
		.expectStatus().isOk()
		.expectHeader().contentType(MediaType.APPLICATION_STREAM_JSON)
		.expectBody()
		.jsonPath("$.id").isNotEmpty()
		.jsonPath("$.nombre").isNotEmpty()
		.jsonPath("$.precio").isNumber();
	}
	
	@Test
	void eliminarTest() {
		Plato plato = new Plato();
		plato.setId("5e63cd8cb9d71c3a37442673");
		
		clienteWeb.delete()
		.uri("/platos/" + plato.getId())
		.accept(MediaType.APPLICATION_STREAM_JSON)
		.exchange()
		.expectStatus().isNoContent();
	}

}
*/
