package com.matricula.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.matricula.document.Usuario;

import reactor.core.publisher.Mono;

public interface IUsuarioRepo extends ReactiveMongoRepository<Usuario, String>{

	 Mono<Usuario> findOneByUsuario(String usuario);

}
