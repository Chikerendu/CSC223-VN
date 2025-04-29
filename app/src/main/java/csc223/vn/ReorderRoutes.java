package csc223.vn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReorderRoutes {
    public int minReorder(int n, int[][] connections) {
        // Step 1: Create a graph to store neighbors (undirected) and track original directions
        Map<Integer, List<int[]>> graph = new HashMap<>();

        // Initialize the graph
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        // Build the graph
        for (int[] conn : connections) {
            int from = conn[0];
            int to = conn[1];

            // from -> to (direction = 1, original direction)
            graph.get(from).add(new int[]{to, 1});

            // to -> from (direction = 0, reverse direction)
            graph.get(to).add(new int[]{from, 0});
        }

        // Step 2: DFS to traverse from city 0
        boolean[] visited = new boolean[n];
        return dfs(0, graph, visited);
    }

    // DFS helper method
    private int dfs(int city, Map<Integer, List<int[]>> graph, boolean[] visited) {
        visited[city] = true;
        int count = 0;

        // Explore all neighbors
        for (int[] neighbor : graph.get(city)) {
            int nextCity = neighbor[0];
            int direction = neighbor[1];

            // If not visited, explore
            if (!visited[nextCity]) {
                // If direction is 1, we need to reverse this road
                count += direction;
                count += dfs(nextCity, graph, visited);
            }
        }

        return count;
    }

    // Main method to test our code
    public static void main(String[] args) {
        ReorderRoutes rr = new ReorderRoutes();

        int n1 = 6;
        int[][] connections1 = {{0,1},{1,3},{2,3},{4,0},{4,5}};
        System.out.println(rr.minReorder(n1, connections1)); // Output: 3

        int n2 = 5;
        int[][] connections2 = {{1,0},{1,2},{3,2},{3,4}};
        System.out.println(rr.minReorder(n2, connections2)); // Output: 2

        int n3 = 3;
        int[][] connections3 = {{1,0},{2,0}};
        System.out.println(rr.minReorder(n3, connections3)); // Output: 0
    }
}

