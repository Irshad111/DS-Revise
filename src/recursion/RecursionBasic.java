package recursion;

import java.util.ArrayList;
import java.util.Stack;

public class RecursionBasic {
	public static int glob=0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {2,3,4,2,5,2};
		int arr1[]=allIndex(arr,2,0,0);
		for(int i:arr1)
			System.out.println(i);
		
		int arr2[]=allIndexGlobal(arr,2,0);
		for(int i:arr2)
			System.out.println(i);
		
		ArrayList<Integer> list=allIndexArrList(arr,2,0);
		System.out.println(list);

		

	}
	// 1. print decreasing number
	// doing work while stack is bulding
	public static void printDec(int n) {
		if(n==0) {
			return;
		}
		System.out.println(n);
		printDec(n-1);
	}
	//2. print Increasing number
	// doing work while stack is falling
	public static void printInc(int n) {
		if(n==0) {
			return;
		}
		printInc(n-1);
		System.out.println(n);

	}
	// 3. print Dec & Inc
	// doing work before a call and after a call
	public static void printDI(int n) {
		if(n==0) {
			return;
		}
		System.out.println(n);
		printDI(n-1);
		System.out.println(n);

	}
	// 4. skip some work or skipDI
	public static void skipDI(int n) {
		if(n==0) {
			return;
		}
		if(n%2==1)
		System.out.println(n);
		printDI(n-1);
		if(n%2==0)
		System.out.println(n);

	}
	// 5. factorial
	public static int fact(int n) {
		if(n==1 || n==0)
			return 1;
		int ans=n*fact(n-1);
		return ans;
	}
	// 6. power 
	public static int power(int x,int n) {
		if(n==0)
			return 1;
		int ans=x*power(x,n-1);
		return ans;
		
	}
	// 7. fiboncii
	public  static int fib(int n) {
		if(n==0 || n==1) {
			return n;
		}
		int f1=fib(n-1);
		int f2=fib(n-2);
		int ans=f1+f2;
		return ans;
	}
	// 8.whether a array is sorted or not
	public static boolean isSorted(int []arr, int si) {
		if(si==arr.length-1) {
			return true;
		}
		
		if(arr[si]>arr[si+1])
			return false;
		return isSorted(arr,si+1);
		
	}
	// 9. first index
	public static int atFirstIndex(int[] arr, int item, int vidx) {
		if (vidx == arr.length) {
			return -1;
		}
		if (arr[vidx] == item )
			return vidx;


		int recans = atFirstIndex(arr, item, vidx + 1);
		return recans;
	}
	// 10.last index
	public static int atLastIndex(int[] arr, int item, int vidx) {
		if (vidx == arr.length) {
			return -1;
		}

		int recans = atLastIndex(arr, item, vidx + 1);
		if (arr[vidx] == item && recans == -1)
			return vidx;
		return recans;
	}
	// 11. all index
	public static int[] allIndex(int arr[],int item,int vidx,int count) {
		if(vidx==arr.length) {
			int []bc=new int[count];
			return bc;
		}
		if(arr[vidx]==item) {
		int [] recans=allIndex(arr,item,vidx+1,count+1);
		recans[count]=vidx;
		return recans;
		}else {
			return allIndex(arr,item,vidx+1,count);
		}
	}
	// using global variable
	public static int[] allIndexGlobal(int arr[],int item,int vidx) {
		if(arr.length==vidx) {
			int []bc=new int[glob];
			return bc;
		}
		if(arr[vidx]==item) {
			glob++;
		}
		int recans[]=allIndexGlobal(arr,item,vidx+1);
		if(arr[vidx]==item) {
			glob--;
			recans[glob]=vidx;
		}
		return recans;
	}
	// using ArrayList
	public static ArrayList<Integer> allIndexArrList(int arr[],int item,int vidx) {
		if(vidx==arr.length) {
			ArrayList<Integer> bc=new ArrayList<>();
			return bc;
		}
		ArrayList<Integer> recans=allIndexArrList(arr,item,vidx+1);
		if(arr[vidx]==item) {
			recans.add(0,vidx);
		}
		return recans;
	}
	// bubble sort
	
	public static void bubbleSort(int arr[],int si,int ei) {
		if(ei==0) {
			return;
		}
		if(si==ei) {
			bubbleSort(arr,0,ei-1);
		}
		if(arr[si]>arr[si+1]) {
			int temp=arr[si];
			arr[si]=arr[si+1];
			arr[si+1]=temp;
		}
		bubbleSort(arr,si+1,ei);
	}
	
	// stack sort using recursion

	public void sort(Stack<Integer> s)
	{
		//add code here.
		if(s.isEmpty()){
		    return;
		}
		
		int temp=s.pop();
		sort(s); 
		insert(s,temp);
	}
	private static void insert(Stack<Integer> s,int ele){
	    if(s.isEmpty() || s.peek()<=ele){
	        s.push(ele);
	        return;
	    }
	    int temp=s.pop();
	    insert(s,ele);
	    s.push(temp);
	}
	// dlelete middle elemenet of stack
	
	public static void deleteMid(Stack<Integer> s,int count) {
		if(s.isEmpty()) {
			return;
		}
		int temp=s.pop();
		deleteMid(s,count+1);
		if(count!=s.size()/2) {
			s.push(temp);
		}
	}
	
	// josephas problem
	static int safePos(int n, int k) {
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=1;i<=n;i++){
            list.add(i);
        }
        
      return solve(list,k-1,0); 
    }
    static int solve(ArrayList<Integer> list,int k,int idx){
        if(list.size()==1){
            return list.get(0);
        }
        
        idx=(idx+k)%list.size();
        list.remove(idx);
        return solve(list,k,idx);
        
    }
    // generate all balance parentheses
    public  static void balancePare(int open,int close,String ans) {
    	if(open==0 && close ==0) {
    		System.out.println(ans);
    	}
    	if(open!=0) {
    		balancePare(open-1,close,ans+"(");
    	}
    	if(close>open) {
    		balancePare(open,close-1,ans+")");
    	}
    }

	

	


	



}
