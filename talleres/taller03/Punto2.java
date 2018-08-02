
/**
 * Respuesta al punto 2 del taller 03.
 * 
 * @author PAblo A. Osorio Marulanda-Verónica Mendoza Iguarán
 * @version 01/08/2017
 */
public class Punto2
{

    //Método auxiliar
    private static void permutationsAux(String base, String s){
        int i=s.length();
        //Caso base
        if(s.length()==0){
            System.out.println(base);
        }else{
            //Ciclo con llamado recursivo para poder ser intermitentes en el string
            for(int j=0;j<i;j++){
                permutationsAux(base+s.substring(j,j+1),s.substring(0,j)+s.substring(j+1));
            }
        }
    }

    public static void permutations(String s){
        permutationsAux("",s);
    }
}
