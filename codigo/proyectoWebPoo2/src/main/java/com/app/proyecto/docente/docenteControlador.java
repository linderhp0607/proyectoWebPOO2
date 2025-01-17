package com.app.proyecto.docente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.proyecto.alumno.Alumno;
import com.app.proyecto.aula.aula;
import com.app.proyecto.aula.aulaRepositorio;

@Controller
public class docenteControlador {

	@Autowired
	private docenteRepositorio repositorio;
	
	@Autowired
	private docenteServicio docenteService;
	
	@Autowired
	private aulaRepositorio aulaRepository;
	
	@GetMapping("/docentes")
	public String listarDocentes(Model modelo,  @Param("palabraClave") String palabraClave) {
		List<Docente> listaDocentes= docenteService.listAll(palabraClave);
		modelo.addAttribute("listaDocentes", listaDocentes);
		modelo.addAttribute("palabraClave", palabraClave);
		return "docentes";
	}
	
	@GetMapping("/docentes/nuevo")
	public String formularioDocentes( Model modelo) {
		List<aula> listaAulas=aulaRepository.findAll();
		modelo.addAttribute("listaAulas", listaAulas);
		modelo.addAttribute("docente", new Docente());
		return "docentesFormulario";
	}
	
	@PostMapping("/docentes/guardar")
	public String guardarDocente(Docente docente) {
		repositorio.save(docente);
		return "redirect:/docentes";
	}
	
	@GetMapping("/docentes/editar/{id}")
	public String formularioEditarDocente(@PathVariable("id") Integer id, Model modelo) {
		Docente docente=repositorio.findById(id).get();
		modelo.addAttribute("docente", docente);
		List<aula> listaAulas=aulaRepository.findAll();
		modelo.addAttribute("listaAulas", listaAulas);
		return "docentesFormulario";
	}
	
	@GetMapping("/docentes/eliminar/{id}")
	public String eliminarDocente(@PathVariable("id") Integer id) {
	    if (repositorio.existsById(id)) {
	        repositorio.deleteById(id);
	    } else {
	        throw new IllegalArgumentException("El docente con ID " + id + " no existe.");
	    }
	    return "redirect:/docentes";
	}
	
}
