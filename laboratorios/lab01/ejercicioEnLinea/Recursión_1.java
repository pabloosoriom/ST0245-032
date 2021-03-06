
/**
 * Solución al ejercicio 2.1 del laboratorio 1.
 * 
 * @author (Pablo Alberto Osorio Marulanda - Verónica Mendoza Iguarán) 
 * @version (11/08/2018)
 */

public class Recursión_1
{
    //Ejercicio 1
    //“Count recursively the total number of "abc" and "aba" substrings that appear in the given string.”  
    public int countAbc(String str) {
        if(str.length()<=2)return 0; //c_1
        if(str.substring(0,3).equals("abc")||str.substring(0,3).equals("aba")){ //c_2
            return 1+countAbc(str.substring(2)); //c_3 + T(n-2)
        }
        return countAbc(str.substring(1)); //T(n-1)+c_4
        //Caso más dificil: T(n-1)+c_4
    }

    //Ejercicio 2
    //"Given a string, compute recursively the number of times lowercase "hi" appears in the string, however do not count "hi" that have an 'x' immedately before them."
    public int countHi2(String str) {
        if(str.equals("hi")){ //c_1
            return 1; //c_2
        }
        if(str.length()>=3){ //c_3
            if(str.startsWith("x")&&str.substring(1,3).equals("hi")){ //c_4
                return 0+countHi2(str.substring(3)); //c_5 + T(n-3)
            }else if (str.startsWith("hi")){ //c_6
                return 1+countHi2(str.substring(2)); //c_7 + T(n-2)
            }else{
                return countHi2(str.substring(1)); //c_8+T(n-1)
            }
        }
        //Caso más dificil: c_8+T(n-1)
        
        return 0; //c_8
    }

    //Ejercicio 3
    //"Given a string that contains a single pair of parenthesis, compute recursively a new string made of only of the parenthesis and their contents, so "xyz(abc)123" yields "(abc)"."
    public String parenBit(String str) {
        if(str.length()<2) return str; //c_1
        if(str.charAt(0) == '('){ //c_2
            if(str.charAt(str.length()-1)== ')'){ //c_3
                return str; //c_4
            }return parenBit(str.substring(0,str.length()-1)); //T(n-1)+c_4
        }return parenBit(str.substring(1)); //T(n-1)+c_5
        
        //Caso más dificil: T(n-1)+c_5
    }

    //Ejercicio 4
    //Given a string, return true if it is a nesting of zero or more pairs of parenthesis, like "(())" or "((()))". Suggestion: check the first and last chars, and then recur on what's inside them.
    public boolean nestParen(String str) {
        if(str.length()==0) return true; //c_1
        if(str.charAt(0)=='(' && str.charAt(str.length()-1) == ')') { //c_2
            return nestParen(str.substring(1,str.length()-1)); //T(n-1)+c_3
        }return false; //c_4
        //Caso más dificil: t()
    }

    //Ejercicio 5
    //"Given a string and a non-empty substring sub, compute recursively the largest substring which starts and ends with sub and return its length."
    public int strDist(String str, String sub) {
        if(str.length()<sub.length()) return 0; //c_1
        if(str.startsWith(sub)){ //c_2
            if(str.endsWith(sub)){ //c_3
                return str.length(); //c_4
            }return strDist(str.substring(0,str.length()-1),sub); //T(n-1)+c_5
        }return strDist(str.substring(1),sub); //T(n-1)+c_6
        
        //Caso más dificil: T(n-1)+c_6
    }

}
