package com.ipartek.formacion.springbasico;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@SpringBootApplication
@Configuration
@ComponentScan
public class SpringBasicoApplication {

	@Autowired
	private Salida salida;
	
	public static void main(String[] args) throws IOException {
		//ConfigurableApplicationContext context = SpringApplication.run(SpringBasicoApplication.class, args);
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringBasicoApplication.class);
		SpringBasicoApplication app = context.getBean(SpringBasicoApplication.class);
		
		app.probarSalida();
		
		context.close();
	}
	
	private void probarSalida() throws IOException {
		//Fabrica fabrica = new Fabrica("configuracion.properties");
		//salida = fabrica.getSalida();
		//ClassPathXmlApplicationContext context = 
		//		new ClassPathXmlApplicationContext("configuracion.xml");
		
		//salida = context.getBean(Salida.class);
		
		salida.mostrarMensaje();
	}
}
