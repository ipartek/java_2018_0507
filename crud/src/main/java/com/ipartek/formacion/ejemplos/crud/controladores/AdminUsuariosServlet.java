package com.ipartek.formacion.ejemplos.crud.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.ejemplos.crud.accesodatos.CrudAble;
import com.ipartek.formacion.ejemplos.crud.accesodatos.UsuarioTreeMapDAO;
import com.ipartek.formacion.ejemplos.crud.modelos.Usuario;

@WebServlet("/admin/usuarios")
public class AdminUsuariosServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//MOSTRAR PANTALLA
		String accion = request.getParameter("accion");
		String id = request.getParameter("id");

		if (accion == null) {
			throw new ControladorException("No se admite una petición que no tenga accion");
		}

		CrudAble<Usuario> dao = UsuarioTreeMapDAO.getInstance();
		//UsuarioTreeMapDAO dao = UsuarioTreeMapDAO.getInstance();
		
		long longId;
		
		Usuario usuario;
		
		switch (accion) {
		case "insert":
			break;
		case "update":
		case "delete":
			longId = extraerId(id);
			
			usuario = dao.getById(longId);
			request.setAttribute("usuario", usuario);
			break;
		default:
			throw new ControladorException("No se admite una petición que no sea insert, update o delete");
		}

		request.setAttribute("accion", accion);
		request.getRequestDispatcher("/WEB-INF/admin/usuario.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//PROCESAR OPCION SELECCIONADA
		String accion = request.getParameter("accion");
		String id = request.getParameter("id");

		if (accion == null) {
			throw new ControladorException("No se admite una petición que no tenga accion");
		}

		CrudAble<Usuario> dao = UsuarioTreeMapDAO.getInstance();
		//UsuarioTreeMapDAO dao = UsuarioTreeMapDAO.getInstance();
		
		long longId;
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Usuario usuario;
		
		switch (accion) {
		case "insert":
			usuario = new Usuario(email, password);
			dao.insert(usuario);
			break;
		case "update":
			longId = extraerId(id);
			usuario = new Usuario(longId, email, password);
			dao.update(usuario);
			break;
		case "delete":
			longId = extraerId(id);
			dao.delete(longId);
			
			usuario = dao.getById(longId);
			request.setAttribute("usuario", usuario);
			break;
		default:
			throw new ControladorException("No se admite una petición que no sea insert, update o delete");
		}

		request.getRequestDispatcher("/admin/index").forward(request, response);
	}

	private long extraerId(String id) {
		long longId;
		
		if(id == null) {
			throw new ControladorException("Necesito un id");
		}
		
		try {
			longId = Long.parseLong(id);
		} catch (NumberFormatException e) {
			throw new ControladorException("El id no era numérico", e);
		}
		return longId;
	}

}
