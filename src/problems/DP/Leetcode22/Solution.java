package problems.DP.Leetcode22;

/*

    Problem Statement : Generate Parenthesis
    Given n pairs of parentheses, write a function to generate all combinations of
    well-formed parentheses.

    Example 1:

    Input: n = 3
    Output: ["((()))","(()())","(())()","()(())","()()()"]
    Example 2:

    Input: n = 1
    Output: ["()"]

*/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    private static List< String > generateParenthesis( int n ) {
        List< String > storage = new ArrayList<>();
        parenthesis( storage , "" , n , n );
        System.out.println( "Total length : " + storage.size() );
        return storage;
    }
    
    private static List< String > parenthesis( List< String > storage , String currentString ,
                                               int openBracketCount , int closeBracketCount ) {
        
        // bounding condition.
        if ( openBracketCount == 0 && closeBracketCount == 0 ) {
            storage.add( currentString );
        }
        
        if ( openBracketCount <= closeBracketCount && openBracketCount >= 0 ) {
            parenthesis( storage , currentString + "(" ,
                    openBracketCount - 1 , closeBracketCount );
        }
        if ( closeBracketCount >= openBracketCount && closeBracketCount >= 0 ) {
            parenthesis( storage , currentString + ")" , openBracketCount ,
                    closeBracketCount - 1 );
        }
        
        return storage;
        
    }
    
    public static void main( String[] args ) {
        System.out.println( generateParenthesis( 5 ) );
    }
    
    
}

