
package com.app.proyecto.alumno;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface alumnoRepositorio extends JpaRepository<Alumno, Integer>{

	@Query("SELECT a FROM Alumno a " +
		       "JOIN a.aula al " +  
		       "WHERE a.nombres LIKE %?1% " +
		       "OR a.apellidos LIKE %?1% " +
		       "OR a.carrera LIKE %?1% " +
		       "OR a.dni LIKE %?1% " +
		       "OR a.direccion LIKE %?1% " +
		       "OR a.telefono LIKE %?1% " +
		       "OR al.turno LIKE %?1% " + 
		       "OR al.nombre LIKE %?1%")
		public List<Alumno> findAll(String palabraClave);
}
