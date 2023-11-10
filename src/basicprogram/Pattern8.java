package basicprogram;

import java.util.Scanner;

public class Pattern8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int row=1;
		int nsp=2*n-3;
		int nst=1;
		
		while(row<=n) {
			// star work
			for(int cst=1;cst<=nst;cst++) {
				System.out.print("*");
			}
			// space work
			for(int csp=1;csp<=nsp;csp++) {
				System.out.print(" ");
			}
			
			// star work
			int cst=1;
			if(row==n) {
				cst=2;
			}

			for(;cst<=nst;cst++) {
				System.out.print("*");
			}
			// prepration for next row
			System.out.println();
			row=row+1;
			nsp=nsp-2;
			nst=nst+1;

			
		}

	}

}
