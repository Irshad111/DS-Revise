package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {
     int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        boolean[] vis = new boolean[V];
        int[] dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[S]=0;

        PriorityQueue<Pair> meanHeap=new PriorityQueue<>((x, y)-> x.wt - y.wt);
        meanHeap.add(new Pair(S,0));

        while(!meanHeap.isEmpty()){

            Pair curr=meanHeap.remove();
            int u=curr.v;
            if(vis[u]){
                continue;
            }
            vis[u]=true;
            ArrayList<ArrayList<Integer>> nbrs=adj.get(u);
            for(ArrayList<Integer> list : nbrs){
                int vertex=list.get(0);
                int wt=list.get(1);
                if(!vis[vertex] && dist[vertex] > dist[u] + wt){
                    dist[vertex] = dist[u] + wt;
                    meanHeap.add(new Pair(vertex, dist[vertex]));
                }
            }
        }
        return dist;
    }
    class Pair{
        int v;
        int wt;
        Pair(int v, int wt){
            this.v=v;
            this.wt=wt;
        }
    }

}




