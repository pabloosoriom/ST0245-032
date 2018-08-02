
/**
 * Solución punto 3 (opcional) taller 3
 * 
 * @author Pablo A. Osorio Marulanda-Verónica Mendoza Iguarán
 * @version 01/08/2018
 */
public class Punto3
{
    //Método auxiliar
    private static void permutationsAux(String base, String s){
        int i=s.length();
        //Caso base
        if(s.length()==0){
            System.out.println(base);
        }else{
            //Caso para las repetidas
            if(base.length()==1){
                for(int p=0;p<=i;p++){
                    System.out.print(base);
                }
                System.out.println();
            }
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
