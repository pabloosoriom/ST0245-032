
import java.util.*;

/**
 * La clase Taller8 tiene la intención de
 * enfatizar en el uso de pilas y colas ya 
 * implementadas en java
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Queue.html"> Ver más acerca de colas<a/>
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html"> Ver más acerca de pilas <a/> 
 * @author Mauricio Toro, Andrés Páez 
 */
public class Taller8 {

    /**
     * @param stack es una pila ya implementada que se crea en el test
     * Este método se encarga de poner la pila stack en orden inverso
     * Nota: recuerde que la funcion pop() no solo expulsa la última 
     * posición de una pila si no que tambien devuelve su valor.
     * @return una pila que haga el inverso de stack
     */
    public static Stack<Integer> inversa (Stack<Integer> stack){
        Stack<Integer> temp= new Stack<>();
        while(stack.size()!=0){
            int tempo=stack.pop();
            temp.push(tempo);

        }
        return temp;
    }

    /**
     * @param queue es una cola ya implementada que se crea en el test
     * Este método se encarga de atender a personas.
     * Nota: Se debe imprimir en consola a quién atiende y sacarlo de la cola
     * existe una función "pull" que hace el trabajo más fácil
     * 
     */
    public static void cola (Queue<String> queue){
        while(queue.size()!=0){
            System.out.println("Atendiendo a: "+queue.remove());
        }
    }

    /**
     * @param string es una cadena de texto que viene de este modo 3 4 5 * + o de esta manera 2 3 * 5 +
     * todo viene separado por espacios por lo que la funcion split.("") vendría muy bien para separarlos
     * Se intenta hacer el calculo por medio del metodo polaco posfijo
     * @return un entero resultado de la operación
     */
    public static int polaca  (String string){
        String[]calculadora=string.split(" ");
        Stack <String> calcu=new Stack<>();
        int result=0;
        int temp2=0;
        for(int i= calculadora.length-1;i>=0;i--){
            calcu.push(calculadora[i]);
        }
        int size= calcu.size();

        for(int i=0;i<size;i++){
            String temp=calcu.pop();
            boolean result2;
            try {
                Integer.parseInt(temp);
                result2 = true;
            } catch (NumberFormatException excepcion) {
                result2 = false;
            }
            

            if(result2&&i==0){
                result=Integer.parseInt(temp);
            }else if(result2){
                temp2=Integer.parseInt(temp);
            }else if(temp.equals("+")){
                result=result+temp2;
            }else if(temp.equals("-")){
                result=result-temp2;

            }else if(temp.equals("*")){
                result=result*temp2;

            }else if(temp.equals("/")){
                result=result/temp2;
            }
        }
        return result;
    }
}
