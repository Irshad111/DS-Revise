package Array;

public class TwoDimentionArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[][] = { { 1, 2, 3,4 }, { 5, 6,7,8 }, {  9, 10,11,12}, { 13, 14,15, 16 } };
		wavePrint(arr1);
		spiralPrint(arr1);
		int arr[][] = new int[3][];
		arr[0] = new int[3];
		arr[1] = new int[5];
		arr[2] = new int[7];
	}

	public static void wavePrint(int arr[][]) {
		for (int row = 0; row < arr.length; row++) {
			if (row % 2 == 0) {
				for (int col = 0; col < arr[row].length; col++) {
					System.out.print(arr[row][col] + " ");
				}
			} else {
				for (int col = arr[row].length - 1; col >= 0; col--) {
					System.out.print(arr[row][col] + " ");
				}
			}
		}
	}

	public static void spiralPrint(int arr[][]) {
		int top = 0;
		int bottom = arr.length - 1;
		int left = 0;
		int right = arr[0].length - 1;
		int count = (bottom + 1) * (right + 1);
		int dir=1;
		
		while(left<=right && top<=bottom) {
			if(count>0 && dir==1) {
				for(int i=left;i<=right;i++) {
					System.out.print(arr[top][i]+" ");
					count--;
				}
				top++;
				dir=2;
			}
			if(count>0 && dir==2) {
				for(int i=top;i<=bottom;i++) {
					System.out.print(arr[i][right]+" ");
					count--;

				}
				right--;
				dir=3;
			}
			if(count>0 && dir==3) {
				for(int i=right;i>=left;i--) {
					System.out.print(arr[bottom][i]+ " ");
					count--;

				}
				bottom--;
				dir=4;
			}
			if(count>0 && dir==4) {
				for(int i=bottom;i>=top;i--) {
					System.out.print(arr[i][left]+ " ");
					count--;

				}
				left++;
				dir=1;
			}



		}

	}

}
