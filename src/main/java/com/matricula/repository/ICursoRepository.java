package com.matricula.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.matricula.document.Curso;

public interface ICursoRepository extends ReactiveMongoRepository<Curso, String> {

}
	