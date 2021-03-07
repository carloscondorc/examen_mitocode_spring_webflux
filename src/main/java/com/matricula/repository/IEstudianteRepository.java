package com.matricula.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.matricula.document.Estudiante;

public interface IEstudianteRepository extends ReactiveMongoRepository<Estudiante, String> {

}
	