
/**
 * Write a description of class Almacen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class Almacen
{
    static Stack<Nevera> neveras=new Stack<>();
    static Queue<Solicitud> solicitudes=new LinkedList();

    public static void agregarNevera (Nevera nevera){
        neveras.push(nevera);
    }

    public static void agregarSolicitud (Solicitud solicitud){
        solicitudes.add(solicitud);	
    }

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
