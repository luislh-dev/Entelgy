package com.entelgy.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TipoMovimientoTest {
	@Test
	void desdeNombreEntrada_NombreValido_RetornaEnum() {
		assertEquals(TipoMovimiento.TERRESTRE, TipoMovimiento.desdeNombreEntrada("Terrestre").orElse(null));
	}

	@Test
	void desdeNombreEntrada_NombreInvalido_RetornaEmpty() {
		assertTrue(TipoMovimiento.desdeNombreEntrada("Invalido").isEmpty());
	}
}
