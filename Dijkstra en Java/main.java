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

        Qro.agregarDestino(Hgo, 12);
        Qro.agregarDestino(BCS, 15);
        
        Qroo.agregarDestino(BCN, 10);
        
        Hgo.agregarDestino(BCN, 2);
        Hgo.agregarDestino(BCS, 1);
        
        BCN.agregarDestino(BCN, 5);

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

        //Estas listas son mas o menos como deberia quedar el camino de la cdmx a los otros 5 lugares
        List<Nodo> rutaMasCortaParaQro = Arrays.asList(cdmx);
        List<Nodo> rutaMasCortaParaQroo = Arrays.asList(cdmx);
        List<Nodo> rutaMasCortaParaHgo = Arrays.asList(cdmx, Qro);
        List<Nodo> rutaMasCortaParaBCN = Arrays.asList(cdmx, Qro, Hgo);
        List<Nodo> rutaMasCortaParaBCS = Arrays.asList(cdmx, Qro, Hgo);

        //Deberia dar True
        boolean prueba = BCS.getDistMasCorta().equals(rutaMasCortaParaBCS);
        System.out.println(prueba);

        for (Nodo nodo : Mexico.getNodos()) {
            //Nada mas comprueba si es cierto
            //nodo.getDistMasCorta().equals(rutaMasCortaParaQro);
            switch (node.getName()) {
                case "Querétaro":
                    assertTrue(node
                      .getDistMasCorta()
                      .equals(shortestPathForNodeQro));
                    break;
                    case "Quintana Roo":
                    assertTrue(node
                      .getDistMasCorta()
                      .equals(shortestPathForNodeQroo));
                    break;
                case "Hidalgo":
                    assertTrue(node
                      .getDistMasCorta()
                      .equals(shortestPathForNodeHgo));
                    break;
                case "Baja California Norte":
                    assertTrue(node
                      .getDistMasCorta()
                      .equals(shortestPathForNodeBCN));
                    break;
                case "Baja California Sur":
                    assertTrue(node
                      .getDistMasCorta()
                      .equals(shortestPathForNodeBCS));
                    break;
                }
        }
    }
}