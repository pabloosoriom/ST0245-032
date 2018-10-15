/**
 * La clase Laboratorio 4 se compone de metodos para dar solucion al punto 1.1 del laboratorio
 * numero 4.
 * @author Verónica Mendoza Iguarán - Pablo Osorio Marulanda 
 * @version 2
 */public class Laboratorio4 {

    /**
     * Metodo pra la creación de un arbol genealógico compuesto por los nombres de los familiares
     * @return BinaryTree con la composicion genealógica
     */public static BinaryTree ArbolGenealogico(String name){

        if(name.equals("Pablo")){
            BinaryTree ArbolPablo = new BinaryTree();
            ArbolPablo.root=new Node("Pablo");
            //Padres
            ArbolPablo.root.left=new Node("Nubia");
            ArbolPablo.root.right=new Node("Mario");
            //Materno
            //Abuelos
            ArbolPablo.root.left.left=new Node("Rosa");
            ArbolPablo.root.left.right=new Node("Pedro");
            //Bisabuelos
            ArbolPablo.root.left.left.left=new Node("Ana");
            ArbolPablo.root.left.left.right=new Node("Joaquín");
            ArbolPablo.root.left.right.left=new Node("Ana P");
            ArbolPablo.root.left.right.right=new Node("Pedro");
            //Tataraabuelos
            ArbolPablo.root.left.left.left.left=new Node("Joaquina");
            ArbolPablo.root.left.left.left.right=new Node("Valentín");

            //Paterno
            //Abuelos
            ArbolPablo.root.right.left=new Node("Arleni");
            ArbolPablo.root.right.right=new Node("Pablo");
            //Bisabuelos
            ArbolPablo.root.right.left.left=new Node("Leonilde");
            ArbolPablo.root.right.left.right=new Node("Ignacio");
            ArbolPablo.root.right.right.left=new Node("Ligia");
            ArbolPablo.root.right.right.right=new Node("Enrique");
            return ArbolPablo;
        }else if (name.equals("Verónica")){
            BinaryTree ArbolVeronica = new BinaryTree();
            ArbolVeronica.root=new Node("Verónica");
            //Padres
            ArbolVeronica.root.left=new Node("Edelis");
            ArbolVeronica.root.right=new Node("David");
            //Materno
            //Abuelos
            ArbolVeronica.root.left.left=new Node("Cayetana");
            ArbolVeronica.root.left.right=new Node("Julio");
            //Bisabuelos
            ArbolVeronica.root.left.left.left=new Node("Ana");
            ArbolVeronica.root.left.left.right=new Node("José");
            ArbolVeronica.root.left.right.left=new Node("Carlota");
            ArbolVeronica.root.left.right.right=new Node("Manuel");
            
            //Paterno
            //Abuelos
            ArbolVeronica.root.right.left=new Node("Catalina");
            ArbolVeronica.root.right.right=new Node("Nicolas");
            //Bisabuelos
            ArbolVeronica.root.right.left.left=new Node("Luisa");
            ArbolVeronica.root.right.left.right=new Node("Francisco");
            ArbolVeronica.root.right.right.left=new Node("Manuela");
            ArbolVeronica.root.right.right.right=new Node("Ramón");
            return ArbolVeronica;
        
        }
         return null;
    }

    /**
     * Método para dibujar estructura del arbol de busqueda respectivo
     * @param BinaryTree que se dibujará
     */
    public static void dibujarArbol(BinaryTree a)
    {
        System.out.println("/* arbolito para http://www.webgraphviz.com/ */"); 
        System.out.println("digraph arbolito {");
        System.out.println("size=\"6,6\";");
        System.out.println("node [color=aquamarine, style=filled];");
        dibujarArbolAux(a.root);
        System.out.println("}");
    }

    /**
     * Método auxiliar para dibujar arbol respectivo
     * @param Nodo que compone el arbol principal
     */private static void dibujarArbolAux(Node nodo)
    {
        if (nodo != null)
        //"x_\n__" -> "xo\n__";
            for(Node n: new Node[] {nodo.left, nodo.right} ){
                if (n != null)
                    System.out.println("\"" + nodo.data + "\" -> \"" + n.data + "\";");
                dibujarArbolAux(n);
            }
    }

    /**
     * Método main para la ejecución del programa
     */
    public static void main(String[] args) {
        //Crea el árbol familiar
        BinaryTree arbolP = ArbolGenealogico("Pablo");
        BinaryTree arbolV= ArbolGenealogico("Verónica");
        //Imprime el árbol familiar
        arbolP.recursivePrint();
        arbolV.recursivePrint();
        //Dibuja el árbol familiar
        dibujarArbol(arbolP);
        dibujarArbol(arbolV);
    }
}

