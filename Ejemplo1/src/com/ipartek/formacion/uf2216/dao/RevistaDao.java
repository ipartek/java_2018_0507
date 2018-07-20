package com.ipartek.formacion.uf2216.dao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ipartek.formacion.uf2216.pojo.Revista;
/**
 * @class RevistaDao
 * @author AnaMAMM
 *
 */
public class RevistaDao implements CrudAble<Revista>{


    private List<Revista> revistas = new ArrayList<>();

    private static RevistaDao INSTANCE;

    
    /**
     * constructor
     */
    private RevistaDao() {
    }

    /**
     * metodo para crear solo una instancia
     * @return
     */
    public static synchronized RevistaDao getInstance() {

        if (INSTANCE == null) {
            INSTANCE = new RevistaDao();
        }

        return INSTANCE;
    }

    
    /**
     * lista todas las revistas
     */
    @Override
    public List<Revista> getAll() {
        return revistas;
    }

    /**
     * consigue una revista por su id
     */
    @Override
    public Revista getById(long id) {
        Revista resul = null;
        //foreach
        for (Revista revista : revistas) {
            if ( id == revista.getId() ) {
                resul = revista;
                break;
            }
        }
        return resul;
    }

    //El ISBN si se considerase unico se podria por ISBN

//    public Revista getByIsbn(String isbn){
//        Revista revista = null;
//        for(Revista revistaIt: revistas){
//            if(revistaIt.getIsbn().equalsIgnoreCase(isbn)){
//                revista=revistaIt;
//            }
//        }
//        return revista;
//    }

    
    /**
     * inserta una revista
     */
    @Override
    public boolean insert(Revista revista) {
        boolean resul = false;

        if (revista != null) {
            resul = revistas.add(revista);
        }
        return resul;
    }

    /**
     * actualiza una revista
     */
    @Override
    public boolean update(Revista revista) {
        boolean resul = false;
        Revista revistaIter = null;
        int i = 0;
        if ( revista != null ) {
            //Iterator
            Iterator<Revista> ir = revistas.iterator();
            while( ir.hasNext() ) {
                revistaIter = ir.next();
                if ( revistaIter.getId() == revista.getId() ) {
                    revistas.set(i, revista);
                    resul = true;
                    break;
                }
                i++;
            }
        }
        return resul;
    }

    /**
     * borra una revista
     */
    @Override
    public boolean delete(long id) {
        boolean resul = false;

        Revista revista = null;

        //buscar revista a eliminar
        for (int i = 0; i < revistas.size(); i++) {

            revista = revistas.get(i);   //revista sobre la que iteramos

            if ( id == revista.getId() ) {    // revista encontrada
                resul = revistas.remove(revista);
                break;
            }
        }

        return resul;
    }

}