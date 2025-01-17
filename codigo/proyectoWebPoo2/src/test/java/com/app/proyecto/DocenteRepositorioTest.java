package com.app.proyecto;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.app.proyecto.aula.aula;
import com.app.proyecto.docente.Docente;
import com.app.proyecto.docente.docenteRepositorio;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class DocenteRepositorioTest {

	@Autowired
	private docenteRepositorio repositorio;
	
	@Autowired
	private TestEntityManager entityMananger;
	
	@Test
	public void crearAula() {
		aula a1=new aula("aula 10", "mañana");
		
		entityMananger.persist(a1);	
	}
	
	@Test
	public void crearDocenteConUnAula() {
		aula a1=entityMananger.find(aula.class, 8);
		Docente d1=new Docente("alfredo", "tuesta abisrror", LocalDate.parse("2002-05-20"), "calleria", "afedo@gmail.com", "72510947", "982249802", "fisica");
		
		d1.agregarAula(a1);
		 repositorio.save(d1);
	}
	
	@Test
	public void crearDocenteConDosAulas() {
		aula a1=entityMananger.find(aula.class, 1);
		aula a2=entityMananger.find(aula.class, 2);
		Docente d1=new Docente("eduardo", "cordova sanchez", LocalDate.parse("1993-12-18"), "yarina", "edu@gmail.com", "76954674", "980567345", "lengua y filosofia");
		
		d1.agregarAula(a1);
		d1.agregarAula(a2);
		 repositorio.save(d1);
	}
	
	@Test
	public void asignarAulaDocenteExistente() {
		Docente d1=repositorio.findById(1).get();
		aula a1=entityMananger.find(aula.class, 4);
		
		d1.agregarAula(a1);
	}
	
	@Test
	public void eliminarAulaDocenteExistente() {
		Docente d1=repositorio.findById(1).get();
		aula a1= new aula(8);
		d1.eliminarAula(a1);
	}
	
	@Test
	public void crearNuevoDocenteConNuevoAula() {
		aula a1=new aula("aula 11", "tarde");
		Docente d1=new Docente("mayly", "de la fuerte gomez", LocalDate.parse("2004-11-11"), "calleria", "may@gmail.com", "78960907", "982249879", "comunicacion");
		
		d1.agregarAula(a1);
		 repositorio.save(d1);
	}
	
	@Test
	public void obtenerDocente() {
		Docente d1=repositorio.findById(1).get();
		entityMananger.detach(d1);
		
		System.out.println(d1.getNombres()+d1.getApellidos()+d1.getDni()+d1.getArea());
		System.out.println(d1.getAulas());
		}
	
	@Test
	public void eliminarDocente() {
		repositorio.deleteById(3);
	}
	
	
	
	
	
	
}
