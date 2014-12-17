
public class Numeros{
	private int numero;
	public Numeros(int n){
		this.numero=n;
	}
	private boolean esPar(){
		return (this.numero%2)==0;
	}
	public String toString(){
		return "El numero "+this.numero+" es par? : "+esPar();
	}
}
