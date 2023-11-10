package Array;

public class SortingAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 88, 10, 40, 20, 50 };
		//bubbleSort(arr);
		for (int i : arr) {
			System.out.println(i);

		}
		//selectionSort(arr);
		//InsertionSort(arr);
		//int arr1[]=mergeSort(arr,0,arr.length-1);
		quickSort(arr,0,arr.length-1);
		for (int i : arr) {
			System.out.println(i);

		}


	}

	public static void bubbleSort(int arr[]) {

		for (int counter = 0; counter < arr.length - 1; counter++) {
			for (int j = 0; j < arr.length - 1 - counter; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	public static void selectionSort(int[] arr) {
		for (int counter = 0; counter < arr.length - 1; counter++) {
			int min = counter;
			for (int j = counter + 1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			int temp = arr[min];
			arr[min] = arr[counter];
			arr[counter] = temp;
		}
	}
	public static void InsertionSort(int[] arr) {
		for(int counter=1;counter<arr.length;counter++) {
			int val=arr[counter];
			int j=counter-1;
				while(j>=0 && arr[j]>val) {
					arr[j+1]=arr[j];
					j--;
				}
				arr[j+1]=val;
			
		}
	}
	public static int [] mergeTwoSortedArray(int [] one,int [] two) {
		int [] merge=new int[one.length+two.length];
		int i=0;
		int j=0;
		int k=0;
		while(i<one.length && j<two.length) {
			if(one[i]<=two[j]) {
				merge[k]=one[i];
				i++;
				k++;
			}else {
				merge[k]=two[j];
				j++;
				k++;
			}
		}
		if(i==one.length) {
			while(j<two.length) {
				merge[k]=two[j];
				j++;
				k++;
			}
		}
		
		if(j==two.length) {
			while(i<one.length) {
				merge[k]=one[i];
				i++;
				k++;
			}
		}
		return merge;

	}
	public static int[] mergeSort(int []arr,int lo,int hi) {
		if(lo==hi) {
			int br[]=new int[1];
			br[0]=arr[lo];
			return br;
		}
		int mid=(lo+hi)/2;
		int [] fh=mergeSort(arr,lo,mid);
		int [] sh=mergeSort(arr,mid+1,hi);
		int sorted[]=mergeTwoSortedArray(fh,sh);
		return sorted;
	}
	
	public static void quickSort(int [] arr,int lo,int hi) {
		if(lo>=hi) {
			return;
		}
		int left=lo;
		int right=hi;
		int mid=(lo+hi)/2;
		int pivot=arr[mid];
		// partitioning
		while(left<=right) {
			while(arr[left]<pivot) {
				left++;
			}
			while(arr[right]>pivot) {
				right--;
			}
			
			if(left<=right) {
				int temp=arr[left];
				arr[left]=arr[right];
				arr[right]=temp;
				left++;
				right--;
			}
		}
		
		// for smaller problem
		quickSort(arr,lo,right);
		quickSort(arr,left,hi);
		
	}

}
