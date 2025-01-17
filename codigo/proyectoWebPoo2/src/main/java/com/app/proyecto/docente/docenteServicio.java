package com.app.proyecto.docente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class docenteServicio {

	@Autowired
	private docenteRepositorio repositorio;
	
	public List<Docente> listAll(String palabraClave){
		if (palabraClave != null) {
			return repositorio.findAll(palabraClave);
		}
		return repositorio.findAll();
	}
}
