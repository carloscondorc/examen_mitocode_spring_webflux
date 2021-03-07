package com.matricula.document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Documento Cursos")
@Document(collection = "cursos")
public class Curso {
	
	@Id
	private String id;
	
	@ApiModelProperty(value = "Longitud minima debe ser 10")
	@NotEmpty
	@Size(min = 10)
	private String nombre;
	
	
	@ApiModelProperty(value = "Longitud minima debe ser 2")
	@NotEmpty
	@Size(min = 2)
	private String siglas;
	
	private boolean estado;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getSiglas() {
		return siglas;
	}
	public void setSiglas(String siglas) {
		this.siglas = siglas;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
	

}
