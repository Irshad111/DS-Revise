package Graph;

import java.util.*;

public class Graph2 {
    int V;
    LinkedList<Integer> adjListArray[];

    Graph2(int v) {
        this.V = v;
        adjListArray = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjListArray[i] = new LinkedList<>();
        }

    }

    public void addEdge(int src, int dest) {
        // add edge src to destination
        adjListArray[src].add(dest);
        // add edge dest to src
        adjListArray[dest].add(src);

    }

    public void display() {
        System.out.println("-----------------");
        for (int i = 0; i < V; i++) {
            System.out.print("Adjacency of vertex " + i + " is ");
            for (Integer nbr : adjListArray[i]) {
                System.out.print("->" + nbr);
            }
            System.out.println();
        }
        System.out.println("------------------");
    }

    /* Complete the function below */
    /*
     * ArrayList<ArrayList<>Integer>list: to represent graph containing 'N' vertices
     * and edges between them N: represent number of vertices
     */


    // 1.floydwarshall
    public static int[][] floydWarshall(int[][] mat, int n) {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
                }
            }
        }
        return mat;
    }

    // 2. find path exist or not

    public static boolean pathExit(int[][] mat, int n, int sr, int sc, boolean visited[][]) {
        if (sr >= n || sc >= n || sc < 0 || sr < 0 || visited[sr][sc] || mat[sr][sc] == 0) {
            return false;

        }
        if (mat[sr][sc] == 2) {
            return true;
        }
        visited[sr][sc] = true;
        if (pathExit(mat, n, sr, sc + 1, visited) || pathExit(mat, n, sr + 1, sc, visited)
                || pathExit(mat, n, sr, sc - 1, visited) || pathExit(mat, n, sr - 1, sc, visited)) {
            return true;
        }
        return false;

    }

    // 3. rotten oranges

    public static int rottenOranges(int mat[][], int r, int c) {
        Queue<Pair> q = new LinkedList<>();
        int ans = 0;
        // put all cell with rotten oranges first
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (mat[i][j] == 2) {
                    Pair np = new Pair(i, j);
                    q.add(np);
                }
            }
        }
        // add delim
        q.add(new Pair(-1, -1));
        while (!q.isEmpty()) {
            boolean flag = false; // for find first fresh orange

            // remove all rotten oranges from q and add nbr
            while (!isDelim(q.peek())) {
                Pair rm = q.remove();
                // for left nbr
                if (isValid(rm.x - 1, rm.y, r, c) && mat[rm.x - 1][rm.y] == 1) {

                    // is first orange to get rotten
                    if (!flag) {
                        flag = true;
                        ans++;
                    }
                    // current cell to rotten
                    mat[rm.x - 1][rm.y] = 2;
                    // put in q
                    q.add(new Pair(rm.x - 1, rm.y));

                }

                // for right
                if (isValid(rm.x + 1, rm.y, r, c) && mat[rm.x + 1][rm.y] == 1) {

                    // is first orange to get rotten
                    if (!flag) {
                        flag = true;
                        ans++;
                    }
                    // current cell to rotten
                    mat[rm.x + 1][rm.y] = 2;
                    // put in q
                    q.add(new Pair(rm.x + 1, rm.y));

                }
                // for top
                if (isValid(rm.x, rm.y + 1, r, c) && mat[rm.x][rm.y + 1] == 1) {

                    // is first orange to get rotten
                    if (!flag) {
                        flag = true;
                        ans++;
                    }
                    // current cell to rotten
                    mat[rm.x][rm.y + 1] = 2;
                    // put in q
                    q.add(new Pair(rm.x, rm.y + 1));

                }
                // for buttom
                if (isValid(rm.x, rm.y - 1, r, c) && mat[rm.x][rm.y - 1] == 1) {

                    // is first orange to get rotten
                    if (!flag) {
                        flag = true;
                        ans++;
                    }
                    // current cell to rotten
                    mat[rm.x][rm.y - 1] = 2;
                    // put in q
                    q.add(new Pair(rm.x, rm.y - 1));

                }
            }
            // remove from front delimeter
            q.remove();
            // add in front if q not empty
            if (!q.isEmpty()) {
                q.add(new Pair(-1, -1));
            }

        }

        // for check all orange
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (mat[i][j] == 1) {// if all oranges not become rotten
                    ans = -1;
                    return ans;
                }
            }
        }
        return ans;

    }

    public static boolean isValid(int x, int y, int r, int c) {
        return (x >= 0 && y >= 0 && x < r && y < c);
    }

    public static boolean isDelim(Pair p) {
        return (p.x == -1 && p.y == -1);
    }

    // 4. min Cost path
    public static int minCostPath(int mat[][], int n) {
        int strg[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                strg[i][j] = Integer.MAX_VALUE;
            }
        }
        Queue<Pair1> q = new LinkedList<>();
        strg[0][0] = mat[0][0];
        q.add(new Pair1(0, 0));
        while (!q.isEmpty()) {
            Pair1 rm = q.remove();
            // add all nbrs if path cost is min
            // left
            if (isValid(rm.x - 1, rm.y, n)) {
                int dist = strg[rm.x][rm.y] + mat[rm.x - 1][rm.y];
                if (dist < strg[rm.x - 1][rm.y]) {
                    strg[rm.x - 1][rm.y] = dist;
                    q.add(new Pair1(rm.x - 1, rm.y));
                }
            }
            // right
            if (isValid(rm.x + 1, rm.y, n)) {
                int dist = strg[rm.x][rm.y] + mat[rm.x + 1][rm.y];
                if (dist < strg[rm.x + 1][rm.y]) {
                    strg[rm.x + 1][rm.y] = dist;
                    q.add(new Pair1(rm.x + 1, rm.y));
                }
            }
            // top
            if (isValid(rm.x, rm.y + 1, n)) {
                int dist = strg[rm.x][rm.y] + mat[rm.x][rm.y + 1];
                if (dist < strg[rm.x][rm.y + 1]) {
                    strg[rm.x][rm.y + 1] = dist;
                    q.add(new Pair1(rm.x, rm.y + 1));
                }
            }
            // buttom
            if (isValid(rm.x, rm.y - 1, n)) {
                int dist = strg[rm.x][rm.y] + mat[rm.x][rm.y - 1];
                if (dist < strg[rm.x][rm.y - 1]) {
                    strg[rm.x][rm.y - 1] = dist;
                    q.add(new Pair1(rm.x, rm.y - 1));
                }
            }
        }
        return strg[n - 1][n - 1];

    }

    public static boolean isValid(int i, int j, int n) {
        return (i >= 0 && j >= 0 && i < n && j < n);
    }

    // 5. find shorted path from 0,0 to destination
    public static int shortedPath(int mat[][], int n, int m, int dr, int dc) {
        if (mat[0][0] != 1 || mat[dr][dc] != 1) {
            return -1;
        }
        boolean visited[][] = new boolean[n][m];
        visited[0][0] = true;
        Queue<Pair2> q = new LinkedList<>();
        q.add(new Pair2(0, 0, 0));
        while (!q.isEmpty()) {
            Pair2 rm = q.remove();
            // dest find
            if (rm.x == dr && rm.y == dc) {
                return rm.dist;
            }
            // add all nbrs if path cost is min
            // left

            if (isValid(rm.x - 1, rm.y, n, m) && mat[rm.x - 1][rm.y] == 1 && !visited[rm.x - 1][rm.y]) {
                visited[rm.x - 1][rm.y] = true;
                q.add(new Pair2(rm.x - 1, rm.y, rm.dist + 1));

            }
            // right
            if (isValid(rm.x + 1, rm.y, n, m) && mat[rm.x + 1][rm.y] == 1 && !visited[rm.x + 1][rm.y]) {
                visited[rm.x + 1][rm.y] = true;
                q.add(new Pair2(rm.x + 1, rm.y, rm.dist + 1));

            }
            // top
            if (isValid(rm.x, rm.y + 1, n, m) && mat[rm.x][rm.y + 1] == 1 && !visited[rm.x][rm.y + 1]) {
                visited[rm.x][rm.y + 1] = true;
                q.add(new Pair2(rm.x, rm.y + 1, rm.dist + 1));

            }
            // buttom
            if (isValid(rm.x, rm.y - 1, n, m) && mat[rm.x][rm.y - 1] == 1 && !visited[rm.x][rm.y - 1]) {
                visited[rm.x][rm.y - 1] = true;
                q.add(new Pair2(rm.x, rm.y - 1, rm.dist + 1));

            }
        }
        // not found path
        return -1;

    }


    // 6. find no of islands

    static int findIslands(ArrayList<ArrayList<Integer>> list, int N, int M) {

        // Your code here
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (list.get(i).get(j) == 1) {
                    count += 1;
                    dfs(list, i, j);
                }
            }
        }
        return count;

    }

    public static void dfs(ArrayList<ArrayList<Integer>> list, int i, int j) {
        if (i < 0 || i >= list.size() || j < 0 || j >= list.get(0).size() || list.get(i).get(j) == 0) {
            return;
        }
        list.get(i).set(j, 0);
        dfs(list, i, j + 1);// left
        dfs(list, i + 1, j);// down
        dfs(list, i - 1, j);// up
        dfs(list, i, j - 1);// right
        dfs(list, i - 1, j - 1);// left up dig
        dfs(list, i + 1, j - 1);// left down dig
        dfs(list, i - 1, j + 1);// right up dig
        dfs(list, i + 1, j + 1);// right down dig
    }

    // 7. find maximum of unit area

    static int count1;

    static int findAreaUtil(int N, int M, int g[][], boolean vis[][]) {
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (g[i][j] == 1 && !vis[i][j]) {
                    count1 = 0;
                    dfs(g, vis, i, j);
                    if (count1 > max) {
                        max = count1;
                    }
                } else if (g[i][j] == 0) {
                    vis[i][j] = true;
                }
            }
        }
        return max;

    }

    public static void dfs(int g[][], boolean vis[][], int i, int j) {
        if (i < 0 || i >= g.length || j < 0 || j >= g[0].length || vis[i][j] == true || g[i][j] == 0) {
            return;
        }
        vis[i][j] = true;
        count1++;
        dfs(g, vis, i, j + 1);// left
        dfs(g, vis, i + 1, j);// down
        dfs(g, vis, i - 1, j);// up
        dfs(g, vis, i, j - 1);// right
        dfs(g, vis, i - 1, j - 1);// left up dig
        dfs(g, vis, i + 1, j - 1);// left down dig
        dfs(g, vis, i - 1, j + 1);// right up dig
        dfs(g, vis, i + 1, j + 1);// right down dig
    }


    //8. no of palindromic path in matrix
    static int res = 0;

    public static void makeString(char[][] mat, int cr, int cc, int er, int ec, String ans) {
        if (cr == er && cc == ec) {
            ans += mat[cr][cc];
            if (ispalindrome(ans)) {
                res++;
            }
            return;
        }
        if (cr > er || cc > ec) {
            return;
        }
        makeString(mat, cr, cc + 1, er, ec, ans + mat[cr][cc]);
        makeString(mat, cr + 1, cc, er, ec, ans + mat[cr][cc]);

    }

    public static boolean ispalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // 9. travelling salesman problem
    public static void main(String[] args) {


        //code
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            int[][] graph = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    graph[i][j] = sc.nextInt();
                }
            }

            boolean vis[] = new boolean[n];

            // add 0
            vis[0] = true;
            int ans = Integer.MAX_VALUE;
            ans = tsp(graph, vis, 0, n, 1, 0, ans);
            System.out.println(ans);

        }
    }

    public static int tsp(int[][] graph, boolean[] vis, int pos, int V, int count, int cost, int ans) {
        if (count == V && graph[pos][0] > 0) {
            ans = Math.min(ans, cost + graph[pos][0]);
            return ans;
        }
        for (int v = 0; v < V; v++) {
            if (!vis[v] && graph[pos][v] > 0) {
                vis[v] = true;
                ans = tsp(graph, vis, v, V, count + 1, cost + graph[pos][v], ans);
                vis[v] = false;
            }
        }
        return ans;
    }



}


//	public static boolean isValid(int i, int j, int n,int m) {
//		return (i >= 0 && j >= 0 && i < n && j < m);
//	}


class Pair2 {
    int x;
    int y;
    int dist;// current distance from source

    Pair2(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}


class Pair1 {
    int x;
    int y;

    Pair1(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
