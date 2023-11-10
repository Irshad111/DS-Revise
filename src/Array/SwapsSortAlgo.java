package Array;

public class SwapsSortAlgo {

	public static void main(String[] args) {
		int arr[]= {2,3,1,5,1};
		swapSortAlgo(arr,5);
		
	}
	// to find missing and duplicate
	public static void swapSortAlgo(int arr[],int n) {
		int i=0;
		while(i<n) {
			if(arr[i]!=arr[arr[i]-1]) {
				int temp=arr[arr[i]-1];
				arr[arr[i]-1]=arr[i];
				arr[i]=temp;
			}else {
				i++;
			}
		}
		
		for( i=0;i<n;i++) {
			
			if(arr[i]!=i+1) {
				System.out.println("mising: "+(i+1));
				System.out.println("Duplicate: "+arr[i]);
			}
		}
	}

}
