package com.app.proyecto.docente;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.app.proyecto.aula.aula;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Docente {

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
	@Column(name = "Dni",nullable = false, unique = true)
	private String dni;
	@Column(name = "Telefono",length = 60, nullable = false)
	private String telefono;
	@Column(name = "Area_especializacion",nullable = false)
	private String area;
	
	@ManyToMany//(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinTable(name = "docente_aula", joinColumns = @JoinColumn(name = "docente_id"),
	inverseJoinColumns = @JoinColumn(name  = "aula_id"))
	private Set<aula> aulas=new HashSet<aula>();

	public Docente() {
		super();
	}

	public Docente(int id, String nombres, String apellidos, LocalDate fechaNacimiento, String direccion, String correo,
			String dni, String telefono, String area, Set<aula> aulas) {
		super();
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.correo = correo;
		this.dni = dni;
		this.telefono = telefono;
		this.area = area;
		this.aulas = aulas;
	}

	public Docente(String nombres, String apellidos, LocalDate fechaNacimiento, String direccion, String correo,
			String dni, String telefono, String area, Set<aula> aulas) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.correo = correo;
		this.dni = dni;
		this.telefono = telefono;
		this.area = area;
		this.aulas = aulas;
	}
	

	public Docente(String nombres, String apellidos, LocalDate fechaNacimiento, String direccion, String correo,
			String dni, String telefono, String area) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.correo = correo;
		this.dni = dni;
		this.telefono = telefono;
		this.area = area;
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

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Set<aula> getAulas() {
		return aulas;
	}

	public void setAulas(Set<aula> aulas) {
		this.aulas = aulas;
	}
	
	public void agregarAula(aula aula) {
		this.aulas.add(aula);
	}
	
	public void eliminarAula(aula aula) {
		this.aulas.remove(aula);
	}
	
}
