package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
<<<<<<< HEAD
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.youtube.model.UsuariosMySqlDAO;


@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.sendRedirect("inicio");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession respuesta = request.getSession(true);
		request.setCharacterEncoding("UTF-8");
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if(email == null || password == null) {
			throw new RuntimeException("Algun campo esta vacio");
		}
		
//		Usuarios user = new Usuarios(email,password);
		
                  try {
					if (UsuariosMySqlDAO.getInstance().isAcountExists(email, password)) {
					      //Significa que la cuenta si existe
					      //OBTENGO EL NOMBRE DEL USUARIO Y LO GUARDO EN UNA SESION
					      String NombreUsuario = UsuariosMySqlDAO.getInstance().getNameByEmail(email);
					      respuesta.setAttribute("email", NombreUsuario);
					      request.getSession().setAttribute("usuario", NombreUsuario);
					      
					  } else {
					      respuesta.setAttribute("error", "Datos mal metidos");
					  }
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                  response.sendRedirect("inicio");
              } 

}
=======

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.accesodatos.UsuarioMySqlDAO;
import com.ipartek.formacion.youtube.model.Usuario;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			Usuario usuario = UsuarioMySqlDAO.getInstance().getByEmail(email);
			
			if(usuario != null && password.equals(usuario.getPassword())) {
				request.getSession().setAttribute("usuario", usuario);
			} else {
				request.setAttribute("alertatipo", "danger");
				request.setAttribute("alertatexto", "El usuario o la contraseña son incorrectos");
			}
			
			request.getRequestDispatcher("/").forward(request, response);

		} catch (Exception e) {
			throw new ControladorException("Error en el login", e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
>>>>>>> branch 'master' of https://github.com/ipartek/java_2018_0507.git
