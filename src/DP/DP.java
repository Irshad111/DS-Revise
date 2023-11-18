package DP;

import java.util.Arrays;

public class DP {


    //a. based on fib
    // using top -down
    //1.
    public static int fiboncciTD(int n, int[] strg) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (strg[n] != 0) {
            return strg[n];
        }
        int fn1 = fiboncciTD(n - 1, strg);
        int fn2 = fiboncciTD(n - 2, strg);
        int fn = fn1 + fn2;
        strg[n] = fn;
        return fn;
    }

    // bottum-up
    public static int fiboncciBU(int n) {
        int[] strg = new int[n + 1];
        strg[0] = 0;
        strg[1] = 1;
        for (int i = 2; i <= n; i++) {
            strg[i] = strg[i - 1] + strg[i - 2];
        }
        return strg[n];
    }

    // bottum-up less space
    public static int fiboncciBUSE(int n) {
        int[] strg = new int[2];
        strg[0] = 0;
        strg[1] = 1;
        for (int i = 2; i <= n; i++) {
            int sum = strg[0] + strg[1];
            strg[0] = strg[1];
            strg[1] = sum;
        }
        return strg[1];
    }

    // a.1 how many ways are possible to reach to end by throwing the dice
    public static int BoardPathTD(int curr, int end, int[] strg) {
        if (curr == end) {
            return 1;
        }
        if (curr > end) {
            return 0;
        }
        if (strg[curr] != 0) {// reuse
            return strg[curr];
        }
        int count = 0;
        for (int dice = 1; dice <= 6; dice++) {
            count += BoardPathTD(curr + dice, end, strg);
        }
        strg[curr] = count;// store

        return count;

    }

    public static int BoardPathBU(int n) {
        int[] strg = new int[n + 6];
        strg[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            strg[i] = strg[i + 1] + strg[i + 2] + strg[i + 3] + strg[i + 4] + strg[i + 5] + strg[i + 6];

        }

        return strg[0];

    }

    public static int BoardPathBUSE(int n) {
        int[] strg = new int[6];
        strg[0] = 1;
        for (int slide = n - 1; slide >= 0; slide--) {
            int sum = strg[0] + strg[1] + strg[2] + strg[3] + strg[4] + strg[5];
            strg[5] = strg[4];
            strg[4] = strg[3];
            strg[3] = strg[2];
            strg[2] = strg[1];
            strg[1] = strg[0];
            strg[0] = sum;

        }
        return strg[0];
    }

    // b maze path :- hom many diffrent no of ways are there to reach from (0,0) to (er,ec)
    public static int mazePathTD(int cr, int cc, int er, int ec, int[][] strg) {
        if (cc == ec && cr == er) {
            return 1;
        }
        if (cc > ec || cr > er) {
            return 0;
        }
        if (strg[cr][cc] != 0) {
            return strg[cr][cc];
        }
        int h = mazePathTD(cr, cc + 1, er, ec, strg);
        int v = mazePathTD(cr + 1, cc, er, ec, strg);
        strg[cr][cc] = h + v;
        return h + v;

    }
    public static int mazePathBU(int m, int n) {
        int strg[][] = new int[m][n];
        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){
                if(row==0 || col==0){
                    strg[row][col] = 1;
                }else{
                    strg[row][col] = strg[row-1][col] + strg[row][col-1];
                }
            }
        }
        return strg[m-1][n-1];
    }

    public static int mazePathBUSE(int m, int n) {
        int strg[] = new int[n];
        Arrays.fill(strg, 1);
        for(int row = 1; row < m; row++){
            for(int col = 0; col < n; col++){
                if(col == 0){
                    strg[col] = 1;
                }else{
                    strg[col] = strg[col-1] + strg[col];
                }
            }
        }
        return strg[n-1];
    }
    // b. 1 can take move in forward digonal
    public static int mazePathDigBUSE(int m, int n) {
        int strg[] = new int[n];
        Arrays.fill(strg, 1);
        int dig=0;
        for(int row = 1; row < m; row++){
            for(int col = 0; col < n; col++){
                if(col == 0){
                    strg[col]=1;
                    dig = 1;
                }else{
                    int sum = strg[col-1] + strg[col] + dig;
                    dig = strg[col];
                    strg[col] = sum;
                }
            }
        }
        return strg[n-1];
    }
}

