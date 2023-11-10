package stack;

public class Stack {
	protected int[] data;
	protected int tos;

	public Stack() {
		this.data = new int[5];
		this.tos = -1;
	}

	public Stack(int cap) {
		this.data = new int[cap];
		this.tos = -1;
	}

	public void push(int item) throws Exception {
		if (isFull()) {
			throw new Exception("stack is full");
		}
		this.tos++;
		this.data[this.tos] = item;

	}

	public boolean isFull() {
		return this.tos + 1 == this.data.length;
	}

	public int pop() throws Exception {
		if (isEmpty()) {
			throw new Exception("Stack is empty");
		}
		int rm=this.data[this.tos];
		this.tos--;
		return rm;
	}
	public int peek() throws Exception {
		if (isEmpty()) {
			throw new Exception("Stack is empty");
		}
		int rm=this.data[this.tos];
		return rm;
	}

	public boolean isEmpty() {
		return this.tos==-1;
	}

	public int size() {
		return this.tos+1;
	}
	public void display() {
		System.out.println("-------------");
		for(int i=tos;i>=0;i--) {
			System.out.println(this.data[i]);
			
		}
		System.out.println("--------------");
	}
}
