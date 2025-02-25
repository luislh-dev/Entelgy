package com.entelgy.factory;

import com.entelgy.enums.TipoMovimiento;
import com.entelgy.model.Animal;
import com.entelgy.model.AnimalAcuatico;
import com.entelgy.model.AnimalTerrestre;
import com.entelgy.model.AnimalVolador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class AnimalFactoryTest {
	private AnimalFactory factory;

	@BeforeEach
	void setUp() {
		factory = new AnimalFactory();
	}

	@Test
	void crearAnimal_TipoTerrestre_CreaAnimalTerrestre() {
		Animal animal = factory.crearAnimal("Perro", "Guau", TipoMovimiento.TERRESTRE);
		assertInstanceOf(AnimalTerrestre.class, animal);
	}

	@Test
	void crearAnimal_TipoAcuatico_CreaAnimalAcuatico() {
		Animal animal = factory.crearAnimal("Pez", "Blub", TipoMovimiento.ACUATICO);
		assertInstanceOf(AnimalAcuatico.class, animal);
	}

	@Test
	void crearAnimal_TipoVolador_CreaAnimalVolador() {
		Animal animal = factory.crearAnimal("Loro", "Pio", TipoMovimiento.VOLADOR);
		assertInstanceOf(AnimalVolador.class, animal);
	}
}
