package com.ipartek.formacion.javaee.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.javaee.modelos.Ahorcado;
import com.ipartek.formacion.javaee.modelos.Persona;

/**
 * Servlet implementation class AhorcadoServlet
 */
public class AhorcadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String palabra="";
	private  Ahorcado ahorcado=new Ahorcado();
	String palabraEle=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AhorcadoServlet() {
        super();
        if(palabraEle==null)
        	palabraEle=ahorcado.getPalabraElegida();
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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		palabra=request.getParameter("letOpal");
		ahorcado.setPalFin(palabraEle);
		if(palabra.length()==1) {
			ahorcado.setLetra(palabra.charAt(0));
		}	
		else
			ahorcado.setPalabra(palabra);
		request.setAttribute("ahorcado", ahorcado);
		request.getRequestDispatcher("ahorcado.jsp").forward(request, response);
		if(ahorcado.getVictoria()==1)
		palabraEle=null;
			
	}

}
