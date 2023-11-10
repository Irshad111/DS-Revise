package basicprogram;

import java.util.Scanner;

public class Pattern11 {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		int nsp=n-1;
		int nst=1;
		int val=1;
		// row
		int row=1;
		while(row<=n) {
			// space work
			for(int csp=1;csp<=nsp;csp++) {
				System.out.print(" ");
			}
			
			// star work

			for(int cst=1;cst<=nst;cst++) {
				System.out.print(val);
				val++;
			}
			// prepration for next row
			System.out.println();
			row=row+1;
			nsp=nsp-1;
			nst=nst+2;

			
		}

	}





}
