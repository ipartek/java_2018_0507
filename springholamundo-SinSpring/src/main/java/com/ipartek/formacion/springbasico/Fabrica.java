package com.ipartek.formacion.springbasico;

import java.io.IOException;
import java.util.Properties;

public class Fabrica {
    private String tipoSalida, tipoEntrada;

    public Fabrica(String ficheroConfiguracion) throws IOException {
        Properties prop = new Properties();

        prop.load(Fabrica.class.getClassLoader().getResourceAsStream(ficheroConfiguracion));

        tipoEntrada = prop.getProperty("entrada");
        tipoSalida = prop.getProperty("salida");
    }

    public Entrada getEntrada() {
        switch (tipoEntrada) {
        case "constante":
            return new EntradaConstante();
        default:
            return null;
        }
    }

    public Salida getSalida() {
        switch (tipoSalida) {
        case "consolabasica":
            return new SalidaConsola(getEntrada());
        case "consolabonita":
            return new SalidaConsolaBonita(getEntrada());
        default:
            return null;
        }
    }
}