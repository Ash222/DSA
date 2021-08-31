package problems.Arrays.Leetcode330;

/*

Given a sorted integer array nums and an integer n, add/patch elements to the array
such that any number in the range [1, n] inclusive can be formed by the sum of some
elements in the array.

Example 1:
Input: nums = [1,3], n = 6
Output: 1
Explanation:
Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3, 4.
Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3], [2,3], [1,2,3].
Possible sums are 1, 2, 3, 4, 5, 6, which now covers the range [1, 6].
So we only need 1 patch.

*/

public class Solution {
    
    private static int minPatches( int[] nums , int n ) {
        
        int minPatches = 0;
        long maxRange = 0;
        int index = 0;
        int arrLength = nums.length;
        
        while ( maxRange < n ) {
            
            if( index < arrLength && nums[index] <= maxRange + 1 ) {
                maxRange += nums[index];
                index++;
            } else {
                maxRange += ( maxRange + 1 );
                minPatches++;
            }
            
        }
        
        return minPatches;
        
    }
    
    public static void main( String[] args ) {
        
        int[] arr = { 1 , 5 , 10 };
        int target = 20;
        
        System.out.println( "Minimum Patches required = " + minPatches( arr , target ) );
        
    }
    
}
