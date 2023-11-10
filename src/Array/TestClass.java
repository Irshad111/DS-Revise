package Array;
import java.util.*;

public class TestClass {
	
	public static void main(String [] args) {
		int [] itemNumber= {101,102,103,104};
		int [] price= {42,50,500,40};
		int [] stock= {10,20,15,16};
		
		Scanner sc=new Scanner(System.in);
		
		int num=sc.nextInt();
		int q=sc.nextInt();
		int idx=-1;
		
		for(int i=0;i<4;i++) {
			if(itemNumber[i]==num) {
				idx=i;
			}
		}
		if(idx==-1) {
			System.out.println("INVALID INPUT");
		}else if(q<=stock[idx]) {
			System.out.printf("%.1f",(double)price[idx]*q);
			System.out.print(" INR\n");
			//System.out.println((double)price[idx]*q);

			System.out.println((stock[idx]-q)+" LEFT");
		}else {
			System.out.println("NO STOCK");
			System.out.println(stock[idx]+ " LEFT");
		}
		
	}

}
