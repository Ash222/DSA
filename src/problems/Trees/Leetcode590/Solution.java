package problems.Trees.Leetcode590;

// Post order traversal in n-ary tree

import java.util.LinkedList;
import java.util.List;

public class Solution {
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
    
    private List<Integer> postorder( Node root ) {
        LinkedList<Integer> result = new LinkedList<>();
        LinkedList<Node> stack = new LinkedList<>();
        
        if( root == null ) return result;
        
        stack.add( root );
        while ( !stack.isEmpty() ) {
            
            Node node = stack.pollLast();
            result.addFirst( node.val );
            
            for ( int i = 0 ; i < node.children.size() ; i++ ) {
                stack.add( node.children.get( i ) );
            }
            
        }
        
        return result;
    }
    
}
