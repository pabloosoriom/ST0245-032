/**
 * La clase nodo otora los parámetros iniciales para darle una estructura al arbol
 * @author Verónica Mendoza Iguarán - Pablo Osorio Marulanda 
 * @version 2
 */public class Node {
    public Node left;
    public Node right;
    public String data;
    
    /**
     * Constructor de la clase Node
     */
    public Node(String d){
        data = d;
    }
}