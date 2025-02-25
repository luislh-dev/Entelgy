package com.entelgy.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalTest {
	@Test
	void obtenerSonido_RetornaCorrecto() {
		Animal perro = new AnimalTerrestre("Perro", "Guau");
		assertEquals("Guau", perro.getOnomatopeya());
	}

	@Test
	void obtenerNombre_RetornaCorrecto() {
		Animal gato = new AnimalTerrestre("Gato", "Miau");
		assertEquals("Gato", gato.getNombre());
	}
}
