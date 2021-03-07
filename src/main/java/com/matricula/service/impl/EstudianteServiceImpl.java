package com.matricula.service.impl;

import java.time.Duration;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.matricula.document.Estudiante;
import com.matricula.pagination.PageSupport;
import com.matricula.repository.IEstudianteRepository;
import com.matricula.service.IEstudianteService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	
	@Autowired
	private IEstudianteRepository repository;
	
	@Override
	public Mono<Estudiante> registrar(Estudiante t) {
		
		return repository.save(t);
	}

	@Override
	public Mono<Estudiante> modificar(Estudiante t) {
		return repository.save(t);
	}

	@Override
	public Flux<Estudiante> listar() {
		return repository.findAll();
	}

	@Override
	public Mono<Estudiante> listarPorId(String v) {
		return repository.findById(v);
	}

	@Override
	public Mono<Void> eliminar(String v) {
		return repository.deleteById(v);
	}

	@Override
	public Flux<Estudiante> listarDemorado() {
		return repository.findAll().delayElements(Duration.ofSeconds(1));
	}

	@Override
	public Flux<Estudiante> listarSobrecargado() {
		return repository.findAll().repeat(3000);
	}

	@Override
	public Mono<PageSupport<Estudiante>> listarPagina(Pageable page) {
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

	@Override
	public Flux<Estudiante> orderByYear() {
		// TODO Auto-generated method stub
		return repository.findAll(Sort.by(Sort.Direction.DESC, "edad"));
	}

}
