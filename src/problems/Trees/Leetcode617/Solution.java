package problems.Trees.Leetcode617;

// merge two binary trees

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
    
    private TreeNode mergeTrees( TreeNode root1 , TreeNode root2 ) {
        
        TreeNode merge = new TreeNode();
        
        if( root1 == null && root2 == null ) return merge;
        
        merge = mergeBTrees( root1 , root2 );
        
        return merge;
    }
    
    private TreeNode mergeBTrees( TreeNode current1 , TreeNode current2 ) {
        
        if( current1 == null ) return current2;
        
        if( current2 == null ) return current1;
        
        TreeNode temp = new TreeNode();
        temp.val = current1.val + current2.val;
        
        temp.left = mergeBTrees( current1.left , current2.left );
        temp.right = mergeBTrees( current1.right , current2.right );
        
        return temp;
        
    }
    
}
