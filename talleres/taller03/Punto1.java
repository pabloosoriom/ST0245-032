
/**
 * Solucion al punto 1 del taller 3
 * 
 * @author Pablo A.Osorio Marulanda - Verónica Mendoza Iguarán  
 * @version 31/07/2018
 */
public class Punto1
{
    public static void torresDeHannoi(int n){
        torresDeHannoiAux(n,1,2,3);
    }
    //Método auxiliar
    private static void torresDeHannoiAux(int n, int origen, int intermedio, int destino){
        //Caso base para imprimir
        if(n==1){
            System.out.println("Mover un disco de la torre " + origen + " a la " + destino);
        }else{
            //Llamados recursivos
            torresDeHannoiAux(n-1,origen,destino,intermedio);
            torresDeHannoiAux(1,origen,intermedio,destino);
            torresDeHannoiAux(n-1,intermedio,origen,destino);
        }
    }
}
