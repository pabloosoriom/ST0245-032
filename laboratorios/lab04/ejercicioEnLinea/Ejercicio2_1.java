
/**
 * La clase Ejercicio2_1 se compone de metodos para dar solucion al punto 2.1 del laboratorio
 * numero 4.
 * @author Verónica Mendoza Iguarán - Pablo Osorio Marulanda 
 * @version 1
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Ejercicio2_1{
    /**
     * Método que se ejecuta para recopilar los elementos pre-orden del arbol y asi imprimirlos en post-orden
     */public static void PrePosOrden(){
        BinaryTree orden=new BinaryTree();
        Scanner console=new Scanner(System.in);
        System.out.println("Pre-orden");
        boolean temp=false;
        while(!temp){
            try{
                int n=console.nextInt();
                orden.add(n); //T(n)=n*n
             }
            catch(Exception e){
                temp=true;
                
            }
        }
        System.out.println("Post-Orden");
        postOrden(orden.root);
        
        //T(n) es O(n^2) (siendo n el número de elementos en el árbol)
    }

    /**
     * Método que de forma recursiva imprime los elementos de un arbol en port-orden (izquiera-derecha-raiz)
     * @param Node representa un nodo incluido en el arbol, que, inicalmente es la raiz
     */private static void postOrden(Node n){
        if(n!=null){
            postOrden(n.left);
            postOrden(n.right);
            System.out.println(n.data);

        }
        
        //T(n) = n
    }
}  