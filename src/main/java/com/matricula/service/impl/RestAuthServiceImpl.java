package com.matricula.service.impl;

import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class RestAuthServiceImpl {

	public boolean tieneAcceso(String path) {
		
		String metodoRol = "";

		// /listar
		switch (path) {
		case "listar":
			metodoRol = "ADMIN";
			break;

		case "listarId":
			metodoRol = "ADMIN,USER,DBA";
			break;
		}
		
		String metodoRoles[] = metodoRol.split(",");
				
		//PENDIENTE TXT CON OBSERVACIONES
		Mono<SecurityContext> context  = ReactiveSecurityContextHolder.getContext();
		
		context.map(c -> {
			System.out.println(c.getAuthentication().getPrincipal().toString());
			return c.getAuthentication().getPrincipal().toString();						
		});

		return true;
	}
}