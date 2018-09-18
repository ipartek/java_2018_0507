package com.ipartek.formacion.javaee.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Colores extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String color = "white";
		
		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie c = cookies[i];
				String name = c.getName();
				if("color".equals(name)) { //name.equals("color") da NullPointerException si no hay cookie llamada "color"
					color = c.getValue();
					break;
				}
			}
		}

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<body style='");
		out.println("background-color: ");
		out.println(color);
		out.println("'>");
		out.println("<form action='#' method='post'>");
		out.println("<select name='color'>");
		out.println("<option value='red'>Rojo</option>");
		out.println("<option value='green'>Verde</option>");
		out.println("<option value='blue'>Azul</option>");
		out.println("</select>");
		out.println("<button>Cambiar color preferido</button>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String color = request.getParameter("color");

//		PrintWriter out = response.getWriter();
//		out.println(color);

		Cookie c = new Cookie("color", color);
		c.setMaxAge(60 * 60 * 24 * 365 * 100);
		response.addCookie(c);

		response.sendRedirect("#");
	}
}
