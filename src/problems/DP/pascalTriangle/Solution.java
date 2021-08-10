package problems.DP.pascalTriangle;

/*
    Given an integer numRows, return the first numRows of Pascal's triangle.

    Example 1:
    Input: numRows = 5
    Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

    Example 2:
    Input: numRows = 1
    Output: [[1]]

 */

import java.util.ArrayList;

public class Solution {
    
    private static ArrayList< ArrayList< Integer > > generatePascalTriangle(
            int numRows ) {
        
        ArrayList< ArrayList< Integer > > outputArray = new ArrayList<>( numRows );
        
        int sum = 0;
        // initialize each element of the arrayList to another arraylist
        for ( int i = 0 ; i < numRows ; i++ ) {
            outputArray.add( new ArrayList<>( i + 1 ) );
        }
        
        for ( int i = 0 ; i < numRows ; i++ ) {
            for ( int j = 0 ; j <= i ; j++ ) {
                if ( j == 0 || j == i ) {
                    outputArray.get( i ).add( j , 1 );
                } else {
                    sum = outputArray.get( i - 1 ).get( j - 1 ) +
                            outputArray.get( i - 1 ).get( j );
                    outputArray.get( i ).add( j , sum );
                }
            }
        }
        
        return outputArray;
        
    }
    
    public static void main( String[] args ) {
        
        System.out.println( generatePascalTriangle( 5 ) );
        
    }
    
}

