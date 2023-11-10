package basicprogram;

import java.util.Scanner;

public class Pattern2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		
		int row=1;
		int nst=1;//no of star
		while(row<=n) {
			
			//work
			int col=1;
			
			while(col<=nst) {
				System.out.print("*");
				col++;

			}
			
			// preprtion for next row
			System.out.print("\n");
			row=row+1;
			nst=nst+1;
		}

	}

}
