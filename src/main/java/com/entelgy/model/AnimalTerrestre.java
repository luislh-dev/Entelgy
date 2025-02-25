package com.entelgy.model;

import com.entelgy.enums.TipoMovimiento;

public class AnimalTerrestre extends Animal {
	public AnimalTerrestre(String nombre, String onomatopeya) {
		super(nombre, onomatopeya);
	}

	@Override public TipoMovimiento obtenerTipoDeMovimiento() {
		return TipoMovimiento.TERRESTRE;
	}

}
