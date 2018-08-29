
import java.util.Arrays;

/**
 * La clase MiArrayList tiene la intención de representar un objeto que simule el comportamiento
 * de la clase ya implementada "ArrayList"
 * 
 * @author Pablo Alberto Osorio Marulanda- Verónica Mendoza Iguarán
 * @version 28/08/2018
 */

public class MiArrayList{
    private int size; 
    private static int DEFAULT_CAPACITY = 10;
    private int elements[]; 

    //Para la complejidad: sea n el size (tamaño del hipotético ArrayList) y m la distancia desde index+1 hasta size
    
    /**
     * El metodo constructor incializa las variables
     */
    public MiArrayList() {
        size=0; //c
        elements = new int [DEFAULT_CAPACITY]; //c
    }     

    /**
     * Retorna la longitud del objeto
     * @return longitud del objeto
     * El size esta influenciado por las funciones add y del
     */
    public int size() {
        return size; //c
    }   

    /** 
     * Método para doblar el tamaño del arreglo
     */
    public void doblarTam(){
        int elementsTemp[] = new int [DEFAULT_CAPACITY]; //c_1
        for(int i=0; i<elementsTemp.length; i++){ //c_2+(c*(n+1))
            elementsTemp[i]=elements[i]; //c_3+(c*n)
        }
        DEFAULT_CAPACITY = DEFAULT_CAPACITY*2; //c_4
        elements = new int [DEFAULT_CAPACITY]; //c_5
        for(int j=0; j<elementsTemp.length; j++){ //c_6+c*(n+1)
            elements[j]=elementsTemp[j]; //c_7+(c*n)
        }
        //T(n)=c_1+c_2+(c*(n+1)+c_3+(c*n)+c_4+c_5+c_6+(c*(n+1))+c_7+(c*(n))
        //Donde al final obtenemos O(n)
    }
    
    /** 
     * @param e el elemento a guardar
     * Agrega un elemento e a la última posición de la lista
     */
    public void add(int e) {
        if(size==elements.length){ //c_1
            doblarTam(); //O(n)
        }
        if(size==0){ //c_2
            elements[0]=e; //c_3
        }
        else{
            for(int i=0; i<elements.length; i++){ //c_4+(c*(n+1))
                if(i+1==size){ //c_5+(c*(n))
                    elements[i+1]=e; //c_6+(c*(n))
                }
            }
        }    
        size++; //c_7
        //T(n)=c_1+O(n)+c_4+(c*(n+1))+c_5+(c*(n))+c_6+(c*(n))+c_7
        //Donde al final obtenemos O(n)
        //La complejidad de este metodo permite que la lista sea utilizada
        //en un editor de texto porque cumple con los parámetros planteados 
        //para que pueda comportarse de esa manera.
    }

    /** 
     * @param i es un índice donde se encuentra el elemento posicionado
     * Retorna el elemento que se encuentra en la posición i de la lista.
     *
     */
    public int get(int i) {
        try {
            if(i>=0 && i<size){  //c
                return elements[i]; //c
            }
        }catch (Exception ex) {//c
            System.out.println("No hay elementos en esta posición");//c
        }
        return -1;//c
        //T(n)= c
        //Donde al final obtenemos O(1)
    }

    /**
     * @param index es la posicion en la cual se va agregar el elemento
     * @param e el elemento a guardar
     * Agrega un elemento e en la posición index de la lista
     *
     */
    public void add(int index, int e) {
        try {
            if(size==elements.length){ //c_1
                doblarTam();//O(n)
            }
            int guardar = 0; //c_2
            for(int i=0; i<elements.length; i++){ //c_3+(c*(n+1))
                if(i==index){ //c_4+(c*(n))
                    guardar = elements[index]; //c_5+(c*(n))
                    elements[index]=e; //c_6+(c*(n))
                    for(int j=index+1; j<size+1; j++){ //c_7+(n*(m+1))
                        int temp = elements[j]; //c_8+(n*(m))
                        elements[j]=guardar; //c_9+(n*(m))
                        guardar=temp; //c_10+(n*(m))
                    }
                    break; //c_11+(c*(n))
                }
            }
            size++; //c_12
        }catch(Exception ex) {
            System.out.println("Usted ha ingresado un valor incorrecto");
        }
        //T(n)= c_1+O(n)+c_2+c_3+(c*(n+1))+c_4+(c*(n))+c_5+(c*(n))+c_6+
        //(c*(n))+c_7+(n*(m+1))+c_8+(n*(m))+c_9+(n*(m))+c_10+(n*(m))+c_11+(c*(n))
        //Donde al final obtenemos O(n*m)
    } 

    /**
     * @param index es la posicion en la cual se va agregar el elemento
     * Elimina el elemento  en la posición index de la lista
     */
    public void del(int index){
        try{
            if(index<=size){ //c_1
                for(int i=0; i<elements.length; i++){ //c_2+(c*(n+1))
                    if(i==index){//c_3+(c*(n))
                        for(int j=index; j<size-1; j++){ //c_4+(n*(m+1))
                            elements[j] = elements[j+1];//c_5+(n*(m))
                        }
                        elements[size-1]=0; //c_6+(c*(n))
                        break; //c_7
                    }
                }
                size--; //c_8
            }
        }catch(Exception ex) {
            System.out.println("Usted ha ingresado un índice incorrecto");
        }
        //Donde al final obtenemos O(n*m)
    }
}