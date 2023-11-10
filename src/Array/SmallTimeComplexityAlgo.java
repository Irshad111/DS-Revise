package Array;

import java.util.Arrays;

public class SmallTimeComplexityAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(power(2,5));
//		int arr[]= {2,1,0,2,1,0,2};
//		sort(arr);
//		for(int i:arr) {
//			System.out.println(i);
//		}
		SOE(25);

	}
	//1 power of x^n log(n)
	public static int power(int x,int n) {
		if(n==0)
			return 1;
		int nm2=power(x,n/2);
		if(n%2==1) {
			return nm2*nm2*x;
		}else
			return nm2*nm2;
	}
	
	// 2 sort array of 0s,1s,2s, o(n)
	public static void sort(int arr[]) {
		int lo=0;
		int i=0;
		int hi=arr.length-1;
		while(i<=hi) {
			if(arr[i]==0) {
				swap(arr,i,lo);
				lo++;
				i++;
			}else if(arr[i]==1) {
				i++;
			}else {
				swap(arr,i,hi);
				hi--;
			}
		}
	}
	public static void swap(int [] arr, int i,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	// 3. to print all prime no in given range in o(nloglog(n))
	public static void SOE(int n) {
		boolean prime[]=new boolean[n+1];
		Arrays.fill(prime, true);
		
		prime[0]=false;
		prime[1]=false;
		for(int table=2;table*table<=n;table++) {
			if(prime[table]==false)
				continue;
			for(int mult=2;table*mult<=n;mult++) {
				prime[table*mult]=false;
			}
		}
		
		for(int i=0;i<prime.length;i++) {
			if(prime[i]==true)
			System.out.println(i);
		}
	}

}
