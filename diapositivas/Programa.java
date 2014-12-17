//programa que requiere de una clase externa
import biblioteca.utilidades.Auxiliar;
import biblioteca.utilidades.Numeros;
public class Programa{
	public static void main(String[]ar){
		Auxiliar a = new Auxiliar("Juan Garcia",26);
		a.setEdad(36);
		System.out.println(a);
		Numeros n = new Numeros();
		System.out.println(n);
	}
	
}
