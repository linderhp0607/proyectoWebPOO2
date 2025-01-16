package com.app.proyecto.alumno;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class alumnoServicio {
	
	@Autowired
	private alumnoRepositorio repositorio;
	
	public List<Alumno> listAll(String palabraClave){
		if (palabraClave != null) {
			return repositorio.findAll(palabraClave);
		}
		return repositorio.findAll();
	}

}
