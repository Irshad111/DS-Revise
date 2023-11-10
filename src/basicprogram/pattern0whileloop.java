package basicprogram;

import java.util.Scanner;

public class pattern0whileloop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		
		int row=1;
		while(row<=n) {
			
			//work
			System.out.print("*");
			
			// preprtion for next row
			System.out.print("\n");
			row=row+1;
		}

	}

}
