package problems.Trees.Leetcode94;

//inorder traversal in tree and resultant should be in List.

import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    public class TreeNode {
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
    
    private List<Integer> inorderTravesal( TreeNode root ) {
        
        List<Integer> result = new ArrayList<>();
        
        inorder( root , result );
        
        return result;
        
    }
    
    private void inorder( TreeNode current , List<Integer> result ) {
        
        if( current == null ) return;
        inorder( current.left , result );
        result.add( current.val );
        inorder( current.right , result );
        
    }
    
}
