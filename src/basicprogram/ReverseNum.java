package basicprogram;

import java.util.Scanner;

public class ReverseNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int num=scn.nextInt();
		int ans=0;
		while(num!=0) {
			int rem=num%10;
			num=num/10;
			ans=ans*10+rem;
			
			
			
		}
		System.out.println(ans);

	}

}
