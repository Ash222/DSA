package problems.Trees.Leetcode589;

/*
 preorder traversal of n-ary tree
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    
    // Definition of Node
    class Node {
        public int val;
        public List<Node> children;
        
        public Node() {
        }
        
        public Node( int _val ) {
            val = _val;
        }
        
        public Node( int _val , List<Node> _children ) {
            val = _val;
            children = _children;
        }
    }
    
    public List<Integer> preorder( Node root ) {
        
        List<Integer> result = new ArrayList<>();
        List<Node> stack = new ArrayList<>();
        
        if( root == null ) return result;
        
        stack.add( root );
        while ( !stack.isEmpty() ) {
            
            Node node = stack.remove( stack.size() - 1 );
            
            result.add( node.val );
            
            Collections.reverse( node.children );
            
            for ( int i = 0 ; i < node.children.size() ; i++ ) {
                stack.add( node.children.get( i ) );
            }
            
        }
        
        return result;
    }
    
}
