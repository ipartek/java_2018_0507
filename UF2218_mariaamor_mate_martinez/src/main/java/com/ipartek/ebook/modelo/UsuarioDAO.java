package com.ipartek.ebook.modelo;

import com.ipartek.ebook.pojo.Usuario;

import java.util.ArrayList;
import java.util.List;


public class UsuarioDAO implements CrudAble<Usuario> {
	

    List<Usuario> usuarios = new ArrayList<Usuario>();
    private static UsuarioDAO INSTANCE;

    private UsuarioDAO() {

    }

    public static synchronized UsuarioDAO getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UsuarioDAO();
            INSTANCE.cargaInicial();
        }

        return INSTANCE;
    }

    private void cargaInicial(){
        Usuario usuario = new Usuario(1,"William","Shakespeare");
        Usuario usuario1 = new Usuario(2,"cervantes","pablo");
        Usuario usuario2 = new Usuario(3,"pablo","neruda");
        Usuario usuario3 = new Usuario(4,"paulo","cohelo");

        usuarios.add(usuario);
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);
    }

    public List<Usuario> getAll() {
        return usuarios;
    }

    public Usuario getById(long id) {
        Usuario user = null;
        for (Usuario u : usuarios)
            if (u.getID() == id) {
                return u;

            }
        return user;
    }

    public boolean insert(Usuario pojo) {
        if (pojo != null)
            usuarios.add(pojo);
        return false;
    }

    public boolean update(Usuario pojo) {
        if (pojo != null)
            for (int i = 0; i < usuarios.size(); i++) {
                if (usuarios.get(i).getID() == pojo.getID()) {
                    usuarios.get(i).setNombre(pojo.getNombre());
                    usuarios.get(i).setPass(pojo.getPass());
                }

            }
        return false;
    }

    public boolean delete(long id) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getID() == id)
                usuarios.remove(i);
        }
        return false;
    }


}
