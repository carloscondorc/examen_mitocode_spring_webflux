package com.matricula.document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Documento Estudiantes")
@Document(collection = "estudiantes")
public class Estudiante {

	@Id
	private String id;
	
	@ApiModelProperty(value = "Longitud minima debe ser 3")
	@NotEmpty
	@Size(min = 3)
	private String nombres;
	
	@ApiModelProperty(value = "Longitud minima debe ser 3")
	@NotEmpty
	@Size(min = 3)
	private String apellidos;
	
	@ApiModelProperty(value = "Longitud minima debe ser 8")
	@NotEmpty
	@Size(min = 3)
	private String dni;
	

	private int edad;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
}
