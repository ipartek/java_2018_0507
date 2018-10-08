package com.ipartek.formacion.MF0967;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.MF0967.pojo.ConnectBD;
import com.ipartek.formacion.MF0967.pojo.Usuario;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nick = request.getParameter("nick");
		String password = request.getParameter("password");
		
		//System.out.println(nick+password);
		
		Usuario usuario = new Usuario(nick, password);
		//Chequeando si el usuario esta en la base de datos para dejarle entrar
		if(ConnectBD.checkUsuarioenBD(nick,password)) {
			request.getSession().setAttribute("usuario", usuario);
			request.getRequestDispatcher("index").forward(request, response);
		} else {
			response.sendRedirect("login.jsp");
		}
	}
}

