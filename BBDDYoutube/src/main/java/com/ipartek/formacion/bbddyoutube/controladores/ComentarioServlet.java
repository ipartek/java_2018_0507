package com.ipartek.formacion.bbddyoutube.controladores;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.bbddyoutube.accesodatos.ComentarioMySqlDAO;
import com.ipartek.formacion.bbddyoutube.accesodatos.UsuarioMySqlDAO;
import com.ipartek.formacion.bbddyoutube.pojos.Comentario;
import com.ipartek.formacion.bbddyoutube.pojos.Usuario;

@WebServlet("/anadirComentario")
public class ComentarioServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("idVideo");
		String texto = request.getParameter("textoComentario");
		Long idL = Long.parseLong(id);
		
		Usuario usuario = (Usuario) request.getSession().getAttribute("user");
		Long idUser = UsuarioMySqlDAO.getInstance().getUserId(usuario);
		
		Date hoy = new Date();
		
		ComentarioMySqlDAO dao = ComentarioMySqlDAO.getInstance();
		Comentario comentario = new Comentario(idL,idUser,texto,hoy);
		dao.insert(comentario);
		
		request.getRequestDispatcher("contenido?id="+id).forward(request, response);
	}

}
