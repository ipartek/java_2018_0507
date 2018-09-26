package com.ipartek.ebook.modelo;

import com.ipartek.ebook.pojo.Pagina;
import sun.security.krb5.internal.PAData;

import java.util.ArrayList;
import java.util.List;

public class PaginaDAO implements CrudAble<Pagina> {
    List<Pagina> paginas = new ArrayList<Pagina>();
    private static PaginaDAO INSTANCE;

    private PaginaDAO() {

    }

    public static synchronized PaginaDAO getInstance() {

        if (INSTANCE == null) {
            INSTANCE = new PaginaDAO();
            INSTANCE.cargaInicial();
        }

        return INSTANCE;
    }

    public int getLastId() {
        //Se hara la id incremental , es decir a medida que insertemos una pagina nueva aumentara en 1
        //Si el tamaño de la lista de paginas es 1 , significa que la unica pagina que hay tendra el ID 1
        //Si metemos una pagina mas el tamaño sera de 2 , pues ese 2 sera la id de la nueva pagina
    	

        int id = paginas.size() + 1;//Mas 1 para que cuando se meta en el array coincida tamaño 1 id 1 , si vamos a meter una nueva pagina llamamos a esta funcion nos deveulve 1+1 = 2 y 2 sera la nueva id
        return id;

    }

    private void cargaInicial() {
        Pagina pagina = new Pagina(1,"Erase una vez...","ADMIN");
        paginas.add(pagina);
    }

    public List<Pagina> getAll() {
        return paginas;
    }

    public Pagina getById(long id) {
        Pagina pagina = null;
        for (Pagina p : paginas)
            if (p.getId() == id) {
                return p;

            }
        return pagina;
    }

    public boolean insert(Pagina pojo) {
        if (pojo != null)
            paginas.add(pojo);
        return false;
    }

    public boolean update(Pagina pojo) {
        if (pojo != null)
            for (int i = 0; i < paginas.size(); i++) {
                if (paginas.get(i).getId() == pojo.getId()) {
                    paginas.get(i).setTexto(pojo.getTexto());
                    return true;
                }
            }
        return false;
    }

    public boolean delete(long id) {
        for (int i = 0; i < paginas.size(); i++) {
            if (paginas.get(i).getId() == id)
                paginas.remove(i);
        }
        return false;
    }

}
