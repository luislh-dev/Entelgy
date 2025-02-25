package com.entelgy.factory;

import com.entelgy.enums.TipoMovimiento;
import com.entelgy.model.Animal;
import com.entelgy.model.AnimalAcuatico;
import com.entelgy.model.AnimalTerrestre;
import com.entelgy.model.AnimalVolador;
import org.springframework.stereotype.Component;

@Component
public class AnimalFactory {
	public Animal crearAnimal(String name, String onomatopeya, TipoMovimiento tipoMovimiento) {
		return switch (tipoMovimiento) {
			case VOLADOR -> new AnimalVolador(name, onomatopeya);
			case ACUATICO -> new AnimalAcuatico(name, onomatopeya);
			case TERRESTRE -> new AnimalTerrestre(name, onomatopeya);
		};
	}
}
