package com.ipartek.formacion.springbasico;

public class SalidaConsolaBonita implements Salida {
    private String mensaje;

    //@Autowired
    public SalidaConsolaBonita(Entrada entrada) {
        mensaje = entrada.recibirMensaje();
    }
    @Override
    public void mostrarMensaje(String mensaje) {
        for(int i = 0; i < mensaje.length(); i++) {
            System.out.print('-');
        }
        
        System.out.println();

        System.out.println(mensaje);
        
        for(int i = 0; i < mensaje.length(); i++) {
            System.out.print('-');
        }

        System.out.println();
    }

    @Override
    public void mostrarMensaje() {
        mostrarMensaje(mensaje);
    }


}