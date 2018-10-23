import java.util.ArrayList;
import java.util.Arrays;
/**
 * This class contains algorithms for digraphs
 * Soución al punto 2.1 Laboratorio 5 (Main y método isBipartite)
 * Adapted from: http://cs.fit.edu/~ryan/java/programs/graph/Dijkstra-java.html
 * @author Pablo Alberto Osorio Marualnda- Verónica Mendoza Iguarán-Mauricio Toro
 * @version 2
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javafx.util.Pair;
import java.util.LinkedList;
import java.util.Queue;

public class DigraphAlgorithms 
{

    /**
     * Método que comprueba si una matriz puede ser separada en dos colores
     * @param ArrayList que recopila las parejas que tienen un arco de enlace en el grafo
     * @return boolean que determina si el arbol puede ser pintado con dos colores y, por consiguiente, es bipartito
     */public static boolean isBipartite(ArrayList<Arco> parejas){
        //ArrayList que va a almacenar los colores asignados a cada nodo con el nodo respectivo
        ArrayList<Bicolor> NodoColor= new ArrayList<>();
        for(int i=0;i<parejas.size();i++){//O(n)
            //Varible que dice si esta en el arrayList de nodos coloreados(primero de la pareja)
            boolean temp1=false;//O(n)
            //Index que me dice la posicion de un vertice en el arraylist de nodos coloreados(primero de la pareja)
            int index1=0;//O(n)
            //Varible que dice si esta en el arrayList de nodos coloreados(segundo de la pareja)
            boolean temp2= false;//O(n)
            //Index que me dice la posicion de un vertice en el arraylist de nodos coloreados(segundo de la pareja)
            int index2=0;//O(n)
            //Para el primer miembro(detecta si se encuenetra para cambiar las variables anteriores)
            for(int j=0;j<NodoColor.size();j++){//O(n*m)
                if((NodoColor.get(j).vertice==parejas.get(i).origen)){//O(n*m)
                    temp1=true;//O(n*m)
                    index1=j;//O(n*m)
                    break;//O(n*m)
                }
            }
            //Para el segundo miembro(detecta si se encuenetra para cambiar las variables anteriores)
            for(int j=0;j<NodoColor.size();j++){//O(n*m)
                if((NodoColor.get(j).vertice==parejas.get(i).destino)){//O(n*m)
                    temp2=true;//O(n*m)
                    index2=j;//O(n*m)
                    break;//O(n*m)
                }
            }
            //Si ambos existe, como son pareja deben ser dftes
            if(temp1&&temp2){//O(n)
                if((NodoColor.get(index1).color*NodoColor.get(index2).color)==1){//O(n)
                    //Incoherencia (ambos son del mismo color)
                    return false;//O(n)
                }
            }else if(temp1){//O(n)
                NodoColor.add(new Bicolor(parejas.get(i).destino,((NodoColor.get(index1).color)*-1)));//O(n*m)              
            }else if(temp2){
                NodoColor.add(new Bicolor(parejas.get(i).origen,((NodoColor.get(index2).color)*-1)));//O(n*m)            
            }else{
                NodoColor.add(new Bicolor(parejas.get(i).origen,-1));//O(n*m)
                NodoColor.add(new Bicolor(parejas.get(i).destino,1));//O(n*m)
            }
        }
        return true;
    }
    
    
    private static int minVertex (int [] dist, boolean [] v) {
        int x = Integer.MAX_VALUE;
        int y = -1;   // graph not connected, or no unvisited vertices
        for (int i=0; i<dist.length; i++) {
            if (!v[i] && dist[i]<x) {y=i; x=dist[i];}
        }
        return y;
    }
    

    static int [] dijsktra(Graph dg, int source)
    {
        final int [] dist = new int [dg.size()];  // shortest known distance from "s"
        final int [] pred = new int [dg.size()];  // preceeding node in path
        final boolean [] visited = new boolean [dg.size()]; // all false initially

        for (int i=0; i<dist.length; i++) {
            dist[i] = Integer.MAX_VALUE; //Infinity
        }
        dist[source] = 0;

        for (int i=0; i<dist.length; i++) {
            final int next = minVertex (dist, visited);
            visited[next] = true;

            // The shortest path to next is dist[next] and via pred[next].

            final ArrayList<Integer> n = dg.getSuccessors (next); 
            for (int j=0; j<n.size(); j++) {
                final int v = n.get(j);
                final int d = dist[next] + dg.getWeight(next,v);
                if (dist[v] > d) {
                    dist[v] = d;
                    pred[v] = next;
                }
            }
        }
        return pred;  // (ignore pred[s]==0!)
    }

    public static ArrayList getPath (int [] pred, int s, int e) {
        final java.util.ArrayList path = new java.util.ArrayList();
        int x = e;
        while (x!=s) {
            path.add (0, x);
            x = pred[x];
        }
        path.add (0, s);
        return path;
    }

    // Código para dibujar el grafo en GraphViz
    // Recomiendo www.webgraphviz.com/
    public static void dibujarGrafo(Graph g)
    {
        System.out.println("digraph Grafo {");
        System.out.println("node [color=cyan, style=filled];");
        int nv = g.size();
        for (int i = 0; i < nv; i++)
        {
            ArrayList<Integer> lista = g.getSuccessors(i);
            for (int j = 0; j < lista.size(); j++)
                System.out.println("\"" + i + "\" -> \"" + lista.get(j) + "\" [ label=\""+ g.getWeight(i,lista.get(j)) +"\"];");
        }
        System.out.println("}");
    }

    public static void main(String[] args)
    throws IOException
    {
        //Lector de texto
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        //Cantida de nodos
        int size=Integer.parseInt(br.readLine());  
        //Cantidad de arcos
        int Arcsize=Integer.parseInt(br.readLine());
        //Arraylist que almacena lo los arcos en forma de pareja
        ArrayList<Arco> nodos= new ArrayList<>();
        String temp=br.readLine();
        while(!(temp.equals("0"))){//O(n)
            String [] parts= temp.split(" ");//O(n)
            nodos.add(new Arco(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]))); //O(n*n)
            temp=br.readLine();//O(n)
        }
        boolean bicolor=isBipartite(nodos);//O(n*m)
        if(bicolor) System.out.println("BICOLOREABLE");
        else System.out.println("NOT BICOLOREABLE");

    }

}
