
/**
 * Clase que simula la atencion en un banco.
 * @author Pablo Alberto Osorio Marulanda, 
 * Verónica Mendoza Iguarán 
 * @version 7/10/2018
 */

import java.util.*;
public class Banco
{
    /**
     * Método que simula la atencion de dos cajeros en un banco con cuatro filas
     * 
     * @param  fila1 - cada una de las cuatro filas que se forman en el banco
     */
    
    public static void simulacion(Fila fila1, Fila fila2, Fila fila3, Fila fila4)
    {
        LinkedList<Fila> filas = new LinkedList();
        filas.add(fila1);
        filas.add(fila2);
        filas.add(fila3);
        filas.add(fila4);
        int numPersonas = fila1.size()+fila2.size()+fila3.size()+fila4.size(); //número de personas en todas las filas
        Queue<Integer> cajeros = new LinkedList(); //una cola con los dos cajeros
        cajeros.add(1);
        cajeros.add(2);
        for(int i=0; i< numPersonas;i++){
            if(fila1.size()>0){
                System.out.println("El cajero " + cajeros.poll() + ", atiende a: " + fila1.getNombre());
            }else if(fila1.size()<0&&fila2.size()>0){
                System.out.println("El cajero " + cajeros.poll() + ", atiende a: " + fila2.getNombre());
            }else if(fila1.size()<0&&fila2.size()<0&&fila3.size()>0){
                System.out.println("El cajero " + cajeros.poll() + ", atiende a: " + fila3.getNombre());
            }else if(fila1.size()<0&&fila2.size()<0&&fila3.size()<0&&fila4.size()>0){
                System.out.println("El cajero " + cajeros.poll() + ", atiende a: " + fila4.getNombre());
            }else{
                System.out.println("No puede ser atendido");
            }
            if(cajeros.size()<0){
                cajeros.add(1);
                cajeros.add(2);
            }
        }
    }
    
    /**
     * Método para la ejecución de la simulación.
     */
    public static void main (String args[]){
        Queue<String> fil1 = new LinkedList();
        fil1.add("Pablo");
        fil1.add("Margot");
        Fila fila1 = new Fila(fil1);
        
        Queue<String> fil2 = new LinkedList();
        fil2.add("Camilo");
        fil2.add("Angela");
        fil2.add("Lucas");
        fil2.add("Simón");
        Fila fila2 = new Fila(fil2);
        
        Queue<String> fil3 = new LinkedList();
        fil3.add("Pedro");
        fil3.add("Francisca");
        fil3.add("Luciana");
        fil3.add("Ana");
        fil3.add("Cesar");
        fil3.add("David");
        Fila fila3 = new Fila(fil3);
        
        Queue<String> fil4 = new LinkedList();
        Fila fila4 = new Fila(fil4);
        
        simulacion(fila1, fila2, fila3, fila4);
    }
}
