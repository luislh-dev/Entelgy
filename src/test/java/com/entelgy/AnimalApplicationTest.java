package com.entelgy;

import com.entelgy.exception.InvalidAnimalException;
import com.entelgy.factory.AnimalFactory;
import com.entelgy.model.Animal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public class AnimalApplicationTest {

	private AnimalApplication app;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@BeforeEach
	void setUp() {
		// Instancia real en lugar de mock
		AnimalFactory factory = new AnimalFactory();
		app = new AnimalApplication(factory);
		System.setOut(new PrintStream(outContent)); // Captura la salida de la consola
	}

	@Test
	void ejecutar_VariosAnimales_AgrupaCorrectamente() {
		String[] args = {"Perro|Guau|Terrestre", "Pez|Blub|Acuatico", "Pajaro|Pio|Volador", "Perro|Guau|Terrestre"};

		app.ejecutar(args);

		String salida = outContent.toString();
		assertTrue(salida.contains("** TERRESTRE (2) **"));
		assertTrue(salida.contains("- Perro: Guau"));
		assertTrue(salida.contains("- Perro: Guau"));
		assertTrue(salida.contains("** ACUATICO (1) **"));
		assertTrue(salida.contains("- Pez: Blub"));
		assertTrue(salida.contains("** VOLADOR (1) **"));
		assertTrue(salida.contains("- Pajaro: Pio"));
	}

	@Test
	void procesarEntrada_EntradaInvalida_LanzaExcepcion() {
		String input = "Pajaro-Pio|volador"; // Formato incorrecto

		InvalidAnimalException exception = assertThrows(InvalidAnimalException.class, () -> app.procesarEntrada(input));

		assertTrue(exception.getMessage().contains("Entrada inválida"));
	}

	@Test
	void procesarEntrada_EntradaValida_CreaAnimal() {
		String input = "Perro|Guau|Terrestre";

		Optional<Animal> resultado = app.procesarEntrada(input);

		assertTrue(resultado.isPresent());
		assertEquals("Perro", resultado.get().getNombre());
	}

	@Test
	void procesarEntrada_EntradaSinTipo_LanzaExcepcion() {
		String input = "Perro|Guau"; // Falta el tipo

		InvalidAnimalException exception = assertThrows(InvalidAnimalException.class, () -> app.procesarEntrada(input));

		assertTrue(exception.getMessage().contains("Entrada inválida"));
	}
}