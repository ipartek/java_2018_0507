package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.Comentario;
import com.ipartek.formacion.youtube.Video;
import com.ipartek.formacion.youtube.model.ComentariosMySqlDAO;
import com.ipartek.formacion.youtube.model.VideoArrayListDAO;
import com.ipartek.formacion.youtube.model.VideoMySqlDAO;

/**
 * Servlet implementation class Comentarios
 */

@WebServlet("/comentario")
public class ComentariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComentariosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Abra que añadirle el usuario que pone el comentarioy esto meter a la bd
		System.out.println("Comentario recibido en el servlet: "+request.getParameter("inputcomentario"));
		
		//Meter a la bd
		request.getParameter("inputcomentario");
		try {
			ComentariosMySqlDAO.getInstance().insert(new Comentario(request.getParameter("inputcomentario"),"UsuarioTemporal"));
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ComentariosMySqlDAO comentariomysqldao=new ComentariosMySqlDAO();
		comentariomysqldao.getAll();
		request.setAttribute("comentarios", comentariomysqldao.getAll());
		
		
		
		//Va sin barra
		response.sendRedirect("inicio");
	}

}
