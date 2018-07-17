
/**
 * Punto 1 del taller 1 de estructuras de datos y algoritmos
 * 
 * @author Pablo A. Osorio Marulanda- Verónica Mendoza Iguarán
 * @version 17/07/2018
 */
import java.util.*;
public class Punto
{
    private double x, y;
    /** Constructor para atriubutos 
     */
    public Punto(double x, double y) {
        this.x=x;
        this.y=y;
    }

    public double x() {
        return this.x;
    }

    public double y() {
        return this.x;
    }
    /** 
     * Distancia desde el origen hasta el punto
     */
    public double radioPolar() {
        double radio=Math.sqrt(((x*x)+(y*y)));
        return radio;
    }
    /**
     * Ángulo formado por la linea polar del origen y el punto
     */    
    public double anguloPolar() {
        double angulo=Math.atan2(y,x);
        return angulo;
    }
   
    /** 
     * Distancia entre dos puntos
     */
    public double distanciaEuclidiana(Punto otro) {
     double distancia= Math.sqrt((Math.pow(otro.x()-x,2)+Math.pow(otro.y()-y,2)));
     return distancia;
    }
}