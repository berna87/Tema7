import java.time.*;
import javax.swing.JOptionPane;
public class TestAleatorio{
	public static void main(String[]ar){
		LocalDate fecha = LocalDate.now();
		Fecha f1 = new Fecha(fecha);
		int n = (int)Math.round(Math.random()*10);
		Numero n1 = new Numero(n);
		String nomb = JOptionPane.showInputDialog("Introduce tu nombre");
		Nombre nom1 = new Nombre(nomb);
		String intNum = JOptionPane.showInputDialog("Introduce un numero del 1 al 10");
		int num = Integer.parseInt(intNum);
		System.out.println(f1);
		System.out.println(nom1);
		System.out.println(n1);
		if (num == n) System.out.println("Enhorabuena "+nomb+" has acertado el numero");
		else System.out.println("Lo siento "+nomb+" has fallado el numero, dijiste "+num+ " y el correcto era el "+n);
	}
}
//modo 1
//ejecutar con: java -cp librerias/fichero.jar:. TestAleatorio 
