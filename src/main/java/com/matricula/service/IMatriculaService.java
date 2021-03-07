package com.matricula.service;

import org.springframework.data.domain.Pageable;

import com.matricula.document.Matricula;
import com.matricula.pagination.PageSupport;

import reactor.core.publisher.Mono;

public interface IMatriculaService extends ICRUD<Matricula, String> {

	Mono<PageSupport<Matricula>> listarPagina(Pageable page);

}
