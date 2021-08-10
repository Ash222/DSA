package problems.DP.permutateString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
    
    private static void permutateString( String inputStr ) {
        
        List< String > storage = new ArrayList<>();
        StringBuilder str = new StringBuilder( inputStr );
        HashSet< String > hset = new HashSet<>();
        permutationNoDuplicates( storage , str , new StringBuilder() ,
                hset );
        
        permutate( storage , str , new StringBuilder() );
        System.out.println( hset );
        System.out.println( storage + " \ntotal length is : " + storage.size() );
        
    }
    
    //this method doesn't handle duplicates.
    private static void permutate( List< String > storage , StringBuilder str ,
                                   StringBuilder stack ) {
        
        if ( str.length() == 0 ) {
            
            storage.add( stack.toString() );
            return;
            
        }
        
        for ( int i = 0 ; i < str.length() ; i++ ) {
            
            String left = str.substring( 0 , i );
            String right = str.substring( i + 1 );
            StringBuilder newStr = new StringBuilder( left + right );
            
            stack.append( str.charAt( i ) );
            permutate( storage , newStr , stack );
            stack.deleteCharAt( stack.length() - 1 );
            
        }
        
    }
    
    // this method will handle the duplication in the string. Will work on this later.
    private static void permutationNoDuplicates( List< String > storage ,
                                                 StringBuilder str
            , StringBuilder stack , HashSet< String > hset ) {
        
        if ( str.length() == 0 ) {
            hset.add( stack.toString() );
            storage.add( stack.toString() );
            return;
            
        }
        
        for ( int i = 0 ; i < str.length() ; i++ ) {
            
            String left = str.substring( 0 , i );
            String right = str.substring( i + 1 );
            StringBuilder newStr = new StringBuilder( left + right );
            
            stack.append( str.charAt( i ) );
            permutationNoDuplicates( storage , newStr , stack , hset );
            stack.deleteCharAt( stack.length() - 1 );
            
        }
        
    }
    
    public static void main( String[] args ) {
        permutateString( "acb" );
    }
}
