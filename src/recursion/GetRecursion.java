package recursion;

import java.util.ArrayList;

public class GetRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list=getss("abc");
		ArrayList<String> list1=permutation("abc");
		ArrayList<String> list2=boardPath(0,10);
		ArrayList<String> list3=mazePath(0,0,2,2);


		System.out.println(list3);
		

	}
	public static ArrayList<String> getss(String str){
		if(str.length()==0) {
			ArrayList<String> bans=new ArrayList<>();
			bans.add("");
			return bans;
		}
		char ch=str.charAt(0);
		String ros=str.substring(1);
		ArrayList<String> reans=getss(ros);
		ArrayList<String> ans=new ArrayList<>();
		for(String val:reans) {
			ans.add(val);
			ans.add(ch+val);
		}
		return ans;
		
	}
	public static ArrayList<String> permutation(String str){
		if(str.length()==0) {
			ArrayList<String> bans=new ArrayList<>();
			bans.add("");
			return bans;
			
		}
		char ch=str.charAt(0);
		String ros=str.substring(1);
		ArrayList<String> recans=permutation(ros);
		ArrayList<String> ans=new ArrayList<>();
		for(String rr:recans) {
			for(int i=0;i<=rr.length();i++) {
				ans.add(rr.substring(0,i)+ch+rr.substring(i));
			}
		}
		return ans;
	}
	public static String getCode(char ch) {

		if (ch == '1')
			return "abc";
		else if (ch == '2')
			return "def";
		else if (ch == '3')
			return "ghi";
		else if (ch == '4')
			return "jk";
		else if (ch == '5')
			return "lmno";
		else if (ch == '6')
			return "pqr";
		else if (ch == '7')
			return "stu";
		else if (ch == '8')
			return "vwx";
		else if (ch == '9')
			return "yz";
		else if (ch == '0')
			return "@#";
		else
			return "";
	}

	public static ArrayList<String> kpc(String str) {
		if (str.length() == 0) {
			ArrayList<String> bres = new ArrayList<>();
			bres.add("");
			return bres;

		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> reans=kpc(ros);
		ArrayList<String> ans=new ArrayList<>();
		String code=getCode(ch);
		for(String rr:reans) {
			for(int i=0;i<code.length();i++) {
				ans.add(code.charAt(i)+rr);
			}
		}
		return ans;
	}
	public static ArrayList<String> boardPath(int curr,int end){
		if(curr==end) {
			ArrayList<String> br=new ArrayList<>();
			br.add("\n");
			return br;
		}
		if(curr>end) {
			ArrayList<String> brn=new ArrayList<>();
			return brn;
		}

		
		ArrayList<String> myans=new ArrayList<>();
		for(int dice=1;dice<=6;dice++) {
			ArrayList<String> reans=boardPath(curr+dice,end);
			for(String rr:reans) {
				myans.add(dice+rr);
			}
		}
		return myans;
	}
	public static ArrayList<String> coinToss(int n) {
		if (n == 0) {
			ArrayList<String> bares = new ArrayList<>();
			bares.add("");
			return bares;
		}
		ArrayList<String> myans = new ArrayList<>();
		ArrayList<String> recres = coinToss(n - 1);
		for (String rr : recres) {
			myans.add("H" + rr);
			myans.add("T" + rr);
		}
		return myans;
	}
	public static ArrayList<String> mazePath(int cr,int cc,int er,int ec){
		if(cr==er && cc==ec) {
			ArrayList<String> bres=new ArrayList<>();
			bres.add("");
			return bres;
		}
		
		if(cr>er || cc>ec) {
			ArrayList<String> bres=new ArrayList<>();
			return bres;
		
		}
		
		ArrayList<String> myans=new ArrayList<>();
		ArrayList<String> reresh=mazePath(cr,cc+1,er,ec);
		for(String rr:reresh) {
			myans.add("H"+rr);
		}
		ArrayList<String> reresv=mazePath(cr+1,cc,er,ec);
		for(String rr:reresv) {
			myans.add("V"+rr);
		}
		return myans;

	}
	public static ArrayList<String> mazePathDig(int cr,int cc,int er,int ec){
		if(cr==er && cc==ec) {
			ArrayList<String> bres=new ArrayList<>();
			bres.add("");
			return bres;
		}
		
		if(cr>er || cc>ec) {

			ArrayList<String> bres=new ArrayList<>();
			return bres;
		
		}
		
		ArrayList<String> myans=new ArrayList<>();
		ArrayList<String> reresh=mazePathDig(cr,cc+1,er,ec);
		for(String rr:reresh) {
			myans.add("H"+rr);
		}
		ArrayList<String> reresv=mazePathDig(cr+1,cc,er,ec);
		for(String rr:reresv) {
			myans.add("V"+rr);
		}
		ArrayList<String> reresd=mazePathDig(cr+1,cc+1,er,ec);
		for(String rr:reresd) {
			myans.add("D"+rr);
		}

		return myans;

	}
	
	public static ArrayList<String> mazePathML(int cr, int cc, int er, int ec) {
		if (cr == er && cc == ec) {
			ArrayList<String> bsres = new ArrayList<>();
			bsres.add("");
			return bsres;
		}
		ArrayList<String> myans = new ArrayList<>();
		
		
		for(int move=1;move<=ec-cc;move++) 
		{
		ArrayList<String> recresh = mazePathML(cr, cc + move, er, ec);
		for (String val : recresh) {
			myans.add("H" + move+ val);
		}
		
		}
		
		for(int move=1;move<=er-cr;move++) {
		ArrayList<String> recresv = mazePathML(cr + move, cc, er, ec);
		for (String val : recresv) {
			myans.add("V" +move+val);
		}
		}
		for(int move=1;move<=(er-cr)&&move<=(ec-cc);move++) {

		ArrayList<String> recresd = mazePathML(cr + move, cc + move, er, ec);
		for (String val : recresd) {
			myans.add("D" +move+ val);
		}
	}
		return myans;
	}






}
