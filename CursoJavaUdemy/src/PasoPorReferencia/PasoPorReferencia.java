package PasoPorReferencia;

public class PasoPorReferencia {

    public static void main(String[] args) {
        Persona p = new Persona();
        p.cambiarNombre("Juan");
        imprimirNombre(p);//Imprime Juan
        modificarPersona(p);
        imprimirNombre(p);//Imprime Carlos
    }

    public static void modificarPersona(Persona arg){
        arg.cambiarNombre("Carlos");
    }
    
    public static void imprimirNombre(Persona p ){
        System.out.println("Valor recibido :" + p.obtenerNombre());
    }
}
