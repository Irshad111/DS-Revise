package Graph;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {

    // 3. topological sort
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
