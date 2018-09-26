package com.ipartek.ebook.logica;


import com.ipartek.ebook.modelo.PaginaDAO;
import com.ipartek.ebook.modelo.UsuarioDAO;
import com.ipartek.ebook.pojo.Pagina;
import com.ipartek.ebook.pojo.Usuario;

import java.util.List;


public class LogicaNegocio {

    public static boolean validarUsuario(Usuario usuario) {

        //Llamar DAO
        //Consultar por email
        // Comparar Password
    	

        UsuarioDAO userdao = UsuarioDAO.getInstance();
        List<Usuario> usuarios = userdao.getAll();
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuario.getNombre().equals(usuarios.get(i).getNombre()) && usuario.getPass().equals(usuarios.get(i).getPass())) {
                return true;
            }

        }
        return false;
    }

    public static List<Pagina> obtenerPaginas() {

        PaginaDAO paginaDAO = PaginaDAO.getInstance();
        List<Pagina> paginas = paginaDAO.getAll();
        return paginas;
    }

    public static Pagina obtenerPaginaPorId(long id) {

        PaginaDAO paginaDAO = PaginaDAO.getInstance();
        Pagina pagina = paginaDAO.getById(id);
        return pagina;

    }

    public static Pagina ultimaPagina() {
        PaginaDAO paginaDAO = PaginaDAO.getInstance();
        List<Pagina> paginas = paginaDAO.getAll();
        Pagina pagina = paginas.get(paginas.size() - 1);
        return pagina;
    }

    public static void agregarPagina(Pagina pagina) {

        PaginaDAO paginaDAO = PaginaDAO.getInstance();
        pagina.setId(paginaDAO.getLastId());
        paginaDAO.insert(pagina);

    }

    public static Pagina buscarPalabraEnPagina(String palabra){
        PaginaDAO paginaDAO = PaginaDAO.getInstance();
        List<Pagina> paginas = paginaDAO.getAll();
        int pos =-1;
        for(Pagina pagina : paginas){
            pos =pagina.getTexto().indexOf(palabra);
            if(pos!=-1) {
                return pagina;
            }
        }
        return null;
    }

    public static void modificarPagina(Pagina pagina) {
        PaginaDAO paginaDAO = PaginaDAO.getInstance();
        paginaDAO.update(pagina);

    }

    public static void borrarPagina(long id) {
        PaginaDAO paginaDAO = PaginaDAO.getInstance();
        paginaDAO.delete(id);
    }

}
