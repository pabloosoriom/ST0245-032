
/**
 * Punto 2 del taller 04
 * 
 * @author Pablo Alberto Osorio Marulanda- Verónica Mendoza Iguarán
 * @version 15/08/2018
 */
import java.util.concurrent.TimeUnit; 
public class Punto2
{
     public static void main(String[] args){
        for (int i = 1; i <= 20; i++){
            int[] a = new int[i];
            for (int j = 0; j < i; j++ ){
                a[j] = j;
            }
            long start = System.currentTimeMillis();
            sumaGrupo(0,a,i);
            long fin = System.currentTimeMillis();       
            System.out.println(fin-start);
        }
    }
    
    public static boolean sumaGrupo(int start, int[] nums, int target) {
        //Condicion base
        if (start >= nums.length){ //C1
            return target == 0; //C2
        }
        try{
                TimeUnit.SECONDS.sleep(1);
            }
            catch (Exception e){
            }
        //Condicion para los llamados recursivos
        if (sumaGrupo(start+1, nums, target - nums[start])){ //C3 + T(n-1)
            //Llamado que ingresa a la primera rama del arbol y evalua los subconjuntos respectivos
            return true; //C4
        }   // Segundo llamado recursivo(Ingreso a la otra rama del arbol)
        else   if ( sumaGrupo(start+1, nums, target)){  //C5 + T(n-1)
            return true;  //C6
        }  else {
            return false; //C7
        }

    }
}