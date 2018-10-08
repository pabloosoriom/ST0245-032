
/**
 * La clase contiene métodos que sirven pra organizar de manera apropiada los carácteres de un String. 
 * Solución al ejercicio 2.1 del laboratorio 3
 * @author Pablo A. Osorio Marulanda- Verónica Mendoza Iguarán 
 * @version 1
 */
import  java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.*;
public class Ejercicio2_1
{
    
    private static LinkedList<String> words=new LinkedList<>();
    
    /**
     * Método que recibe el string invoca el metodo que lo organizará y a su vez, elmina del string final
     * los corchetes sobrantes.
     * @param String str String que necesita ser ordenado
     * @return String string ordenado
     * 
     */ public String inicioFin(String str){
        int tam=str.length();//c
        String temp="";//c
        linkedMethod(str.substring(0,tam));
        int size=words.size();//c
        for(int i=0;i<size;i++){//O(n)
            if(!(words.getFirst().equals("["))&&!(words.getFirst().equals("]"))){//C                
                temp+=words.getFirst();//O(n)
            }
            words.removeFirst();//c
        }
        return temp;//c
    }

    /**
     * Método que ejecuta todas ls funciones pra organizar internamente el LinkedList declarado como parámetro,
     * ortorgando a este último el orden verdadero de los carácteres
     * @param String String sin ordenar
     */private void linkedMethod(String str){
        LinkedList<String> copy=new LinkedList<>();//c
        boolean start=false;//c
        boolean end=true; //c
        int count=0;//c
        for(int i=0;i<str.length();i++){//O(n)
            copy.add(str.substring(i,i+1));//O(n)
        }
        int size=copy.size();//c
        String temp2="";//c
        for(int i=0;i<size;i++){//O(n)
            if(copy.getFirst().equals("[")){//O(n)
                start=true;//O(n)
                end=false;//O(n)
                count=0;      //O(n)                         
            }else  if(copy.getFirst().equals("]")){//O(n)
                start=false;//O(n)
                end=true; //O(n)                             
            }
            if(start){//O(n)
                words.add(count,copy.getFirst()); //O(n)        
            }else{//O(n)
                words.add(copy.getFirst());   //O(n)
            }
            count++;//O(n)
            copy.removeFirst();//O(n)
        }

    }
}

