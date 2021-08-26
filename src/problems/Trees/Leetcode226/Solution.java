package problems.Trees.Leetcode226;

// invert the binary tree.

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
    
    private TreeNode invertTree( TreeNode current ) {
        
        if( current == null ) return null;
        if( current != null ) {
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
        }
        
        current.left = invertTree( current.left );
        current.right = invertTree( current.right );
        
        return current;
        
    }
}
