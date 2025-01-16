package com.app.proyecto.alumno;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.app.proyecto.aula.aula;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Alumno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "Nombres", length = 60 , nullable = false)
	private String nombres;
	@Column(name = "Apellidos", length = 60, nullable = false)
	private String apellidos;
	@Column(name = "Fecha_nacimiento",nullable = false)
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate fechaNacimiento;
	@Column(name = "Direccion",nullable = false)
	private String direccion;
	@Column(name = "Correo",nullable = false, unique = true)
	private String correo;
	@Column(name = "Carrera",nullable = false)
	private String carrera;
	@Column(name = "Dni",nullable = false, unique = true)
	private String dni;
	@Column(name = "Telefono",length = 60, nullable = false)
	private String telefono;
	
	@ManyToOne
	@JoinColumn(name = "aula_id")
	private aula aula;

	public Alumno() {
		super();
	}

	public Alumno(int id, String nombres, String apellidos, LocalDate fechaNacimiento, String direccion, String correo,
			String carrera, String dni, String telefono, com.app.proyecto.aula.aula aula) {
		super();
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.correo = correo;
		this.carrera = carrera;
		this.dni = dni;
		this.telefono = telefono;
		this.aula = aula;
	}

	public Alumno(String nombres, String apellidos, LocalDate fechaNacimiento, String direccion, String correo,
			String carrera, String dni, String telefono, com.app.proyecto.aula.aula aula) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.correo = correo;
		this.carrera = carrera;
		this.dni = dni;
		this.telefono = telefono;
		this.aula = aula;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public aula getAula() {
		return aula;
	}

	public void setAula(aula aula) {
		this.aula = aula;
	}

	
	
}
