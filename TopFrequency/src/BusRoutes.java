import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/**
 * 18th - Leetcode 815 - Bus Routes
 */
public class BusRoutes {
    /**
     * Solution: Breadth First Search
     * TC: O(n)
     * SC: O(n)
     */
    public int numBusesToDestination(int[][] routes, int source, int target) {
        /**
         * Array of List to store the connection of bus stations
         */
        ArrayList<Integer>[] graph = new ArrayList[1000000];
        /**
         * Edges in the graph means two bus stations are connected - value = route index
         */
        for (int i = 0; i < routes.length; i++){
            int[] arr = routes[i];
            for (int e : arr){
                if (graph[e] == null) graph[e] = new ArrayList<>();
                graph[e].add(i);
            }
        }
        boolean[] visited = new boolean[1000000];
        boolean[] taken = new boolean[routes.length];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{source, 0});
        while (!queue.isEmpty()){
            int[] e = queue.remove();
            int s = e[0];
            int lev = e[1];
            if (s == target) return lev;
            visited[s] = true;
            for (int bus : graph[s]){
                if (taken[bus]) continue;
                for (int x : routes[bus]){
                    if (!visited[x]){
                        queue.add(new int[]{x, lev + 1});
                    }
                }
                taken[bus] = true;
            }
        }
        return -1;
    }
}