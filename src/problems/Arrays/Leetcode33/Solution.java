package problems.Arrays.Leetcode33;

/*

There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is rotated at an unknown pivot index
k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ...,
nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7]
might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the rotation and an integer target, return the index of target
if it is in nums, or -1 if it is not in nums.
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

Example 3:
Input: nums = [1], target = 0
Output: -1

*/


public class Solution {
    
    private static int search( int[] nums , int target ) {
        
        int left = 0;
        int right = nums.length - 1;
        
        while ( left < right ) {
            // so this is basically for overflow.
            int midPoint = left + ( right - left ) / 2;
            if ( nums[ midPoint ] > nums[ right ] ) {
                left = midPoint + 1;
            } else {
                right = midPoint;
            }
        }
        
        int start = left;
        left = 0;
        right = nums.length - 1;
        
        if ( target >= nums[ start ] && target <= nums[ right ] ) {
            left = start;
        } else {
            right = start;
        }
        
        while ( left <= right ) {
            int midPoint = left + ( right - left ) / 2;
            if ( nums[ midPoint ] == target ) {
                return midPoint;
            } else if ( nums[ midPoint ] > target ) {
                right = midPoint - 1;
            } else {
                left = midPoint + 1;
            }
        }
        
        return -1;
    }
    
    public static void main( String[] args ) {
        
        int[] num={4,5,6,7,0,1,2};
        int target=6;
        
        System.out.println(search( num,target));
        
    }
    
}
