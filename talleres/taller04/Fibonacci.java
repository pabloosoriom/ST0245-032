/**
 * Punto 3 del taller 04
 * 
 * @author Pablo Alberto Osorio Marulanda- Verónica Mendoza Iguarán
 * @version 15/08/2018
 */
import java.util.concurrent.TimeUnit;
public class Fibonacci
{
    public static void main(String[] args){
        for (int i = 0; i <= 20; i++){
            long start = System.currentTimeMillis();
            fibonacci(i);
            long fin = System.currentTimeMillis();       
            System.out.println(fin-start);
        }
    }    

    //Método que muestra el enésimo número de la sucesión de fibonacci
    public static int fibonacci(int n){
        //Condicion base
        if(n==0||n==1){  //C1
            return n;  //C2
        }else{
            try{
                TimeUnit.SECONDS.sleep(1);
            }
            catch (Exception e){
            }
            //Condicion para los llamados recursivos
            return fibonacci(n-1)+fibonacci(n-2);  //C3 + T(n-1) + T(n-2)
        }
    }
}

