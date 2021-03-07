package com.matricula.service;

import org.springframework.data.domain.Pageable;

import com.matricula.document.Curso;
import com.matricula.pagination.PageSupport;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICursoService extends ICRUD<Curso, String> {

	Flux<Curso> listarDemorado();
	Flux<Curso> listarSobrecargado();	
	Mono<PageSupport<Curso>> listarPagina(Pageable page);
}
