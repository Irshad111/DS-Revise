package hashmap;

public class LinkedList<T> {
			private class Node {
				T data;
				Node next;
			}

			private Node head;
			private Node tail;
			private int size;

			public T getFirst() throws Exception {
				if (this.size == 0) {
					throw new Exception("LL is Empty");
				}
				return this.head.data;
			}

			public T getLast() throws Exception {
				if (this.size == 0) {
					throw new Exception("LL is Empty");
				}
				return this.tail.data;
			}

			public T getAt(int idx) throws Exception {
				if (this.size == 0) {
					throw new Exception("LL is Empty");
				}
				if (idx < 0 || idx >= this.size) {
					throw new Exception("Invalid Index");
				}
				Node temp = this.head;
				for (int i = 1; i <= idx; i++) {
					temp = temp.next;
				}
				return temp.data;

			}

			public Node getAtNode(int idx) throws Exception {
				if (this.size == 0) {
					throw new Exception("LL is Empty");
				}
				if (idx < 0 || idx >= this.size) {
					throw new Exception("Invalid Index");
				}
				Node temp = this.head;
				for (int i = 1; i <= idx; i++) {
					temp = temp.next;
				}
				return temp;

			}

			public void display() {
				System.out.println("-------------");
				Node temp = this.head;
				for (int i = 0; i < this.size; i++) {
					System.out.println(temp.data + " ");
					temp = temp.next;
				}
				System.out.println("--------------");

			}

			public void addLast(T item) {
				Node nn = new Node();
				nn.next = null;
				nn.data = item;
				if (this.size == 0) {
					this.tail = nn;
					this.head = nn;
					this.size++;
				} else {
					this.tail.next = nn;
					this.tail = nn;
					this.size++;
				}

			}

			public void addFirst(T item) {
				Node nn = new Node();
				nn.data = item;
				if (this.size == 0) {
					this.tail = nn;
					this.head = nn;
					this.size++;
				} else {
					nn.next = this.head;
					this.head = nn;
					this.size++;
				}
			}

			public void addAt(int idx, T item) throws Exception {
				if (idx < 0 || idx > this.size) {
					throw new Exception("Invalid Index");
				}
				if (idx == 0) {
					addFirst(item);
				} else if (idx == this.size) {
					addLast(item);
				} else {
					Node temp = new Node();
					temp.data = item;
					temp.next = null;
					// link
					Node nm1 = getAtNode(idx - 1);
					Node np1 = getAtNode(idx);
					nm1.next = temp;
					temp.next = np1;
					this.size++;

				}

			}

			public T removeFirst() throws Exception {
				if (size == 0) {
					throw new Exception("LL is Empty");
				}
				T Temp = this.head.data;
				if (size == 1) {
					this.head = null;
					this.tail = null;
					this.size--;

				} else {
					this.head = this.head.next;
					this.size--;
				}
				return Temp;
			}

			public T removeLast() throws Exception {
				if (size == 0) {
					throw new Exception("LL is Empty");
				}
				T Temp = this.tail.data;
				if (size == 1) {
					this.head = null;
					this.tail = null;
					this.size--;

				} else {
					Node lm1 = getAtNode(this.size - 2);
					lm1.next = null;
					this.tail = lm1;
					this.size--;
				}
				return Temp;
			}

			public T removeAt(int idx) throws Exception {
				if (size == 0) {
					throw new Exception("LL is Empty");
				}
				if (idx < 0 || idx >= this.size) {
					throw new Exception("Invalid Index");
				}
				if (idx == 0) {
					return removeFirst();
				}
				if (idx == this.size - 1) {
					return removeLast();
				} else {
					Node prev = getAtNode(idx - 1);
					Node self = prev.next;
					Node ahead = self.next;
					prev.next = ahead;
					this.size--;
					return self.data;
				}
			}
			public int find(T item) {
				int idx=0;
				for(Node temp=this.head;temp!=null;temp=temp.next) {
					if(temp.data.equals(item)) {
						return idx;
					}
					idx++;
				}
				return-1;
			}
			public boolean  isEmpty() {
				return this.size==0;
			}




}
