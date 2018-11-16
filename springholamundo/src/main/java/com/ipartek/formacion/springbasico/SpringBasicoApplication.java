package com.ipartek.formacion.springbasico;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//@SpringBootApplication
//@Configuration
//@ComponentScan
public class SpringBasicoApplication {

	//@Autowired
	private Salida salida;
	
	public static void main(String[] args) throws IOException {
		SpringBasicoApplication app = new SpringBasicoApplication();
				
		//ConfigurableApplicationContext context = SpringApplication.run(SpringBasicoApplication.class, args);
		
		//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringBasicoApplication.class);
		//SpringBasicoApplication app = context.getBean(SpringBasicoApplication.class);
		
		app.probarSalida();
	}
	
	private void probarSalida() throws IOException {
		//Fabrica fabrica = new Fabrica("configuracion.properties");
		//salida = fabrica.getSalida();
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("configuracion.xml");
		
		salida = context.getBean(Salida.class);
		Entrada entrada = context.getBean(Entrada.class);
		
		System.out.println(entrada.recibirMensaje());
		
		salida.mostrarMensaje();
		
		context.close();
	}
}
