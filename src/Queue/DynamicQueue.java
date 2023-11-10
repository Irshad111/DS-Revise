package Queue;

public class DynamicQueue extends Queue {
	
	public void enqueue(int item) throws Exception {
		if(this.isFull()) {
			int oarr[]=this.data;
			int narr[]=new int[oarr.length*2];
			for(int i=0;i<oarr.length;i++) {
				narr[i]=oarr[(i+this.front)%oarr.length];
			}
			this.data=narr;
			this.front=0;
			
		}
		super.enqueue(item);
		
	}
	
	public void enqueuecheck(int item) throws Exception {
		if(this.isFull()) {
			//int oarr[]=this.data;
			int narr[]=new int[this.data.length*2];
			for(int i=0;i<this.data.length;i++) {
				narr[i]=this.data[(i+this.front)%this.data.length];
			}
			this.data=narr;
			this.front=0;
			
		}
		super.enqueue(item);
		
	}

	

}
