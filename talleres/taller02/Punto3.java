
/**
 * Solucion al punto 3 taller 2.
 * 
 * @author (Pablo Alberto Osorio Marulanda y Verónica Mendoza Iguarán) 
 * @version (24/47/2018)
 */
public class Punto3
{
    /**
     * Metodo para ejecutar el auxiliar que contiene los llamados recursivos.
     */
    public static void combinations(String s) {    
        auxiliar("",s);
        System.out.println("\"\" ");
    }
    
  
    /**
     * Metodo auxiliar para resolver el problema.
     */
    public static void auxiliar(String base, String s) {
        if (s.length() == 0){        
            System.out.println(base);     
        }    
        else { 
            auxiliar (base + s.charAt(0), s.substring(1));   
            auxiliar (base, s.substring(1));  
        }
    }
    
    
}
