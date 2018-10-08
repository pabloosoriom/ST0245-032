/**
 * La clase contiene métodos necesarios para detectar el pivote en una lista de enterps
 * Solución al ejercicio 1.2del laboratorio 3
 * @author Pablo A. Osorio Marulanda- Verónica Mendoza Iguarán 
 * @version 1
 */
import  java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.*;
public class Exercise1_2
{
      /**
       * Método que detecta cual es el pivote en una lista de enteros
       * @param List, lista de números enteros para detectarle el pivote
       * @return int, int que significa el index donde esta el pivote
       */ public static int SmartInsert(List <Integer> list){
        int index=list.size()-1;
        ArrayList<Class1_2>pivotes=new ArrayList<>();
        //Funciona si el tamaño e la lista es mayor que 2
        for(int i=1;i<list.size()-1;i++){
            int sumleft=0;
            int sumright=0;
            for(int j=0;j<i;j++){
                sumleft=sumleft+list.get(j);	
            }
            for(int k=list.size()-1;k>i;k--){
                sumright=sumright+list.get(k);
            }
            int diferencia=Math.abs((sumleft-sumright));
            Class1_2 diference=new Class1_2(diferencia,i);
            pivotes.add(diference);
        }
        //Para recoger la menor diferencia;
        Class1_2 menor=pivotes.get(0);
        for(int l=1;l<pivotes.size();l++){
            Class1_2 temp=pivotes.get(l);
            if(temp.getData()<menor.getData()){
                menor=temp;
            }

        }
        return menor.getIndex();
    }
}

