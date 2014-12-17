//programa que requiere de una clase externa
//ahora no trabajo con import
//pongo la ruta a la hora de crear el objeto
public class ProgramaNuevo{
	public static void main(String[]ar){
		biblioteca.utilidades.Auxiliar a = new biblioteca.utilidades.Auxiliar("Juan Garcia",26);
		a.setEdad(36);
		System.out.println(a);
	}
	
}
