package com.ipartek.formacion.springbasico;

import org.springframework.stereotype.Component;

@Component
public class EntradaConstante implements Entrada {

    @Override
    public String recibirMensaje() {
        return "HOLA MUNDO NUEVO";
    }

}