package com.entelgy.model;

import com.entelgy.enums.TipoMovimiento;

public abstract class Animal {
	private final String nombre;
	private final String onomatopeya;

	protected Animal(String nombre, String onomatopeya) {
		this.nombre = nombre;
		this.onomatopeya = onomatopeya;
	}

	public abstract TipoMovimiento obtenerTipoDeMovimiento();

	public String getOnomatopeya() {
		return onomatopeya;
	}

	public String getNombre() {
		return nombre;
	}
}
