
/**
 * Punto 3 de taller en sala #5.
 * 
 * @author Pablo Alberto Osorio Marulanda- Verónica Mendoza Iguarán 
 * @version 21/08/2018
 */
import java.util.concurrent.TimeUnit;
public class Ejercicio3{
    public static void main (String [] args){
        for (int i = 0; i <= 20; i++){
            int j=0;
            for (j = 0; j < i; j++ ){
               j = j;
            }
            
            long start = System.currentTimeMillis();
            tablas(i,j);
            long fin = System.currentTimeMillis();       
            System.out.println(i+"--"+(fin-start));

        }

    }

    public static void tablas(int n,int m){
        for (int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                //System.out.println(i+"x"+j+"="+(i*j));
                String d=i+"x"+j+"="+(i*j);
                try{
                    TimeUnit.SECONDS.sleep(1);
                }
                catch (Exception e){
                }

            }
        }
    }

}	