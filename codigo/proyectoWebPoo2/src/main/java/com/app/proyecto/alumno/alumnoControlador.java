package com.app.proyecto.alumno;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.proyecto.aula.aula;
import com.app.proyecto.aula.aulaRepositorio;

@Controller
public class alumnoControlador {
	
	@Autowired
	private alumnoRepositorio repositorio;
	
	@Autowired
	private aulaRepositorio aulaRepository;
	
	@GetMapping("/alumnos")
	public String listarAlumnos(Model modelo) {
		List<Alumno> listaAlumnos= repositorio.findAll();
		modelo.addAttribute("listaAlumnos", listaAlumnos);
		return "alumnos";
	}
	
	@GetMapping("/alumnos/nuevo")
	public String formularioNuevoAlumno(Model modelo) {
		List<aula> listaAulas=aulaRepository.findAll();
		modelo.addAttribute("alumno", new Alumno());
		modelo.addAttribute("listaAulas", listaAulas);
		return "alumnoFormulario";
	}
	
	@PostMapping("/alumnos/guardar")
	public String guardarAlumno( Alumno alumno) {
		repositorio.save(alumno);
		return "redirect:/alumnos";
	}
	
	@GetMapping("/alumnos/editar/{id}")
	public String formularioEditar(@PathVariable("id") Integer id, Model modelo) {
		Alumno alumno=repositorio.findById(id).get();
		modelo.addAttribute("alumno", alumno);
		List<aula> listaAulas=aulaRepository.findAll();
		modelo.addAttribute("listaAulas", listaAulas);
		return "alumnoFormulario";
	}
	
	@GetMapping("/alumnos/eliminar/{id}")
	public String eliminarAlumno(@PathVariable("id") Integer id) {
	    if (repositorio.existsById(id)) {
	        repositorio.deleteById(id);
	    } else {
	        throw new IllegalArgumentException("El alumno con ID " + id + " no existe.");
	    }
	    return "redirect:/alumnos";
	}
}
