import java.util.ArrayList;
import java.util.List;
 
public class Piloto {
 
    public static final int NUMERO_VUELTAS_ENTRENAMIENTO = 5;
 
    private final String nombre;
 
    private final List<Double> tiemposVueltas;
 
    public Piloto(String nombre) {
        this.nombre = nombre;
        this.tiemposVueltas = new ArrayList<Double>();
    }
 
    public String getNombre() {
        return nombre;
    }
 
    public List<Double> getTiemposVueltas() {
        return tiemposVueltas;
    }
    
}
