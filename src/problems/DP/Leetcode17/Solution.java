package problems.DP.Leetcode17;

/*

    Problem statement : Letter Combinations of a Phone Number
    Given a string containing digits from 2-9 inclusive, return all possible letter
    combinations that the number could represent. Return the answer in any order.
    A mapping of digit to letters (just like on the telephone buttons) is given below.
    Note that 1 does not map to any letters.

    Example 1:
    Input: digits = "23"
    Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

    Example 2:
    Input: digits = ""
    Output: []

    Example 3:
    Input: digits = "2"
    Output: ["a","b","c"]

*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    
    private static List< String > letterCombinations( String digits ) {
        List< String > storage = new ArrayList<>();
        HashMap< Character, String > phoneKeys = new HashMap<>();
        
        phoneKeys.put( '2' , "abc" );
        phoneKeys.put( '3' , "def" );
        phoneKeys.put( '4' , "ghi" );
        phoneKeys.put( '5' , "jkl" );
        phoneKeys.put( '6' , "mno" );
        phoneKeys.put( '7' , "pqrs" );
        phoneKeys.put( '8' , "tuv" );
        phoneKeys.put( '9' , "wxyz" );
        
        combinations( storage , phoneKeys , digits , 0 , new StringBuilder() );
        
        return storage;
    }
    
    private static void combinations( List< String > result ,
                                      HashMap< Character, String > phone ,
                                      String digits , int digitIndex ,
                                      StringBuilder stack ) {
        
        // bounding condition
        if ( digitIndex == digits.length() ) {
            result.add( stack.toString() );
            return;
        }
        
        // if this line were to be initialise at top of this method then it will throw
        // an error. This is because as the recursion reaches to the bounding
        // condition the "digitIndex" will be overshoot the index of the "digit". That
        // is why it is defined here.
        String current = phone.get( digits.charAt( digitIndex ) );
        for ( int i = 0 ; i < current.length() ; i++ ) {
            //pushing it into the stack
            stack.append( current.charAt( i ) );
            combinations( result , phone , digits , digitIndex + 1 , stack );
            //before backtracking popping the element
            stack.deleteCharAt( stack.length() - 1 );
            
        }
        
    }
    
    public static void main( String[] args ) {
        String digit = "23";
        System.out.println( letterCombinations( digit ) );
    }
    
}

