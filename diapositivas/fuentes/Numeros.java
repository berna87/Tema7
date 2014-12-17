//clase que genera numeros aleatorios
package biblioteca.utilidades;
public class Numeros{
	//atributos
	private int numero;
	//constructor
	public Numeros(){
		this.numero=(int)(Math.random()*10);
	}
	@Override
	public String toString(){
		return ("Numero creado = "+this.numero);
	}
}
