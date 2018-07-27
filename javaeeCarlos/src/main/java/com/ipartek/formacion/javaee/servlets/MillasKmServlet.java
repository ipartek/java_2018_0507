package com.ipartek.formacion.javaee.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MillasKmServlet
 */
public class MillasKmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String m = request.getParameter("millas");
		String k = request.getParameter("km");

		if (k.equals("") || k.equals(null))
				k="0";
		
		if (m.equals("") || m.equals(null))
				m = "0";
		
		double millas = Double.parseDouble(m);
		double km = Double.parseDouble(k);
		
		System.out.println(millas);
		System.out.println(km);
		
		MillasKmForm mkm = new MillasKmForm(millas, km);
//		if (millas == 0 && km == 0) {
//			throw new RuntimeException("No se han recibido ni millas ni km");
//		}
		
		if(millas == 0 && millas == 0) { 
			mkm.setError("Debe introducir o millas o kilometros o ambos");
		}else {
			mkm.setError("");
		}
		if(millas == 0.0)
			mkm.setErrorMillas("");
		if(km == 0.0)
			mkm.setErrorKm("");
		if (millas != 0) {
			km = millas*1.60934;
			k = Double.toString(km);
			System.out.println(k);
			mkm.setErrorMillas(k);
		}
		if (km != 0) {
			millas= km*0.621371;
			m = Double.toString(millas);
			System.out.println(m);
			mkm.setErrorKm(m);
		}
		request.setAttribute("millaskm", mkm);
		
		request.getRequestDispatcher("millasKm.jsp").forward(request, response);
		
	}

}
