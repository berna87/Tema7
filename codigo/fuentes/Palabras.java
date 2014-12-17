package biblioteca.cadenas;
public class Palabras{
	private String palabra;
	public Palabras(String p){
		this.palabra=p;
	}
	private boolean empiezaVocal(){
		return (this.palabra.startsWith("a")||this.palabra.startsWith("e")||this.palabra.startsWith("i")||this.palabra.startsWith("o")||this.palabra.startsWith("u")||
		this.palabra.startsWith("A")||this.palabra.startsWith("E")||this.palabra.startsWith("I")||this.palabra.startsWith("O")||this.palabra.startsWith("U"));
	}
	@Override
	public String toString(){
		return "La parabra : "+this.palabra+" empieza por vocal? : "+empiezaVocal();
	}
}
