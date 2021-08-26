package problems.Trees.Leetcode100;

// check if two trees are same or not.

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
    
    private boolean isSameTree( TreeNode p , TreeNode q ) {
        
        if( p == null && q == null ) return true;
        
        if( p == null || q == null ) return false;
        
        return p.val == q.val && isSameTree( p.left , q.left ) &&
                isSameTree( p.right , q.right );
    }
    
}
