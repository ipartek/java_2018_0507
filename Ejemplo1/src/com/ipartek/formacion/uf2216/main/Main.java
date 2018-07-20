package com.ipartek.formacion.uf2216.main;

import java.util.Scanner;

import com.ipartek.formacion.uf2216.dao.RevistaDao;
import com.ipartek.formacion.uf2216.pojo.Revista;
/**
 * @class Main
 * @author AnaMAMM
 *
 */
public class Main {

	/**
	 * variables constantes para el switch
	 */
    private static final int INSERTAR = 1;
    private static final int LISTAR = 2;
    private static final int GUARDAR = 3;
    private static final int SALIR = 0;

    
    private static RevistaDao dao = RevistaDao.getInstance();
    private static Scanner s = new Scanner(System.in);
   
    
    public static void main(String[] args) {
        int opcion;
        /**
         * switch con do while para que se ejecute siempre que la opcion no sea salir
         * muestra el menu para pedir una opcion
         */
        
        do {
        	mostrarMenu();
            opcion =s.nextInt();
           
            switch (opcion){
                case INSERTAR:
//                	s.nextInt();
//                	Revista r = new Revista();
//                	if(r.validarIsbn(s) == true) {
                		
 //               	}
                	
                     String titulo =s.next();
                    
                    break;
                case LISTAR:
                    break;
                case GUARDAR:
                    break;
            }
            mostrarMenu();
        } while (opcion!=SALIR);


    }

    /**
     * muestra el menu
     */
    private static void mostrarMenu() {
        p("------------");
        p("Revistas");
        p("------------");
        p("");
        p("1. Insertar Revista");
        p("2. Listar libros insertados");
        p("3. Guardar en un fichero txt todos los libros");
        p("");
        p("0. Salir");
        p("");
        p("Elige una opción");
    }

    
    
    
/**
 * hace que no haya que escribir system.... tantas veces
 * @param s
 */
    public static void p(String s) {
        System.out.println(s);
    }

}