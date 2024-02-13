package Array;

public class ArrayQ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(-5%5);
		}
	public static int[] rotate(int[] arr,int r) {
		if(r>=arr.length || r<0) {
			r=(r+ arr.length)%arr.length;
		}
		int []ans=new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			if(i<r) {
				ans[i]=arr[i-r+arr.length];
			}else {
				ans[i]=arr[i-r];
			}
		}
		return ans;
	}
	public int kadansAlgo(int arr[]) {
		int cur_max=0;
		int glob_max=Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++) {
			cur_max=Math.max(arr[i],cur_max+arr[i]);
			if(cur_max>glob_max) {
				cur_max=glob_max;
			}
		}
		return glob_max;
	}
	// Boyer-Moore Majority Voting Algorithm

	public int findMajority(int [] arr) {
		int votes=0;
		int candidate=-1;
		for(int i=0;i<arr.length;i++) {
			if(votes==0) {
				candidate=arr[i];
				votes=1;
			}else {
			if(candidate==arr[i])
				votes++;
			else
				votes--;
			}
		}
		int count=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==candidate) {
				count++;
			}
		}
		
		if(count>arr.length/2)
			return candidate;
		else 
			return -1;
	}

}
