package basicprogram;

import java.util.Scanner;

public class Pattern4 {



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		
		int row=1;
		int nst=1;
		int nsc=n-1;
		while(row<=n) {
			
			//work space
			int csc=1;
			while(csc<=nsc) {
				System.out.print(" ");
				csc++;
			}
			// work for star
			int cst=1;
			while(cst<=nst) {
				System.out.print("*");
				cst++;
			}
			
			// preprtion for next row
			System.out.print("\n");
			row=row+1;
			nst=nst+1;
			nsc=nsc-1;
		}

	}





}
