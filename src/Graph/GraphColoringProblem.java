package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GraphColoringProblem {
    // 1. m coloring problem
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        boolean[] vis = new boolean[n];
        int[] color = new int[n];
        int maxColor = 1;
        Arrays.fill(color, 1);

        for (int v = 0; v < n; v++) {
            if (vis[v]) {
                continue;
            }

            Queue<Integer> q = new LinkedList<>();
            q.add(v);
            while (!q.isEmpty()) {
                int rm = q.remove();

                // for self loop
                if (graph[rm][rm]) {
                    return false;
                }

                if (vis[rm]) {
                    continue;
                }
                vis[rm] = true;
                for (int i = 0; i < n; i++) {
                    if (graph[i][rm]) {
                        if (color[rm] == color[i]) {
                            color[i] = color[i] + 1;
                        }
                        maxColor = Math.max(color[i], maxColor);
                        if (maxColor > m) {
                            return false;
                        }
                        if (!vis[i]) {
                            q.add(i);
                        }
                    }
                }
            }
        }
        return true;
    }

    // 2. is bipartite M-1 using bfs
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[V];
        int[] color = new int[V];
        int maxColor = 1;
        for (int v = 0; v < V; v++) {
            if (vis[v]) {
                continue;
            }

            Queue<Integer> q = new LinkedList<>();
            q.add(v);

            while (!q.isEmpty()) {
                int rm = q.remove();

                if (vis[rm]) {
                    continue;
                }
                vis[rm] = true;
                ArrayList<Integer> nbrs = adj.get(rm);

                for (int u : nbrs) {
                    if (color[rm] == color[u]) {
                        color[u] += 1;
                    }

                    maxColor = Math.max(maxColor, color[u]);

                    if (maxColor >= 2) {
                        return false;
                    }

                    if (!vis[u]) {
                        q.add(u);
                    }
                }
            }
        }
        return true;
    }

}
