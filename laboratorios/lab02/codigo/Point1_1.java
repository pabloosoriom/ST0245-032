
/**
 * Point 1.1 solution 
 * 
 * @author Pablo A. Osorio Marulanda -Verónica Mendoza Iguarán
 * @version 09/09/2018
 *
 */
import java.util.concurrent.TimeUnit;
public class Point1_1

{
    public static void main(String[] args){
        for (int i = 0; i <= 20; i++){
            int[] a = new int[i];
            for (int j = 0; j < i; j++ ){
                a[j] = j;
            }
            long start = System.currentTimeMillis();
            aux(a);
            long fin = System.currentTimeMillis();       
            System.out.println(i+"--"+(fin-start));
        }
    }
    //Insertion sort
    public static int [] sort(int [] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=i;j>0;j--){
                if(arr[j]<arr[j-1]){
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
                try{
                    TimeUnit.SECONDS.sleep(1);
                }
                catch (Exception e){
                }
            }

        }
        return arr;
    }
    //Merge sort
    /**
     * Title: Método de ordenación MergeSort
     * Author: García , Enrique
     * Date: 2015
     * Avaiulability:http://puntocomnoesunlenguaje.blogspot.com/2014/10/java-mergesort.html
     */
    public static void aux(int A[]){
        mergesort(A, 0,A.length-1);

    }

    private static void mergesort(int A[],int izq, int der){
        if (izq<der){

            int m=(izq+der)/2;
            mergesort(A,izq, m);
            mergesort(A,m+1, der);
            merge(A,izq, m, der);

        }

    }

    private static void merge(int A[],int izq, int m, int der){

        int i, j, k;
        int [] B = new int[A.length]; //Auxiliar array
        for (i=izq; i<=der; i++){ //To copy both halfs of the uxiliar array
            B[i]=A[i];
            

        }
        i=izq; j=m+1; k=izq;
        while (i<=m && j<=der){ //To copy the next bigger element 
            if (B[i]<=B[j])
                A[k++]=B[i++];
            else
                A[k++]=B[j++];
            try{
                TimeUnit.SECONDS.sleep(1);
            }
            catch (Exception e){
            }
        }
        while (i<=m) {//To copy the elements missing in the first half ( if they exist)
            A[k++]=B[i++];
            try{
                TimeUnit.SECONDS.sleep(1);
            }
            catch (Exception e){
            }

        } 

    }
}

