package problems.DP.Leetcode1025;

/*

Alice and Bob take turns playing a game, with Alice starting first.

Initially, there is a number n on the chalkboard. On each player's turn, that player makes
 a move consisting of:

Choosing any x with 0 < x < n and n % x == 0.
Replacing the number n on the chalkboard with n - x.
Also, if a player cannot make a move, they lose the game.

Return true if and only if Alice wins the game, assuming both players play optimally.

Example 1:

Input: n = 2
Output: true
Explanation: Alice chooses 1, and Bob has no more moves.
Example 2:

Input: n = 3
Output: false
Explanation: Alice chooses 1, Bob chooses 1, and Alice has no more moves.

*/


/*

    This particular problem , can be solved in O(1) time. From our observation whoever
    get "even" number in its turn is going to win. Since Alice is going to take turn
    first then if "n" is "even" we simply return "true" otherwise "false".

*/

import java.util.HashMap;

public class Solution {
    
    public static boolean divisorGame( int n ) {

//        HashMap< Integer, Boolean > storage = new HashMap<>();
//        return game( n , storage );
//
        return n % 2 == 0;
        
    }
    
    // this is recursive approach , if we were to give ganda wala storage then it will
    // become DP. Let's do that.
    public static boolean game( int n ) {
        
        if ( n == 1 ) {
            return false;
        }
        
        for ( int i = 1 ; i < n ; i++ ) {
            
            if ( ( n % i == 0 ) && ( game( n - i ) == false ) ) {
                return true;
            }
            
        }
        
        return false;
        
    }
    
    // this is DP wala approach
    public static boolean gameDP( int n , HashMap< Integer, Boolean > storage ) {
        
        if ( storage.containsKey( n ) ) {
            return storage.get( n );
        }
        
        if ( n == 1 ) {
            return false;
        }
        
        for ( int i = 1 ; i < n ; i++ ) {
            if ( ( n % i == 0 ) && ( gameDP( n - i , storage ) == false ) ) {
                storage.put( n , true );
                return true;
            }
        }
        
        storage.put( n , false );
        return false;
        
    }
    
    public static void main( String[] args ) {
        System.out.println( divisorGame( 5 ) );
    }
    
}

