package com.ipartek.formacion.springrest.apirest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.springrest.modelos.Saludo;

@RestController
public class SaludoController {
	private static final String plantilla = "Hola, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/saludo")
    public Saludo saludar(@RequestParam(value="nombre", defaultValue="Mundo") String nombre) {
        return new Saludo(counter.incrementAndGet(),
                            String.format(plantilla, nombre));
    }
    
    @PostMapping("/saludo")
    public void recibirSaludo(@RequestBody Saludo saludo) {
    	System.out.println(saludo);
    }
    
    @GetMapping("/datos")
    public List<Saludo> saludos() {
    	List<Saludo> datos = new ArrayList<>();
    	
    	for(int i = 1; i <= 3; i++) {
    		datos.add(new Saludo(i, "Hola" + i));
    	}
    	
    	return datos;
    }
}
