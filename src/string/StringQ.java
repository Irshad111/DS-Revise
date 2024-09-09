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

	// 6.  manachers algo to count all palindromic algo or longest palindroic algo
	public static int manachers(String str) {
		int max=0;
		//odd
		for(int axis = 0; axis < str.length(); axis++){
			for(int orb = 0; (axis - orb) >= 0 && (axis + orb) < str.length(); orb++){
				if(str.charAt(axis - orb) == str.charAt(axis + orb)){
					max=Math.max(max, 2 * orb + 1);
				}else{
					break;
				}
			}
		}
		//even
		for(double axis = 0.5; axis < str.length(); axis++){
			for(double orb = 0.5; (axis - orb) >= 0 && (axis + orb) < str.length(); orb++){
				if(str.charAt((int)(axis - orb)) == str.charAt((int)(axis + orb))){
					max=Math.max(max, (int)(2 * orb));
				}else{
					break;
				}
			}
		}
		return max;
	}

	// 7. KMP
	/**
	 * Slow method of pattern matching
	 */
	public boolean hasSubstring(char[] text, char[] pattern){
		int i=0;
		int j=0;
		int k = 0;
		while(i < text.length && j < pattern.length){
			if(text[i] == pattern[j]){
				i++;
				j++;
			}else{
				j=0;
				k++;
				i = k;
			}
		}
		if(j == pattern.length){
			return true;
		}
		return false;
	}

	/**
	 * Compute temporary array to maintain size of suffix which is same as prefix
	 * Time/space complexity is O(size of pattern)
	 */
	private int[] computeTemporaryArray(char pattern[]){
		int [] lps = new int[pattern.length];
		int j =0;
		for(int i=1; i < pattern.length;){
			if(pattern[i] == pattern[j]){
				lps[i] = j + 1;
				j++;
				i++;
			}else{
				if(j != 0){
					j = lps[j-1];
				}else{
					lps[i] =0;
					i++;
				}
			}
		}
		return lps;
	}

	/**
	 * KMP algorithm of pattern matching.
	 */
	public boolean KMP(char []text, char []pattern){

		int lps[] = computeTemporaryArray(pattern);
		int i=0;
		int j=0;
		while(i < text.length && j < pattern.length){
			if(text[i] == pattern[j]){
				i++;
				j++;
			}else{
				if(j!=0){
					j = lps[j-1];
				}else{
					i++;
				}
			}
		}
		if(j == pattern.length){
			return true;
		}
		return false;
	}


}
