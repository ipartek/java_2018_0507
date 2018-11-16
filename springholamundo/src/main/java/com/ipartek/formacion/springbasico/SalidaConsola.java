package com.ipartek.formacion.springbasico;

//@Component
public class SalidaConsola implements Salida {
    private String mensaje;

    public SalidaConsola() {}
    
    //@Autowired
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