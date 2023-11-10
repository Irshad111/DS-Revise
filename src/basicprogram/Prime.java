package basicprogram;

import java.util.Scanner;

public class Prime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int divisor = 2;
		//int n=7;
		boolean flag=true;
		while(divisor<n) {
			
			if(n%divisor==0) {
				flag=false;
				break;
			}
			divisor++;
		}
		if(flag)
			System.out.println(n+" is prime");
		else
			System.out.println(n+" is not prime");
		

	}

}
