import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Nodo {
	private String nombre;
	
	public Nodo(String nombre) {
        this.nombre = nombre;
    }
    
    private List<Nodo> distMasCorta = new LinkedList<>();
	
	//Simular distancia infinita en algoritmo Dijkstra
    private Integer distancia = Integer.MAX_VALUE;
     
    Map<Nodo, Integer> nodosCercanos = new HashMap<>();
 
    public void agregarDestino(Nodo destino, int distancia) {
    	nodosCercanos.put(destino, distancia);
    }
    
    // getters y setters

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Nodo> getDistMasCorta() {
		return distMasCorta;
	}

	public void setDistMasCorta(List<Nodo> distMasCorta) {
		this.distMasCorta = distMasCorta;
	}

	public Integer getDistancia() {
		return distancia;
	}

	public void setDistancia(Integer distancia) {
		this.distancia = distancia;
	}

	public Map<Nodo, Integer> getAdjacentNodes() {
		return nodosCercanos;
	}

	public void setAdjacentNodes(Map<Nodo, Integer> nodosCercanos) {
		this.nodosCercanos = nodosCercanos;
	}
}