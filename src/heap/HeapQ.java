package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class HeapQ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]={5,5,4,6,4};
		sortWithFrequency(arr);

	}

	// 1. kth smallest/ kth largest
	public static int kthSmallest(int[] arr, int k) {
		// Your code here
		// PriorityQueue<Integer> maxHeap=new
		// PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> y - x);

		for (int i = 0; i < arr.length; i++) {
			maxHeap.add(arr[i]);
			if (maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
		return maxHeap.peek();
	}

	// 2. k largest/ k smallest
	int[] kLargest(int[] arr, int k) {
		// code here
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for (int i = 0; i < arr.length; i++) {
			minHeap.add(arr[i]);
			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}
		int ans[] = new int[k];
		for (int i = k - 1; i >= 0; i--) {
			ans[i] = minHeap.poll();
		}
		return ans;
	}
	// 3. sort a k sorted array /sort nearly sorted array
	ArrayList <Integer> nearlySorted(int arr[], int num, int k)
	{
		PriorityQueue<Integer> minHeap=new PriorityQueue<>();
		ArrayList<Integer> ans=new ArrayList<>();
		for(int i=0;i<arr.length;i++){
			minHeap.add(arr[i]);
			if(minHeap.size()>k){
				ans.add(minHeap.poll());
			}
		}
		while(!minHeap.isEmpty()){
			ans.add(minHeap.poll());
		}
		return ans;
	}

	// 4. find k closest number of give a number x
	// if diff same then return smallest element
	// M1 using Comparable
	public ArrayList<Integer> Kclosest(int arr[], int n, int x, int k) {
		// Your code goes here
		PriorityQueue<Pair> maxHeap = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			maxHeap.add(new Pair(arr[i], Math.abs(arr[i] - x)));
			if (maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
		ArrayList<Integer> ans = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			ans.add(maxHeap.poll().num);
		}
		Collections.sort(ans); // this is only k size now so nlogk time complexity
		return ans;
	}

	// M2 using Comparator
	public ArrayList<Integer> Kclosest1(int arr[], int n, int x, int k) {
		// Your code goes here
		PriorityQueue<Pair1> maxHeap = new PriorityQueue<>(new Comparator<Pair1>() {
			public int compare(Pair1 p1, Pair1 p2) {
				if (p2.diff - p1.diff == 0) {
					return p2.num - p1.num;
				}
				return p2.diff - p1.diff;
			}
		});
		for (int i = 0; i < n; i++) {
			maxHeap.add(new Pair1(arr[i], Math.abs(arr[i] - x)));
			if (maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
		ArrayList<Integer> ans = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			ans.add(maxHeap.poll().num);
		}
		Collections.sort(ans);
		return ans;
	}

	class Pair1 {
		int num;
		int diff;

		public Pair1(int num, int diff) {
			this.num = num;
			this.diff = diff;
		}
	}

	// M3 using lamda function
	public ArrayList<Integer> Kclosest2(int arr[], int n, int x, int k) {
		// Your code goes here
		PriorityQueue<Pair1> maxHeap = new PriorityQueue<>(
				(a, b) -> a.diff == b.diff ? b.num - a.num : b.diff - a.diff);
		for (int i = 0; i < n; i++) {
			maxHeap.add(new Pair1(arr[i], Math.abs(arr[i] - x)));
			if (maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
		ArrayList<Integer> ans = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			ans.add(maxHeap.poll().num);
		};
		Collections.sort(ans);
		return ans;
	}

	// 5. Top K Frequent Elements in Array
	public int[] topK(int[] nums, int k) {
		// Code here
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i]) + 1);
			} else {
				map.put(nums[i], 1);
			}
		}
		PriorityQueue<HashMap.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
				(a, b) -> a.getValue() == b.getValue() ? a.getKey() - b.getKey() : a.getValue() - b.getValue());
		for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
			minHeap.add(entry);
			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}
		int ans[] = new int[k];
		for (int i = k - 1; i >= 0; i--) {
			ans[i] = minHeap.poll().getKey();
		}
		return ans;

	}
	// 6.Sort array by element frequency.
	//Given an array A[] of integers, sort the array according to frequency of elements. That is elements
	// that have higher frequency come first. If frequencies of two elements are same, then smaller number
	// comes first.
	public static void sortWithFrequency(int []nums){
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i]) + 1);
			} else {
				map.put(nums[i], 1);
			}
		}
		PriorityQueue<HashMap.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
				(a, b) -> a.getValue() == b.getValue() ? a.getKey() - b.getKey() : b.getValue() - a.getValue());
		for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
			maxHeap.add(entry);
		}
		while(!maxHeap.isEmpty()){
			HashMap.Entry<Integer, Integer> entry=maxHeap.poll();
			for(int i=0;i<entry.getValue();i++){
				System.out.print(entry.getKey()+" ");
			}
		}

	}

	// 7.k closest point to origin
    public int[][] kClosest(int[][] points, int k) {
        int result[][]=new int[k][2];
        PriorityQueue<Pair2> maxHeap=new PriorityQueue<>(
            (a,b)->b.x*b.x+b.y*b.y-a.x*a.x-a.y*a.y
        );
        for(int i=0;i<points.length;i++){
            maxHeap.add(new Pair2(points[i][0],points[i][1]));
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }
        int index=0;
        while(!maxHeap.isEmpty()){
            Pair2 pair=maxHeap.poll();
            result[index][0]=pair.x;
            result[index][1]=pair.y;
            index++;

        }
        return result;
        
    }
    class Pair2{
        int x;
        int y;
        public Pair2(int x,int y){
           this.x=x;
            this.y=y;
        }
    }
// 8.//Function to return the minimum cost of connecting the ropes.
    long minCost(long arr[], int n) 
    {
        // your code here
        PriorityQueue<Long> minHeap=new PriorityQueue<>();
        long cost=0;
        for(int i=0;i<n;i++){
            minHeap.add(arr[i]);
        }
        while(minHeap.size()>=2){
            long first=minHeap.poll();
            long second=minHeap.poll();
            cost+=first+second;
            minHeap.add(first+second);
        }
        return cost;
    }

}

class Pair implements Comparable<Pair> {
	int num;
	int diff;

	public Pair(int num, int diff) {
		this.num = num;
		this.diff = diff;
	}

	public int compareTo(Pair other) {
		if (other.diff == this.diff) {
			return other.num - this.num;
		}
		return other.diff - this.diff;
	}
}
