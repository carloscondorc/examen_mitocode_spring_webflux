package com.matricula.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.matricula.document.Matricula;
import com.matricula.service.IMatriculaService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@SessionAttributes("matriculas")
@RequestMapping("/matriculas")
public class MatriculaController {
	
	@Autowired
	private IMatriculaService service;
	
	@GetMapping
	public Mono<ResponseEntity<Flux<Matricula>>> listar(){
		Flux<Matricula> cursosFlux = service.listar();
		
		return Mono.just(ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_STREAM_JSON)
				.body(cursosFlux));
	}
	
	@GetMapping("/{id}")
	public Mono<ResponseEntity<Matricula>> listarPorId(@PathVariable("id") String id){
		return service.listarPorId(id)	//Mono.empty()	
				//.defaultIfEmpty(new Matricula())
				.map(p -> ResponseEntity.ok()
						.contentType(MediaType.APPLICATION_STREAM_JSON)
						.body(p)
				).defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Mono<ResponseEntity<Matricula>> registrar(@Valid @RequestBody Matricula matricula, final ServerHttpRequest req){
		return service.registrar(matricula)
				.map(p -> ResponseEntity.created(URI.create(req.getURI().toString().concat("/").concat(p.getId())))
						.contentType(MediaType.APPLICATION_STREAM_JSON)
						.body(p)
					).onErrorMap(error -> new ArithmeticException("Ups"));
	}
	
	@PutMapping
	public Mono<ResponseEntity<Matricula>> modificar(@Valid @RequestBody Matricula plato){
		return service.modificar(plato)
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
