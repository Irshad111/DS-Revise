package stack;


public class StackClient {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		Stack s=new Stack();
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		s.push(50);
		//s.push(60);
		///s.push(70);
		//s.display();
		//System.out.println(s.pop());
		//System.out.println(s.pop());
		//displayReverse(s);
		//ActualReverse(s,new Stack());
		s.display();
		
		//StackClient sc=new StackClient();
		//sc.displayReverse(s);
		
		//s.display();
		//System.out.println(s.size());
		int arr[]= {7,4,0,9};
//		int ans[]=stockSpan(arr,7);
//		for(int i:ans) {
//			System.out.println(i);
//		}
		System.out.println(rainWaterTrapping(arr,4));
		


	}
	//1.
	public void displayReverse(Stack s) throws Exception {
		if(s.isEmpty())
			return;
		int temp=s.pop();
		displayReverse(s);
		System.out.println(temp);
		s.push(temp);
	}
	// 2.
	public static void ActualReverse(Stack s,Stack h) throws Exception {
		if(s.isEmpty()) {
			helper(s,h);
			return;
		}
		int temp=s.pop();
		h.push(temp);
		ActualReverse(s,h);
	}

	private static void helper(Stack s, Stack h) throws Exception {
		if(h.isEmpty())
			return;
		int temp=h.pop();
		helper(s,h);
		s.push(temp);
		
	}
	// 3 next largest element or nearest geater to right
    public static int[] nextLargerElement(int[] arr, int n) throws Exception {
    	int ans[]=new int[n];
    	Stack s=new DynamicStack();
    	for(int i=n-1;i>=0;i--) {
    		if(s.isEmpty()) {
    			ans[i]=-1;
    		}else if(s.peek()>arr[i]) {
    			ans[i]=s.peek();
    		}else {// s.peek()<=arr[i]
    			
    			while(!s.isEmpty() && s.peek()<=arr[i]) {
    				s.pop();
    			}
    			if(s.isEmpty()) {
    				ans[i]=-1;
    			}else {
    				ans[i]=s.peek();
    			}
    		}
    		s.push(arr[i]);
    	}
    	return ans;
    }
    //4. nearest greater to left
    public static int[] nearestGreaterToLeft(int[] arr, int n) throws Exception {
    	int ans[]=new int[n];
    	Stack s=new DynamicStack();
    	for(int i=0;i<n;i++) {
    		if(s.isEmpty()) {
    			ans[i]=-1;
    		}else if(s.peek()>arr[i]) {
    			ans[i]=s.peek();
    		}else {// s.peek()<=arr[i]
    			
    			while(!s.isEmpty() && s.peek()<=arr[i]) {
    				s.pop();
    			}
    			if(s.isEmpty()) {
    				ans[i]=-1;
    			}else {
    				ans[i]=s.peek();
    			}
    		}
    		s.push(arr[i]);
    	}
    	return ans;
    }
    //5 nearest smaller to left
    public static int[] nearestSmallerToLeft(int[] arr, int n) throws Exception {
    	int ans[]=new int[n];
    	Stack s=new DynamicStack();
    	for(int i=0;i<n;i++) {
    		if(s.isEmpty()) {
    			ans[i]=-1;
    		}else if(s.peek()<arr[i]) {
    			ans[i]=s.peek();
    		}else {// s.peek()>=arr[i]
    			
    			while(!s.isEmpty() && s.peek()>=arr[i]) {
    				s.pop();
    			}
    			if(s.isEmpty()) {
    				ans[i]=-1;
    			}else {
    				ans[i]=s.peek();
    			}
    		}
    		s.push(arr[i]);
    	}
    	return ans;
    }
    // 6.nearest smaller to right
    public static int[] nearestSmallerToRight(int[] arr, int n) throws Exception {
    	int ans[]=new int[n];
    	Stack s=new DynamicStack();
    	for(int i=n-1;i>=0;i--) {
    		if(s.isEmpty()) {
    			ans[i]=-1;
    		}else if(s.peek()<arr[i]) {
    			ans[i]=s.peek();
    		}else {// s.peek()>=arr[i]
    			
    			while(!s.isEmpty() && s.peek()>=arr[i]) {
    				s.pop();
    			}
    			if(s.isEmpty()) {
    				ans[i]=-1;
    			}else {
    				ans[i]=s.peek();
    			}
    		}
    		s.push(arr[i]);
    	}
    	return ans;
    }
    //7.stock span
    public static int[] stockSpan(int []arr,int n) throws Exception {
    	int ans[]=new int[n];
    	Stack s=new DynamicStack();
    	for(int i=0;i<n;i++) {
    		if(s.isEmpty()) {
    			ans[i]=i+1;//i-(-1);
    		}else if(arr[s.peek()]>arr[i]) {
    			ans[i]=i-s.peek();
    		}else {
    			while(!s.isEmpty() && arr[s.peek()]<=arr[i]) {
    				s.pop();
    			}
    			if(s.isEmpty())
    				ans[i]=i+1;
    			else
    				ans[i]=i-s.peek();
    		}
    		s.push(i);
    	}

    	return ans;
    }
    // 8. histogram
    public static int histogram(int arr[],int n)throws Exception {
    	int nsl[]=new int[n];
    	int psudoidx=-1;
    	Stack s=new DynamicStack();
    	for(int i=0;i<n;i++) {
    		if(s.isEmpty()) {
    			nsl[i]=psudoidx;
    		}else if(arr[s.peek()]<arr[i]) {
    			nsl[i]=s.peek();
    		}else {// s.peek()>=arr[i]
    			
    			while(!s.isEmpty() && arr[s.peek()]>=arr[i]) {
    				s.pop();
    			}
    			if(s.isEmpty()) {
        			nsl[i]=psudoidx;
    			}else {
    				nsl[i]=s.peek();
    			}
    		}
    		s.push(i);
    	}
    	
    	//for nsr
    	Stack s1=new DynamicStack();
    	int nsr[]=new int[n];
    	 psudoidx=n;
    	for(int i=n-1;i>=0;i--) {
    		if(s1.isEmpty()) {
    			nsr[i]=psudoidx;
    		}else if(arr[s1.peek()]<arr[i]) {
    			nsr[i]=s1.peek();
    		}else {// s.peek()>=arr[i]
    			
    			while(!s1.isEmpty() && arr[s1.peek()]>=arr[i]) {
    				s1.pop();
    			}
    			if(s1.isEmpty()) {
        			nsr[i]=psudoidx;
    			}else {
    				nsr[i]=s1.peek();
    			}
    		}
    		s1.push(i);
    	}
    	
    	int maxarea=0;
    	for(int i=0;i<n;i++) {
    		int area=(nsr[i]-nsl[i]-1)*arr[i];
    		maxarea=Math.max(area, maxarea);
    	}
    	return maxarea;

    	

    	
    }
    // m-2
    public static int histogramArea(int []arr) throws Exception {
 	   int maxarea=0;
 	   int area=0;
 	   int i=0;
 	   Stack s=new DynamicStack();
 	   while(i<arr.length) {
 		   if(s.isEmpty()||arr[s.peek()]<=arr[i]) {
 			   s.push(i);
 			   i++;
 		   }else {
 			   int top=s.pop();
 			   if(s.isEmpty()) 
 				   area=arr[top]*i;
 			   else
 				   area=arr[top]*(i-s.peek()-1);
 				   
 			   
 		   }
 		   if(maxarea<area)
 			   maxarea=area;
 			   
 	   }
 	   
 	   // if all element are not poped
 	   while(!s.isEmpty()) {
 		   int top=s.pop();
 		   if(s.isEmpty()) 
 			   area=arr[top]*i;
 		   else
 			   area=arr[top]*(i-s.peek()-1);
 			   
 		   
 	   
 	       if(maxarea<area)
 		   maxarea=area;
 		   
 	   }
 	   return maxarea;
    }
    // 9.max area rectangle in binary matrix
    public static int maxArea(int mat[][],int m,int n) throws Exception{
        //add code here.
        int temp[]=new int[mat[0].length];
		int maxarea=0,area=0;
		for(int row=0;row<mat.length;row++) {
			for(int col=0;col<mat[0].length;col++) {
				if(mat[row][col]==0) {
					temp[col]=0;
				}
				else {
					temp[col]+=mat[row][col];
				}
			}
			area=histogramArea(temp);
			if(area>maxarea) {
				maxarea=area;
			}
		}
		return maxarea;
	}
    //10.rain water trapping
    public static int rainWaterTrapping(int arr[],int n) {
    	int maxl[]=new int[n];
    	int maxr[]=new int[n];
    	maxl[0]=arr[0];
    	for(int i=1;i<n;i++) {
    	 maxl[i]= Math.max(maxl[i-1], arr[i]);
    	}
    	
    	maxr[n-1]=arr[n-1];
    	for(int i=n-2;i>=0;i--) {
    		maxr[i]=Math.max(maxr[i+1], arr[i]);
    	}
    	
    	int water[]=new int[n];
    	int sum=0;
    	for(int i=0;i<n;i++) {
    		water[i]=Math.min(maxl[i],maxr[i])-arr[i];
    		sum+=water[i];
    	}
    		
    	return sum;
    	
    }

}
