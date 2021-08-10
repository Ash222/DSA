package problems.DP.canSum;

/*

    Problem statement 1 :
    Given an array , we have to find if it is possible to find the target sum.
    You can reuse the numbers in the array.

    for e.g. : target sum = 7  array=[2,3] ans : true.

    Problem Statement 2 :
    Similar to above problem 1 , the only difference would be to get all the possible
    combination of the sum. Reuse of the numbers is allowed.

    Problem Statement 3 :
    Similar to problem 1 , the only difference is we have to find the combination of
    the sum n , from 1 to n.

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    private static int counter = 0;
    
    // though this logic is good , it is far from sufficient as the time complexity is
    // exponential.
    private static boolean canSum( int targetSum , ArrayList< Integer > array ) {
        
        if ( targetSum == 0 ) {
            return true;
        }
        if ( targetSum < 0 ) {
            return false;
        }
        
        for ( int i = 0 ; i < array.size() ; i++ ) {
            
            if ( canSum( targetSum - array.get( i ) , array ) == true ) {
                return true;
            }
            
        }
        
        return false;
        
    }
    
    // better canSum method by using DP.
    private static boolean canSumDP( int targetSum , ArrayList< Integer > array ,
                                     HashMap< Integer, Boolean > storage ) {
        
        if ( storage.containsKey( targetSum ) ) {
            return storage.get( targetSum );
        }
        if ( targetSum == 0 ) {
            return true;
        }
        
        if ( targetSum < 0 ) {
            return false;
        }
        
        for ( int i = 0 ; i < array.size() ; i++ ) {
            
            if ( canSumDP( targetSum - array.get( i ) , array , storage ) == true ) {
                storage.put( targetSum , true );
                return true;
            }
            
        }
        
        storage.put( targetSum , false );
        
        return false;
        
    }
    
    // this method gives all the permutation of the sum. If we want combination that means
    // repeating numbers aren't allowed, then that logic is in method below.
    private static void permutationSum( int targetSum , ArrayList< Integer > array ,
                                        ArrayList< Integer > stack ) {
        
        if ( targetSum == 0 ) {
            System.out.println( stack );
        }
        
        for ( int i = 0 ; i < array.size() ; i++ ) {
            
            stack.add( array.get( i ) );
            
            permutationSum( targetSum - array.get( i ) , array , stack );
            
            stack.remove( stack.size() - 1 );
            
        }
        
    }
    
    // this method gives the combination of the sum. Just by passing the startIndex to
    // the recursion whole tree got changed.
    private static void combinationSum( int targetSum , ArrayList< Integer > array ,
                                        ArrayList< Integer > stack , int startIndex ) {
        
        if ( targetSum == 0 ) {
            counter++;
            System.out.println( stack );
        }
        
        for ( int i = startIndex ; i < array.size() ; i++ ) {
            
            stack.add( array.get( i ) );
            
            if(targetSum-array.get(i)>=0)
                combinationSum( targetSum - array.get( i ) , array , stack , i );
            
            stack.remove( stack.size() - 1 );
            
        }
        
    }
    
    
    public static void main( String[] args ) {
        
        // for problem 1 :
        // 7 [5,3,4,7]
        // 7 [2,3]
        // 7 [2,4]
        // 8 [2,3,5]
        // 300 [7,14]
        ArrayList< Integer > arr = new ArrayList<>( Arrays.asList( 1 , 2 , 3 ) );
        HashMap< Integer, Boolean > storage = new HashMap<>();
        HashMap< Integer, ArrayList< Integer > > store = new HashMap<>();
        ArrayList< Integer > st = new ArrayList<>();
        int sum = 4;

/*
        System.out.println( canSum( sum , arr ) );
        permutationSum( sum , arr , st );
*/


//        System.out.println( canSumDP( sum , arr , storage ) );

//        System.out.println();
        
        combinationSum( sum , arr , st , 0 );
        
        System.out.println( "Total number of ways = " + counter );

//        System.out.println( combinationSumDP( sum , arr , st , 0 , store ) );
        
        System.out.println();
        
    }
    
}
