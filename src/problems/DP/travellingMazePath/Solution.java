package problems.DP.travellingMazePath;

/*

    Problem Statement :
    Given a grid let say 3*4 , we have to find in how many ways one can travel from
    grid[1,1] to grid[3,4]. Constraints - only downwards and rightward movements is
    allowed.

  start ==>  | 1,1 | 1,2 | 1.3 | 1,4 |
             | 2,1 | 2,2 | 2,3 | 2,4 |
             | 3,1 | 3,2 | 3,3 | 3,4 |  <== end

     Total number of ways is 6(for this grid).

*/

import java.util.HashMap;

public class Solution {
    
    // this logic is correct but it is calculating the same thing again and again
    // which for big values of row and column gives the result late. Since the time
    // complexity of this is 2^(row+column). To improve this we use DP.
    private static int numberOfWaysToTravelGrid( int row , int column ) {
        
        if ( row == 1 && column == 1 ) {
            return 1;
        }
        if ( row == 0 || column == 0 ) {
            return 0;
        }
        
        return numberOfWaysToTravelGrid( row - 1 , column ) +
                numberOfWaysToTravelGrid( row , column - 1 );
        
    }
    
    
    // we're doing the same thing as above but the onl difference is we're storing
    // repeating value in some container.
    private static int numberOfWaysToTravelGridDP( int row , int column , HashMap< String,
            Integer > storage ) {
        
        String key = row + "," + column;
        
        if ( storage.containsKey( key ) ) {
            return storage.get( key );
        }
        
        if ( row == 1 && column == 1 ) {
            return 1;
        }
        if ( row == 0 || column == 0 ) {
            return 0;
        }
        
        storage.put( key ,
                numberOfWaysToTravelGridDP( row - 1 , column , storage ) +
                        numberOfWaysToTravelGridDP( row , column - 1 , storage ) );
        
        return storage.get( key );
        
    }
    
    public static void main( String[] args ) {
        
        int row = -2, column = 1;
        
        HashMap< String, Integer > storage = new HashMap<>();

//        int result = numberOfWaysToTravelGrid( 3 , 3 );
        if ( row >= 0 && column >= 0 ) {
            int resultDP = numberOfWaysToTravelGridDP( row , column , storage );
            System.out.println( resultDP );
        } else {
            System.out.println( "Negative row and column grid means nothing." );
        }
        
    }
    
    
}

