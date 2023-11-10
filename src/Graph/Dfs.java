package Graph;

import java.util.ArrayList;

public class Dfs {
    // 2. dfs of graph
    static void dfs(int V, ArrayList<ArrayList<Integer>> list){
        boolean [] vis=new boolean[V];
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                dfs(i,list,vis);
            }
        }
    }
    static void dfs(int src, ArrayList<ArrayList<Integer>> list, boolean vis[]) {
        // add your code here
        vis[src] = true;
        System.out.print(src + " ");
        for (Integer child : list.get(src)) {
            if (!vis[child]) {
                dfs(child, list, vis);
            }
        }
    }
}
