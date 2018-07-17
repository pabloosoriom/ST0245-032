
/**
 * Write a description of class Punto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class Punto
{
    private double x, y;

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
    
    public double radioPolar() {
        double radio=Math.sqrt(((x*x)+(y*y)));
        return radio;
    }
    
    public double anguloPolar() {
        double angulo=Math.atan2(y,x);
        return angulo;
    }
   

    public double distanciaEuclidiana(Punto otro) {
     double distancia= Math.sqrt((Math.pow(otro.x()-x,2)+Math.pow(otro.y()-y,2)));
     return distancia;
    }
}