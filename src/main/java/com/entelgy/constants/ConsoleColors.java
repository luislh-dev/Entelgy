package com.entelgy.constants;

import com.entelgy.enums.TipoMovimiento;

public class ConsoleColors {
	public static final String RESET = "\u001B[0m";
	public static final String AMARILLO = "\u001B[93m";
	public static final String CYAN = "\u001B[36m";
	public static final String VERDE = "\u001B[32m";
	public static final String AZUL = "\u001B[34m";

	public static String obtenerColorPorTipo(TipoMovimiento tipo) {
		return switch (tipo) {
			case TERRESTRE -> VERDE;
			case VOLADOR -> AZUL;
			case ACUATICO -> CYAN;
		};
	}
}
