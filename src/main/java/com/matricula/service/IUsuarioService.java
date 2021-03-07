package com.matricula.service;

import com.matricula.document.Usuario;
import com.matricula.security.User;

import reactor.core.publisher.Mono;

public interface IUsuarioService extends ICRUD<Usuario, String>{

	Mono<User> buscarPorUsuario(String usuario);

}
