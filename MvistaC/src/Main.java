import com.ignazio.controlador.ClienteController;
import com.ignazio.daoInt.ClienteDaoImpl;
import com.ignazio.daoInt.InterDao;
import com.ignazio.modelo.Cliente;
import com.ignazio.vista.ClienteVista;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Cliente clien=llenarDatosCliente();
//		ClienteVista vista =new ClienteVista();
//		ClienteController controlador=new ClienteController(clien, vista);
//		controlador.actualizarDatos();
//		controlador.setNombre("iñaki");
//		controlador.actualizarDatos();
		Cliente cli=new Cliente(1,"juan","al");
		InterDao clienteBueno =new ClienteDaoImpl();
		System.out.println(clienteBueno.obtenerClientes());
		System.out.println(clienteBueno.obtenerCliente(1));
		clienteBueno.actualizarCliente(cli);
		System.out.println(clienteBueno.obtenerClientes());
		clienteBueno.eliminarCliente(cli);
		System.out.println(clienteBueno.obtenerClientes());
		
		
		
		
	}
	
	private static Cliente llenarDatosCliente() {
		Cliente cliente = new Cliente();
		cliente.setId(1);
		cliente.setNombre("Elivar");
		cliente.setApellido("Largo");
		return cliente;
	}
}


