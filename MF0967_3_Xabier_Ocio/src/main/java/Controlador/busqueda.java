package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ListaPerros;

public class busqueda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public busqueda() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String buscar=request.getParameter("busqueda");
		for(int i=0;i<ListaPerros.getListaPerros().size();i++) {
			if(buscar.equals(ListaPerros.getListaPerros().get(i).getPojoChip().getId())){
				request.setAttribute("perro", ListaPerros.getListaPerros().get(i));
				request.getRequestDispatcher("mostrar.jsp").forward(request, response);
			}else if(buscar.equals(ListaPerros.getListaPerros().get(i).getNombre())) {
				request.setAttribute("perro", ListaPerros.getListaPerros().get(i));
				request.getRequestDispatcher("mostrar.jsp").forward(request, response);
			}
		}
		response.sendRedirect("index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
