
/**
 * Solucion al punto 6. 4)Simulacro de Parcial.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Punto6
{
    public static int suma(String n)
    {
        return sumaAux(n,0);
    }

     public static int sumaAux(String n, int i)
    {
        if(i>=n.length()) return 0;
        if(i+1 < n.length() && n.charAt(i) == n.charAt(i+1)){
            return sumaAux(n,i+2); //Linea 10
        }
        return (n.charAt(i)-'0') + sumaAux(n,i+1); //Linea 12
    }
}
