
import java.util.ArrayList;
/**
 * Esta clase es una implementación de un digrafo usando matrices de adyacencia
 * @author Pablo A. Osorio Marulanda - Verónica Mendoza Igurán 
 * @version 2
 */
public class DigraphAM extends Graph
{
    int[][] matriz;

    /**
     * Método constructor para crear una nueva matriz de adyacencia
     * @param size - tamaño de la matriz, esto es, la cantidad de vertices que tiene el grafo
     */
    public DigraphAM(int size)
    {
        super(size);
        matriz = new int[size][size];
    }

    /**
     * Método para obtener la arista (conección) que tiene un nodo dirigido con otro
     * @param source - origen del nodo
     * @param destination - destino del nodo, esto es, el vértice al que está dirigido
     * @return el peso 
     */
    public int getWeight(int source, int destination)
    {
        return matriz[source][destination];
    }

    /**
     * Método para agregar un nodo
     * @param source - origen del nodo
     * @param destination -  destino del nodo
     * @param weight - peso del nodo
     */
    public void addArc(int source, int destination, int weight)
    {
        matriz[source][destination] = weight;
    }

    /**
     * Método para obtener los vertices adyacentes a un nodo especifico
     * @param vertex - vértice del nodo a evaluar
     * @return ArrayList con los nodos adyacentes.
     */
    public ArrayList<Integer> getSuccessors(int vertex)
    {
        ArrayList<Integer> sucessors=new ArrayList<>();
        for(int i=0; i<size;i++){
            if(matriz[vertex][i]!=0){
                sucessors.add(matriz[vertex][i]);
            }
        }
        return sucessors;
    }
}