
/**
 * Main para la ejecución de los porgramas diseñados para el taller
 * 
 * @author Pablo A. Osorio Marulanda y Verónica Mendoza Iguarán
 * @version 17/07/2018
 */
public class Main {

    public static void main(String[] args) {
        Contador c = new Contador("test");
        for (int i = 0; i < 10; ++i)
            c.incrementar();
        // 10
        System.out.println(c);

        System.out.println();

        Punto p = new Punto(-1, 1);
        // 0,0
        System.out.printf("Punto: {%f, %f}\n", p.x(), p.y());
        // 1*sqrt(2)
        System.out.println("Radio Polar: " + p.radioPolar());
        // -45 "(Debería ser 135)"
        System.out.println("Angulo Polar: " + Math.toDegrees(p.anguloPolar()));
        // 2
        System.out.println("Distancia euclidiana: " + p.distanciaEuclidiana(new Punto(1, 1)));

        System.out.println();

        Fecha f1 = new Fecha((byte)1,(byte)8, (short)2017);
        Fecha f2 = new Fecha( (byte)2,(byte)5, (short)2016);
        System.out.println(f1);
        System.out.println(f2);
        // 1
        System.out.println(f1.comparar(f2));
    }

}
