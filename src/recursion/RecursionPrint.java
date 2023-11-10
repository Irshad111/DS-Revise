package recursion;

import java.util.ArrayList;

public class RecursionPrint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// permutation("abc", "");
		//permutationNoDup("aab", "");
		//printSS("abc","");
		System.out.println(mazePath(0, 2, 0, 2, ""));
	}

	// 1. print subsguence
	public static void printSS(String que, String ans) {
		if (que.length() == 0) {
			System.out.println(ans);
			return;
		}
		char ch = que.charAt(0);
		String ros = que.substring(1);
		printSS(ros, ans);// value don't include
		printSS(ros, ans + ch);// value take

	}

	// 2.find sub sequence including ascii value
	public static void printSubSAscii(String que, String ans) {
		if (que.length() == 0) {
			System.out.println(ans);
			return;
		}
		char ch = que.charAt(0);
		String ros = que.substring(1);
		printSubSAscii(ros, ans);
		printSubSAscii(ros, ans + ch);
		printSubSAscii(ros, ans + (int) ch);
	}

	// 3.
	public static void kpc(String que, String ans) {
		if (que.length() == 0) {
			System.out.println(ans);
			return;
		}
		char ch = que.charAt(0);
		String ros = que.substring(1);
		String code = GetRecursion.getCode(ch);
		for (int i = 0; i < code.length(); i++) {
			kpc(ros, ans + code.charAt(i));
		}
	}

	// 4 permutation
	public static void permutation(String que, String ans) {
		if (que.length() == 0) {
			System.out.println(ans);
			return;
		}
		for (int i = 0; i < que.length(); i++) {
			char ch = que.charAt(i);
			String ros = que.substring(0, i) + que.substring(i + 1);
			permutation(ros, ans + ch);
		}
	}

	// no duplicate permutaion
	public static void permutationNoDup(String que, String ans) {
		if (que.length() == 0) {
			System.out.println(ans);
			return;
		}
		boolean track[] = new boolean[256];
		for (int i = 0; i < que.length(); i++) {
			char ch = que.charAt(i);
			String ros = que.substring(0, i) + que.substring(i + 1);
			if (!track[ch]) {
				track[ch] = true;
				permutationNoDup(ros, ans + ch);
			}
		}
	}

	public static void coinToss(int n, String ans) {
		if (n == 0) {
			System.out.println(ans);
			return;
		}
		coinToss(n - 1, ans + "H");
		coinToss(n - 1, ans + "T");
	}

	public static void noConsicutiveHead(int n, String ans, boolean visited) {
		if (n == 0) {
			System.out.println(ans);
			return;
		}
		if (!visited)
			noConsicutiveHead(n - 1, ans + "H", true);

		noConsicutiveHead(n - 1, ans + "T", false);

	}

	public static void printBoardPath(int curr, int end, String ans) {
		if (curr == end) {
			System.out.println(ans);
			return;
		}
		if (curr > end) {
			return;
		}
		for (int dice = 1; dice <= 6; dice++) {
			printBoardPath(curr + dice, end, ans + dice);
		}
	}

	public static int countBoardPath(int curr, int end) {
		if (curr == end) {
			return 1;
		}
		if (curr > end) {
			return 0;
		}
		int count = 0;
		for (int dice = 1; dice <= 6; dice++) {
			count += countBoardPath(curr + dice, end);
		}
		return count;
	}

	public static int mazePath(int cc, int ec, int cr, int er, String ans) {
		if (cc == ec && cr == er) {
			System.out.println(ans);
			return 1;
		}
		if (cc > ec || cr > er) {
			return 0;
		}

		int h_count = mazePath(cc + 1, ec, cr, er, ans + "H");
		int v_count = mazePath(cc, ec, cr + 1, er, ans + "V");

		return h_count + v_count;
	}

	public static int mazePathDig(int cc, int ec, int cr, int er, String ans) {
		if (cc == ec && cr == er) {
			System.out.println(ans);
			return 1;
		}
		if (cc > ec || cr > er) {
			return 0;
		}

		int h_count = mazePathDig(cc + 1, ec, cr, er, ans + "H");
		int v_count = mazePathDig(cc, ec, cr + 1, er, ans + "V");
		int d_count = mazePathDig(cc + 1, ec, cr + 1, er, ans + "H");

		return h_count + v_count + d_count;
	}

}
