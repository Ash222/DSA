package problems.DP.knapsack;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    private static void knapsack( int weight[] , int[] values , int capacity ) {
        
        ArrayList< Integer > profit = new ArrayList<>();
        profit.add( 0 );
        solve( weight , values , capacity , 0 , 0 , profit );
        
        System.out.println( "maximum profit : " + profit );
        
    }
    
    private static void solve( int[] weight , int[] values , int capacity ,
                               int startIndex , int tempProfit ,
                               List< Integer > maxProfit ) {
        
        if ( capacity == 0 ) {
            return;
        }
        
        
        for ( int i = startIndex ; i < weight.length ; i++ ) {
            
            tempProfit = tempProfit + values[i];
            
            if ( capacity - weight[i] >= 0 ) {
                
                if ( tempProfit > maxProfit.get( 0 ) ) {
                    maxProfit.set( 0 , tempProfit );
                }
                
                solve( weight , values , capacity - weight[i] , i + 1 ,
                        tempProfit , maxProfit );
            }
            
            tempProfit = tempProfit - values[i];
            
        }
        
    }
    
    public static void main( String[] args ) {
        int weight[] = { 1 , 2 , 3 , 8 , 7 , 4 };
        int values[] = { 20 , 5 , 10 , 40 , 15 , 25 };
        int capacity = 10;
        knapsack( weight , values , capacity );
    }
    
}

