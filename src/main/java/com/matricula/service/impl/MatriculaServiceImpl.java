package com.matricula.service.impl;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.matricula.document.Matricula;
import com.matricula.pagination.PageSupport;
import com.matricula.repository.ICursoRepository;
import com.matricula.repository.IMatriculaRepository;
import com.matricula.service.IMatriculaService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MatriculaServiceImpl implements IMatriculaService{

	
	@Autowired
	private IMatriculaRepository repository;
	
	@Autowired
	private ICursoRepository cRepo;	
	
	@Override
	public Mono<Matricula> registrar(Matricula t) {
		return repository.save(t);
	}

	@Override
	public Mono<Matricula> modificar(Matricula t) {		
		return repository.save(t);
	}

	@Override
	public Flux<Matricula> listar() {
		return repository.findAll();
	}
	
	public Mono<Matricula> listarPorId(String v) {
		return repository.findById(v);
	}

	@Override
	public Mono<Void> eliminar(String v) {
		return repository.deleteById(v);
	}

	@Override
	public Mono<PageSupport<Matricula>> listarPagina(Pageable page) {
		return repository.findAll()
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
