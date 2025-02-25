package com.entelgy.constants;

import com.entelgy.enums.TipoMovimiento;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsoleColorsTest {
	@Test
	void obtenerColorPorTipo_TipoTerrestre_DevuelveVerde() {
		assertEquals(ConsoleColors.VERDE, ConsoleColors.obtenerColorPorTipo(TipoMovimiento.TERRESTRE));
	}
}
