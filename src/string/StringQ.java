package string;

public class StringQ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 1.
	public static boolean ispalindromic(String str) {
		int left = 0;
		int right = str.length() - 1;
		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	// 2.
	public static void subString(String str) {
		for (int si = 0; si < str.length(); si++) {
			for (int hi = si + 1; hi <= str.length(); hi++) {
				System.out.println(str.substring(si, hi));
			}
		}
	}
	
	//3.
	public static void permutation(String que, String ans) {
		if (que.length() == 0) {
			System.out.println(ans);
			return;
		}
		for (int i = 0; i < que.length(); i++) {
			char ch = que.charAt(i);
			String ros = que.substring(0, i) + que.substring(i + 1);
			permutation(ros, ans + ch);
		}
	}

	// no dublicate result
	public static void permutationNoDup(String que, String ans) {
		if (que.length() == 0) {
			System.out.println(ans);
			return;
		}
		boolean[] track = new boolean[256];
		for (int i = 0; i < que.length(); i++) {
			char ch = que.charAt(i);
			String ros = que.substring(0, i) + que.substring(i + 1);
			if (!track[(int) ch]) {
				permutationNoDup(ros, ans + ch);
				track[(int) ch] = true;
			}
		}
	}
	// 4.anagram
	public static boolean isAnagram(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		int temp[] = new int[256];
		for (int i = 0; i < str1.length(); i++) {
			temp[(int) str1.charAt(i)] += 1;
		}
		for (int i = 0; i < str2.length(); i++) {
			temp[(int) str2.charAt(i)] -= 1;
		}
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] != 0) {
				return false;
			}
		}
		return true;
	}
	//5.
	// remove all duplicate in string
	public static String removeduplicate(String str) {
		boolean temp[] = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			temp[(int) str.charAt(i)] = true;
		}
		String str1 = "";
		for (int i = 0; i < str.length(); i++) {
			if (temp[str.charAt(i)]) {
				str1 += str.charAt(i);
				temp[str.charAt(i)] = false;

			}
		}
		return str1;

	}




}
