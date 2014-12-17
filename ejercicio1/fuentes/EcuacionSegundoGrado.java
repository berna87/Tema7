package librerias.matematicas;
public class EcuacionSegundoGrado{    //ecuacion segundo grado con get y set
	//variables que necesitare para trabajar internamente
	private double a;
	private double b;
	private double c;
	//metodos "get" para coger los datos de estas variables desde fuera de esta clase
	public double getA(){
		return this.a;
	}
	public double getB(){
		return this.b;
	}
	public double getC(){
		return this.c;	
	}
	
	//metodos "set" para asignar valores a las variables privadas igualandolos a un valor externo a esta clase
	public void setA(double a){
		this.a=a;	//el valor this.a y a son diferentes porque el "a" hace referencia al dato obtenido a traves del set
	}				//mientras que el this.a le asignara un valor a este, que sera el mismo valor que le hemos dado a set
	public void setB(double b){
		this.b=b;
	}
	public void setC(double c){
		this.c=c;
	}
	
	//metodos para resolver las operaciones de la ecuacion de segundo grado
	public double x1(){
		return (-this.b + (Math.sqrt(this.b*this.b-(4*this.a*this.c))))/(this.a*2);
	}
	public double x2(){
		return (-this.b - (Math.sqrt(this.b*this.b-(4*this.a*this.c))))/(this.a*2);
	}


}
