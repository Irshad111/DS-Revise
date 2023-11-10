package Array;

public class SearchingAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 66, 72, 79, 86, 95, 104, 106, 110, 119, 123, 124, 129, 132, 136, 137, 142, 150, 2, 12, 14, 17, 26,
				30, 36, 38, 46, 52, 60 };
		int arr1[] = { 5,10,15,12,11,4,2,1};
		char arr2[] = { 'a', 'b', 'c', 'f', 'j' };
		// System.out.println(LinearSearch(arr, 8));
		// System.out.println(BinarySearch(arr, 8));
		// System.out.println(lowerBound(arr, 2));
		// System.out.println(upperBound(arr, 2));
		// System.out.println(findElement(arr,12));
		// System.out.println(floor(arr1,5));
		// System.out.println(ceil(arr1,5));
		System.out.println(nextElement(arr2,'j'));
		// System.out.println(minDiffElement(arr1,7));
		//System.out.println(peakElement(arr1));

	}

	// 1.
	public static int LinearSearch(int arr[], int item) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == item) {
				return i;
			}
		}
		return -1;
	}

	// 2.
	public static int BinarySearch(int arr[], int item) {
		int lo = 0;
		int hi = arr.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (arr[mid] == item) {
				return mid;
			} else if (arr[mid] < item) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}

		return -1;
	}

	public static int BS(int arr[], int item, int lo, int hi) {
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (arr[mid] == item) {
				return mid;
			} else if (arr[mid] < item) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}

		return -1;
	}

	// 3. find lower and upper bound in sorted array
	public static int lowerBound(int arr[], int item) {

		int lo = 0;
		int hi = arr.length - 1;
		int ans = -1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (arr[mid] == item) {
				ans = mid;
				hi = mid - 1;// bcz we want lower bond so may be same element available at left side
			} else if (arr[mid] < item) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}

		return ans;

	}

	// 4. find last occurence of element
	public static int upperBound(int arr[], int item) {

		int lo = 0;
		int hi = arr.length - 1;
		int ans = -1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (arr[mid] == item) {
				ans = mid;
				lo = mid + 1;// bcz we want uper bond so may be same element available at right side
			} else if (arr[mid] < item) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}

		return ans;

	}

	// 5 find count of an element occerence in sorted array
	public static int countOfElement(int arr[], int item) {
		int last = upperBound(arr, item);
		int first = lowerBound(arr, item);
		return last - first + 1;
	}

	// 6.how many times sorted array rotated
	public static int noOfTimes(int[] arr) {
		int hi = arr.length - 1;
		int n = arr.length;
		int lo = 0;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int prev = (mid - 1 + n) % n;
			int next = (mid + 1) % n;

			if (arr[mid] <= arr[prev] && arr[mid] <= arr[next]) {
				return mid;
			} else if (arr[lo] > arr[mid]) {
				hi = mid - 1;
			} else if (arr[hi] < arr[mid]) {
				lo = mid + 1;
			} else {
				return lo;
			}
		}
		return 0;

	}

	// 7. find an element in rotated sorted arr;
	public static int findElement(int arr[], int item) {
		int idx = noOfTimes(arr);
		int left = BS(arr, item, 0, idx - 1);
		int right = BS(arr, item, idx, arr.length);
		return left == -1 ? right : left;
	}

	// 8 floar
	public static int floor(int arr[], int item) {
		int lo = 0;
		int hi = arr.length - 1;
		int ans = -1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (arr[mid] == item) {
				return mid;
			} else if (arr[mid] < item) {
				lo = mid + 1;
				ans = mid;
			} else {
				hi = mid - 1;
			}
		}

		return ans;
	}

	// 9.ceil
	public static int ceil(int arr[], int item) {
		int lo = 0;
		int hi = arr.length - 1;
		int ans = -1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (arr[mid] == item) {
				return mid;
			} else if (arr[mid] < item) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
				ans = mid;
			}
		}

		return ans;
	}

	// 10.next alphabetical element
	public static int nextElement(char arr[], char item) {
		int lo = 0;
		int hi = arr.length - 1;
		int ans = -1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (arr[mid] == item) {
				lo = mid + 1;
			} else if (arr[mid] < item) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
				ans = mid;
			}
		}

		return ans;
	}

	// 11 minimum diffrence element in binary search array
	public static int minDiffElement(int arr[], int item) {
		int lo = 0;
		int hi = arr.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (arr[mid] == item) {
				return arr[mid];
			} else if (arr[mid] < item) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		int firstNeighbor = Math.abs(arr[hi] - item);
		int secondNeighbor = Math.abs(arr[lo] - item);
		if (firstNeighbor < secondNeighbor)
			return arr[hi];
		else
			return arr[lo];

	}

	// 12 peak element
	public static int peakElement(int arr[]) {
		int lo = 0;
		int size = arr.length;
		int hi = size - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (mid > 0 && mid < size - 1) {
				if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
					return mid;
				} else if (arr[mid - 1] >= arr[mid]) {
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}
			} else if (mid == 0) {
				if (arr[0] > arr[1])
					return 0;
				else
					return 1;
			} else if (mid == size - 1) {
				if (arr[size - 1] > arr[size - 2])
					return size - 1;
				else
					return size - 2;
			}
		}
		return -1;
	}
	

}
