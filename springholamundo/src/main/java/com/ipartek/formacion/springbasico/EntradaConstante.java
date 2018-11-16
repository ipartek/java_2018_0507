package com.ipartek.formacion.springbasico;

//@Component
public class EntradaConstante implements Entrada {

    @Override
    public String recibirMensaje() {
        return "HOLA MUNDO NUEVO";
    }

}