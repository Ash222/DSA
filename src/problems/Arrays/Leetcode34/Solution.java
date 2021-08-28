package problems.Arrays.Leetcode34;

public class Solution {
    
    private static int[] searchRange( int[] nums , int target ) {
        
        int[] result = new int[2];
        
        result[0] = findPositionUsingBinarySearch( nums , target , true );
        result[1] = findPositionUsingBinarySearch( nums , target , false );
        
        return result;
        
    }
    
    private static int findPositionUsingBinarySearch( int[] num , int target ,
                                                      boolean firstPosition ) {
        
        int position = -1;
        int left = 0;
        int right = num.length - 1;
        
        while ( left <= right ) {
            
            int middle = left + ( right - left ) / 2;
            
            if( num[middle] == target ) {
                
                position = middle;
                
                if( firstPosition ) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
                
            } else if( target > num[middle] ) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
            
        }
        
        return position;
        
    }
    
    public static void main( String[] args ) {
        
        int[] arr = { 5 , 7 , 7 , 8 , 8 , 8 , 8 , 10 };
        
        int target = 8;
        
        int[] result = searchRange( arr , target );
        
        for ( int res : result ) {
            System.out.println( res );
        }
        
    }
    
}
