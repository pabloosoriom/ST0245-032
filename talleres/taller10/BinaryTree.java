/**
* La clase BinaryTree intenta dar un conocimiento a los
* estudiantes acerca del manejo de un arbol binario de enteros.  
* Aquí se espera crear una estrcutura concreta del árbol binario,
* cabe aclarar que esta estrucutra ya esta implementada.
* @author Verónica Mendoza Iguarán - Pablo Osorio Marulanda 
* @version 2
*/


public class BinaryTree {
    //SI SUBRAYAN QUITEN EL MOUSE POR FAVOR.
    // Sirve como raíz del árbol
    public Node root;

    /**
     * @param n el dato del nodo que se busca buscar
     * Metodo auxiliar de insetarAux.
     *
     */
    public void insertar(int n) {
        insertarAux(root, n);
    }

    /**
     * @param node es la raíz del arbol
     * @param n el data del nodo que se busca insertar
     * nota: metodo recursivo.
     * Inserta un dato respetando claro las desigualdades en el árbol
     */
    private void insertarAux(Node node, int n) {
        if (node == null){
            Node root = new Node(n);
        }
        if(!buscar(n)){
            if (n > node.data){
                if(node.right == null){
                    node.right.data=n;
                }else{
                    insertarAux(node.right,n); //T(n) = T(n-1) + C
                }
            }
            else if(n < node.data){
                if(node.right == null){
                    node.left.data=n;
                }
                else{
                    insertarAux(node.left,n); //T(n) = T(n-1) + C
                }
            }
        }else{
            System.out.println("El dato ya está guardado");
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