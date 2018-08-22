
/**
 * Punto 2 de taller en sala #5.
 * 
 * @author Pablo Alberto Osorio Marulanda- Verónica Mendoza Iguarán 
 * @version 21/08/2018
 */
import java.util.concurrent.TimeUnit;
public class Ejercicio2
{

    public static void main(String[] args){
        for (int i = 0; i <= 100; i=i+5){
            int[] a = new int[i];
            for (int j = 0; j < i; j++ ){
                a[j] = j;
            }
            long start = System.currentTimeMillis();
            suma(a);
            long fin = System.currentTimeMillis();       
            System.out.println(i+"--"+(fin-start));
        }
    }

    private static int suma(int[] a){
        int suma = 0; // c_1
        for(int i = 0; i < a.length; i++){ //c_2+sum c_3,i=0 to n-1
            suma += a[i];
            try{
                TimeUnit.SECONDS.sleep(1);
            }
            catch (Exception e){
            }

        }
        return suma;
    }
}