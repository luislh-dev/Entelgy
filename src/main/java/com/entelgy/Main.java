package com.entelgy;

import com.entelgy.config.Configuracion;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Configuracion.class);

		AnimalApplication app = context.getBean(AnimalApplication.class);

		app.ejecutar(args);
	}
}
