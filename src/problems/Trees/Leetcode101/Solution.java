package problems.Trees.Leetcode101;

// check if the binary tree is mirror or not

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
    
    private boolean isSymmetric( TreeNode root ) {
        
        if( root == null ) return true;
        
        return mirror( root.left , root.right );
        
    }
    
    private boolean mirror( TreeNode leftHalf , TreeNode rightHalf ) {
        
        if( leftHalf == null && rightHalf == null ) return true;
        if( leftHalf == null || rightHalf == null ) return false;
        if( leftHalf.val != rightHalf.val ) return false;
        
        return mirror( leftHalf.left , rightHalf.right ) &&
                mirror( leftHalf.right , rightHalf.left );
    }
    
}
