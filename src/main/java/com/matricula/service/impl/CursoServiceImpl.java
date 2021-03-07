package com.matricula.service.impl;

import java.time.Duration;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.matricula.document.Curso;
import com.matricula.pagination.PageSupport;
import com.matricula.repository.ICursoRepository;
import com.matricula.service.ICursoService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CursoServiceImpl implements ICursoService {

	
	@Autowired
	private ICursoRepository repository;
	
	@Override
	public Mono<Curso> registrar(Curso t) {
		
		return repository.save(t);
	}

	@Override
	public Mono<Curso> modificar(Curso t) {
		return repository.save(t);
	}

	@Override
	public Flux<Curso> listar() {
		return repository.findAll();
	}

	@Override
	public Mono<Curso> listarPorId(String v) {
		return repository.findById(v);
	}

	@Override
	public Mono<Void> eliminar(String v) {
		return repository.deleteById(v);
	}

	@Override
	public Flux<Curso> listarDemorado() {
		return repository.findAll().delayElements(Duration.ofSeconds(1));
	}

	@Override
	public Flux<Curso> listarSobrecargado() {
		return repository.findAll().repeat(3000);
	}

	@Override
	public Mono<PageSupport<Curso>> listarPagina(Pageable page) {
		return repository.findAll() //mi query segun filtros
				.collectList()
				.map(lista -> new PageSupport<>(
						lista
						.stream()
						.skip(page.getPageNumber() * page.getPageSize())
						.limit(page.getPageSize())
						.collect(Collectors.toList()),
					page.getPageNumber(), page.getPageSize(), lista.size()
					));
	}

}
