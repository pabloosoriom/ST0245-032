
/**
 * Clase que simula un almacen de neveras. 
 * En esta clase se encuentran las neveras y  
 * las solicitudes que le hacen al almacen.
 * @author Pablo Alberto Osorio Marulanda, 
 * Verónica Mendoza Iguarán 
 * @version 7/10/2018
 */
import java.util.*;
public class Almacen
{
    static Stack<Nevera> neveras=new Stack<>();
    static Queue<Solicitud> solicitudes=new LinkedList();

    /**
     * Método para agregar neveras al almacen
     * 
     * @param nevera - nevera que se va a agregar al almacen.
     * La nevera se agrega a una pila.
     */
    public static void agregarNevera (Nevera nevera){
        neveras.push(nevera);
    }

    /**
     * Método para agregar una solicitud a una lista.
     * @param solicitud- solicitud que se hace al almacen.
     * La solicitud se agrega a una lista (cola)
     */
    public static void agregarSolicitud (Solicitud solicitud){
        solicitudes.add(solicitud); 
    }

    /**
     * Método que simula la atención de solicitudes del almacen
     */
    public static void atenderSolicitud(){
        int tamList=solicitudes.size();
        for(int i=0;i<tamList;i++){
            Solicitud solicitud= solicitudes.remove();
            int cantidad=solicitud.getCantidad();
            System.out.print(solicitud.getName() + " :");
            while(cantidad!=0&&neveras.size()!=0){
                Nevera temp= neveras.pop();
                System.out.print(" "+temp.getCodigo()+"-"+temp.getDescripcion()+",");
                cantidad--;
            }
            System.out.println();
            if(neveras.size()==0){
                System.out.println("Se acabaron las neveras");
                break;
            }
        }
    }
    
}