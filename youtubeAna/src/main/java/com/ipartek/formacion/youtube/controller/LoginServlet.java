package com.ipartek.formacion.youtube.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.Comentario;
import com.ipartek.formacion.youtube.model.ComentariosMySqlDAO;

/**
 * Servlet implementation class Comentarios
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
			
		
		System.out.println("LoginServlet");
		
		//request.setAttribute("comentarios", comentariomysqldao.getAll());
		
		System.out.println(request.getParameter("email"));
		System.out.println(request.getParameter("pass"));
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		
		//Comprobar user y pass en la bbdd
		
		//para poder usar estos valores en el jsp hay que ponerlos en sesion
		request.getSession().setAttribute("email",email);
		request.getSession().setAttribute("pass",pass);
		
		//request.getRequestDispatcher("Logueado.jsp").forward(request, response);
		request.getRequestDispatcher("/inicio").forward(request, response);
		
		
		//Va sin barra
		//response.sendRedirect("Logueado.jsp");
	}

}
