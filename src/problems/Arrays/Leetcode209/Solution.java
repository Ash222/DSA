package problems.Arrays.Leetcode209;

/*

Given an array of positive integers nums and a positive integer target, return the
minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which
the sum is greater than or equal to target. If there is no such subarray, return 0
instead.

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.

Input: target = 4, nums = [1,4,4]
Output: 1

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0

Follow up: If you have figured out the O(n) solution, try coding another solution of
which the time complexity is O(n log(n)).


*/

public class Solution {
    
    private static int minSubArrayLen( int target , int[] nums ) {
        
        int minLength = nSolution( target , nums );
        
        return minLength;
    }
    
    private static int nSolution( int target , int[] nums ) {
        int result = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for ( int i = 0 ; i < nums.length ; i++ ) {
            sum += nums[i];
            
            while ( sum >= target ) {
                
                result = Math.min( result , i + 1 - left );
                sum -= nums[left];
                left++;
                
            }
        }
        
        return result == Integer.MAX_VALUE ? 0 : result;
    }
    
    @Deprecated
    // this is n^2 solution. Ok so this solution is flawed.
    private static int n2Solution( int target , int[] nums ) {
        
        int minCount = Integer.MAX_VALUE;
        
        for ( int i = 0 ; i < nums.length - 1 ; i++ ) {
            int count = 1;
            int sum = nums[i];
            
            if( sum == target ) return count;
            
            for ( int j = i + 1 ; j < nums.length ; j++ ) {
                sum += nums[j];
                count++;
                if( sum > target ) {
                    break;
                }
                if( sum == target ) {
                    minCount = Math.min( minCount , count );
                }
            }
        }
        
        return minCount == Integer.MAX_VALUE ? 0 : minCount;
    }
    
    public static void main( String[] args ) {
        int arr[] = { 1 , 2 , 3 , 4 , 5 };
        int target = 11;
        
        System.out.println( "Minimum length = " + minSubArrayLen( target , arr ) );
    }
    
}
