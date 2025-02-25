package com.entelgy.model;

import com.entelgy.enums.TipoMovimiento;

public class AnimalVolador extends  Animal{
	public AnimalVolador(String nombre, String onomatopeya) {
		super(nombre, onomatopeya);
	}

	@Override
	public TipoMovimiento obtenerTipoDeMovimiento() {
		return TipoMovimiento.VOLADOR;
	}
}
