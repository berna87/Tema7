import biblioteca.cadenas.Palabras;
import biblioteca.matematicas.Numeros;
public class Principal{
	public static void main(String[]ar){
		Palabras p1 = new Palabras("Oveja");
		Palabras p2 = new Palabras("cabra");
		System.out.println(p1);
		System.out.println(p2);
		System.out.println("-----------------------------");
		Numeros n1 = new Numeros(11);
		Numeros n2 = new Numeros(8);
		System.out.println(n1);
		System.out.println(n2);
	}
}
