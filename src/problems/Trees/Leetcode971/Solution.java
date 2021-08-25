package problems.Trees.Leetcode971;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    //definition of TreeNode
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode() {
        }
        
        TreeNode( int val ) {
            this.val = val;
        }
        
        TreeNode( int val , TreeNode left , TreeNode right ) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    List< Integer > results = new ArrayList<>();
    int index = 0;
    
    private List< Integer > flipMathVoyager( TreeNode root , int[] voyager ) {
        List< Integer > negativeResult = new ArrayList<>();
        negativeResult.add( -1 );
        
        return preTraversal( root , voyager ) ? results : negativeResult;
        
    }
    
    private boolean preTraversal( TreeNode current , int[] voyager ) {
        
        if ( current == null ) {
            return true;
        }
        if ( current.val != voyager[ index ] ) {
            return false;
        }
        
        index++;
        
        if ( current.left != null && current.left.val == voyager[ index ] ) {
            
            results.add( current.val );
            
            return preTraversal( current.left , voyager ) &&
                    preTraversal( current.right , voyager );
        } else {
            return preTraversal( current.right , voyager ) &&
                    preTraversal( current.left , voyager );
        }
    }
    
}
