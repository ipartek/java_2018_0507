package com.ipartek.formacion.springbasico;

import java.io.IOException;

//@SpringBootApplication
//@Configuration
//@ComponentScan
public class SpringBasicoApplication {

	//@Autowired
	private Salida salida;
	
	public static void main(String[] args) throws IOException {
		SpringBasicoApplication app = new SpringBasicoApplication();
		
		//ClassPathXmlApplicationContext context = 
		//	new ClassPathXmlApplicationContext("configuracion.xml");
		//Salida salida = context.getBean(Salida.class);
		
		//ConfigurableApplicationContext context = SpringApplication.run(SpringBasicoApplication.class, args);
		
		//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringBasicoApplication.class);
		//SpringBasicoApplication app = context.getBean(SpringBasicoApplication.class);
		
		app.probarSalida();

		//context.close();
	}
	
	private void probarSalida() throws IOException {
		Fabrica fabrica = new Fabrica("configuracion.properties");
		salida = fabrica.getSalida();
		salida.mostrarMensaje();
	}
}
