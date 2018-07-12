public class PruebaConsola
{
	public static void main(String[] argumentos) {
		//System.console().readLine() sólo funciona en la consola real, no en la de Eclipse
		//Sólo existe a partir de Java6
		
		System.out.print("Que saludo quieres: ");
		//Soy Mik
		String saludo = System.console().readLine();
		System.out.println(saludo + " " + argumentos[0]);
	}
}