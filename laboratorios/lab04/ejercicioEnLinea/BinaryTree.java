/**
 * La clase BinaryTree otorga un manejo de un arbol binario de enteros
 * @author Verónica Mendoza Iguarán - Pablo Osorio Marulanda 
 * @version 1
 */

public class BinaryTree {
    // Sirve como raíz del árbol
    public Node root;

    /**
     * @param n el dato del nodo que se busca buscar
     * Metodo auxiliar de insetarAux.
     *
     */
    public void add(int n) {
        insertarAux(root, n);
    }

    /**
     * @param node es la raíz del arbol
     * @param n el data del nodo que se busca insertar
     * nota: metodo recursivo.
     * Inserta un dato respetando las desigualdades en el árbol
     */
    private void insertarAux(Node node, int n) {
        if (node == null){
            root = new Node(n);
        }else if (n > node.data){
            if(node.right == null){
                node.right=new Node(n);
            }else{
                insertarAux(node.right,n); //T(n) = T(n-1) + C
            }
        }
        else if(n < node.data){
            if(node.left == null){
                node.left=new Node(n);
            }
            else{
                insertarAux(node.left,n); //T(n) = T(n-1) + C
            }
        }

    }

    /**
     * @param n el dato del nodo que se busca.
     * Metodo auxiliar de buscarAux.
     * @return true si el metodo buscarAux es true
     */
    public boolean buscar(int n) {
        return buscarAux(root, n);
    }

    /**
     * @param node es la raíz del arbol
     * @param n el data del nodo que se busca
     * nota: metodo recursivo.
     * Inserta un dato respetando claro las desigualdades en el árbol
     * @return true si se encuentra el elemento en el árbol, false de lo contrario
     */ 

    private boolean buscarAux(Node node, int n) {
        if (node.data == n)
            return true;
        if (node == null)
            return false;
        if (n > node.data)
            return buscarAux(node.right, n); // T(n) = T(n-1) + C
        else // n < nodo.data
            return buscarAux(node.left, n);      
    }

}