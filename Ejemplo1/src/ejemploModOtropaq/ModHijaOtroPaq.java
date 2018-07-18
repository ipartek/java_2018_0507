package ejemploModOtropaq;

import com.ipartek.formacion.ejemplomodificadores.Modificadores;

public class ModHijaOtroPaq extends Modificadores {
static String prot;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Modificadores m=new Modificadores();
		System.out.println(m.publico);
//		System.out.println(m.paquete);
//		System.out.println(m.protegido);
//		System.out.println(m.privado);
			ModHijaOtroPaq m1=new ModHijaOtroPaq();
			
			System.out.println(m1.publico);
//			System.out.println(m1.paquete);
			System.out.println(m1.protegido);
//			System.out.println(m1.privado);
	
	}

}
