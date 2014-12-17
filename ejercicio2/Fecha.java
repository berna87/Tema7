import java.time.*;
public class Fecha{
	private LocalDate fecha;
	public Fecha(LocalDate f){
		this.fecha=f;
		
	}
	public String toString(){
		return "La fecha es "+this.fecha;
	}
	
}
