package com.ipartek.formacion.javaee.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PaletaColores extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<body>");
		out.print("<form action='#' method='post'>");
		out.println("<select name='color'>");
		out.println( "<option value='verde'>Verde</option>");
		out.println( "<option value='rojo'>Rojo</option>");
		out.println( "<option value='azul'>Azul</option>");
		out.println("</select>");
		out.println("<button>Enviar<button>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		String color = request.getParameter("color");
		
		
		if (color.equals("verde"))
		{
			 	PrintWriter out = response.getWriter();
	            out.println ("<HTML>");
	            out.println ("<BODY style='background-color'= green");
	            out.println ("</BODY></HTML>");
	            out.close();
		}
		if (color.equals("rojo"))
		{
			 	PrintWriter out = response.getWriter();
	            out.println ("<HTML>");
	            out.println ("<BODY style='background-color'= red");
	            out.println ("</BODY></HTML>");
	            out.close();
		}
		if (color.equals("azul"))
		{
			 	PrintWriter out = response.getWriter();
	            out.println ("<HTML>");
	            out.println ("<BODY style='background-color'= blue");
	            out.println ("</BODY></HTML>");
	            out.close();
		}

//		Cookie[] cs = request.getCookies();
//		for (int i = 0; i < cs.length; i++) {
//			if ((cs[i].getName()).equals("verde")) {
//				color = cs[i].getValue();
//				break;
//			}
//		}

		request.getRequestDispatcher("index.html").forward(request, response);

	}

}
