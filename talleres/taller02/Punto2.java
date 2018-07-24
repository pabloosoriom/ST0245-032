
/**
 * Punto 2 del taller 02
 * 
 * @author Pablo Alberto Osorio Marulanda- Verónica Mendoza Hincapié
 * @version 24/07/2018
 */
public class Punto2
{
    public static boolean sumaGrupo(int start, int[] nums, int target) {
        //Condicion base
        if (start >= nums.length){ 
            return target == 0;
        }
        //Condicion para los llamados recursivos
        if (sumaGrupo(start+1, nums, target - nums[start])){
            //Llamado que ingresa a la primer rama del arbol y evalua los subconjuntos respectivos
            return true;
        }   // Segundo llamado recursivo(Ingreso a la otra rama del arbol)
        else   if ( sumaGrupo(start+1, nums, target)){
            return true;
        }  else {
            return false;
        }

    }
}
