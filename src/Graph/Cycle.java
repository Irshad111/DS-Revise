package Graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class Cycle {

    // 4. cycle in undirected graph
    //Using dfs
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean [] vis=new boolean[V];
        for(int v = 0;v < V; v++){
            if(!vis[v]){
                if(dfs(v, adj, vis, -1)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean [] vis, int parent){
        vis[v]=true;

        for(Integer child : adj.get(v)){
            if(!vis[child]){
                if(dfs(child, adj, vis, v)){
                    return true;
                }
            }else if(parent!= child){
                return true;
            }
        }
        return false;
    }
    //Using bfs
    static boolean isCyclic(ArrayList<ArrayList<Integer>> list, int V) {
        // add your code here

        boolean vis[] = new boolean[V];
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (vis[i]) {
                continue;
            }
            q.addLast(i);
            while (!q.isEmpty()) {
                int rm = q.removeFirst();
                if (vis[rm]) {
                    return true;
                }
                vis[rm] = true;
                ArrayList<Integer> children = list.get(rm);
                for (Integer child : children) {
                    //self loop
                    if (child == rm) {
                        return true;
                    }
                    if (!vis[child]) {
                        q.addLast(child);
                    }

                }
            }
        }
        return false;

    }

    // 5. cycle in directed graph

    static boolean Cyclic(ArrayList<ArrayList<Integer>> list, int V) {
        // add your code here
        boolean visited[] = new boolean[V];
        boolean recstack[] = new boolean[V];
        for(int v = 0;v < V; v++){
            if(!visited[v]){
                if(dfs(list, v, visited, recstack)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(ArrayList<ArrayList<Integer>> list, int v, boolean[] vis, boolean[] recstack) {
        // add in visited list
        vis[v] = true;
        // add inn stack
        recstack[v] = true;
        ArrayList<Integer> children = list.get(v);
        for (Integer child : children) {
            if(!vis[child]){
                if(dfs(list, child, vis, recstack)){
                    return true;
                }
            }else if(recstack[child]){
                return true;
            }
        }
        // after visited make false
        recstack[v] = false;

        return false;
    }

}
