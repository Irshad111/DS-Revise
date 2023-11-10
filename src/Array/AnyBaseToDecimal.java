package Array;

import java.util.Scanner;

public class AnyBaseToDecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int sb=scn.nextInt();// source base
		System.out.println(BaseToDecimal(n,sb));
		System.out.println(DecimalToBase(238,5));

	}
	public static int BaseToDecimal(int n,int sb) {
		int multiplier=1;
		int ans=0;
		
		while(n!=0) {
			int rem=n%10;
			ans=ans+rem*multiplier;
			multiplier=multiplier*sb;
			n=n/10;
			
		}
		return ans;
	}
	
	public static int DecimalToBase(int n,int dsb) {
		int multiplier=1;
		int ans=0;
		
		while(n!=0) {
			int rem=n%dsb;
			ans=ans+rem*multiplier;
			multiplier=multiplier*10;
			n=n/dsb;
			
		}
		return ans;
	}


}
