package com.app.proyecto.aula;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class aulaControlador {

	@Autowired
	private aulaRepositorio repositorio;
	
	@GetMapping("/aulas")
	public String listarAulas(Model modelo) {
		List<aula> listaAulas= repositorio.findAll();
		modelo.addAttribute("listaAulas", listaAulas);
		return "aulas";
	}
	
	@GetMapping("/aulas/nuevo")
	public String formularioNuevaAula(Model modelo) {
		modelo.addAttribute("aula",new aula());
		return "aula_formulario";
	}
	
	@PostMapping("/aulas/guardar")
	public String guardarAula(aula aula) {
		repositorio.save(aula);
		return "redirect:/aulas";
	}
	
	@GetMapping("/aulas/editar/{id}")
    public String formularioEditarAula(@PathVariable("id") Integer id, Model modelo) {
        aula aulaExistente = repositorio.findById(id).orElseThrow(() -> new IllegalArgumentException("Aula no encontrada con ID: " + id));
        modelo.addAttribute("aula", aulaExistente);
        return "aula_formularioEditar";
    }
	
	@GetMapping("/aulas/eliminar/{id}")
    public String eliminarAula(@PathVariable("id") Integer id) {
        aula aulaExistente = repositorio.findById(id).orElseThrow(() -> new IllegalArgumentException("Aula no encontrada con ID: " + id));
        repositorio.delete(aulaExistente);
        return "redirect:/aulas";
    }
}
