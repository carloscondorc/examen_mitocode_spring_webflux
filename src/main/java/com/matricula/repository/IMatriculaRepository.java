package com.matricula.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.matricula.document.Matricula;

public interface IMatriculaRepository extends ReactiveMongoRepository<Matricula, String> {

}
