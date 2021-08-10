package problems.DP.Leetcode39;

/*

    Problem Statement : Combination Sum
    Example 1:
    Input: candidates = [2,3,6,7], target = 7
    Output: [[2,2,3],[7]]
    Explanation:
    2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
    7 is a candidate, and 7 = 7.
    These are the only two combinations.

    Example 2:
    Input: candidates = [2,3,5], target = 8
    Output: [[2,2,2,2],[2,3,3],[3,5]]

    Example 3:
    Input: candidates = [2], target = 1
    Output: []

    Example 4:
    Input: candidates = [1], target = 1
    Output: [[1]]

    Example 5:
    Input: candidates = [1], target = 2
    Output: [[1,1]]

*/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    private static List< List< Integer > > combinationSum( int[] candidates ,
                                                           int target ) {
        List< List< Integer > > result = new ArrayList<>();
        
        combination( candidates , target , result , new ArrayList<>() , 0 );
        
        return result;
    }
    
    private static void combination( int[] candidates , int target ,
                                     List< List< Integer > > result ,
                                     ArrayList< Integer > stack , int startIndex ) {
        
        // bounding condition
        if ( target == 0 ) {
            result.add( new ArrayList<>( stack ) );
            return;
        }
        
        for ( int i = startIndex ; i < candidates.length ; i++ ) {
            stack.add( candidates[i] );
            if ( target - candidates[i] >= 0 ) {
                combination( candidates , target - candidates[i] , result , stack , i );
            }
            stack.remove( stack.size() - 1 );
        }
        
    }
    
    public static void main( String[] args ) {
        int[] candidates = new int[]{ 2 , 3 , 6 , 7 };
        int target = 7;
        System.out.println( combinationSum( candidates , target ) );
    }
}

