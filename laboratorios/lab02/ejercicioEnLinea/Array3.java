
/**
 * Solution to exercise 2.2 of the laboratory 2.
 * 
 * @author (Pablo Alberto Osorio Marulanda - Verónica Mendoza Iguarán) 
 * @version (9/09/2018)
 */
public class Array3
{
    //Exercise 1
    //Consider the leftmost and righmost appearances of some value in an array.
    //We'll say that the "span" is the number of elements between the two inclusive.
    //A single value has a span of 1. Returns the largest span found in the given array. 
    //(Efficiency is not a priority.)
    public int maxSpan(int[] nums) {
        int max=1; //c
        int cont = 0; //c
        if (nums.length<=0) return 0; //c
        for(int i=0; i< nums.length; i++){ //c*(n+1)
            for(int j=nums.length-1; j> i; j--){ //c*(m+1)*n
                if(nums[i]==nums[j]){ //c*m*n
                    cont = (j-i)+1;  //c*m*n
                }
                if(cont>max){ //c*m*n
                    max=cont; //c*m*n
                }
            }
        }return max; //c
        // Most difficult case: T(n,m)= c_1+c_2*n+c_3*m*n
    }

    
    //Exercise 2
    //Return an array that contains exactly the same numbers as the given array, 
    //but rearranged so that every 3 is immediately followed by a 4. 
    //Do not move the 3's, but every other number may move. 
    //The array contains the same number of 3's and 4's, every 3 has a number 
    //after it that is not a 3, and a 3 appears in the array before any 4.
    public int[] fix34(int[] nums) {
        for(int i=0;i<nums.length;i++){ //c*(n+1)
            if(nums[i]==3){ //c*n
                int temp = nums[i+1]; //c*n
                nums[i+1]=4; //c*n
                for(int j=i+2;j<nums.length; j++){ //c*(m+1)*n
                    if(nums[j]==4){ //c*m*n
                        nums[j]=temp; //c*m*n
                    }
                }
            }
        }return nums;//c
        // Most difficult case: T(n,m)= c_1+c_2*n+n+c_3*m*n
    }

    
    //Exercise 3
    //Return an array that contains exactly the same numbers as the given array, 
    //but rearranged so that every 4 is immediately followed by a 5. 
    //Do not move the 4's, but every other number may move. 
    //The array contains the same number of 4's and 5's, and every 4 has a number 
    //after it that is not a 4. In this version, 5's may appear anywhere in the original array.
    public int[] fix45(int[] nums) {
        for (int i = 0; i < nums.length; i++) { //c*(n+1)
            if (nums[i] == 4) { //c*n
                for (int j = 0; j < nums.length; j++){ //c*(n+1)*n
                    if (nums[j] == 5) { //c*n*n
                        if (j == 0) { //c*n*n
                            int num1 = nums[i+1]; //c*n*n
                            nums[i+1] = 5; //c*n*n
                            nums[j] = num1; //c*n*n
                        }
                        if (j > 0 && nums[j-1]!= 4){ //c*n*n
                            int num2 = nums[i+1]; //c*n*n
                            nums[i+1] = 5; //c*n*n
                            nums[j] = num2; //c*n*n
                        }
                    }
                }
            }
        }
        return nums;
        // Most difficult case: T(n)= c_1+c_2*n+c_3*n*n
    }

    
    //Exercise 4
    //Given a non-empty array, return true if there is a place to split the array
    //so that the sum of the numbers on one side is equal to the sum of the numbers on the other side.
    public boolean canBalance(int[] nums) {
        int acum =0; //c
        for(int i=0;i<nums.length;i++){ //c*(n+1)
            acum += nums[i]; //c*n
            int acum2 =0; //c*n
            for(int j=nums.length-1;j>i;j--){ //c*(m+1)*n
                acum2 += nums[j]; //c*n*m
            }
            if(acum==acum2){ //c*n
                return true; //c*n
            }
        }return false; //c
        // Most difficult case: T(n,m)= c_1+c_2*n+c_3*m*n+c*n
    }

    
    //Exercise 5
    //Given two arrays of ints sorted in increasing order, outer and inner, 
    //return true if all of the numbers in inner appear in outer. 
    //The best solution makes only a single "linear" pass of both arrays,
    //taking advantage of the fact that both arrays are already in sorted order.
    public boolean linearIn(int[] outer, int[] inner) {
        int cont=0; //c
        for(int i=0;i<inner.length;i++){ //c*(n+1)
            for(int j=0;j<outer.length;j++){ //c*(m+1)*n
                if(outer[j]==inner[i]){ //c*n*m
                    cont++; //c*n*m
                    break; //c*n*m
                }
            }
        }
        if(cont==inner.length){ //c
            return true; //c
        }return false; //c
        // Most difficult case: T(n,m)= c_1+c_2*n+c_3*n*m+c_4
    }

    
    //Exercise 6
    //Given n>=0, create an array with the pattern 
    //{1,    1, 2,    1, 2, 3,   ... 1, 2, 3 .. n} (spaces added to show the grouping). 
    //Note that the length of the array will be 1 + 2 + 3 ... + n, which is known 
    //to sum to exactly n*(n + 1)/2.
    public int[] seriesUp(int n) {
        int arr[]=new int[n*(n + 1)/2]; //c
        int indice=0; //c
        for(int i=1;i<=n;i++){ //c*(n+1)
            for(int j=1;j<=i;j++){ //c*(m+1)*n
                arr[indice]=j; //c*m*n
                indice++;//c*m*n
            }
        }return arr;//c
        // Most difficult case: T(n,m)= c_1+c_2*n+c_3*n*m+c_4
    }
}
