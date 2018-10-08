package com.ipartek.txarkur.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.txakur.accesoAdatos.PerroArrayDao;
import com.ipartek.txakur.pojo.Perro;
import com.ipartek.txakur.pojo.Usuario;
import com.ipartek.txarkur.LogicaNegocio.LogicaNegocio;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String logout=request.getParameter("logout");
		if(logout!=null) {
		request.getSession().invalidate();
		request.getRequestDispatcher("inicio").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombre, pass;
		Usuario usu;
		nombre = request.getParameter("usuario");
		pass = request.getParameter("password");
		if (nombre != null && pass != null) {
			if (LogicaNegocio.comprobarUsuario(nombre, pass) != null) {
				usu=LogicaNegocio.comprobarUsuario(nombre, pass);
				request.getSession().setAttribute("usuario", usu);
				request.setAttribute("perros",(ArrayList<Perro> )PerroArrayDao.getInstance().getAll());
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} else
				request.getRequestDispatcher("login.jsp").forward(request, response);
		} else
			throw new ControladoresException("no puede ser usuario o pass en blanco");

		doGet(request, response);
	}

}
