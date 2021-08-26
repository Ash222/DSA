package problems.Trees.Leetcode111;

/*

    Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node
down to the nearest leaf node.

Note: A leaf is a node with no children.

*/

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
    
    private int minDepth( TreeNode root ) {
        
        if( root == null ) return 0;
        
        return findMinDepth( root , 1 );
        
    }
    
    private int findMinDepth( TreeNode current , int level ) {
        
        if( current.left == null && current.right == null ) return level;
        
        int leftDepth = Integer.MAX_VALUE;
        int rightDepth = Integer.MAX_VALUE;
        
        if( current.left != null ) leftDepth = findMinDepth( current.left , level + 1 );
        
        if( current.right != null )
            rightDepth = findMinDepth( current.right , level + 1 );
        
        return Math.min( leftDepth , rightDepth );
    }
    
}
