package SlidingWindow;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { -13, 0, 6, 15, 16, 2, 15, -12, 17, -16, 0, -3, 19, -3, 2, -9, -6 };
		int arr1[] = { -13, 0, 6, 15 };
		// System.out.println(maxSumSubArray(arr, 3));

		// firstNegInteger(arr, 3);
		String str = "aabaabaa";
		String ptr = "aaba";
		// System.out.println(countAnagram(str,ptr));
		// ArrayList<Integer> list=maximum(arr,9,3);
		// System.out.println(list);
		// System.out.println(longest(arr1,4,15));
		System.out.println(minWindow("timetopractice", "toc"));

	}

	// 1. maximum sum of k size sub array
	public static int maxSumSubArray(int arr[], int k) {
		int i = 0, j = 0, sum = 0, max = Integer.MIN_VALUE;
		while (j < arr.length) {
			sum = sum + arr[j];// calculation

			if ((j - i + 1) < k) {
				j++;
			} else if ((j - i + 1) == k) {
				max = Math.max(max, sum);// ans from calculation
				sum = sum - arr[i];
				i++; // slide window
				j++;
			}
		}
		return max;
	}

	// 2. find first -ve integer in k size subarray
	public static void firstNegInteger(int[] arr, int k) {
		Queue<Integer> q = new LinkedList<>();
		int i = 0;
		int j = 0;
		while (j < arr.length) {
			// calculation
			if (arr[j] < 0) {
				q.add(arr[j]);
			}
			if ((j - i + 1) < k) {
				j++;
			} else if ((j - i + 1) == k) {
				if (q.isEmpty()) {
					System.out.print(0 + " ");
				} else {
					System.out.println(q.peek() + " ");
					if (arr[i] == q.peek()) {
						q.remove();
					}
				}
				i++;
				j++;
			}
		}
	}

	// 3.count occurencess of anagram u have given str1 and prn find no of anagram
	// of ptn in str1
	public static int countAnagram(String txt, String ptr) {
		int ans = 0;
		HashMap<Character, Integer> hm = new HashMap<>();

		int k = ptr.length();
		// store all char frequency in map

		for (int l = 0; l < k; l++) {
			char ch = ptr.charAt(l);
			if (hm.containsKey(ch)) {
				hm.put(ch, hm.get(ch) + 1);
			} else {
				hm.put(ch, 1);

			}
		}
		int count = hm.size();
		int i = 0;
		int j = 0;
		while (j < txt.length()) {
			char ch = txt.charAt(j);
			if (hm.containsKey(ch)) {
				hm.put(ch, hm.get(ch) - 1);
				if (hm.get(ch) == 0)
					count--;
			}
			if (j - i + 1 < k) {
				j++;
			} else if (j - i + 1 == k) {
				if (count == 0) {
					ans++;
				}
				char ch1 = txt.charAt(i);
				if (hm.containsKey(ch1)) {
					hm.put(ch1, hm.get(ch1) + 1);
					if (hm.get(ch1) == 1)
						count++;
				}
				i++;
				j++;
			}

		}
		return ans;
	}

	// 4. find maximum in every k size subarray
	public static ArrayList<Integer> maximum(int arr[], int n, int k) {
		Deque<Integer> dq = new LinkedList<>();
		ArrayList<Integer> list = new ArrayList<>();

		int i = 0, j = 0;
		while (j < n) {
			while (!dq.isEmpty() && dq.peekLast() < arr[j]) {
				dq.removeLast();
			}
			dq.addLast(arr[j]);

			if (j - i + 1 < k) {
				j++;
			} else if (j - i + 1 == k) {
				int ans = dq.peek();
				list.add(ans);
				if (ans == arr[i]) {
					dq.removeFirst();
				}
				i++;
				j++;
			}

		}
		return list;

	}

	// 5.longest subarray of sum k arr element should be all +ve
	public static int longest(int arr[], int N, int K) {
		int i = 0;
		int j = 0;
		long sum = 0;
		int max = 0;
		while (j < N) {
			sum += arr[j];
			if (sum < K) {
				j++;
			} else if (sum == K) {
				max = Math.max(max, j - i + 1);
				j++;
			} else if (sum > K) {
				while (sum > K) {
					sum -= arr[i];
					i++;
				}
				j++;
			}
		}
		return max;
	}

	// 6.longest substring with unique k character
	public static int longestStr(String str, int k) {
		HashMap<Character, Integer> hm = new HashMap<>();
		int ans = 0;
		int i = 0, j = 0;
		while (j < str.length()) {
			char ch = str.charAt(j);
			if (hm.containsKey(ch))
				hm.put(ch, hm.get(ch) + 1);
			else
				hm.put(ch, 1);

			if (hm.size() < k) {
				j++;
			} else if (hm.size() == k) {
				ans = Math.max(ans, j - i + 1);
				j++;
			} else if (hm.size() > k) {
				while (hm.size() > k) {
					char ch1 = str.charAt(i);
					hm.put(ch1, hm.get(ch1) - 1);
					if (hm.get(ch1) == 0)
						hm.remove(ch1);
					i++;

				}
				j++;
			}
		}
		return ans;
	}

	// 7. longest substring with without repeating characters
	public static int longestdist(String str) {
		int i = 0;
		int j = 0;
		HashMap<Character, Integer> hm = new HashMap<>();
		int ans = 0;
		while (j < str.length()) {
			char ch = str.charAt(j);
			if (hm.containsKey(ch))
				hm.put(ch, hm.get(ch) + 1);
			else
				hm.put(ch, 1);
			if (hm.size() == j - i + 1) {
				ans = Math.max(ans, j - i + 1);
				j++;
			} else if (hm.size() < j - i + 1) {
				while (hm.size() < j - i + 1) {
					char ch1 = str.charAt(i);
					hm.put(ch1, hm.get(ch1) - 1);
					if (hm.get(ch1) == 0) {
						hm.remove(ch1);
					}
					i++;
				}
				j++;
			}

		}
		return ans;
	}

	// 8 minimum window substring given str1 find str2 all char in str1 with minimum
	// window
	public static int minWindow(String str1, String str2) {
		int ans = Integer.MAX_VALUE;
		int i = 0;
		int j = 0;

		HashMap<Character, Integer> hm = new HashMap<>();
		for (int l = 0; l < str2.length(); l++) {
			char ch = str2.charAt(l);
			if (hm.containsKey(ch)) {
				hm.put(ch, hm.get(ch) + 1);
			} else
				hm.put(ch, 1);

		}
		int count = hm.size();

		while (i< str1.length()) {
			char ch = str1.charAt(j);
			if (hm.containsKey(ch)) {
				hm.put(ch, hm.get(ch) - 1);
				if (hm.get(ch) == 0)
					count--;
			}
			if (count == 0) {

				while (count == 0) {
					ans = Math.min(ans, j - i + 1);				
					char ch1 = str1.charAt(i);
					if (hm.containsKey(ch1)) {
						hm.put(ch1, hm.get(ch1) + 1);
						if (hm.get(ch1) == 1)
							count++;
					}
					i++;
				}
			}
			j++;
		}

		return ans;
	}

}
