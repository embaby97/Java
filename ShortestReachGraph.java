import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static class Graph {
        
        List<List<Integer>> adjList; 
        int size;
        public Graph(int size) {
            adjList = new ArrayList<>();
            this.size = size;
            while(size-- > 0)//Initialize the adjancency list.
                adjList.add(new ArrayList<Integer>());
        }

        public void addEdge(int first, int second) {
            adjList.get(first).add(second);
            adjList.get(second).add(first); 
        }
        
        public int[] shortestReach(int startId) { // 0 indexed
            int[] distances = new int[size];
            Arrays.fill(distances, -1); // O(n) space.
            Queue<Integer> que = new LinkedList<>();
            
            que.add(startId); // Initialize queue.
            distances[startId] = 0;
            HashSet<Integer> seen = new HashSet<>(); //O(n) space. Could be further optimized. I leave it to you to optimize it. 
            seen.add(startId);
            while(!que.isEmpty()) { // Standard BFS loop.
                Integer curr = que.poll();
                for(int node : adjList.get(curr)) {
                    if(!seen.contains(node)) {
                        que.offer(node);
            // Right place to add the visited set.
                        seen.add(node); 
            // keep on increasing distance level by level.
                        distances[node] = distances[curr] + 6; 
                    }
                }
            }   
            return distances;
        }
        
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      
        int queries = scanner.nextInt();
        
        for (int t = 0; t < queries; t++) {
            
            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();
            
            // read and set edges
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
                
                // add each edge to the graph
                graph.addEdge(u, v);
            }
            
            // Find shortest reach from node s
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);
 
            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();            
        }
        
        scanner.close();
    }
}
