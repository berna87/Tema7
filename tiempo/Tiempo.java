import java.time.*;
public class Tiempo{
	public static void main(String[]ar){
		//fehca
		LocalDate fecha = LocalDate.now();
		System.out.println("Fecha : "+fecha);																				// formato ingles
		System.out.printf("Fecha : %s-%s-%s%n", fecha.getDayOfMonth(), fecha.getMonthValue(), fecha.getYear()); // formato español
		//hora
		LocalTime hora = LocalTime.now();
		System.out.println("Hora : "+hora);
		//sumar cinco horas
		LocalTime nuevaHora = hora.plusHours(5);
		System.out.println("Hora despues de 5 horas : "+nuevaHora);
		//Fecha y hora
		LocalDateTime fechaYHora = LocalDateTime.now();
		System.out.println("Fecha y hora : "+fechaYHora);
		
				
	}
}
