package com.ipartek.formacion.javaee.cristinaservlets.filtros;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.ipartek.formacion.javaee.cristinaservlets.pojo.Usuario;

@WebFilter(dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.FORWARD }, urlPatterns = { "/admin/*" })
public class AdminFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// place your code here
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		Usuario usuario = (Usuario) httpRequest.getSession().getAttribute("user");

		if (usuario == null || !"admin@email.com".equals(usuario.getEmail())) {
			httpRequest.getRequestDispatcher("/login").forward(request, response);
		} else {
			chain.doFilter(request, response); //haz lo que hubieras hecho si no estuviera el filtro
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
}
