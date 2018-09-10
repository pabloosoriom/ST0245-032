
/**
 * Point 2.1 solution (Coding-Bat Array-2)
 * 
 * @author Pablo A. Osorio MArulanda -Verónica Mendoza Iguarán
 * @version 09/09/2018
 */
public class Point2_1
{
    //Return the number of even ints in the given array
    public int countEvens(int[] nums) {
        int sum=0;//c_1
        for(int i =0; i<nums.length;i++){//c_2+(c_3*(n+1))
            if(nums[i]%2==0)sum++;//c_4*n+c_5
        }
        return sum;//c_6
    }
    
    
//Given an array of ints, return true if the number of 1's is greater than the number of 4's
    public boolean more14(int[] nums) {
        int unos=0;//c_1
        int cuatros=0; ;//c_2
        for(int i=0;i<nums.length;i++){//c_3+(c_4*(n+1))
            if(nums[i]==1)unos++;//c_5*n+c_6
            if(nums[i]==4)cuatros++;//c_7*n+c_8
        }
        return unos>cuatros;//c_9
    }
    
//Return the sum of the numbers in the array, returning 0 for an empty array. Except the number 13 is very unlucky, 
//so it does not count and numbers that come immediately after a 13 also do not count.
    public int sum13(int[] nums) {
        if(nums.length==0)return 0;//c_1
        int sum=0; //c_2
        int z=0; //c_3
        for(int i=z;i<nums.length;i++){//c_4+(c_5*(n+1))
            if(nums[i]!=13){ //c_6*n+c_7
                sum+=nums[i]; //c_8*n+c_9
            }else{//c_10
                i++;//c_11*n+c_12
            }

        }
        return sum;//c_13

    }
    
    //Return true if the group of N numbers at the start and end of the array are the same. 
    public boolean sameEnds(int[] nums, int len) {
        if(len==0)return true;//c_1
        boolean result=false;//c_2
        for(int i=0; i<len;i++){ //c_3+(c_4*(n+1))
            result= nums[i]==nums[nums.length-len+i];//c_5+(c_6*n)
            if(result==false)break;//c_7+(c_8*n)
        }
        return result;//c_9
    }
    
    /*
     * This is slightly more difficult version of the famous FizzBuzz problem which is sometimes given as a first problem for job interviews. 
     * (See also: FizzBuzz Code.) Consider the series of numbers beginning at start and running up to but not including end, so for example start=1 and
     * end=5 gives the series 1, 2, 3, 4. Return a new String[] array containing the string form of these numbers, except for multiples of 3, use "Fizz" 
     * instead of the number, for multiples of 5 use "Buzz", and for multiples of both 3 and 5 use "FizzBuzz". In Java, String.valueOf(xxx) will make the 
     * String form of an int or other type. This version is a little more complicated than the usual version since you have to allocate and index into an array
     * instead of just printing, and we vary the start/end instead of just always doing 1..100.

     */

    public String[] fizzBuzz(int start, int end) {
        String [] array=new String [end-start];//c_1
        int pos=0;//c_2
        for(int i=start;i<=end-1;i++){//c_3+(c_4(n+1))
            if(i%5==0&&i%3==0){//c_5+c_6*n
                array[pos]="FizzBuzz";//c_7*n
                pos++;//c_8*n
            }else if(i%3==0){//c_9+c_10*n
                array[pos]="Fizz";//c_11*n
                pos++;//c_12*n

            }else if(i%5==0){//c_13+c_14*n
                array[pos]="Buzz";//c_15*n
                pos++;//c_16*n
            }else{//c_18*n
                array[pos]=i+"";//c_19*n
                pos++;//c_20*n
            }
        }
        return array;//c_21
    }


}
