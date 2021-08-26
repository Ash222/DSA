package problems.Trees.Leetcode108;

// make BST from a given sorted array(ascending order).

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
    
    private TreeNode sortedArrayToBST( int[] nums ) {
        
        TreeNode bst;
        
        bst = makeBST( nums , 0 , nums.length - 1 );
        
        return bst;
        
    }
    
    private TreeNode makeBST( int[] nums , int left , int right ) {
        
        if( left > right ) return null;
        
        int middle = left + ( right - left ) / 2;
        
        TreeNode temp = new TreeNode( nums[middle] );
        
        temp.left = makeBST( nums , left , middle - 1 );
        temp.right = makeBST( nums , middle + 1 , right );
        
        return temp;
        
    }
    
}
