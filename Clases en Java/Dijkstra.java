import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class Dijkstra {
	public static Grafo calcularCaminoMasCortoDesdeOrigen(Grafo mapaMexico, Nodo fuente) {
		fuente.setDistancia(0);
	 
	    Set<Nodo> nodosCalculados = new HashSet<>();
	    Set<Nodo> nodosNoCalculados = new HashSet<>();
	 
	    nodosNoCalculados.add(fuente);
	 
	    while (nodosNoCalculados.size() != 0) {
	    	Nodo nodoActual = getLowestDistanceNode(nodosNoCalculados);
	    	nodosNoCalculados.remove(nodoActual);
	        for (Entry < Nodo, Integer> parAdjunto: 
	        	nodoActual.getNodosCercanos().entrySet()) {
	        	Nodo nodoAdjunto = parAdjunto.getKey();
	            Integer pesoArista = parAdjunto.getValue();
	            if (!nodosCalculados.contains(nodoAdjunto)) {
	                CalculateMinimumDistance(nodoAdjunto, pesoArista, nodoActual);
	                nodosNoCalculados.add(nodoAdjunto);
	            }
	        }
	        nodosCalculados.add(nodoActual);
	    }
	    return mapaMexico;
	}
	
	//Obtener el nodo con la menor distancia del nodo no calculado
	private static Nodo getLowestDistanceNode(Set < Nodo > nodosNoCalculados) {
		Nodo nodoMenorDistancia = null;
	    int menorDistancia = Integer.MAX_VALUE;
	    for (Nodo nodo: nodosNoCalculados) {
	        int distanciaNodo = nodo.getDistancia();
	        if (distanciaNodo < menorDistancia) {
	        	menorDistancia = distanciaNodo;
	        	nodoMenorDistancia = nodo;
	        }
	    }
	    return nodoMenorDistancia;
	}
	
	//Compara la distancia actual con la ultima calculada
	// siguiendo el ultimo camino explorado
	private static void CalculateMinimumDistance(Nodo nodoEvaluacion, Integer pesoArista, Nodo nodoOrigen) {
	    Integer distOrigen = nodoOrigen.getDistancia();
	    if (distOrigen + pesoArista < nodoEvaluacion.getDistancia()) {
	    	nodoEvaluacion.setDistancia(distOrigen + pesoArista);
	        LinkedList<Nodo> rutaMasCorta = new LinkedList<>(nodoOrigen.getDistMasCorta());
	        rutaMasCorta.add(nodoOrigen);
	        nodoEvaluacion.setDistMasCorta(rutaMasCorta);
	    }
	}
}