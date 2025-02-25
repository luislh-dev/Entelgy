package com.entelgy.enums;

import java.util.Optional;

public enum TipoMovimiento {
	TERRESTRE("terrestre"),
	VOLADOR("volador"),
	ACUATICO("acuatico");

	private final String nombreEntrada;

	TipoMovimiento(String nombreEntrada) {
		this.nombreEntrada = nombreEntrada;
	}

	public static Optional<TipoMovimiento> desdeNombreEntrada(String nombreEntrada) {
		for (TipoMovimiento movementType : TipoMovimiento.values()) {
			if (movementType.nombreEntrada.equalsIgnoreCase(nombreEntrada)) {
				return Optional.of(movementType);
			}
		}
		return Optional.empty();
	}
}
