package com.ipartek.formacion.MF0967;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.MF0967.pojo.ConnectBD;
import com.ipartek.formacion.MF0967.pojo.Perro;

/**
 * Servlet implementation class AltaPerro
 */
@WebServlet("/altaPerro")
public class AltaPerro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaPerro() {
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

		String nombreperro=request.getParameter("nombreperro");
		String edad=request.getParameter("edad");
		String raza=request.getParameter("raza");
		String peso=request.getParameter("peso");
		String apadrinado=request.getParameter("apadrinado");
		String chip=request.getParameter("chip");
		
	
		
		ConnectBD.savePerrosatDB(new Perro(nombreperro,Integer.parseInt(edad),raza,Double.parseDouble(peso),apadrinado,chip));
		
	
		
		
		response.sendRedirect("index.jsp");
	}
	  

}
