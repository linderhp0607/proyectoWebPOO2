package com.app.proyecto.aula;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class aula {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 50, nullable = false, unique = true)
	private String nombre;
	@Column(length = 50, nullable = false)
	private String turno;
	
	public aula() {
		super();
	}

	public aula(Integer id, String nombre, String turno) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.turno = turno;
	}

	public aula(Integer id) {
		super();
		this.id = id;
	}

	public aula(String nombre) {
		super();
		this.nombre = nombre;
	}

	public aula(String nombre, String turno) {
		super();
		this.nombre = nombre;
		this.turno = turno;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	
	
}
