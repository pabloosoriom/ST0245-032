import java.util.ArrayList;
/**
 * Esta clase es una implementación de un digrafo usando listas de adyacencia
 * 
 * @author Mauricio Toro 
 * @version 1
 * 
 */
import java.util.LinkedList;
public class DigraphAL extends Graph
{
    ArrayList<LinkedList<Pareja>> lista=new ArrayList<>();
    public DigraphAL(int size)
    {
        super(size);
        for(int i=0;i<size;i++){
            lista.add(new LinkedList());        
        }
    }

    public void addArc(int source, int destination, int weight)
    {
        Pareja pair=new Pareja(destination,weight);
        LinkedList <Pareja> temp=lista.get(source);
        temp.add(pair);
        lista.add(source,temp);
    }

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