package Adapters;

import Queue.DynamicQueue;
import Queue.Queue;

public class SUQPushEff {
	DynamicQueue pq=new DynamicQueue();
	//o(1);
	public void push(int item) throws Exception {
		try {
		pq.enqueue(item);
		} catch(Exception e) {
			throw new Exception("stack is full");
		}
	}
	//o(n)
	public int pop() throws Exception {
		
		try{DynamicQueue hq=new DynamicQueue();
		
		while(pq.size()!=1) {
			hq.enqueue(pq.dequeue());
		}
		
		int temp=pq.dequeue();
		pq=hq;
		return temp;
		}catch(Exception e) {
			throw new Exception("stack is empty");
		}
	
	}
	//o(n)
	public int peek() throws Exception {
		
		try{DynamicQueue hq=new DynamicQueue();
		
		while(pq.size()!=1) {
			hq.enqueue(pq.dequeue());
		}
		
		int temp=pq.dequeue();
		hq.enqueue(temp);
		pq=hq;
		return temp;
		}catch(Exception e) {
			throw new Exception("stack is empty");
		}
	
	}
	//o(1)
	public int size() {
		return pq.size();
	}
	//o(1)
	public boolean isEmpty() {
		return pq.isEmpty();
	}
	//o(1)
	public boolean isFull() {
		return pq.isFull();
	}
	
	public void display() throws Exception {
		display(0);
	}
	private void display(int count) throws Exception {
		try {
		if(count==pq.size()) {
			return;
		}
		int temp=pq.dequeue();
		pq.enqueue(temp);
		display(count+1);
		System.out.println(temp);
		}catch(Exception e) {
			throw new Exception("Error in Exception");
		}
		
		
	}



}
