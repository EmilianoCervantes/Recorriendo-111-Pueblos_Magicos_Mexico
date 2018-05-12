import java.util.Arrays;
import java.util.List;

public class Main {
    //Asi es como se podrian ingresar los datos para obtener las rutas
    public void Test(String[] args){
        Nodo cdmx = new Nodo("cdmx");
        Nodo Qro = new Nodo("Querétaro");
        Nodo Qroo = new Nodo("Quintana Roo");
        Nodo Hgo = new Nodo("Hidalgo");
        Nodo BCN = new Nodo("Baja California Norte");
        Nodo BCS = new Nodo("Baja California Sur");

        cdmx.agregarDestino(Qro, 10);
        cdmx.agregarDestino(Qroo, 15);

        Qro.agregarDestino(Hgo, 21);
        Qroo.agregarDestino(Hgo, 15);
        Grafo Mexico = new Grafo();
    
        Mexico.agregaNodo(cdmx);
        Mexico.agregaNodo(Qro);
        Mexico.agregaNodo(Qroo);
        Mexico.agregaNodo(Hgo);
        Mexico.agregaNodo(Hgo);
        Mexico.agregaNodo(Hgo);
        Mexico.agregaNodo(Hgo);

        //Despues de calcular, camino mas corto y distancia se pondran para cada nodo en el grafo
        Mexico = Dijkstra.calcularCaminoMasCortoDesdeOrigen(Mexico, cdmx);

        List<Nodo> rutaMasCortaParaQro = Arrays.asList(cdmx);
        List<Nodo> rutaMasCortaParaQroo = Arrays.asList(cdmx);
        List<Nodo> rutaMasCortaParaHgo = Arrays.asList(cdmx, Qro);
        List<Nodo> rutaMasCortaParaBCN = Arrays.asList(cdmx, Qro, Hgo);
        List<Nodo> rutaMasCortaParaBCS = Arrays.asList(cdmx, Qro, Hgo);
    }
}