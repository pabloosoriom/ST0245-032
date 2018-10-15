/**
 * La clase BinaryTree contiene una estructura para crear, a partir de la clase nodo
 * un arbol binario de Strings
 * @author Verónica Mendoza Iguarán - Pablo Osorio Marulanda 
 * @version 2
 */public class BinaryTree {
    public Node root;

    /**
     * Constructor de la clase BinaryTree
     */
    public BinaryTree(){
        root = null;
    }

    
    /**
     * Método para calcular el máximo entre dos números
     * @param i - número 1 a comparar
     * @param j - número 2 a comparar
     * @return  el máximo entre dos números
     */
    private int max2(int i, int j)
    {
        if (i > j)
            return i;
        return j;
    }

    /**
     * Método auxiliar para calcular la máxima altura de un árbol
     * @param node - nodo del árbol
     * @return la máxima altura del árbol
     */
    private int maxheightAUX(Node node)
    {
        if (node == null)
            return 0;
        else 
            return max2(maxheightAUX(node.left), maxheightAUX(node.right))+1;
    }

    /**
     * Método para calcular la máxima altura de un árbol
     * @return la máxima altura del árbol
     */
    public int maxheight()
    {
        return maxheightAUX(root);
    }

    /**
     * Método auxiliar para imprimir un árbol
     */
    private void recursivePrintAUX(Node node)
    {
        if (node != null)
        {
            recursivePrintAUX(node.left);
            recursivePrintAUX(node.right);
            System.out.println(node.data);
        }

    }
    
    /**
     * Método para imprimir un árbol
     */
    public void recursivePrint()
    {
        recursivePrintAUX(root);
    }

    /**
     * Método auxiliar para calcular la abuela materna de una persona
     * @param node - nodo que representa a cada persona del grupo familiar en el árbol
     * @param nombre - nombre de la persona a la que se calculará su abuela
     * @return el nodo con la abuela de la persona
     */
    private Node calculaAbuelaAux(Node node, String nombre){ 
        try{
            if (node == null){
                System.out.println("No se ha encontrado la información requerida");
                return null;
            }
            if (node.data == nombre){
                System.out.println(node.left.left.data);
                return node.left.left;
            }
            else{
                calculaAbuelaAux(node.left,nombre);
                calculaAbuelaAux(node.right,nombre);
            }
        }catch(Exception e){
            System.out.println("No se ha encontrado la información requerida");
        }
        return null;
    }
    
    /**
     * Método para calcular la abuela materna de una persona
     */
    public void calculaAbuela(String nombre){
        calculaAbuelaAux(root,nombre);
    }
}