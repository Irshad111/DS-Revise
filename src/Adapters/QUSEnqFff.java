package Adapters;

import stack.DynamicStack;

public class QUSEnqFff {
	DynamicStack ps = new DynamicStack();

	//o(1)
	public void enqueue(int item) throws Exception {
		try {
			ps.push(item);
		} catch (Exception e) {
			throw new Exception("Queue is full");
		}
	}
 
	//o(n)
	public int dequeue() throws Exception {
		try {
			DynamicStack hs = new DynamicStack();

			while (ps.size() != 1) {
				hs.push(ps.pop());
			}
			int temp = ps.pop();
			while (!hs.isEmpty()) {
				ps.push(hs.pop());
			}
			return temp;
		} catch (Exception e) {
			throw new Exception("Queue is Empty");
		}

	}
	

	//o(n)
	public int getFront() throws Exception {
		try {
			DynamicStack hs = new DynamicStack();

			while (ps.size() != 1) {
				hs.push(ps.pop());
			}
			int temp = ps.pop();
			hs.push(temp);
			while (!hs.isEmpty()) {
				ps.push(hs.pop());
			}
			return temp;
		} catch (Exception e) {
			throw new Exception("Queue is Empty");
		}

	}

	// o(1)
	public int size() {
		return ps.size();
	}

	// o(1)
	public boolean isEmpty() {
		return ps.isEmpty();
	}

	// o(1)
	public boolean isFull() {
		return ps.isFull();
	}

	// o(n)
	public void display() throws Exception {
		try {
		if(ps.isEmpty()) {
			return;
		}
		int temp=ps.pop();
		display();
		System.out.println(temp);
		ps.push(temp);
		}catch(Exception e) {
			throw new Exception( "Error in display");
		}

	}

	

}
