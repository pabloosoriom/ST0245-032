/**
 * Punto 3 del taller6
 * 
 * @author Pablo Alberto Osorio Marulanda- Verónica Mendoza Iguarán
 * @version 28/08/2018
 */
import java.util.*;
public class Ejercicio3
{
    public static void serie(int n){
        ArrayList<Integer>serie=new ArrayList<>();
        for(int i=1;i<=n;i++){//c_1+c_2*(n+1)
            for(int j=1;j<=i;j++){//c_3+n*((sum i=0 hasta n de i)+1)
                serie.add(j);//c_4+n*((sum i=0 hasta n de i))
            }
        }
        for(int i=0;i<serie.size();i++){//c_6*(n+1)+c
            System.out.print(serie.get(i) +" ");//c_7*n+1
        }
        System.out.println();
        //O(n)=n^2
    }
}
