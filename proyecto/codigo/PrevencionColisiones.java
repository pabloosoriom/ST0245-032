import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import javafx.geometry.Point3D;
import java.util.ArrayList;
import java.lang.Math;
import java.util.LinkedList;
/**
 * Implementacion de un algoritmo para prevenir Colisiones
 * Estructura de datos utilizada: Árbol Octree y LinkedList
 * Complejidad: Peor Caso O(nlogn) 
 *
 * @author Pablo Alberto Osorio Marulanda y Verónica Mendoza Iguarán 
 * @version 3
 */
public class PrevencionColisiones
{
    private static Point3D abejaMax;
    private static Point3D abejaMin;
    public static Point3D getAbejaMax(){
        return abejaMax;

    }

    public static Point3D getAbejaMin(){
        return abejaMin;

    }

    /**
     * Metodo para leer un archivo de abejas y almacenarlas en un arreglo de puntos en 3D
     *
     * @param  numeroDeAbejas  El numero de abejas a leer
     * @return un arreglo de puntos 3D donde cada elemento representa las coordenadas de una abeja
     */
    public static LinkedList<Point3D> leerArchivo(int numeroDeAbejas){
        final String nombreDelArchivo = "ConjuntoDeDatosCon"+numeroDeAbejas+"abejas.txt";
        LinkedList <Point3D> listaDeAbejas= new LinkedList<>();
        //Encotrar mÃ¡ximos y mÃ­nimos de cada eje
        double maxX=90;
        double maxY=-180;
        double maxZ=0;
        double minX=-90;
        double minY=180;
        double minZ=8000;

        try {            
            BufferedReader br = new BufferedReader(new FileReader(nombreDelArchivo));
            String lineaActual = br.readLine();
            lineaActual = br.readLine(); // Descarta la primera linea
            int index = 0;
            while (lineaActual != null){ // Mientras no llegue al fin del archivo
                String [] cadenaParticionada = lineaActual.split(",");
                Point3D abeja = new Point3D(Double.parseDouble(cadenaParticionada[0]),
                        Double.parseDouble(cadenaParticionada[1]),
                        Double.parseDouble(cadenaParticionada[2]));
                listaDeAbejas.addFirst(abeja);
                if(abeja.getX()<maxX){
                    maxX=abeja.getX();
                }
                if(abeja.getY()>maxY){
                    maxY=abeja.getY();
                }
                if(abeja.getZ()>maxZ){
                    maxZ=abeja.getZ();
                }
                if(abeja.getX()>minX){
                    minX=abeja.getX();
                }
                if(abeja.getY()<minY){
                    minY=abeja.getY();
                }
                if(abeja.getZ()<minZ){
                    minZ=abeja.getZ();
                }
                lineaActual = br.readLine();
            }
        }
        catch(IOException ioe) {
            System.out.println("Error leyendo el archivo de entrada");
        }

        abejaMax=new Point3D(maxX,maxY,maxZ);
        abejaMin=new Point3D(minX,minY,minZ);       

        return listaDeAbejas;
    }

    /**
     * Algoritmo para prevenir colisiones (genera muchas respuestas repetidas)
     *
     * @param  arregloDeAbejas  Un arreglo con coordenadas de las abejas
     * @return una lista definida con arreglos con las abejas que tienen riesgo de colision
     */
    public static LinkedList<Point3D> detectarColisiones(LinkedList<Point3D> listaDeAbejas){
        Nodo root= new Nodo(abejaMax,abejaMin);
        Octree arbol= new Octree(root);
        arbol.inicio();
        int tamaño=listaDeAbejas.size();
        for(int i=0;i<tamaño;i++){//O(n)
            arbol.insertAux(listaDeAbejas.getFirst());//O(nlog(n))
            listaDeAbejas.removeFirst();
        }
        arbol.returningAux();
        LinkedList<Point3D> listaPeligro=arbol.ListaPeligro();
        return listaPeligro;

    }

    /**
     * Metodo para escribir un archivo con la respuesta
     *
     * @param  abejasConRiesgoDeColision  Lista definida con arreglos con las abejas con riesgo de colision
     * @param  numeroDeAbejas  Numero de abejas del conjunto de datos original
     */
    public static void guardarArchivo(LinkedList<Point3D> abejasConRiesgoDeColision, int numeroDeAbejas){
        final String nombreDelArchivo = "respuestaConjuntoDeDatosCon"+numeroDeAbejas+"abejas.txt"; 
        int tamaño=abejasConRiesgoDeColision.size();        
        try {
            PrintWriter escritor = new PrintWriter(nombreDelArchivo, "UTF-8");
            for (int i=0;i<tamaño;i++){
                Point3D abeja=abejasConRiesgoDeColision.getFirst();
                escritor.println(abeja.getX()+","+abeja.getY()+","+abeja.getZ());
                abejasConRiesgoDeColision.removeFirst();
            }
            escritor.close();
        } 
        catch(IOException ioe) {
            System.out.println("Error escribiendo el archivo de salida");
        }  
    }

    /**
     * Método para la ejecución de todo el programa
     */
    public static void main (String[]args){
        // Recibir el numero de abejas como parametro
        final int numeroDeAbejas =args.length == 0 ? 10 : Integer.parseInt(args[0]);
        // Leer el archivo con las coordenadas de las abejas

        LinkedList listaDeAbejas = leerArchivo(numeroDeAbejas);

        // Prevenir las colisiones revisando todas con todas
        long startTime = System.currentTimeMillis();
        LinkedList<Point3D> abejasConRiesgoDeColision = detectarColisiones(listaDeAbejas);
        long estimatedTime = System.currentTimeMillis() - startTime;
        // Guardar en un archivo las abejas con riesgo de colision 
        System.out.println("El algoritmo tomo un tiempo de: "+estimatedTime+" ms");

        guardarArchivo(abejasConRiesgoDeColision, numeroDeAbejas);

    }
}