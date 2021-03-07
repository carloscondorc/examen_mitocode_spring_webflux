package com.matricula.service;

import org.springframework.data.domain.Pageable;

import com.matricula.document.Estudiante;
import com.matricula.pagination.PageSupport;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IEstudianteService extends ICRUD<Estudiante, String> {

	Flux<Estudiante> listarDemorado();
	Flux<Estudiante> listarSobrecargado();	
	Mono<PageSupport<Estudiante>> listarPagina(Pageable page);
	Flux<Estudiante> orderByYear();
}
