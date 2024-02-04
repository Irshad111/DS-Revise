package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DynamicProgramming {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 35;
		String S= "T|F^F&T|F^F^F^T|T&T^T|F^T^F&F^T|T^F";
//		int W = 4;
//		int values[] = { 1, 2, 3 };
//		int weight[] = { 4, 5, 1 };
//		System.out.println(knapSackRec(W, weight, values, N));
//		System.out.println(knapSackTD(W, weight, values, N, new int[N + 1][W + 1]));
//
//		System.out.println(knapSack(W, weight, values, N));
	System.out.println(printlcs("ecfbefdcfca", "badfcbebbf", 11, 10));
//		System.out.println(lpsubstring("aaaabbaa",8));
//		System.out.println(printSCSS("hello","geek",5,4));
		System.out.println("helllo");
		int arr[]={1,2,3,4,5};
		// add 1 in at 0 and n th index
		System.out.println(burstingballoon(arr));
		System.out.println();


	}

	// a. knapsack problem
	public static int knapSackRec(int W, int wt[], int val[], int n) {
		if (n == 0 || W == 0)
			return 0;

		if (wt[n - 1] <= W)
			return Math.max(val[n - 1] + knapSackRec(W - wt[n - 1], wt, val, n - 1), knapSackRec(W, wt, val, n - 1));
		else //else if( wt[n - 1] > W)
			return knapSackRec(W, wt, val, n - 1);
	}

	public static int knapSackTD(int W, int wt[], int val[], int n, int strg[][]) {
		if (n == 0 || W == 0)
			return 0;
		if (strg[n][W] != 0)
			return strg[n][W];
		if (wt[n - 1] <= W)
			strg[n][W] = Math.max(val[n - 1] + knapSackTD(W - wt[n - 1], wt, val, n - 1, strg),
					knapSackTD(W, wt, val, n - 1, strg));
		else if( wt[n - 1] > W)
			strg[n][W] = knapSackTD(W, wt, val, n - 1, strg);

		return strg[n][W];
	}

	public static int knapSack(int W, int wt[], int val[], int n) {

		int[][] strg = new int[n + 1][W + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= W; j++) {
				if (i == 0 || j == 0) {
					strg[i][j] = 0;
					continue;
				}
				if (wt[i - 1] <= j) {
					strg[i][j] = Math.max(val[i - 1] + strg[i - 1][j - wt[i - 1]], strg[i - 1][j]);
				} else if (wt[i - 1] > j){
					strg[i][j] = strg[i - 1][j];

				}
			}
		}
		return strg[n][W];
	}

	// a.1 subset sum problem
	public static boolean isSubsetSum(int n, int arr[], int sum) {
		boolean[][] strg = new boolean[n + 1][sum + 1];
		for (int i = 0; i <= n; i++) {
			strg[i][0] = true;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				if (arr[i - 1] <= j) {
					strg[i][j] = strg[i - 1][j - arr[i - 1]] || strg[i - 1][j];
				} else if(arr[i - 1] > j){
					strg[i][j] = strg[i - 1][j];

				}
			}
		}
		return strg[n][sum];

	}

	// a.2. equal sum partition sum
	public static boolean equalPartition(int N, int arr[]) {
		int sum = 0;
		for (int i = 0; i < N; i++)
			sum += arr[i];

		if (sum % 2 != 0)
			return false;
		else
			return isSubsetSum(N, arr, sum / 2);
	}

	// a.3 count of subsets sum with given sum
	public static int countSubsetSum(int n, int arr[], int sum) {
		int[][] strg = new int[n + 1][sum + 1];
		for (int i = 0; i <= n; i++) {
			strg[i][0] = 1;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				if (arr[i - 1] <= j) {
					strg[i][j] = strg[i - 1][j - arr[i - 1]] + strg[i - 1][j];
				} else {
					strg[i][j] = strg[i - 1][j];

				}
			}
		}
		return strg[n][sum];

	}
	// a.4 minimum subset sum

	public static int minDifference(int arr[], int n) {
		int sum = 0;
		for (int i = 0; i < n; i++)
			sum += arr[i];

		boolean[][] strg = new boolean[n + 1][sum + 1];
		for (int i = 0; i <= n; i++) {
			strg[i][0] = true;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				if (arr[i - 1] <= j) {
					strg[i][j] = strg[i - 1][j - arr[i - 1]] || strg[i - 1][j];
				} else {
					strg[i][j] = strg[i - 1][j];

				}
			}
		}

		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i <= sum / 2; i++) {
			if (strg[n][i])
				list.add(i);
		}
		int min = Integer.MAX_VALUE;
		for (int i : list) {
			min = Math.min(min, sum - 2 * i);
		}
		return min;

	}

	// a.5 count the no of subset with a given difference
	public static int count(int arr[], int diff, int n) {
		int sum = 0;
		for (int i = 0; i < n; i++)
			sum += arr[i];
		int sum1 = (diff + sum) / 2;
		return countSubsetSum(n, arr, sum1);
	}

	// a.6 given target sum and arr how many types u can asign +/- sign
	public static int targetSum(int[] arr, int sum, int n) {
		return count(arr, sum, n);
	}

	// b unbounded knapsack
	public static int unboundedKnapSack(int W, int wt[], int val[], int n) {

		int[][] strg = new int[n + 1][W + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= W; j++) {
				if (i == 0 || j == 0) {
					strg[i][j] = 0;
					continue;
				}
				if (wt[i - 1] <= j) {
					strg[i][j] = Math.max(val[i - 1] + strg[i][j - wt[i - 1]], strg[i - 1][j]);
				} else if (wt[i - 1] > j){
					strg[i][j] = strg[i - 1][j];

				}
			}
		}
		return strg[n][W];
	}

	// b.1 rod cutting
	public static int cutRod(int price[], int length[], int n) {
		int[][] strg = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					strg[i][j] = 0;
					continue;
				}
				if (length[i - 1] <= j) {
					strg[i][j] = Math.max(price[i - 1] + strg[i][j - length[i - 1]], strg[i - 1][j]);
				} else if(length[i - 1] > j) {
					strg[i][j] = strg[i - 1][j];

				}
			}
		}
		return strg[n][n];

	}

	// b.2 coin change - maximum no of way given sum?
	public static int coinChangeWay(int sum, int price[], int n) {

		int[][] strg = new int[n + 1][sum + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= sum; j++) {
				if (i == 0 || j == 0) {
					if (i == 0)
						strg[i][j] = 0;
					if (j == 0)
						strg[i][j] = 1;

					continue;
				}
				if (price[i - 1] <= j) {
					strg[i][j] = strg[i][j - price[i - 1]] + strg[i - 1][j];
				} else if(price[i - 1] > j) {
					strg[i][j] = strg[i - 1][j];

				}
			}
		}
		return strg[n][sum];
	}

	// b.3 coin change - minimum no of coin
	public static int minCoin(int sum, int price[], int n) {

		int[][] strg = new int[n + 1][sum + 1];
		// initialization
		for (int j = 0; j <= sum; j++) {
			strg[0][j] = Integer.MAX_VALUE - 1;
		}
		for (int i = 0; i <= n; i++) {
			strg[i][0] = 0;
		}
		for (int j = 1; j <= sum; j++) {
			if (j % price[0] == 0)
				strg[1][j] = j / price[0];
			else
				strg[1][j] = Integer.MAX_VALUE - 1;

		}

		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				if (price[i - 1] <= j) {
					strg[i][j] = Math.min(1 + strg[i][j - price[i - 1]], strg[i - 1][j]);
				} else if(price[i -1] > j) {
					strg[i][j] = strg[i - 1][j];

				}
			}
		}
		return strg[n][sum];
	}

	// c lcs
	public static int lcsRec(String s1, String s2, int l1, int l2) {
		if (l1 == 0 || l2 == 0)
			return 0;
		if (s1.charAt(l1 - 1) == s2.charAt(l2 - 1))
			return 1 + lcsRec(s1, s2, l1 - 1, l2 - 1);
		else
			return Math.max(lcsRec(s1, s2, l1 - 1, l2), lcsRec(s1, s2, l1, l2 - 1));
	}

	public static int lcsTD(String s1, String s2, int l1, int l2, int[][] strg) {
		if (l1 == 0 || l2 == 0)
			return 0;
		if (strg[l1][l2] != 0)
			return strg[l1][l2];
		if (s1.charAt(l1 - 1) == s2.charAt(l2 - 1))
			return strg[l1][l2] = 1 + lcsRec(s1, s2, l1 - 1, l2 - 1);
		else
			return strg[l1][l2] = Math.max(lcsRec(s1, s2, l1 - 1, l2), lcsRec(s1, s2, l1, l2 - 1));
	}

	public static int lcs(String s1, String s2, int l1, int l2) {
		int strg[][] = new int[l1 + 1][l2 + 1];
		for (int i = 0; i <= l1; i++) {
			for (int j = 0; j <= l2; j++) {
				if (i == 0 || j == 0) {
					strg[i][j] = 0;
					continue;
				}
				if (s1.charAt(i - 1) == s2.charAt(j - 1))
					strg[i][j] = 1 + strg[i - 1][j - 1];
				else
					strg[i][j] = Math.max(strg[i - 1][j], strg[i][j - 1]);

			}
		}
		return strg[l1][l2];

	}

	// c.1 longest common substring
	public static int lcsubstring(String s1, String s2, int l1, int l2) {
		int strg[][] = new int[l1 + 1][l2 + 1];
		int max = 0;
		for (int i = 0; i <= l1; i++) {
			for (int j = 0; j <= l2; j++) {
				if (i == 0 || j == 0) {
					strg[i][j] = 0;
					continue;
				}
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					strg[i][j] = 1 + strg[i - 1][j - 1];
					max = Math.max(max, strg[i][j]);
				} else
					strg[i][j] = 0;

			}
		}
		return max;

	}

	// c.2 print longest common subsequence
	public static String printlcs(String s1, String s2, int l1, int l2) {
		int strg[][] = new int[l1 + 1][l2 + 1];
		for (int i = 0; i <= l1; i++) {
			for (int j = 0; j <= l2; j++) {
				if (i == 0 || j == 0) {
					strg[i][j] = 0;
					continue;
				}
				if (s1.charAt(i - 1) == s2.charAt(j - 1))
					strg[i][j] = 1 + strg[i - 1][j - 1];
				else
					strg[i][j] = Math.max(strg[i - 1][j], strg[i][j - 1]);

			}
		}
		int i = l1, j = l2;
		StringBuilder sb = new StringBuilder();
		while (i > 0 && j > 0) {
			if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
				sb.append(s1.charAt(i - 1));
				i--;
				j--;
			} else if (strg[i - 1][j] > strg[i][j - 1]) {
				i--;
			} else
				j--;
		}
		sb.reverse();
		return sb.toString();
	}
	// c.3 shortest common supper sequence length
	public static int SCSS(String s1, String s2, int l1, int l2) {
		return l1+l2-lcs(s1,s2,l1,l2);
	}
	// c.4 minimum number of insertion and deletionto covert string a to b
	public static int minNum(String s1, String s2, int l1, int l2) {
		return l1+l2-2*lcs(s1,s2,l1,l2);
	}
	// c.5 longest palindromic subsequence in a string
	public static int lps(String s1, int l) {
		StringBuilder sb=new StringBuilder(s1);
		sb.reverse();
		String s2=sb.toString();
		return lcs(s1,s2,l,l);
	}
	
	// c.6 longest palindromic substring in a string

	public static int lpsubstring(String s1, int l) {
		StringBuilder sb=new StringBuilder(s1);
		sb.reverse();
		String s2=sb.toString();
		return lcsubstring(s1,s2,l,l);
	}
	// c.7 minimum number of deletion in a string to make it a palindrome
	public static int minNumDeletion(String str) {
		return str.length()-lps(str,str.length());
	}
	// c.8 print shortest common super sequence
	public static String printSCSS(String s1, String s2, int l1, int l2) {
		

		int strg[][] = new int[l1 + 1][l2 + 1];
		for (int i = 0; i <= l1; i++) {
			for (int j = 0; j <= l2; j++) {
				if (i == 0 || j == 0) {
					strg[i][j] = 0;
					continue;
				}
				if (s1.charAt(i - 1) == s2.charAt(j - 1))
					strg[i][j] = 1 + strg[i - 1][j - 1];
				else
					strg[i][j] = Math.max(strg[i - 1][j], strg[i][j - 1]);

			}
		}
		int i = l1, j = l2;
		StringBuilder sb = new StringBuilder();
		while (i > 0 && j > 0) {
			if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
				sb.append(s1.charAt(i - 1));
				i--;
				j--;
			} else if (strg[i - 1][j] > strg[i][j - 1]) {
				sb.append(s1.charAt(i-1));
				i--;
			} else {
				sb.append(s2.charAt(j-1));
				j--;
			}
		}
		while(i>0) {
			sb.append(s1.charAt(i-1));
			i--;
		}
		while(j>0) {
			sb.append(s2.charAt(j-1));
			j--;
		}

		sb.reverse();
		return sb.toString();
	
	}
	
	// c.9 longest repeating subsequence
	public static int lrs(String str,int l) {
		return lrsHelper(str,str,l,l);
	}
	private static int lrsHelper(String s1, String s2, int l1, int l2) {
		int strg[][] = new int[l1 + 1][l2 + 1];
		for (int i = 0; i <= l1; i++) {
			for (int j = 0; j <= l2; j++) {
				if (i == 0 || j == 0) {
					strg[i][j] = 0;
					continue;
				}
				if (s1.charAt(i - 1) == s2.charAt(j - 1) && i!=j)
					strg[i][j] = 1 + strg[i - 1][j - 1];
				else
					strg[i][j] = Math.max(strg[i - 1][j], strg[i][j - 1]);

			}
		}
		return strg[l1][l2];

	}
	// c.10 Sequence pattern matching
	public static boolean spm(String str,String ptr) {
		int len=lcs(str,ptr,str.length(),ptr.length());
		if(len==ptr.length())
			return true;
		else 
			return false;
	}
	
	// c.11 minimum number of insertion in a string to make it a palindrome
	public static int minNumInsertion(String str) {
		return str.length()-lps(str,str.length());
	}
	
	
	
	// d MCM matrix chain maltplication
	public static int MCM(int arr[],int n) {
		return MCMRec(arr,1,n-1);
	}
	public static int MCMRec(int arr[],int i,int j) {
		if(i>=j) {
			return 0;
		}
		int min=Integer.MAX_VALUE;
		for(int k=i;k<=j-1;k++) {
			int temp=MCMRec(arr,i,k)+MCMRec(arr,k+1,j)+arr[i-1]*arr[k]*arr[j];
			if(temp<min) {
				min=temp;
			}
		}
		return min;
	}
	public static int MCMTD(int arr[],int i,int j,int strg[][]) {
		if(i>=j) {
			return 0;
		}
		if(strg[i][j]!=0)
			return strg[i][j];
		int min=Integer.MAX_VALUE;
		for(int k=i;k<=j-1;k++) {
			int temp=MCMTD(arr,i,k,strg)+MCMTD(arr,k+1,j,strg)+arr[i-1]*arr[k]*arr[j];
			if(temp<min) {
				min=temp;
			}
		}
		return strg[i][j]=min;
	}
	public static int MCMTDOptimization(int arr[],int i,int j,int strg[][]) {
		if(i>=j) {
			return 0;
		}
		if(strg[i][j]!=0)
			return strg[i][j];
		int min=Integer.MAX_VALUE;
		for(int k=i;k<=j-1;k++) {
			int left=0,right=0;
			if(strg[i][k]!=0) {
			left=strg[i][k];	
			}else {
				left=MCMTDOptimization(arr,i,k,strg);
				strg[i][k]=left;
				
			}
			
			if(strg[k+1][j]!=0) {
			right=strg[k+1][j];	
			}else {
				right=MCMTDOptimization(arr,k+1,j,strg);
				strg[k+1][j]=right;
			}

			int temp=left+right+arr[i-1]*arr[k]*arr[j];
			if(temp<min) {
				min=temp;
			}
		}
		return strg[i][j]=min;
	}
	
	// d.1 palindromic partition

	public static int palindromicpartitionTD(String str, int i, int j, int[][] strg) {
		 if(i>=j) {
			 return 0;
		 }
		if (isPalindromic(str, i, j)) {
			return 0;
		}
		if (strg[i][j] != 0) {
			return strg[i][j];
		}
		int min = Integer.MAX_VALUE;

		for (int k = i; k <= j - 1; k++) {
			int temp = palindromicpartitionTD(str, i, k,strg)+ palindromicpartitionTD(str, k + 1, j,strg)+1;
			if (temp < min) {
				min = temp;
			}
		

		}
		return strg[i][j]=min;
	}
	public static int palindromicpartitionTDOpti(String str, int i, int j, int[][] strg) {
		 if(i>=j) {
			 return 0;
		 }
		if (isPalindromic(str, i, j)) {
			return 0;
		}
		if (strg[i][j] != 0) {
			return strg[i][j];
		}
		int min = Integer.MAX_VALUE;

		for (int k = i; k <= j - 1; k++) {
			int left=0,right=0;
			if(strg[i][k]!=0)
				left=strg[i][k];
			else {
				left=palindromicpartitionTDOpti(str, i, k,strg);
				strg[i][k]=left;
			}
				
			if(strg[k+1][j]!=0)
				right=strg[k+1][j];
			else {
				right=palindromicpartitionTDOpti(str, k + 1, j,strg);
				strg[k+1][j]=right;
			}

			int temp =left+right+1;
			if (temp < min) {
				min = temp;
			}
		

		}
		return strg[i][j]=min;
	}

	public static boolean isPalindromic(String str, int i, int j) {
		int left = i;
		int right = j;
		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	// d.2 Evaluation expression to True (# of ways)/boolean parenthesization
	static int countWaysRec(String s, int i, int j, boolean isTrue){
		if(i > j){
			return 0;
		}
		if(i == j){
			if(isTrue){
				return s.charAt(i) == 'T' ? 1 : 0;
			}else{
				return s.charAt(i) == 'F' ? 1 : 0;
			}
		}

		int ans=0;
		for(int k = i + 1; k <= j-1; k += 2){
			int l_T = countWaysRec(s, i, k-1, true);
			int l_F = countWaysRec(s, i, k-1, false);
			int r_T = countWaysRec(s, k+1, j, true);
			int r_F = countWaysRec(s, k+1, j, false);

			if(s.charAt(k) == '&'){
				if(isTrue){
					ans += l_T * r_T;
				}else {
					ans += l_T * r_F + l_F * r_T + l_F * r_F;
				}
			}else if (s.charAt(k) == '|'){
				if(isTrue){
					ans += l_T * r_F + l_F * r_T + l_T * r_T;
				}else {
					ans += l_F * r_F;
				}
			} else if (s.charAt(k) == '^') {
				if(isTrue){
					ans += l_T * r_F + l_F * r_T ;
				}else {
					ans += l_F * r_F + l_T * r_T ;
				}
			}

		}

		return ans;

	}
	static int countWaysTD(String s, int i, int j, boolean isTrue, HashMap<String, Integer> map){
		if(i > j){
			return 0;
		}
		if(i == j){
			if(isTrue){
				return s.charAt(i) == 'T' ? 1 : 0;
			}else{
				return s.charAt(i) == 'F' ? 1 : 0;
			}
		}
		String key=i+ "_" + j +"_" + isTrue;
		if(map.containsKey(key)){
			return map.get(key);
		}

		int ans=0;
		for(int k = i + 1; k <= j-1; k += 2){
			int l_T = countWaysTD(s, i, k-1, true, map);
			int l_F = countWaysTD(s, i, k-1, false, map);
			int r_T = countWaysTD(s, k+1, j, true, map);
			int r_F = countWaysTD(s, k+1, j, false, map);

			if(s.charAt(k) == '&'){
				if(isTrue){
					ans += l_T * r_T;
				}else {
					ans += l_T * r_F + l_F * r_T + l_F * r_F;
				}
			}else if (s.charAt(k) == '|'){
				if(isTrue){
					ans += l_T * r_F + l_F * r_T + l_T * r_T;
				}else {
					ans += l_F * r_F;
				}
			} else if (s.charAt(k) == '^') {
				if(isTrue){
					ans += l_T * r_F + l_F * r_T ;
				}else {
					ans += l_F * r_F + l_T * r_T ;
				}
			}

		}
		map.put(key, ans);
		return ans;

	}

	// d.3 scrambled string
	
	// d.4 egg dropping problem
	public static int eggDropRec(int e,int f) {
		if(f==0 || f==1)
			return f;
		if(e==1)
			return f;
		
		int min=Integer.MAX_VALUE;
		for(int k=1;k<=f;k++) {
			int temp=1+Math.max(eggDropRec(e,f-k),eggDropRec(e-1,k-1));
			min=Math.min(min,temp);
		}
		return min;
	}
	
	public static int eggDropTD(int e,int f,int strg[][]) {
		if(f==0 || f==1)
			return f;
		if(e==1)
			return f;
		if(strg[e][f]!=0)
			return strg[e][f];
		
		int min=Integer.MAX_VALUE;
		for(int k=1;k<=f;k++) {
			int temp=1+Math.max(eggDropTD(e,f-k,strg),eggDropTD(e-1,k-1,strg));
			min=Math.min(min,temp);
		}
		return strg[e][f]=min;
	}
	
	public static int eggDropTDOpti(int e,int f,int strg[][]) {
		if(f==0 || f==1)
			return f;
		if(e==1)
			return f;
		if(strg[e][f]!=0)
			return strg[e][f];
		
		int min=Integer.MAX_VALUE;
		for(int k=1;k<=f;k++) {
			int low=0,high=0;
			if(strg[e-1][k-1]!=0) {
				low=strg[e-1][k-1];
			}else {
				low=eggDropTDOpti(e-1,k-1,strg);
				strg[e-1][k-1]=low;
			}
			
			if(strg[e][f-k]!=0) {
				high=strg[e][f-k];
			}else {
				high=eggDropTDOpti(e,f-k,strg);
				strg[e][f-k]=high;
			}
			int temp=1+Math.max(low,high);
			min=Math.min(min,temp);
		}
		return strg[e][f]=min;
	}
	// d.5
	public static int burstingballoon(int arr[]){
		int temp[] = new int[arr.length +2];
		temp[0]=temp[temp.length -1]=1;
		for(int i=0;i<arr.length;i++){
			temp[i+1]=arr[i];
		}
		return burstingballoonTD(temp,0,temp.length-1, new int[temp.length][temp.length]);
	}
	public static int burstingballoonRec(int [] arr, int i, int j){
		if(i>j){
			return 0;
		}
		int max=0;
		for(int k=i+1; k<=j-1; k++){
			int temp=arr[i]*arr[k]*arr[j] +burstingballoonRec(arr, i, k) +burstingballoonRec(arr, k, j);
			max=Math.max(temp,max);
		}
		return max;
	}
	public static int burstingballoonTD(int [] arr, int i, int j, int strg[][]){
		if(i>j){
			return 0;
		}
		if(strg[i][j]!=0){
			return strg[i][j];
		}
		int max=0;
		for(int k=i+1; k<=j-1; k++){
			int temp=arr[i]*arr[k]*arr[j] +burstingballoonTD(arr, i, k, strg) +burstingballoonTD(arr, k, j, strg);
			max=Math.max(temp,max);
		}
		return strg[i][j] = max;
	}

	public static int burstingballoonTDOptim(int [] arr, int i, int j, int strg[][]){
		if(i>j){
			return 0;
		}
		if(strg[i][j]!=0){
			return strg[i][j];
		}
		int max=0;
		for(int k=i+1; k<=j-1; k++){
			int left=0,right=0;
			if(strg[i][k]!=0){
				left=strg[i][k];
			}else{
				left=burstingballoonTDOptim(arr, i, k, strg);
				strg[i][k]=left;
			}
			if(strg[k][j]!=0){
				right=strg[k][j];
			}else{
				right=burstingballoonTDOptim(arr, k, j, strg);
				strg[k][j]=right;
			}
			int temp=arr[i]*arr[k]*arr[j] +left+right;
			max=Math.max(temp,max);
		}
		return strg[i][j] = max;
	}

	// DP on tree
	private class Node {
		int data;
		Node left;
		Node right;
	}
	//e.1 diameter of binary tree (we are calculating no of node )
	public static int max=Integer.MIN_VALUE;

	public static int diameter(Node node){
		if(node == null){
			return 0;
		}
		int lt = diameter(node.left);
		int rt = diameter(node.right);
		int temp = Math.max(lt, rt) + 1;
		int ans = Math.max(temp, lt + rt + 1);
		max = Math.max(ans, max);
		return temp;
	}

	//e.2 maximum path sum from any node to any node
	public static int maxPathAnyToAny(Node node){
		if(node == null){
			return 0;
		}
		int lt = maxPathAnyToAny(node.left);
		int rt = maxPathAnyToAny(node.right);
		int temp = Math.max(lt, rt) + node.data;
		temp = Math.max(temp, node.data);
		int ans = Math.max(temp, lt + rt + node.data);
		max = Math.max(ans, max);
		return temp;
	}
	// e.3 maximum path sum from leaf node to leaf node
	public static int maxPathLeafToLeaf(Node node){
		if(node == null){
			return 0;
		}
		int lt = maxPathLeafToLeaf(node.left);
		int rt = maxPathLeafToLeaf(node.right);
		int temp = Math.max(lt, rt) + node.data;
		if(node.left == null && node.right == null ) {
			temp = Math.max(temp, node.data);
		}
		int ans = Math.max(temp, lt + rt + node.data);
		max = Math.max(ans, max);
		return temp;
	}
	// f.1 wine problem
	public static int wineProblem(int[] price, int i, int j, int yr) {
		if (i == j) {
			return price[i] * yr;
		}

		int fc = wineProblem(price, i + 1, j, yr + 1) + price[i] * yr;
		int sc = wineProblem(price, i, j - 1, yr + 1) + price[j] * yr;
		int res = Math.max(fc, sc);
		return res;

	}
	public static int wineProblemTD(int[] price, int i, int j, int yr, int strg[][]) {
		if (i == j) {
			return price[i] * yr;
		}
		if(strg[i][j]!=0){
			return strg[i][j];
		}

		int fc = wineProblem(price, i + 1, j, yr + 1) + price[i] * yr;
		int sc = wineProblem(price, i, j - 1, yr + 1) + price[j] * yr;
		int res = Math.max(fc, sc);
		return strg[i][j]=res;

	}
	// g .1 edit distance
	public static int editDistanceRec(String s1, String s2, int l1, int l2) {
		if (l1 == 0 || l2 == 0)
			return Math.max(l1, l2);
		if (s1.charAt(l1 - 1) == s2.charAt(l2 - 1))
			return editDistanceRec(s1, s2, l1 - 1, l2 - 1);
		else
			return Math.min(Math.min(editDistanceRec(s1, s2, l1 - 1, l2), editDistanceRec(s1, s2, l1, l2 - 1)),
					editDistanceRec(s1, s2, l1 - 1, l2 - 1)) + 1;
	}

	public static int editDistanceTD(String s1, String s2, int l1, int l2, int[][] strg) {
		if (l1 == 0 || l2 == 0)
			return Math.max(l1, l2);
		if (strg[l1][l2] != 0)
			return strg[l1][l2];
		if (s1.charAt(l1 - 1) == s2.charAt(l2 - 1))
			return strg[l1][l2] = editDistanceTD(s1, s2, l1 - 1, l2 - 1, strg);
		else
			return strg[l1][l2] = Math.min(Math.min(editDistanceTD(s1, s2, l1 - 1, l2, strg), editDistanceTD(s1, s2, l1, l2 - 1, strg)),
					editDistanceTD(s1, s2, l1 - 1, l2 - 1, strg)) + 1;
	}

	public static int editDistance(String s1, String s2, int l1, int l2) {
		int strg[][] = new int[l1 + 1][l2 + 1];
		for (int i = 0; i <= l1; i++) {
			for (int j = 0; j <= l2; j++) {
				if (i == 0 || j == 0) {
					strg[i][j] = Math.max(i,j);
					continue;
				}
				if (s1.charAt(i - 1) == s2.charAt(j - 1))
					strg[i][j] = strg[i - 1][j - 1];
				else
					strg[i][j] = Math.min(Math.min(strg[i - 1][j], strg[i][j - 1]), strg[i-1][j-1]) + 1;

			}
		}
		return strg[l1][l2];

	}

	// h.1 LIS
	public static int LIS(int[] arr) {
		int n = arr.length;
		int[] lis = new int[n];
		Arrays.fill(lis, 1);

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					lis[i] = Math.max(lis[i] ,lis[j] + 1);
				}
			}
		}
		int max=0;
		for(int i = 0; i < n; i++){
			max = Math.max(max, lis[i]);
		}
		return max;
	}
   // h.2
   public static int weightedJob(Job[] jobs) {
	   int[] T = new int[jobs.length];
	   Arrays.sort(jobs, (x,y)-> x.finishtime-y.finishtime);
	   for(int i = 0; i<jobs.length; i++){
		   T[i] = jobs[i].profit;
	   }
	   for (int i = 1; i < jobs.length; i++) {
		   for (int j = 0; j < i; j++) {
			   if (jobs[j].finishtime <= jobs[i].starttime) {
				   T[i] = Math.max(T[i], T[j] + jobs[i].profit);
			   }
		   }
	   }
	   int max = Integer.MIN_VALUE;
	   for (int val : T) {
		   max = Math.max(val, max);
	   }
	   return max;

   }
   // h 3.
   public static int longestBitonicSubSeq(int arr[]) {
	   int lis[] = new int[arr.length];
	   int lds[] = new int[arr.length];
	   for (int i = 0; i < arr.length; i++) {
		   lis[i] = 1;
		   lds[i] = 1;
	   }
	   for (int i = 1; i < arr.length; i++) {
		   for (int j = 0; j < i; j++) {
			   if (arr[j] < arr[i])
				   lis[i] = Math.max(lis[i], lis[j] + 1);
		   }
	   }
	   for (int i = arr.length - 2; i >= 0; i--) {
		   for (int j = arr.length - 1; j > i; j--) {
			   if (arr[j] < arr[i])
				   lds[i] = Math.max(lds[i], lds[j] + 1);
		   }
	   }
	   int max = Integer.MIN_VALUE;
	   for (int i = 0; i < arr.length; i++) {
		   max = Math.max(max, lis[i] + lds[i] - 1);
	   }
	   return max;
   }

	// i .1 Kadane's Algorithm is a linear time algorithm used to find the maximum subarray sum in a given array.
	// A subarray is defined as a contiguous subset of elements within the array.

	public static int kadansAlgo(int arr[]) {
		int curr_max = arr[0], global_max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			curr_max = Math.max(arr[i], arr[i] + curr_max);
			if (curr_max > global_max) {
				global_max = curr_max;
			}
		}
		return global_max;
	}

	// i.2 with start and end index
	public static int[] kadans(int arr[]) {
		int curr_max = arr[0];
		int[] result = new int[3];

		result[0] = arr[0];// for global max
		result[1] = 0;// start index
		result[2] = 0;// end index
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] + curr_max < arr[i]) {
				curr_max = arr[i];
				result[1] = i;
			} else {
				curr_max = curr_max + arr[i];
			}
			// curr_max=Math.max(arr[i],arr[i]+curr_max); bcz u want start index
			if (curr_max >= result[0]) {
				result[0] = curr_max;
				result[2] = i;
			}
		}

		return result;
	}

	// i.3 Find maximum sum rectangle in 2D matrix.

	public static void maxSubMatrix(int mat[][]) {
		int maxsum = Integer.MIN_VALUE;
		int maxleft = -1;
		int maxright = -1;
		int maxup = -1;
		int maxdown = -1;

		for (int left_col = 0; left_col < mat[0].length; left_col++) {
			int strg[] = new int[mat.length];
			for (int right_col = left_col; right_col < mat[0].length; right_col++) {
				for (int row = 0; row < mat.length; row++) {
					strg[row] += mat[row][right_col];
				}
				int[] result = kadans(strg);
				if (result[0] > maxsum) {
					maxsum = result[0];
					maxleft = left_col;
					maxright = right_col;
					maxup = result[1];
					maxdown = result[2];
				}

			}
		}
		System.out.println("left=" + maxleft + " right=" + maxright);
		System.out.println("bottom=" + maxdown + " up=" + maxup);
		System.out.println("max sum=" + maxsum);

	}
	// i.4
	// 1) Construct a sum matrix S[R][C] for the given M[R][C].
	// a) Copy first row and first columns as it is from M[][] to S[][]
	// b) For other entries, use following expressions to construct S[][]
	// If M[i][j] is 1 then
	// S[i][j] = min(S[i][j-1], S[i-1][j], S[i-1][j-1]) + 1
	// Else /*If M[i][j] is 0*/
	// S[i][j] = 0
	// 2) Find the maximum entry in S[R][C]
	// 3) Using the value and coordinates of maximum entry in S[i], print
	// sub-matrix of M[][]

	public static int maxiSizeSqureSubMatrixOf1s(int mat[][]) {
		int max = 0;
		int strg[][] = new int[mat.length][mat[0].length];
		// copy first row
		for (int col = 0; col < mat[0].length; col++) {
			strg[0][col] = mat[0][col];
			if (strg[0][col] == 1) {
				max = 1;
			}
		}
		// copy first column
		for (int row = 0; row < mat.length; row++) {
			strg[row][0] = mat[row][0];
			if (strg[row][0] == 1) {
				max = 1;
			}
		}
		// other
		for (int row = 1; row < mat.length; row++) {
			for (int col = 1; col < mat[0].length; col++) {
				if (mat[row][col] == 0) {
					strg[row][col] = 0;
				} else {
					strg[row][col] = Math.min(Math.min(strg[row][col - 1], strg[row - 1][col]), strg[row - 1][col - 1])
							+ 1;
					if (strg[row][col] > max) {
						max = strg[row][col];
					}
				}
			}
		}
		return max;
	}
	// j.1
	/**
	 * This is slow method but easier to understand. Time complexity is O(k * number
	 * of days ^ 2) T[i][j] = max(T[i][j-1], max(prices[j] - prices[m] + T[i-1][m]))
	 * where m is 0...j-1
	 */
	public static int stockBuySell(int[] price, int k) {
		if (k == 0 || price.length == 0) {
			return 0;
		}
		if (k >= price.length) {
			return profit(price, k);
		}
		int strg[][] = new int[k + 1][price.length];
		for (int i = 1; i < strg.length; i++) {
			for (int j = 1; j < strg[0].length; j++) {
				int maxvalue = Integer.MIN_VALUE;
				for (int m = 0; m < j; m++) {
					maxvalue = Math.max(maxvalue, price[j] - price[m] + strg[i - 1][m]);
				}
				strg[i][j] = Math.max(strg[i][j - 1], maxvalue);
			}
		}
		return strg[k][price.length - 1];

	}

	public static int profit(int[] price, int k) {
		int profit = 0;
		for (int i = 1; i < price.length; i++) {
			if(price[i] > price[i-1]){
				profit+= price[i] - price[i-1];
			}
		}
		return profit;
	}

	/**
	 * This is faster method which does optimization on slower method Time
	 * complexity here is O(K * number of days)
	 *
	 * Formula is T[i][j] = max(T[i][j-1], prices[j] + maxDiff) maxDiff =
	 * max(maxDiff, T[i-1][j] - prices[j])
	 */
	/*
	 * Scanner sc=new Scanner(System.in); int t=sc.nextInt(); while(t-->0){ int
	 * k=sc.nextInt(); int n=sc.nextInt(); int arr[]=new int[n]; for(int
	 * i=0;i<n;i++){ arr[i]=sc.nextInt(); } System.out.println(); }
	 */
	public static int stockBuySellfaster(int[] price, int k) {
		if (k == 0 || price.length == 0) {
			return 0;
		}
		if (k >= price.length) {
			return profit(price, k);
		}
		int strg[][] = new int[k + 1][price.length];
		for (int i = 1; i < strg.length; i++) {
			int maxdiff = Integer.MIN_VALUE;
			for (int j = 1; j < strg[0].length; j++) {
				maxdiff = Math.max(maxdiff, strg[i - 1][j - 1] - price[j - 1]);
				strg[i][j] = Math.max(strg[i][j - 1], maxdiff + price[j]);

			}
		}
		return strg[k][price.length - 1];

	}











	class Job {
		int starttime;
		int finishtime;
		int profit;

		Job(int s, int f, int p) {
			this.finishtime = f;
			this.starttime = s;
			this.profit = p;
		}
	}








}
