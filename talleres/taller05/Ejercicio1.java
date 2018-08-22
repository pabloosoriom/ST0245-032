
/**
 * Punto 1 de taller en sala #5.
 * 
 * @author Pablo Alberto Osorio Marulanda- Verónica Mendoza Iguarán 
 * @version 21/08/2018
 */
import java.util.concurrent.TimeUnit;
public class Ejercicio1
{
    public static void main(String[] args){
        for (int i = 0; i <= 20; i++){
            int[] a = new int[i];
            for (int j = 0; j < i; j++ ){
                a[j] = j;
            }
            long start = System.currentTimeMillis();
            sort(a);
            long fin = System.currentTimeMillis();       
            System.out.println(i+"--"+(fin-start));
        }
    }

    public static int [] sort(int [] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=i;j>0;j--){
                if(arr[j]<arr[j-1]){
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
                try{
                    TimeUnit.SECONDS.sleep(1);
                }
                catch (Exception e){
                }
            }

        }
        return arr;
    }
}

