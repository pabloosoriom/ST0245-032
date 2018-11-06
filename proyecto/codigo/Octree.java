/**
 * Implementacion de un algoritmo para prevenir Colisiones
 * Clase Octree-> Creación de los espacios repectivos
 * @author Pablo Alberto Osorio Marulanda y Verónica Mendoza Iguarán 
 * @version 3
 */
import javafx.geometry.Point3D;
import java.lang.Math;
import java.util.LinkedList;
public class Octree
{
    static Nodo root; 
    static int topIterations;
    static double maxSide;
    public Octree(Nodo root){
        this.root=root;
    }

    /**
     * Este metodo prepara el octree para su ejecucion posterior, declarando cual es el nodo raiz y las aproximaciones del espacio
     */
    public static void inicio(){

        Point3D maxSize=new Point3D(Math.abs(111325*root.max.getX()),Math.abs((111325)*root.max.getY()),Math.abs((root.max.getZ())));//Valores, en metros , de las coordenadas de la abeja mÃ¡xima
        Point3D minSize=new Point3D(Math.abs(111325*root.min.getX()),Math.abs((111325)*root.min.getY()),Math.abs(root.min.getZ()));//Valores, en metros, de las coordenadas de la abeja mÃ­nima
        Point3D spaceDim=new Point3D(Math.abs(maxSize.getX()-minSize.getX()),Math.abs(maxSize.getY()-minSize.getY()),Math.abs(maxSize.getZ()-minSize.getZ()));//Dimensiones del espacio donde estÃ¡n las abejas

        double maxSideTemp=Math.max(Math.max(spaceDim.getX(),spaceDim.getY()),spaceDim.getZ());//To be sure to do a cube
        double multiplo=0;
        for(int i=0;(multiplo-maxSideTemp<0&&multiplo%2==0);i++){//O(m)
            multiplo+=100;
        }
        maxSide=multiplo;//Aproximacion del cubo a un multiplo de 100 para dividirlo en cubos exactamente igules a eso.
        int topIterationsTemp=0;//Nos permite saber cuantos "pisos" tendra el octree, es decir, cuantos subdivisiones tendrÃ¡ que realizar
        while(multiplo>=100){
            multiplo=multiplo/2;
            topIterationsTemp++;
        }
        topIterations=topIterationsTemp-1;        
        //Ahora se sacarÃ¡n las coordenadas de cada espacio
        double factorCorrec=Math.abs(maxSide-maxSideTemp); // Factor de correccion al aproximar la dimesiÃ³n del espacio
        Point3D coordMax=new Point3D(maxSize.getX()+factorCorrec,maxSize.getY()+factorCorrec,maxSize.getZ()+factorCorrec);
        Point3D coordMin=new Point3D(coordMax.getX()-maxSide,coordMax.getY()-maxSide,coordMax.getZ()-maxSide);//PAra hacer un cubo
        root=new Nodo(coordMax,coordMin); //Coordendas mÃ¡ximas y mÃ­nimas del espacio principal (el que representa la raiz)

    }    

    /**
     * Metodo ejecutar el metodo insertar 
     */
    public static void insertAux(Point3D abeja){
        insert(root,abeja,topIterations,maxSide);
    }

    /**
     * Este método se encarga de crear los espacios respectivos para asi agregar sus nodos
     * @param Nodo n - nodo (Espacio respectivo)
     * @param abeja que se insertará
     * @param iterations (Iteraciones para dividir el arbol)
     * @param maxSid medida de lado máximo del cubo
     */
    public static void insert(Nodo n,Point3D abeja,int iterations, double maxSid){
        Point3D abejaMetros= new Point3D(Math.abs(111325*abeja.getX()),Math.abs((111325)*abeja.getY()),abeja.getZ());
        if(iterations==1){
            n.abejas.addFirst(abeja);
        }else{
            //Condicion para entrar al primer espacio
            if((abejaMetros.getX()<=n.max.getX())&&(abejaMetros.getY()<=n.max.getY())&&(abejaMetros.getZ()<=n.max.getZ())&&((abejaMetros.getX()>=(n.min.getX())+(maxSid/2))
                &&(abejaMetros.getY()>=(n.min.getY()+(maxSid/2)))&&(abejaMetros.getZ()>=(n.min.getZ()+(maxSid/2))))){
                if(n.hijos[0]==null){
                    Point3D max= new Point3D(n.max.getX(),n.max.getY(),n.max.getZ());
                    Point3D min = new Point3D((n.min.getX()+(maxSid/2)),(n.min.getY()+(maxSid/2)),(n.min.getZ()+(maxSid/2)));
                    Nodo space= new Nodo(max,min);
                    n.hijos[0]=space;
                    insert(space,abeja,iterations-1,maxSid/2);
                }else{
                    insert(n.hijos[0],abeja,iterations-1,maxSid/2);
                }      
            }//Condicion para el segundo espacio
            else if((abejaMetros.getX()<=(n.max.getX()-(maxSid/2))&&(abejaMetros.getY()<=n.max.getY())&&(abejaMetros.getZ()<=n.max.getZ()))&&(abejaMetros.getX()>=n.min.getX()
                &&abejaMetros.getY()>=n.min.getY()+(maxSid/2)&&abejaMetros.getZ()>=n.min.getZ()+(maxSid/2))){
                if(n.hijos[1]==null){
                    Point3D max= new Point3D(n.max.getX()-(maxSid/2),n.max.getY(),n.max.getZ());
                    Point3D min = new Point3D(n.min.getX(),n.min.getY()+(maxSid/2),n.min.getZ()+(maxSid/2));
                    Nodo space= new Nodo(max,min);
                    n.hijos[1]=space;
                    insert(space,abeja,iterations-1,maxSid/2);
                }else{
                    insert(n.hijos[1],abeja,iterations-1,maxSid/2);
                }   
            }//Condicion para el tercer espacio
            else if((abejaMetros.getX()<=(n.max.getX()-(maxSid/2))&&(abejaMetros.getY()<=n.max.getY())&&(abejaMetros.getZ()<=n.max.getZ()-(maxSid/2)))
            &&(abejaMetros.getX()>=n.min.getX()&&abejaMetros.getY()>=n.min.getY()+(maxSid/2)&&abejaMetros.getZ()>=n.min.getZ())){
                if(n.hijos[2]==null){
                    Point3D max= new Point3D(n.max.getX()-(maxSid/2),n.max.getY(),n.max.getZ()-(maxSid/2));
                    Point3D min = new Point3D(n.min.getX(),n.min.getY()+(maxSid/2),n.min.getZ());
                    Nodo space= new Nodo(max,min);
                    n.hijos[2]=space;
                    insert(space,abeja,iterations-1,maxSid/2);
                }else{
                    insert(n.hijos[2],abeja,iterations-1,maxSid/2);
                }   
            }//Condicion para el cuarto espacio
            else if((abejaMetros.getX()<=n.max.getX()&&(abejaMetros.getY()<=n.max.getY())&&(abejaMetros.getZ()<=n.max.getZ()-(maxSid/2)))
            &&(abejaMetros.getX()>=n.min.getX()+(maxSid/2)&& abejaMetros.getY()>=n.min.getY()+(maxSid/2)&&abejaMetros.getZ()>=n.min.getZ())){
                if(n.hijos[3]==null){
                    Point3D max= new Point3D(n.max.getX(),n.max.getY(),n.max.getZ()-(maxSid/2));
                    Point3D min = new Point3D(n.min.getX()+(maxSid/2),n.min.getY()+(maxSid/2),n.min.getZ());
                    Nodo space= new Nodo(max,min);
                    n.hijos[3]=space;
                    insert(space,abeja,iterations-1,maxSid/2);
                }else{
                    insert(n.hijos[3],abeja,iterations-1,maxSid/2);
                }   
            }//Condicion para el quinto espacio
            else if((abejaMetros.getX()<=n.max.getX()&&(abejaMetros.getY()<=n.max.getY()-(maxSid/2))&&(abejaMetros.getZ()<=n.max.getZ()))&&
            (abejaMetros.getX()>=n.min.getX()+(maxSid/2)&&abejaMetros.getY()>=n.min.getY()&&abejaMetros.getZ()>=n.min.getZ()+(maxSid/2))){
                if(n.hijos[4]==null){
                    Point3D max= new Point3D(n.max.getX(),n.max.getY()-(maxSid/2),n.max.getZ());
                    Point3D min = new Point3D(n.min.getX()+(maxSid/2),n.min.getY(),n.min.getZ()+(maxSid/2));
                    Nodo space= new Nodo(max,min);
                    n.hijos[4]=space;
                    insert(space,abeja,iterations-1,maxSid/2);
                }else{
                    insert(n.hijos[4],abeja,iterations-1,maxSid/2);
                }   
            }//Condicion para el sexto espacio
            else if((abejaMetros.getX()<=n.max.getX()&&(abejaMetros.getY()<=n.max.getY()-(maxSid/2))&&(abejaMetros.getZ()<=n.max.getZ()-(maxSid/2)))
            &&(abejaMetros.getX()>=n.min.getX()&& abejaMetros.getY()>=n.min.getY()&&abejaMetros.getZ()>=n.min.getZ()+(maxSid/2))){
                if(n.hijos[5]==null){
                    Point3D max= new Point3D(n.max.getX()-(maxSid/2),n.max.getY()-(maxSid/2),n.max.getZ());
                    Point3D min = new Point3D(n.min.getX(),n.min.getY(),n.min.getZ()+(maxSid/2));
                    Nodo space= new Nodo(max,min);
                    n.hijos[5]=space;
                    insert(space,abeja,iterations-1,maxSid/2);
                }else{
                    insert(n.hijos[5],abeja,iterations-1,maxSid/2);
                }   
            }//Condicion para el septimo espacio
            else if((abejaMetros.getX()<=n.max.getX()-(maxSid/2)&&(abejaMetros.getY()<=n.max.getY()-(maxSid/2))&&(abejaMetros.getZ()<=n.max.getZ()-(maxSid/2)))
            &&(abejaMetros.getX()>=n.min.getX()&&abejaMetros.getY()>=n.min.getY()&&abejaMetros.getZ()>=n.min.getZ())){
                if(n.hijos[6]==null){
                    Point3D max= new Point3D(n.max.getX()-(maxSid/2),n.max.getY()-(maxSid/2),n.max.getZ()-(maxSid/2));
                    Point3D min = new Point3D(n.min.getX(),n.min.getY(),n.min.getZ());
                    Nodo space= new Nodo(max,min);
                    n.hijos[6]=space;
                    insert(space,abeja,iterations-1,maxSid/2);//O(log(n))
                }else{
                    insert(n.hijos[6],abeja,iterations-1,maxSid/2);
                }   
            }//Condicion para el octavo espacio
            else if((abejaMetros.getX()<=n.max.getX()&&(abejaMetros.getY()<=n.max.getY()-(maxSid/2))&&(abejaMetros.getZ()<=n.max.getZ()-(maxSid/2)))
            &&(abejaMetros.getX()>=n.min.getX()+(maxSid/2)&&  abejaMetros.getY()>=n.min.getY()&&abejaMetros.getZ()>=n.min.getZ())){
                if(n.hijos[7]==null){
                    Point3D max= new Point3D(n.max.getX(),n.max.getY()-(maxSid/2),n.max.getZ()-(maxSid/2));
                    Point3D min = new Point3D(n.min.getX()+(maxSid/2),n.min.getY(),n.min.getZ());
                    Nodo space= new Nodo(max,min);
                    n.hijos[7]=space;
                    insert(space,abeja,iterations-1,maxSid/2);
                }else{
                    insert(n.hijos[7],abeja,iterations-1,maxSid/2);
                }   
            }             
        }
    }
    static int datosDeLista;
    static LinkedList<LinkedList<Point3D>> ListasColisiones=new LinkedList<>();
    /**
     * Método para ejecutar returning
     */public static void returningAux(){
        returning(root);
    }

    /**
     * Método que se encarga de buscar las linkedlist finales de cada nodo
     * @param Nodo espacio respectivo
     */public static void returning(Nodo n){
        if(n.abejas==null||n.abejas.size()==0){
            for(int i=0;i<8;i++){
                if(n.hijos[i]!=null){
                    returning(n.hijos[i]);  
                }          
            }        
        }  else if(n.abejas.size()>1){
            datosDeLista+=n.abejas.size();
            ListasColisiones.addFirst(n.abejas);
        }          

    }

    /**
     * Método que convierte la lista enlazada de listas de elementos a una lista de elementos
     * @return LinkedList con las abejas que se chocan
     */public static LinkedList<Point3D>ListaPeligro(){
        LinkedList<Point3D> listaPeligro=new LinkedList<>();
        for(int i=0;i<ListasColisiones.size();i++){
            while(ListasColisiones.getFirst().size()>0){
                listaPeligro.addFirst(ListasColisiones.getFirst().getFirst());
                ListasColisiones.getFirst().removeFirst();
            }
            ListasColisiones.removeFirst();
        }
        return listaPeligro;

    }
} 
