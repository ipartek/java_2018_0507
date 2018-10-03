package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.bbdd.Usuarios;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		//System.out.println(request.getParameter("user"));
		String user=request.getParameter("user");
		String pass=request.getParameter("pass");
		//System.out.println(request.getParameter("pass"));
		//response.sendRedirect("Logueado.jsp");
		
		//System.out.println("USUARIO recibido " + user);
		//System.out.println("PASS recibido " + pass);
		boolean usuarioBD=Usuarios.comprobarUsuario(user,pass);
		
		//System.out.println("Usuario en la bd??" + usuarioBD);
		if(usuarioBD) {
			if(user==null) {
				Usuarios.setUser("");
			}else {
				Usuarios.setUser(user);
			}
			request.setAttribute("user", user);
			request.setAttribute("pass", pass);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		
	}

}
