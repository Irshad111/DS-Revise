package Adapters;

import stack.DynamicStack;

public class QUSDeqEff {
	DynamicStack ps = new DynamicStack();

	// o(1)
	public int Dequeue() throws Exception {
		try {
			int temp = ps.pop();
			return temp;
		} catch (Exception e) {
			throw new Exception("Queue is empty");
		}

	}

	// o(1)
	public int getFront() throws Exception {
		try {

			return ps.peek();
		} catch (Exception e) {
			throw new Exception("Queue is empty");
		}

	}

	// o(n)
	public void enqueue(int item) throws Exception {
		try {
			DynamicStack hs = new DynamicStack();
			while (!ps.isEmpty()) {
				hs.push(ps.pop());
			}
			hs.push(item);
			while (!hs.isEmpty()) {
				ps.push(hs.pop());
			}

		} catch (Exception e) {
			throw new Exception("Queue is full");
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
	public void display() {
		ps.display();
	}

}
