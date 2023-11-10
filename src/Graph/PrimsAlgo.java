package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgo {
    int spanningTree(int V, int E, int edges[][]){
        
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<Pair>());
        }
        for(int i=0;i<edges.length;i++)
        {
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];
            adj.get(u).add(new Pair(v,wt));
            adj.get(v).add(new Pair(u,wt));
        }
        // Code Here.
        boolean [] vis=new boolean[V];
        PriorityQueue<Pair> meanHeap=new PriorityQueue<>((x, y)->x.wt-y.wt);

        meanHeap.add(new Pair(0,0));
        int ans=0;

        while(!meanHeap.isEmpty()){
            Pair cur=meanHeap.remove();
            int u=cur.v;
            if(vis[u]){
                continue;
            }

            ans+=cur.wt;
            vis[u]=true;
            for(Pair nbr:adj.get(u)){
                if(!vis[nbr.v]){
                    meanHeap.add(new Pair(nbr.v,nbr.wt));
                }
            }
        }
        return ans;

    }
    int spanningTree(int V,ArrayList<ArrayList<ArrayList<Integer>>> adj ){
        // Code Here.
        boolean [] vis=new boolean[V];
        PriorityQueue<Pair> meanHeap=new PriorityQueue<>((x, y)->x.wt-y.wt);

        meanHeap.add(new Pair(0,0));
        int ans=0;

        while(!meanHeap.isEmpty()){
            Pair cur=meanHeap.remove();
            int u=cur.v;
            if(vis[u]){
                continue;
            }

            ans+=cur.wt;
            vis[u]=true;
            ArrayList<ArrayList<Integer>> nbrs=adj.get(u);
            for(ArrayList<Integer> list: nbrs){
                int vertex=list.get(0);
                int wt=list.get(1);
                if(!vis[vertex]){
                    meanHeap.add(new Pair(vertex,wt));
                }
            }
        }
        return ans;

    }

    class Pair{
        int wt;
        int v;

        Pair(int v, int wt){
            this.v=v;
            this.wt=wt;
        }


    }
    class Pair1 implements Comparable<Pair1>{
        int wt;
        int v;

        Pair1(int v, int wt){
            this.v=v;
            this.wt=wt;
        }
        public int compareTo(Pair1 other){
            return this.wt- other.wt;
        }


    }

}



