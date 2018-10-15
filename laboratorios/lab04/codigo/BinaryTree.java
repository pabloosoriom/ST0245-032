/**
 * La clase BinaryTree contiene una estructura para crear, a partir de la clase nodo
 * un arbol binario de Strings
 * @author Verónica Mendoza Iguarán - Pablo Osorio Marulanda 
 * @version 1
 */public class BinaryTree {
    public Node root;

    public BinaryTree(){
        root = null;
    }

    private int max2(int i, int j)
    {
        if (i > j)
            return i;
        return j;
    }

    private int maxheightAUX(Node node)
    {
        if (node == null)
            return 0;
        else 
            return max2(maxheightAUX(node.left), maxheightAUX(node.right))+1;
    }

    public int maxheight()
    {
        return maxheightAUX(root);
    }

    private void recursivePrintAUX(Node node)
    {
        if (node != null)
        {
            recursivePrintAUX(node.left);
            recursivePrintAUX(node.right);
            System.out.println(node.data);
        }

    }
    public void recursivePrint()
    {
        recursivePrintAUX(root);
    }

	
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

    public void calculaAbuela(String nombre){
        calculaAbuelaAux(root,nombre);
    }
}