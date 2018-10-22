
/**
 * Esta clase es una implementación de un digrafo usando listas de adyacencia
 * @author Pablo A. Osorio Marulanda - Verónica Mendoza Igurán  
 * @version 2
 * 
 */
import java.util.LinkedList;
import java.util.ArrayList;
public class DigraphAL extends Graph
{
    ArrayList<LinkedList<Pareja>> lista=new ArrayList<>();

    /**
     * Método constructor que crea la lista de adyacencia de vértices 
     * @param size - tamaño de la lista, esto es, la cantidad de vertices que tiene el grafo
     */
    public DigraphAL(int size)
    {
        super(size);
        for(int i=0;i<size;i++){
            lista.add(new LinkedList());        
        }
    }

    /**
     * Método para agregar los vertices adyacentes a cada una lista con su respectivo peso
     * @param source - origen del vértice
     * @param destination - destino del vértice, esto es, el vértice al que está dirigido
     * @param weight - peso del vértice
     */
    public void addArc(int source, int destination, int weight)
    {
        Pareja pair=new Pareja(destination,weight);
        LinkedList <Pareja> temp=lista.get(source);
        temp.add(pair);
        lista.add(source,temp);
    }

    /**
     * Método para obtener el peso del vértice
     * @param source - origen del vértice
     * @param destination - destino del vértice, esto es, el vértice al que está dirigido
     * @return el peso 
     */
    public int getWeight(int source, int destination)
    {
        LinkedList <Pareja> temp=lista.get(source);
        for(int i=0;i<temp.size();i++){
            if(temp.get(i).vertice==destination){
                return temp.get(i).peso;
            }
            break;
        }
        return 0;
    }

    /**
     * Método para obtener los vertices adyacentes a uno específico
     * @param vertice - vértice a evaluar
     * @return una lista de vertices adyacentes a uno ingresado
     */
    public ArrayList<Integer> getSuccessors(int vertice)
    {
        LinkedList<Pareja> temp=lista.get(vertice);
        ArrayList<Integer> sucessors=new ArrayList<>();
        for(int i=0;i<temp.size();i++){
            if(temp.get(i).peso!=0){
                sucessors.add(temp.get(i).vertice);
            }
        }
        return sucessors;
    }
}