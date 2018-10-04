package com.ipartek.formacion.bbddyoutube.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.bbddyoutube.accesodatos.CrudAble;
import com.ipartek.formacion.bbddyoutube.accesodatos.UsuarioMySqlDAO;
import com.ipartek.formacion.bbddyoutube.pojos.Usuario;

/**
 * Servlet implementation class AdministrarUsuariosServlet
 */
@WebServlet("/usuarios")
public class AdministrarUsuariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		String id = request.getParameter("id");
		
		if (accion == null) {
			throw new ControladorException("No se admite una peticion que no tenga accion");
		}
		
		CrudAble<Usuario> dao = UsuarioMySqlDAO.getInstance();
		//UsuarioMySqlDAO<Usuario> dao = UsuarioMySqlDAO.getInstance();
		
		Long idL;
		Usuario usuario = null;
		switch (accion) {
			case "insertar":
				break;
			case "editar":
			case "borrar":
				idL = extraerId(id);
				usuario = dao.getById(idL);
				request.setAttribute("usuario", usuario);
				break;
			default:
				throw new ControladorException("No se admite una peticion que no sea insertar, editar o borrar");
		}
		
		request.setAttribute("accion", accion);
		request.getRequestDispatcher("/WEB-INF/admin/operacionesUsuario.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// PROCESAR LA OPCION SELECCIONADA
		String accion = request.getParameter("accion");
		String id = request.getParameter("id");
		
		if (accion == null) {
			throw new ControladorException("No se admite una peticion que no tenga accion");
		}
		
		CrudAble<Usuario> dao = UsuarioMySqlDAO.getInstance();
		//UsuarioMySqlDAO<Usuario> dao = UsuarioMySqlDAO.getInstance();
		
		Long idL;
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");

		Usuario usuario = null;
		switch (accion) {
			case "insertar":
				dao.insert(usuario);		
				break;
			case "editar":
				idL = extraerId(id);
				usuario = new Usuario(idL, nombre, password);
				dao.update(usuario);
				break;
			case "borrar":

				idL = extraerId(id);
				dao.delete(idL);
				break;
			default:
				throw new ControladorException("No se admite una peticion que no sea insertar, editar o borrar");
		}
		
		request.setAttribute("accion", accion);
		request.getRequestDispatcher("administrar").forward(request, response);
	}
	
	private long extraerId(String id) {
		long idLong;
		
		if (id == null) {
			throw new ControladorException("Necesito un id");
		}
		
		try {
			idLong = Long.parseLong(id);
		} catch (NumberFormatException e) {
			throw new ControladorException("El id no era numérico", e);
		}
		return idLong;
	}

}
