package librerias.matematicas;
public class SistemaEcuaciones{
	//atributos
	private double valorA;
	private double valorB;
	private double valorC;
	private double valorD;
	private double valorE;
	private double valorF;
	//constructor
	public SistemaEcuaciones(double va, double vb, double vc, double vd, double ve, double vf){
		this.valorA=va;
		this.valorB=vb;
		this.valorC=vc;
		this.valorD=vd;
		this.valorE=ve;
		this.valorF=vf;
	}
	//metodo que devuelve si la ecuacion tiene solucion o no
	public boolean esResoluble(){
			return ((this.valorA*this.valorD)-(this.valorB*this.valorC))!=0;
	}
	//metodo que devuelve el valor de x
	public double solucionX(){
		return ((this.valorE*this.valorD)-(this.valorB*this.valorF))/((this.valorA*this.valorD)-(this.valorB*this.valorC));
	}
	//metodo que devuelve el valor de y
	public double solucionY(){
		return ((this.valorA*this.valorF)-(this.valorE*this.valorC))/((this.valorA*this.valorD)-(this.valorB*this.valorC));
	}
	//sobreescribo el metodo toString
	@Override
	public String toString(){
		return ("\n"+this.valorA+"·x "+this.valorB+"·y ="+this.valorE+"\n"+this.valorC+"·x "+this.valorD+"·y ="+this.valorF+
		"\nTiene solucion : "+esResoluble()+"\nValor de X : "+solucionX()+"\nSolucion de Y : "+solucionY());
	}
	
}
/*class TestEcuacion{
	public static void main(String[]ar){
		Ecuacion e1 = new Ecuacion(1,1,2,2,1,2);
		Ecuacion e2 = new Ecuacion(2,1,-1,2,7,-1);
		System.out.println("Ecuacion 1 :");
		System.out.println(e1);
		evaluarResultados(e1);
		System.out.println("Ecuacion 2 :");
		System.out.println(e2);
		evaluarResultados(e2);
	}
	public static void evaluarResultados(Ecuacion e){  //creo un metodo estatico al que accedo directamente pasando como parametros la referencia
		if (e.esResoluble()) System.out.println("Solucion de x = "+e.solucionX()+"\nSolucion de y = "+e.solucionY());
		else System.out.println("La ecuacion no tiene solucion");
	}
}
*/



