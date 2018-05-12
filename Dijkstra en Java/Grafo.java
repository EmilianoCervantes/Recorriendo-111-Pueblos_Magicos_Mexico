import java.util.HashSet;
import java.util.Set;

public class Grafo {
 
    private Set<Nodo> nodos = new HashSet<>();
     
    public void agregaNodo(Nodo nodoA) {
        nodos.add(nodoA);
    }

	public Set<Nodo> getNodos() {
		return nodos;
	}

	public void setNodos(Set<Nodo> nodos) {
		this.nodos = nodos;
	}
}