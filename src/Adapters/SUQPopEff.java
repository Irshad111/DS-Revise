package Adapters;

import Queue.DynamicQueue;

public class SUQPopEff {
	DynamicQueue pq = new DynamicQueue();
	//o(1)
	public int pop() throws Exception {
		try {
		return pq.dequeue();
		}catch(Exception e) {
			throw new Exception("Stack is empty");
		}
	}
	//o(1)
	
	public int peek() throws Exception {
		try {
		return pq.getFront();
		}catch(Exception e) {
			throw new Exception("Stack is empty");
		}
	}
	//o(n)
	public void push(int item) throws Exception {
		try {
		DynamicQueue hq=new DynamicQueue();
		hq.enqueue(item);
		
		while(pq.size()!=0) {
			hq.enqueue(pq.dequeue());
		}
		pq=hq;
		}catch(Exception e) {
			throw new Exception("Stack is full");
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
	
	//o(n)
	public void display() {
		pq.display();
	}



}
