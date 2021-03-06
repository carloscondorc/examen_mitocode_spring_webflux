package com.matricula.controller;

import java.net.URI;

import javax.management.Query;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matricula.document.Curso;
import com.matricula.service.ICursoService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/cursos")
public class CursoController {

	@Autowired
	private ICursoService service;
	
	@GetMapping
	public Mono<ResponseEntity<Flux<Curso>>> listar(){
		
						
		Flux<Curso> platosFlux = service.listar();
		
		return Mono.just(ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_STREAM_JSON)
				.body(platosFlux));
	}
	
	@GetMapping("/{id}")
	public Mono<ResponseEntity<Curso>> listarPorId(@PathVariable("id") String id){
		return service.listarPorId(id)	//Mono.empty()	
				//.defaultIfEmpty(new Cliente())
				.map(p -> ResponseEntity.ok()
						.contentType(MediaType.APPLICATION_STREAM_JSON)
						.body(p)
				).defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Mono<ResponseEntity<Curso>> registrar(@Valid @RequestBody Curso curso, final ServerHttpRequest req){
		return service.registrar(curso)
				.map(p -> ResponseEntity.created(URI.create(req.getURI().toString().concat("/").concat(p.getId())))
						.contentType(MediaType.APPLICATION_STREAM_JSON)
						.body(p)
					).onErrorMap(error -> new ArithmeticException("Ups"));
	}
	
	@PutMapping
	public Mono<ResponseEntity<Curso>> modificar(@Valid @RequestBody Curso curso){
		return service.modificar(curso)
				.map(p -> ResponseEntity.ok()
						.contentType(MediaType.APPLICATION_STREAM_JSON)
						.body(p)
					).defaultIfEmpty(ResponseEntity.notFound().build());	
	}
	
	@DeleteMapping("/{id}")
	public Mono<ResponseEntity<Void>> eliminar(@PathVariable("id") String id){
		return service.listarPorId(id)
				.flatMap(p -> {
					return service.eliminar(p.getId())
							.then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
				})
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}
	

}
