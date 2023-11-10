package heap;

public class BinaryHeap{
	private int []data;
	private int size;
	BinaryHeap(){
		this.data=new int[10];
		this.size=0;
	}
	BinaryHeap(int cap){
		this.data=new int[cap];
		this.size=0;
	}
	public int size() {
		return this.size;
	}
	public boolean isEmpty() {
		return this.size==0;
	}
	public void add(int item) {
		this.data[this.size]=item;
		upheapify(this.size);
		this.size++;
		
	}
	private void upheapify(int ci) {
		int pi=(ci-1)/2;
		if(this.data[ci]<this.data[pi]) {
			swap(ci,pi);
			upheapify(pi);
		}
		
	}
	private void swap(int ci, int pi) {
		int temp=this.data[ci];
		this.data[ci]=this.data[pi];
		this.data[pi]=temp;
		
	}
	public int remove() {
		swap(0,this.size-1);
		int rm=this.data[this.size-1];
		this.data[this.size-1]=0;
		this.size--;
		downheap(0);
		return rm;
	}
	private void downheap(int pi) {
		int lc=2*pi+1;
		int rc=2*pi+2;
		int min=pi;
		if(lc<this.size && this.data[lc]<this.data[min]) {
			min=lc;
		}
		if(rc<this.size && this.data[rc]<this.data[min]) {
			min=rc;
		}
		if(min!=pi) {
			swap(min,pi);
			downheap(min);
		}
		
		
	}
	public void display() {
		for(int i=0;i<this.size;i++) {
			System.out.print(this.data[i]+" ");
		}
		System.out.println();
	}

}

	
