package LinkedList;

public class LLQ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private class Node {
		Node next;
		int data;
		Node left;
		Node right;
		Node bottom;
	}

	// 1. Delete without head pointer
	void deleteNode(Node node) {
		Node temp = node.next;
		node.data = temp.data;
		node.next = temp.next;
		temp = null;
	}

	// 2.merge sort
	static Node mergeSort(Node head) {
		if (head == null || head.next == null) {
			return head;
		}

		Node middle = getMid(head);
		Node nextofmiddle = middle.next;

		middle.next = null;
		Node left = mergeSort(head);

		Node right = mergeSort(nextofmiddle);
		Node sortedlist = sortedMerge(left, right);
		return sortedlist;

	}

	public static Node sortedMerge(Node a, Node b) {
		Node result = null;

		if (a == null)
			return b;
		if (b == null)
			return a;

		if (a.data <= b.data) {
			result = a;
			result.next = sortedMerge(a.next, b);
		} else {
			result = b;
			result.next = sortedMerge(a, b.next);
		}
		return result;
	}

	public static Node getMid(Node h) {

		if (h == null)
			return h;
		Node fastptr = h;
		Node slowptr = h;

		while (fastptr.next != null && fastptr.next.next != null) {

			slowptr = slowptr.next;
			fastptr = fastptr.next.next;

		}
		return slowptr;
	}

	// 3. rverse a linked list
	Node reverseList(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node prev = head;
		Node curr = prev.next;
		while (curr != null) {
			Node ahead = curr.next;
			curr.next = prev;
			prev = curr;
			curr = ahead;
		}
		head = prev;
		return head;
	}

	// 4. nth from last
	int getNthFromLast(Node head, int n) {
		if (head == null) {
			return -1;
		}
		Node fast = head;
		Node slow = head;
		int count = 1;
		while (count <= n) {
			if (fast == null) {
				return -1;
			}
			fast = fast.next;
			count++;
		}
		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow.data;
	}

	// detect loop
	public static boolean loop(Node head) {
		if (head == null) {
			return false;
		}
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow) {
				return true;
			}

		}
		return false;
	}

	// 5. remove loop from the linkedlist
	public static void removeTheLoop(Node head) {
		if (head == null ) {
			return;
		}
		Node slow = head;
		Node fast = head;
		
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
			
		}
		if (slow == fast) {
			slow = head;
			if(slow!=fast){
				while(fast.next!=slow.next){
					slow = slow.next;
					fast = fast.next;
				}
				fast.next=null;
			}else {
				while(fast.next!=slow) {// when loop at head node
					fast=fast.next;
				}
				fast.next=null;
			}
		}
	}

	// 6. remove duplicate element from sorted linkedlist
	Node removeDuplicates(Node root) {
		// Your code here
		if (root == null || root.next == null) {
			return root;
		}
		Node prev = root;
		Node curr = root.next;
		while (curr != null) {
			if (prev.data == curr.data) {
				prev.next = curr.next;
				curr = curr.next;
			} else {
				curr = curr.next;
				prev = prev.next;
			}
		}
		return root;

	}

	// 7 binary tree to Dll
	Node head;

	Node bToDLL(Node root) {
		// Your code here
		// logic reverse inorder traversal
		if (root == null) {
			return null;
		}
		bToDLL(root.right);
		root.right = head;
		if (head != null) {
			head.left = root;
		}
		head = root;
		bToDLL(root.left);
		return head;
	}

	// 8 . linkedlist is palindrome or not
	boolean isPalindrome(Node head) {
		// Your code here

		Heapmover mover = new Heapmover();
		mover.left = head;
		boolean ans = ispalindrome(mover, head);
		return ans;
	}

	private class Heapmover {
		Node left;

	}

	private static boolean ispalindrome(Heapmover mover, Node right) {
		if (right == null) {
			return true;
		}
		boolean res = ispalindrome(mover, right.next);
		if (!res || mover.left.data != right.data) {
			return false;
		}
		mover.left = mover.left.next;
		return true;
	}

	// 9. flatting a linked list
	Node flatten(Node root) {
		if (root == null || root.next == null) {
			return root;
		}
		Node right = flatten(root.next);
		Node recans = mergetolist(root, right);
		return recans;
	}

	private static Node mergetolist(Node one, Node two) {
		if (one == null)
			return two;
		if (two == null)
			return one;
		Node result = null;
		if (one.data < two.data) {
			result = one;
			result.bottom = mergetolist(one.bottom, two);
		} else {
			result = two;
			result.bottom = mergetolist(one, two.bottom);
		}
		return result;
	}

	// 10. reverse in group in k
	public static Node reverse(Node node, int k) {
		if (node == null || node.next == null || k == 1) {
			return node;
		}
		Node prv = null;
		Node curr = node;
		Node ahead = null;
		int count = 0;
		while (count < k && curr != null) {
			ahead = curr.next;
			curr.next = prv;
			prv = curr;
			curr = ahead;
			count++;
		}
		if (curr != null)
			node.next = reverse(curr, k);
		return prv;// this i head

	}

}
