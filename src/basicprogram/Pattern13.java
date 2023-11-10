package basicprogram;

import java.util.Scanner;

public class Pattern13 {



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		int nst=1;
		// row
		int nr=2*n-1;
		int row=1;
		int val=1;
		while(row<=nr) {

				
			// star work

			for(int cst=1;cst<=nst;cst++) {
				if(cst%2==0)
				System.out.print("*");
				else
				System.out.print(val);
			}
			// prepration for next row
			System.out.println();
			if(row<=nr/2) {
				val++;
			}else {
				val--;
			}
			row=row+1;
			nst=nst+2;

			
		}

	}





}
