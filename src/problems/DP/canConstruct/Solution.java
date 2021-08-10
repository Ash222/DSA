package problems.DP.canConstruct;

/*
    We're given a target string S , and an array of strings , and we have to find if it
     is possible to form the target string S from the array of strings. It's permutation
     and combination.
*/


import java.util.HashMap;

public class Solution {
    
    // this method return if it is possible to make the target string from the given
    // array.
    private static boolean canConstruct( String targetStr , String[] wordBank ) {
        
        StringBuilder target = new StringBuilder( targetStr );
        return constructionPossible( target , wordBank );
    }
    
    private static boolean constructionPossible( StringBuilder target ,
                                                 String[] wordBank ) {
        
        if ( target.length() == 0 ) {
            return true;
        }
        
        for ( int i = 0 ; i < wordBank.length ; i++ ) {
            
            if ( target.indexOf( wordBank[i] ) == 0 ) {
                
                StringBuilder newTarget =
                        new StringBuilder( target.substring( wordBank[i].length() ) );
                
                if ( constructionPossible( newTarget , wordBank ) ) {
                    return true;
                }
                
            }
            
        }
        
        return false;
    }
    
    // there is a problem with the above method , it is that it doesn't cache the
    // result as such it's time complexity is exponential. Thus for bigger target
    // string and array string it will result in taking a lot of time. We can reduce
    // the time by allowing caching. The below method is DP.
    private static boolean canConstructDP( String targetStr , String[] wordBank ) {
        
        StringBuilder target = new StringBuilder( targetStr );
        
        return constructionPossibleDP( target , wordBank , new HashMap< StringBuilder,
                Boolean >() );
        
    }
    
    private static boolean constructionPossibleDP( StringBuilder target ,
                                                   String[] wordBank ,
                                                   HashMap< StringBuilder, Boolean > store ) {
        
        if ( store.containsKey( target ) ) {
            return store.get( target );
        }
        
        if ( target.length() == 0 ) {
            return true;
        }
        
        for ( int i = 0 ; i < wordBank.length ; i++ ) {
            
            if ( target.indexOf( wordBank[i] ) == 0 ) {
                
                StringBuilder newTarget =
                        new StringBuilder( target.substring( wordBank[i].length() ) );
                
                if ( constructionPossibleDP( newTarget , wordBank , store ) ) {
                    store.put( target , true );
                    return true;
                }
                
            }
            
        }
        
        store.put( target , false );
        
        return false;
        
    }
    
    // the below method will count the number of ways if at all , string can be
    // constructed from the array.
    private static int countConstruct( String targetStr , String[] wordBank ) {
        
        StringBuilder target = new StringBuilder( targetStr );
        
        return numberOfConstruct( target , wordBank );
        
    }
    
    private static int numberOfConstruct( StringBuilder target , String[] wordBank ) {
        
        if ( target.length() == 0 ) {
            return 1;
        }
        
        int totalNumberOfWays = 0;
        
        for ( int i = 0 ; i < wordBank.length ; i++ ) {
            if ( target.indexOf( wordBank[i] ) == 0 ) {
                StringBuilder newTarget =
                        new StringBuilder( target.substring( wordBank[i].length() ) );
                int count = numberOfConstruct( newTarget , wordBank );
                
                totalNumberOfWays = totalNumberOfWays + count;
            }
        }
        
        return totalNumberOfWays;
        
    }
    
    // the below method will use DP technique on the above logic
    private static int countConstructDP( String targetStr , String[] wordBank ) {
        
        StringBuilder target = new StringBuilder( targetStr );
        return numberOfConstructDP( target , wordBank ,
                new HashMap< StringBuilder, Integer >() );
        
    }
    
    private static int numberOfConstructDP( StringBuilder target , String[] wordBank ,
                                            HashMap< StringBuilder, Integer > store ) {
        
        if ( store.containsKey( target ) ) {
            return store.get( target );
        }
        
        if ( target.length() == 0 ) {
            return 1;
        }
        
        int totalNumberOfWays = 0;
        
        for ( int i = 0 ; i < wordBank.length ; i++ ) {
            
            if ( target.indexOf( wordBank[i] ) == 0 ) {
                
                StringBuilder newTarget =
                        new StringBuilder( target.substring( wordBank[i].length() ) );
                int count = numberOfConstructDP( newTarget , wordBank , store );
                
                totalNumberOfWays = totalNumberOfWays + count;
                
            }
            
        }
        
        store.put( target , totalNumberOfWays );
        return totalNumberOfWays;
    }
    
    
    public static void main( String[] args ) {
        String target = "purple";
        String[] arr = { "purp" , "p" , "ur" , "le" , "purpl" };
        // { "ab" , "abc" , "cd" , "def" , "abcd" }; target = "abcdef" ==> true
        // { "bo" , "rd" , "ate" , "t" , "ska" , "sk" , "boar" }
        // target="skateboard" ==>false
        // { "e" , "ee" , "eee" , "eeee" , "eeeee" , "eeeeee" }
        // target = "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef" ==>false
        
        
        System.out.println( countConstructDP( target , arr ) );
    }
    
}
