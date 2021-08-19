package theory.graphs.traversal;


import java.util.Iterator;
import java.util.LinkedList;

public class Solution {
    
    // number of vertices
    private int vertices;
    
    // Linked adjacency
    private LinkedList< Integer > adj[];
    
    // constructor for the graph
    Solution( int vertices ) {
        this.vertices = vertices;
        
        adj = new LinkedList[ vertices ];
        for ( int i = 0 ; i < vertices ; i++ ) {
            adj[ i ] = new LinkedList<>();
        }
    }
    
    // method to add edge in the graph
    private void addEdge( int vertex , int adjacentVertex ) {
        
        adj[ vertex ].add( adjacentVertex );
        
    }
    
    private void dfsTraversal( int startVertex ) {
        
        boolean[] visited = new boolean[ this.vertices ];
        
        DFS( startVertex , visited );
        
    }
    
    // This is depth first search traversal
    private void DFS( int vertex , boolean visited[] ) {
        
        if ( visited[ vertex ] ) return;
        visited[ vertex ] = true;
        System.out.println( "Visited : " + vertex );
        
        Iterator< Integer > itr = adj[ vertex ].listIterator();
        
        while ( itr.hasNext() ) {
            DFS( itr.next() , visited );
        }
        
    }
    
    public static void main( String[] args ) {
        
        int numberOfVertices = 4;
        Solution graph = new Solution( numberOfVertices );
        
        graph.addEdge( 0 , 1 );
        graph.addEdge( 0 , 2 );
        graph.addEdge( 1 , 2 );
        graph.addEdge( 2 , 0 );
        graph.addEdge( 2 , 3 );
        graph.addEdge( 3 , 3 );
        
        System.out.println( " DFS traversal of the graph (starting vertex 2) : " );
        
        graph.dfsTraversal( 2 );
        
    }
    
}
