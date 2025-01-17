package com.app.proyecto.docente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface docenteRepositorio extends JpaRepository<Docente, Integer>{
	
	@Query("SELECT a FROM Docente a " +
		       "WHERE a.nombres LIKE %?1% " +
		       "OR a.apellidos LIKE %?1% " +
		       "OR a.area LIKE %?1% " +
		       "OR a.dni LIKE %?1% " +
		       "OR a.direccion LIKE %?1% " +
		       "OR a.telefono LIKE %?1% ")
		public List<Docente> findAll(String palabraClave);

}
