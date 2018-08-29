/**
 * Punto 2 del taller6
 * 
 * @author Pablo Alberto Osorio Marulanda- Verónica Mendoza Iguarán
 * @version 28/08/2018
 */
import java.util.Scanner;
import java.util.*;

public class Ejercicio2
{
    private static ArrayList<Integer> array=new ArrayList<>();
    public static void main (String [] args){
        Scanner entero=new Scanner(System.in);//c_1
        int number=entero.nextInt();//c_2
        while(number!=-1){//c_3*(n+1)
            array.add(0,number);//c_4(n^2)
            number=entero.nextInt();//c_5*n
        }
        for(int i=0;i<array.size();i++){//c_6*(n+1)+c
            System.out.println(array.get(i));//c_7*n+1

        }
        //T(n)=c_1+c_2+(c_3*(n+1))+c_4(n^2)+c_4(n^2)+c_5*n+c_6*(n+1)+c+c_7*n+1
        //O(n)=n^2
    }
}
