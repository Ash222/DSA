package problems.Arrays.Leetcode442;

/*

    Problem statement :
    Given an integer array nums of length n where all the integers of nums are in the
    range [1, n] and each integer appears once or twice, return an array of all the
    integers that appears twice.

    You must write an algorithm that runs in O(n) time and uses only constant extra
    space.

    Example 1:

    Input: nums = [4,3,2,7,8,2,3,1]
    Output: [2,3]
    Example 2:

    Input: nums = [1,1,2]
    Output: [1]
    Example 3:

    Input: nums = [1]
    Output: []

*/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static List< Integer > findDuplicates( int[] nums ) {
        
        List< Integer > outputArray = new ArrayList<>();
        
        int index = 0;
        
        // logic
        for ( int i = 0 ; i < nums.length ; i++ ) {
            
            index = Math.abs( nums[i] ) - 1;
            if ( nums[index] < 0 ) {
                outputArray.add( index + 1 );
            }
            nums[index] = -nums[index];
            
        }
        
        return outputArray;
        
    }
    
    public static void main( String[] args ) {
        
        int[] arr = new int[]{ 4 , 3 , 2 , 7 , 8 , 2 , 3 , 1 };
        
        System.out.println( findDuplicates( arr ) );
    }
}
