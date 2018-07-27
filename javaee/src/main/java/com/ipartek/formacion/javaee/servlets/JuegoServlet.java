package com.ipartek.formacion.javaee.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.javaee.modelos.Juego;
import com.ipartek.formacion.javaee.modelos.LoginForm;

/**
 * Servlet implementation class JuegoServlet
 */
public class JuegoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JuegoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<String> lista=new ArrayList<String>();
		lista.add("caracol");
		lista.add("lechuga");
		lista.add("torre");
		lista.add("temerario");
		Juego obj=new Juego();
		String respuesta=obj.getPalabra();
		if(respuesta.equals("")){
			obj.iniciarbf(pal);
		}
	}

}
