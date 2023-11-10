package basicprogram;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		
		int counter=1;
		int a=0;
		int b=1;
		while(counter<=n+1) {
			System.out.println(a);

			int sum=a+b;
			a=b;
			b=sum;
			counter++;
		}

	}

}
