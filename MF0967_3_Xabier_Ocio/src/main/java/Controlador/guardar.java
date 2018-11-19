package Controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Chip;
import modelo.ListaPerros;
import modelo.Perro;

/**
 * Servlet implementation class guardar
 */
public class guardar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public guardar() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombreP=request.getParameter("nombre");
		String edadP=request.getParameter("edad");
		String razaP=request.getParameter("raza");
		String pesoP=request.getParameter("peso");
		String idP=request.getParameter("id");
		String latitudP=request.getParameter("latitud");
		String longitudP=request.getParameter("longitud");
		int pesoPi=0;
		int edadPi=0;
		int longitudPi=0;
		int latitudPi=0;
	    try{
			pesoPi=(int)Integer.parseInt(pesoP);
			edadPi=(int)Integer.parseInt(edadP);
			longitudPi=(int)Integer.parseInt(longitudP);
			latitudPi=(int)Integer.parseInt(latitudP);
	    }catch(NumberFormatException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
	    }
	    if(pesoPi==0) {
	    	response.sendRedirect("administrar.jsp");
	    }else {
	    Chip ch=new Chip();
		Perro pojo=new Perro();
			pojo.setNombre(nombreP);
			pojo.setEdad(edadPi);
			pojo.setRaza(razaP);
			pojo.setPeso(pesoPi);
			
			ch.setId(idP);
			ch.setLatitud(latitudPi);
			ch.setLongitud(longitudPi);
			pojo.setPojoChip(ch);
			ListaPerros.getListaPerros().add(pojo);
			response.sendRedirect("index.jsp");
	    }
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
