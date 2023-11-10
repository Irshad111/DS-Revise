package basicprogram;

import java.util.Scanner;

public class Pattern0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		
		for(int row=1;row<=n;row++) {
			
			//work
			System.out.print("*");
			
			// pripration for next row
			System.out.print("\n");
		}

	}

}
