package com.ipartek.formacion.javaee.filtros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.javaee.modelos.LoginForm;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {

	public void destroy() {}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httprequest=(HttpServletRequest)request;
		HttpSession session= httprequest.getSession();
		
		LoginForm usuario=(LoginForm)session.getAttribute("usuario");
		
		if(usuario==null) {
			HttpServletResponse httpResponse =(HttpServletResponse)response;
			httpResponse.sendRedirect("/javaee/loginForm.jsp");
			return;
		}
		
		//chain es la cadena de peticion que te llega cuando todo va bien para ir a ella
		//Si no se cumple la condicion de arriba se ejecuta
		System.out.println("*********En zona de Administrador*************");
		chain.doFilter(request, response);
		
		
		//Ejecucion
		/*llamo a http://localhost:8080/javaee/admin
		 * y me redirige a http://localhost:8080/javaee/loginForm.jsp*/
	}

	public void init(FilterConfig fConfig) throws ServletException {}

}
package com.ipartek.formacion.javaee.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.javaee.modelos.LoginForm;

public class LoginFilter implements Filter {

	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//LoginForm usuario = (LoginForm)((HttpServletRequest)request).getSession().getAttribute("usuario");
		
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpSession session = httpRequest.getSession();
		LoginForm usuario = (LoginForm)session.getAttribute("usuario");
		
		if(usuario == null) {
			HttpServletResponse httpResponse = (HttpServletResponse)response;
			httpResponse.sendRedirect("/javaee/index.jsp");
			return;
		}
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {}

}
