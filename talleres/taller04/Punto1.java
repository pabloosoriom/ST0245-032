/**
 * Punto 1 del taller 04
 * 
 * @author Pablo Alberto Osorio Marulanda- Verónica Mendoza Hincapié
 * @version 15/08/2018
 */
import java.util.concurrent.TimeUnit; 
public class Punto1
{

    public static void main(String[] args){
        for (int i = 1; i <= 20; i++){
            int[] a = new int[i];
            for (int j = 0; j < i; j++ ){
                a[j] = j;
            }
            long start = System.currentTimeMillis();
            suma(a);
            long fin = System.currentTimeMillis();       
            System.out.println(fin-start);
        }
    }

    public static int suma(int[] a){
        return suma(a, 0);
    }

    //Método auxiliar para ejecutar la suma
    private static int suma(int[] a, int i){
        //Condicion base
        if (i == a.length)//C1
            return 0;//C2
        else{
            try{
                TimeUnit.SECONDS.sleep(1);
            }
            catch (Exception e){
            }
            //Condicion para el llamado recursivo
            return a[i] + suma(a,i+1);}//C3+t(n-1)
    }
}
