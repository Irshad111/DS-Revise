package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bfs {
    // 1. bfs

    static void bfs(int s, ArrayList<ArrayList<Integer>> list, boolean vis[], int nov) {
        // add your code here

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < nov; i++) {
            if (vis[i]) {
                continue;
            }
            q.add(s);
            while (!q.isEmpty()) {
                int rm = q.remove();
                if (vis[rm]) {
                    continue;
                }
                vis[rm] = true;
                System.out.print(rm + " ");
                ArrayList<Integer> children = list.get(rm);
                for (Integer child : children) {
                    if (!vis[child]) {
                        q.add(child);
                    }
                }
            }
        }

    }

}
