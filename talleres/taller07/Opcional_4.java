
/**
 * Write a description of class s here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Opcional_4{
    public boolean comparation(LinkedListMy list1, LinkedListMy list2){
        return comparationAux(list1, list2, 0);
    }
    
    public boolean comparationAux(LinkedListMy list1, LinkedListMy list2, int index){
        if(list1.size() != list2.size()){
            return false;
        }
        if(list1.getNode(index)!=list2.getNode(index)){
            return false;
        }
        if(index==list1.size()-1){
            return true;
        }
        else {
            return comparationAux(list1, list2, index+1);
        }
    }
}