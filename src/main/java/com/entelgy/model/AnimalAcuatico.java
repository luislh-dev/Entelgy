package com.entelgy.model;

import com.entelgy.enums.TipoMovimiento;

public class AnimalAcuatico extends Animal {
	public AnimalAcuatico(String nombre, String onomatopeya) {
		super(nombre, onomatopeya);
	}

	@Override public TipoMovimiento obtenerTipoDeMovimiento() {
		return TipoMovimiento.ACUATICO;
	}

}
