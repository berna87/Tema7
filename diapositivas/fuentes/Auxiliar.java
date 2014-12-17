//creamos una biblioteca basica situada en biblioteca.utilidades
//para hacerlo lo compilamos con el comando javac -d . + nombre del archivo
//seria javac -d . Auxiliar.java esto nos crearia el archivo class dentro de biblioteca/utilidades
package biblioteca.utilidades;
public class Auxiliar{
	//atributos
	private String nombre;
	private int edad;
	//constructor
	public Auxiliar(String n, int e){
		this.nombre=n;
		this.edad=e;
	}
	//getter y setters
	public String getNombre(){
		return this.nombre;
	}
	public int getEdad(){
		return this.edad;
	}
	public void setNombre(String n){
		this.nombre=n;
	}
	public void setEdad(int e){
		this.edad=e;
	}
	public boolean mayorDeEdad(){
		return this.edad>=18;
	}
	@Override
	public String toString(){
		return this.nombre+" con edad "+this.edad;
	}
}
