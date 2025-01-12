package com.app.proyecto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.proyecto.aula.aula;
import com.app.proyecto.aula.aulaRepositorio;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class aulaRepositorioTest {

	@Autowired
	private aulaRepositorio repositorio;
	
	@Test
	public void testCrearAula(){
		aula aulaGuardada= repositorio.save(new aula("aula 1","mañana"));
		assertThat(aulaGuardada.getId()).isGreaterThan(0);
	}
}
