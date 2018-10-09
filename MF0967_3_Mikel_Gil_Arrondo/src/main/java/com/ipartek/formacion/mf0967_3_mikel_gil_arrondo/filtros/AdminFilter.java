package com.ipartek.formacion.mf0967_3_mikel_gil_arrondo.filtros;

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
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.mf0967_3_mikel_gil_arrondo.modelos.Usuario;

/**
 * Servlet Filter implementation class AdminFilter
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD
		}
					, urlPatterns = { "/admin/*" })
public class AdminFilter implements Filter {
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		Usuario usuario = (Usuario)((HttpServletRequest)request).getSession().getAttribute("user");
		
		if (usuario == null || !"scobby".equals(usuario.getNombre())){
			((HttpServletResponse)response).sendRedirect(((HttpServletRequest) request).getContextPath() + "/");
			return;
		}
		
		chain.doFilter(request, response);
	}

    public AdminFilter() {
    }

	public void destroy() {
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
