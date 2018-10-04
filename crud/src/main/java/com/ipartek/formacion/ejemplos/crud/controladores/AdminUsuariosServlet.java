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
			if(id == null) {
				throw new ControladorException("Necesito un id");
			}
			
			try {
				longId = Long.parseLong(id);
			} catch (NumberFormatException e) {
				throw new ControladorException("El id no era numérico", e);
			}
			
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
		doGet(request, response);
	}

}