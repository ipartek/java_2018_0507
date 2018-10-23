package com.ipartek.formacion.bbddyoutube.controladores;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.bbddyoutube.accesodatos.ComentarioMySqlDAO;
import com.ipartek.formacion.bbddyoutube.accesodatos.PuntuacionMySqlDAO;
import com.ipartek.formacion.bbddyoutube.accesodatos.UsuarioMySqlDAO;
import com.ipartek.formacion.bbddyoutube.pojos.Comentario;
import com.ipartek.formacion.bbddyoutube.pojos.Puntuacion;
import com.ipartek.formacion.bbddyoutube.pojos.Usuario;

/**
 * Servlet implementation class PuntuarController
 */
@WebServlet("/puntuar")
public class PuntuarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			String puntos = request.getParameter("rating");
			Long idL = Long.parseLong(id);
			int puntosI = Integer.parseInt(puntos);
			
			Usuario usuario = (Usuario) request.getSession().getAttribute("user");
			Long idUser = UsuarioMySqlDAO.getInstance().getUserId(usuario);
			
			PuntuacionMySqlDAO dao = PuntuacionMySqlDAO.getInstance();
			Puntuacion puntuacion = new Puntuacion (puntosI, idUser,idL);
			
			dao.insert(puntuacion);
			
			request.getRequestDispatcher("contenido?id="+id).forward(request, response);
			
		}catch(Exception e) {
			throw new ControladorException("Error al guardar la puntuacion", e);
		}
	}
}
