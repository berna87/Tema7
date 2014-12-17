public class Nombre{
	private String nombre;
	public Nombre(String n){
		this.nombre=n;
	}
	@Override
	public String toString(){
		return "La persona se llama "+nombre;
	}
}
