package basicprogram;

import java.util.Scanner;

public class Pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int row=1;
		int nst=1;
		int nsp=n/2;
		
		while(row<=n) {
			//work for space
			int csp=1;
			while(csp<=nsp) {
				System.out.print(" ");
				csp++;
			}
			
			// work for star
			int cst=1;
			while(cst<=nst) {
				System.out.print("*");
				cst++;
			}
			
			//prep
			System.out.println();
			if(row<=n/2) {
				nst=nst+2;
				nsp=nsp-1;
			}else {
				nst=nst-2;
				nsp=nsp+1;
			}
			row=row+1;

			
		}
		
		

	}



}
