package Graph;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {

    // 3. topological sort
    // Topological sort is a technique used in graph theory to order the vertices of a directed acyclic graph (DAG).
    // It ensures that for every directed edge from vertex A to vertex B, vertex A comes before vertex B in the ordering.
    // This is useful in scheduling problems, where tasks depend on the completion of other tasks.
    static int[] topoSort(ArrayList<ArrayList<Integer>> list, int N) {
        // add your code here
        Stack<Integer> stack = new Stack();
        boolean[] visited = new boolean[N];
        for (int v = 0; v < N; v++) {
            if (!visited[v]) {
                dfs(list, v, visited, stack);
            }

        }
        int output[] = new int[N];
        int i = 0;
        for (Integer a : stack) {
            output[i++] = a;
        }
        return output;

    }

    static void dfs(ArrayList<ArrayList<Integer>> list, int n, boolean[] visited, Stack<Integer> stack) {
        visited[n] = true;
        ArrayList<Integer> children = list.get(n);
        for (Integer child : children) {
            if (!visited[child]) {
                dfs(list, child, visited, stack);

            }
        }
        stack.push(n);
    }

}
