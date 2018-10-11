package com.ipartek.formacion.MF0967;


import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.MF0967.pojo.ConnectBD;
import com.ipartek.formacion.MF0967.pojo.Perro;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
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
	
		System.out.println("En el siguiente servlet");
		
		 ResultSet perros=ConnectBD.getPerrosfromDB();
		 
		
				
				//perros.getString("nombre")+" " +perros.getInt("edad")+" " +
					//	perros.getString("raza")+" " +rs.getString("peso")+" " +perros.getString("apadrinado")+" " +perros.getString("chip"));
			
		
		 
		request.setAttribute("perros",Perro.getDao());
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
