package basicprogram;

import java.util.Scanner;

public class GCD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n1 = scn.nextInt();
		int n2 = scn.nextInt();

		System.out.println(GCDUsingIteration(n1, n2));
		System.out.println(GCDUsingRec(n1,n2));

	}

	public static int GCDUsingIteration(int n1, int n2) {
		int divident = n1;
		int divisor = n2;
		while (divident % divisor != 0) {

			int rem = divident % divisor;
			divident = divisor;
			divisor = rem;

		}
		return divisor;
	}

	public static int GCDUsingRec(int n1, int n2) {
		if (n2 != 0) {
			return GCDUsingRec(n2, n1 % n2);
		} else {
			return n1;
		}
	}

}
