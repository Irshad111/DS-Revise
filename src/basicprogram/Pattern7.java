package basicprogram;

import java.util.Scanner;

public class Pattern7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int row=1;
		int nst=n-1;
		int nsp=1;
		
		while(row<=n) {
			//work for star
			int cst=1;
			while(cst<=nst/2) {
				System.out.print("*");
				cst++;
			}
			// work for space
			int csp=1;
			while(csp<=nsp) {
				System.out.print(" ");
				csp++;
			}
			// work for star
			while(cst<=nst) {
				System.out.print("*");
				cst++;
			}
			
			//prep
			System.out.println();
			if(row<=n/2) {
				nst=nst-2;
				nsp=nsp+2;
			}else {
				nst=nst+2;
				nsp=nsp-2;
			}
			row=row+1;

			
		}
		
		

	}

}
