package com.app.proyecto.aula;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}
