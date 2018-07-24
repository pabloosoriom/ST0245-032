
/**
 * Punto 1 del taller 02
 * 
 * @author Pablo Alberto Osorio Marulanda- Verónica Mendoza Hincapié
 * @version 24/07/2018
 */
public class Punto1
{
    public static int gcdi (int p, int q){
        //Caso base
        if (q==0){
            return p;
        }else {
            //Llamado recursivo con algoritmo de euclides
            return gcdi(q, p%q);
        }

    }   

}