package com.entelgy;

import com.entelgy.constants.ConsoleColors;
import com.entelgy.enums.TipoMovimiento;
import com.entelgy.factory.AnimalFactory;
import com.entelgy.model.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class AnimalApplication {

	private final AnimalFactory factory;

	@Autowired
	public AnimalApplication(AnimalFactory factory) {
		this.factory = factory;
	}

	public void ejecutar(String[] args) {
		if (args.length == 0) {
			System.out.println(ConsoleColors.AMARILLO + "No se proporcionaron argumentos. Ejecute el programa con el formato: 'Nombre|Onomatopeya|Tipo'" + ConsoleColors.RESET);
			return;
		}

		List<Animal> animals = Arrays.stream(args)
			.map(this::procesarEntrada)
			.filter(Optional::isPresent)
			.map(Optional::get)
			.collect(Collectors.toList());

		agruparYMostrar(animals);
	}

	/**
	 * Procesa una línea de entrada y devuelve un Optional<Animal> si es válido.
	 */
	private Optional<Animal> procesarEntrada(String input) {
		String[] parts = input.split("\\|");
		if (parts.length != 3) {
			System.out.println("Entrada inválida: " + input + ". Use el formato 'Nombre|Onomatopeya|Tipo'.");
			return Optional.empty();
		}

		String nombre = parts[0].trim();
		String onomatopeya = parts[1].trim();
		String tipoStr = parts[2].trim();

		if (nombre.isEmpty() || onomatopeya.isEmpty()) {
			System.out.println(ConsoleColors.AMARILLO + "Nombre u onomatopeya vacíos en: " + input + ". Se omitirá este animal." + ConsoleColors.RESET);
			return Optional.empty();
		}

		Optional<TipoMovimiento> tipoMovimiento = TipoMovimiento.desdeNombreEntrada(tipoStr);
		if (tipoMovimiento.isEmpty()) {
			System.out.println(ConsoleColors.AMARILLO + "Tipo no válido: " + tipoStr + " en: " + input + ". Se omitirá este animal." + ConsoleColors.RESET);
			return Optional.empty();
		}

		return Optional.of(factory.crearAnimal(nombre, onomatopeya, tipoMovimiento.get()));
	}

	/**
	 * Agrupa los animales por tipo de movimiento y los muestra en la consola.
	 */
	private void agruparYMostrar(List<Animal> animals) {
		Map<TipoMovimiento, List<Animal>> grupos = animals.stream()
			.filter(animal -> animal.obtenerTipoDeMovimiento() != null)
			.collect(Collectors.groupingBy(Animal::obtenerTipoDeMovimiento));

		grupos.forEach((tipo, lista) -> {
			String color = ConsoleColors.obtenerColorPorTipo(tipo);
			System.out.println(color + "** " + tipo + " (" + lista.size() + ") **" + ConsoleColors.RESET);
			lista.forEach(animal ->
				System.out.println(color + "- " + animal.getNombre() + ": " + animal.getOnomatopeya() + ConsoleColors.RESET));
		});
	}
}