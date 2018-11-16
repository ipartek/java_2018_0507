package com.ipartek.formacion.springbasico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class SalidaConsola implements Salida {
    private String mensaje;

    public SalidaConsola() {}
    
    @Autowired
    public SalidaConsola(Entrada entrada) {
        mensaje = entrada.recibirMensaje();
    }
    @Override
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    @Override
    public void mostrarMensaje() {
        mostrarMensaje(mensaje);
    }


}