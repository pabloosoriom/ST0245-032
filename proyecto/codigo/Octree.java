
/**
 * Write a description of class Octree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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

    public static void inicio(){

        Point3D maxSize=new Point3D(Math.abs(111325*root.max.getX()),Math.abs((Math.cos(root.max.getX())*111325)*root.max.getY()),Math.abs((root.max.getZ())));//Valores, en metros , de las coordenadas de la abeja máxima
        Point3D minSize=new Point3D(Math.abs(111325*root.min.getX()),Math.abs((Math.cos(root.min.getX())*111325)*root.min.getY()),Math.abs(root.min.getZ()));//Valores, en metros, de las coordenadas de la abeja mínima
        Point3D spaceDim=new Point3D(Math.abs(maxSize.getX()-minSize.getX()),Math.abs(maxSize.getY()-minSize.getY()),Math.abs(maxSize.getZ()-minSize.getZ()));//Dimensiones del espacio donde están las abejas

        double maxSideTemp=Math.max(Math.max(spaceDim.getX(),spaceDim.getY()),spaceDim.getZ());//To be sure to do a cube
        double multiplo=0;
        for(int i=0;(multiplo-maxSideTemp<0&&multiplo%2==0);i++){
            multiplo+=100;
        }
        maxSide=multiplo;//Aproximacion del cubo a un multiplo de 100 para dividirlo en cubos exactamente igules a eso.
        int topIterationsTemp=0;//Nos permite saber cuantos "pisos" tendra el octree, es decir, cuantos subdivisiones tendrá que realizar
        while(multiplo>=100){
            multiplo=multiplo/2;
            topIterationsTemp++;
        }
        topIterations=topIterationsTemp;        
        //Ahora se sacarán las coordenadas de cada espacio
        double factorCorrec=Math.abs(maxSide-maxSideTemp); // Factor de correccion al aproximar la dimesión del espacio
        Point3D coordMax=new Point3D(maxSize.getX()+factorCorrec,maxSize.getY()+factorCorrec,maxSize.getZ()+factorCorrec);
        Point3D coordMin=new Point3D(Math.abs(minSize.getX()-factorCorrec),Math.abs(minSize.getY()-factorCorrec),Math.abs(minSize.getZ()-factorCorrec));
        root=new Nodo(coordMax,coordMin); //Coordendas máximas y mínimas del espacio principal (el que representa la raiz)

    }    

    public static void insertAux(Point3D abeja){
        insert(root,abeja,topIterations,maxSide);
    }

    public static void insert(Nodo n,Point3D abeja,int iterations, double maxSid){
        Point3D abejaMetros= new Point3D(Math.abs(111325*abeja.getX()),Math.abs((Math.cos(abeja.getX())*111325)*abeja.getY()),abeja.getZ());
        if(iterations==1){
            n.abejas.addFirst(abeja);
        }else{
            //Condicion para entrar al primer espacio
            if((abejaMetros.getX()<=n.max.getX())&&(abejaMetros.getY()<=n.max.getY())&&(abejaMetros.getZ()<=n.max.getZ())&&((abejaMetros.getX()>=(n.min.getX()+(maxSid/2)))&&
                (abejaMetros.getY()>=(n.min.getY()+(maxSid/2)))&&(abejaMetros.getZ()>=(n.min.getZ()+(maxSid/2))))){
                if(n.hijos[0]==null){
                    Point3D max= new Point3D(n.max.getX(),n.max.getY(),n.max.getZ());
                    Point3D min = new Point3D((n.min.getX()+(maxSid/2)),(n.min.getY()+(maxSid/2)),(n.min.getY()+(maxSid/2)));
                    Nodo space= new Nodo(max,min);
                    insert(space,abeja,iterations-1,maxSid/2);
                }else{
                    insert(n.hijos[0],abeja,iterations-1,maxSid/2);
                }      
            }//Condicion para el segundo espacio
            else if((abejaMetros.getX()<=(n.max.getX()-(maxSid/2))&&(abejaMetros.getY()<=n.max.getY())&&(abejaMetros.getZ()<=n.max.getZ()))&&(abejaMetros.getX()>=n.min.getX()&&
                abejaMetros.getY()>=n.min.getY()+(maxSid/2)&&abejaMetros.getZ()>=n.min.getZ()+(maxSid/2))){
                if(n.hijos[1]==null){
                    Point3D max= new Point3D(n.max.getX()-(maxSid/2),n.max.getY(),n.max.getZ());
                    Point3D min = new Point3D(n.min.getX(),n.min.getY()+(maxSid/2),n.min.getZ()+(maxSid/2));
                    Nodo space= new Nodo(max,min);
                    insert(space,abeja,iterations-1,maxSid/2);
                }else{
                    insert(n.hijos[1],abeja,iterations-1,maxSid/2);
                }   
            }//Condicion para el tercer espacio
            else if((abejaMetros.getX()<=(n.max.getX()-(maxSid/2))&&(abejaMetros.getY()<=n.max.getY())&&(abejaMetros.getZ()<=n.max.getZ()-(maxSid/2)))&&(abejaMetros.getX()>=n.min.getX()&&
                abejaMetros.getY()>=n.min.getY()+(maxSid/2)&&abejaMetros.getZ()>=n.min.getZ())){
                if(n.hijos[2]==null){
                    Point3D max= new Point3D(n.max.getX()-(maxSid/2),n.max.getY(),n.max.getZ()-(maxSid/2));
                    Point3D min = new Point3D(n.min.getX(),n.min.getY()+(maxSid/2),n.min.getZ());
                    Nodo space= new Nodo(max,min);
                    insert(space,abeja,iterations-1,maxSid/2);
                }else{
                    insert(n.hijos[2],abeja,iterations-1,maxSid/2);
                }   
            }//Condicion para el cuarto espacio
            else if((abejaMetros.getX()<=n.max.getX()&&(abejaMetros.getY()<=n.max.getY())&&(abejaMetros.getZ()<=n.max.getZ()-(maxSid/2)))&&(abejaMetros.getX()>=n.min.getX()+(maxSid/2)&&
                abejaMetros.getY()>=n.min.getY()+(maxSid/2)&&abejaMetros.getZ()>=n.min.getZ())){
                if(n.hijos[3]==null){
                    Point3D max= new Point3D(n.max.getX(),n.max.getY(),n.max.getZ()-(maxSid/2));
                    Point3D min = new Point3D(n.min.getX()+(maxSid/2),n.min.getY()+(maxSid/2),n.min.getZ());
                    Nodo space= new Nodo(max,min);
                    insert(space,abeja,iterations-1,maxSid/2);
                }else{
                    insert(n.hijos[3],abeja,iterations-1,maxSid/2);
                }   
            }//Condicion para el quinto espacio
            else if((abejaMetros.getX()<=n.max.getX()&&(abejaMetros.getY()<=n.max.getY()-(maxSid/2))&&(abejaMetros.getZ()<=n.max.getZ()))&&(abejaMetros.getX()>=n.min.getX()+(maxSid/2)&&
                abejaMetros.getY()>=n.min.getY()&&abejaMetros.getZ()>=n.min.getZ()+(maxSid/2))){
                if(n.hijos[4]==null){
                    Point3D max= new Point3D(n.max.getX(),n.max.getY()-(maxSid/2),n.max.getZ());
                    Point3D min = new Point3D(n.min.getX()+(maxSid/2),n.min.getY(),n.min.getZ()+(maxSid/2));
                    Nodo space= new Nodo(max,min);
                    insert(space,abeja,iterations-1,maxSid/2);
                }else{
                    insert(n.hijos[4],abeja,iterations-1,maxSid/2);
                }   
            }//Condicion para el sexto espacio
            else if((abejaMetros.getX()<=n.max.getX()&&(abejaMetros.getY()<=n.max.getY()-(maxSid/2))&&(abejaMetros.getZ()<=n.max.getZ()-(maxSid/2)))&&(abejaMetros.getX()>=n.min.getX()&&
                abejaMetros.getY()>=n.min.getY()&&abejaMetros.getZ()>=n.min.getZ()+(maxSid/2))){
                if(n.hijos[5]==null){
                    Point3D max= new Point3D(n.max.getX()-(maxSid/2),n.max.getY()-(maxSid/2),n.max.getZ());
                    Point3D min = new Point3D(n.min.getX(),n.min.getY(),n.min.getZ()+(maxSid/2));
                    Nodo space= new Nodo(max,min);
                    insert(space,abeja,iterations-1,maxSid/2);
                }else{
                    insert(n.hijos[5],abeja,iterations-1,maxSid/2);
                }   
            }//Condicion para el septimo espacio
            else if((abejaMetros.getX()<=n.max.getX()-(maxSid/2)&&(abejaMetros.getY()<=n.max.getY()-(maxSid/2))&&(abejaMetros.getZ()<=n.max.getZ()-(maxSid/2)))&&(abejaMetros.getX()>=n.min.getX()&&
                abejaMetros.getY()>=n.min.getY()&&abejaMetros.getZ()>=n.min.getZ())){
                if(n.hijos[6]==null){
                    Point3D max= new Point3D(n.max.getX()-(maxSid/2),n.max.getY()-(maxSid/2),n.max.getZ()-(maxSid/2));
                    Point3D min = new Point3D(n.min.getX(),n.min.getY(),n.min.getZ());
                    Nodo space= new Nodo(max,min);
                    insert(space,abeja,iterations-1,maxSid/2);//O(log(n))
                }else{
                    insert(n.hijos[6],abeja,iterations-1,maxSid/2);
                }   
            }//Condicion para el octavo espacio
            else if((abejaMetros.getX()<=n.max.getX()&&(abejaMetros.getY()<=n.max.getY()-(maxSid/2))&&(abejaMetros.getZ()<=n.max.getZ()-(maxSid/2)))&&(abejaMetros.getX()>=n.min.getX()+(maxSid/2)&&
                abejaMetros.getY()>=n.min.getY()&&abejaMetros.getZ()>=n.min.getZ())){
                if(n.hijos[7]==null){
                    Point3D max= new Point3D(n.max.getX(),n.max.getY()-(maxSid/2),n.max.getZ()-(maxSid/2));
                    Point3D min = new Point3D(n.min.getX()+(maxSid/2),n.min.getY(),n.min.getZ());
                    Nodo space= new Nodo(max,min);
                    insert(space,abeja,iterations-1,maxSid/2);
                }else{
                    insert(n.hijos[7],abeja,iterations-1,maxSid/2);
                }   
            }             
        }
    }
    static int datosDeLista;
    static LinkedList<LinkedList<Point3D>> ListasColisiones=new LinkedList<>();
    public static void returningAux(){
        returning(root);
    }

    public static void returning(Nodo n){
        if(n.abejas.size()>0){
            datosDeLista+=n.abejas.size();
            ListasColisiones.addFirst(n.abejas);
        }else if(n.abejas.size()==0){
            for(int i=0;i<n.hijos.length;i++){
                returning(n.hijos[i]);            
            }        
        }            

    }

    public static LinkedList<Point3D>ListaPeligro(){
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
