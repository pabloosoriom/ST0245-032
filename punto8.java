
/**
 * Solucion al punto 8. 4)Simulacro de Parcial.
 * 
 * @author () 
 * @version ()
 */
public class punto8
{
    public static int cuantas(int k,int[]v,int n)
    {
        if(k==0) return 1;
        boolean imposible;
        imposible = n<=0 && k>=1;
        imposible = imposible || k<0;
        if(imposible) return 0; //Linea 9 
        int ni = cuantas(k,v,n-1);
        int nj = cuantas(k-v[n-1],v,n);
        int suma = ni+nj; //Linea 13
        return suma;
    }
}
