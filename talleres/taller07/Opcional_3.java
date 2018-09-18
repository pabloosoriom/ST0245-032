/**
 * Write a description of class j here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Opcional_3{
    LinkedListMy list=new LinkedListMy();
    public int Ejercicio_3(){
        return auxiliar(list.first.data, list.first);

    }

    public int auxiliar(int mayor,Node temp){
        if(temp==null){
            throw new IndexOutOfBoundsException();
        }
        if(temp.next==null)return mayor;
        return Math.max(mayor,auxiliar(temp.next.data,temp.next));
    }
}
