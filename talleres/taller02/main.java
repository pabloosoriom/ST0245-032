
/**
 * Solucion al punto 3 taller 2.
 * 
 * @author (Pablo Alberto Osorio Marulanda y Verónica Mendoza Iguarán) 
 * @version (24/47/2018)
 */
public class main
{

    /**
     * Metodo main para ejecutar todo el taller2
     */
    public static void main(String args[])
    {
        //Objetos de prueba para los tres puntos
        Punto1 ejemplo1 = new Punto1();
        ejemplo1.gcdi(27,13);
  
        Punto2 ejemplo2 = new Punto2();
        int nums []={2,4,8};
        ejemplo2.sumaGrupo(0,nums,10);
        
        Punto3 ejemplo3 = new Punto3();
        ejemplo3.combinations("abcd");
    }

}
