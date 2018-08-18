
/**
 * Solución al ejercicio 2.2 del laboratorio 1.
 * 
 * @author (Pablo Alberto Osorio Marulanda - Verónica Mendoza Iguarán) 
 * @version (11/08/2018)
 */
public class Recursion_2
{
    //Ejercicio1
    /*
     * Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums to the given target with this additional constraint: 
     * If a value in the array is chosen to be in the group, the value immediately following it in the array must not be chosen. (No loops needed.)
     */
    public boolean groupNoAdj(int start, int[] nums, int target) {
        if(start>=nums.length) return (target==0); //c_1
        if(groupNoAdj(start + 2, nums, target - nums[start])) return true; //T(n-2)
        if(groupNoAdj(start + 1, nums, target)) return true; //T(n-1)
        return false; //c_2
    }

    // Ejercicio 2
    /*
     * Given an array of ints, is it possible to choose a group of some of the ints, beginning at the start index, such that the group sums to the given target?
     * However, with the additional constraint that all 6's must be chosen. (No loops needed.)
     */
    //<>
    public  boolean groupSum6(int start, int[] nums, int target) {
        if (start >= nums.length) return target == 0; //c_1
        if(nums[start]==6){ //c_2
            if (groupSum6(start+1, nums, target -6))return true; //T(n-1)
        }else{
            if (groupSum6(start+1, nums, target - nums[start]))return true; //T(n-1)
            if (groupSum6(start+1, nums, target)) return true; //T(n-1)
        }
        return false; //c_3
    }

    //Ejercicio 3
    /*
     * Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums to the given target, with this additional constraint: 
     * if there are numbers in the array that are adjacent and the identical value, they must either all be chosen, or none of them chosen. For example, with the array {1, 2, 2, 2, 5, 2},
     * either all three 2's in the middle must be chosen or not, all as a group. (one loop can be used to find the extent of the identical values).
     */
    /**
     * Title: github.com/mirandaio
     * Author: Miranda, Alfredo
     * Date: 2013
     * Avaiulability: https://github.com/mirandaio/codingbat/blob/master/java/recursion-2/groupSumClump.java
     */
    public boolean groupSumClump(int start, int[] nums, int target) {
        if(start >= nums.length)return target == 0; //c_1 
        int i = start; //c_2
        int sum = 0; //c_3
        while(i < nums.length && nums[start] == nums[i]) { //c_4*n
            sum += nums[i]; //c_5
            i++; //c_6
        }
        if(groupSumClump(i, nums, target - sum))return true; //T(n-1)
        if(groupSumClump(i, nums, target))return true; //T(n-1)
        return false; //c_7
    }

    //Ejercicio 4
    /*
     * Given an array of ints, is it possible to divide the ints into two groups, so that the sums of the two groups are the same. 
     * Every int must be in one group or the other. Write a recursive helper method that takes whatever arguments you like, 
     * and make the initial call to your recursive helper from splitArray(). (No loops needed.)
     */
    public boolean splitArray(int[] nums) {
        return auxiliar(nums,0,0);
    }
    //Método auxiliar para ejercicio 4
    private boolean auxiliar(int[] nums, int start,int target){
        if(start>=nums.length)return target==0; //c_1
        if(auxiliar(nums,start+1,target-nums[start]))return true; //T(n-1)
        if(auxiliar(nums,start+1,target+nums[start]))return true; //T(n-1)
        return false; //c_2
    }

    //Ejercicio 5
    /*
     * Given an array of ints, is it possible to divide the ints into two groups, so that the sum of the two groups is the same, with these constraints: 
     * all the values that are multiple of 5 must be in one group, and all the values that are a multiple of 3 (and not a multiple of 5) must be in the other. 
     * (No loops needed.)
     */

    public boolean split53(int[] nums) {
        return auxiliarsplit53(nums,0,0);
    }
    //Método auxiliar 
    private boolean auxiliarsplit53(int[] nums, int start,int target){
        if(start>=nums.length)return target==0; //c_1
        if(nums[start]%3==0){ //c_2
            return auxiliarsplit53(nums,start+1,target+nums[start]); //T(n-1)
        }
        if(nums[start]%5==0){ //c_3
            return auxiliarsplit53(nums,start+1,target-nums[start]); //T(n-1)
        }else{
            if(auxiliarsplit53(nums,start+1,target-nums[start]))return true; //T(n-1)
            if(auxiliarsplit53(nums,start+1,target+nums[start]))return true; //T(n-1)
            return false; //c_4
        }

    }

}
