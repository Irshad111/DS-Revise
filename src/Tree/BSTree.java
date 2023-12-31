package Tree;


public class BSTree {
	
	private class Node{
		int data;
		Node left;

		Node right;
	}
	private Node root;
    // M 2 if in order given
	public BSTree(int[] in) {
		this.root = construct(in, 0, in.length - 1);
	}

	private Node construct(int[] in, int lo, int hi) {
		if (lo > hi) {
			return null;
		}
		int mid = (lo + hi) / 2;
		Node nn = new Node();
		nn.data = in[mid];
		nn.left = construct(in, lo, mid - 1);
		nn.right = construct(in, mid + 1, hi);
		return nn;
	}
	public void display() {
		System.out.println("----------");
		display(this.root);
		System.out.println("----------");
	}

	private void display(Node node) {
		if (node == null) {
			return;
		}
		String str = "";
		if (node.left != null) {
			str += node.left.data + " <- ";
		} else {
			str += ".";
		}
		str += node.data;
		if (node.right != null) {
			str += " -> " + node.right.data;
		} else {
			str += ".";
		}
		System.out.println(str);
		display(node.left);
		display(node.right);

	}

	public int size() {
		return size(this.root);
	}

	private int size(Node node) {
		if (node == null) {
			return 0;
		}
		int ls = size(node.left);
		int rs = size(node.right);
		return ls + rs + 1;
	}
	public int max() {
		return max(this.root);
	}

	private int max(Node node) {
		if (node.right == null)
			return node.data;
		return max(node.right);
	}
	public boolean find(int item) {
		return find(this.root, item);
	}

	private boolean find(Node node, int item) {
		if (node == null)
			return false;
		if (node.data == item) {
			return true;
		} else if (node.data > item) {
			return find(node.left, item);
		} else {
			return find(node.right, item);
		}
	}

	public int ht() {
		return ht(this.root);
	}

	private int ht(Node node) {
		if (node == null) {
			return -1;
		}
		int lh = ht(node.left);
		int rh = ht(node.right);
		return Math.max(lh, rh) + 1;

	}
	public void printInRange(int lo, int hi) {
		printInRange(this.root, lo, hi);
		System.out.println();
	}

	private void printInRange(Node node, int lo, int hi) {
		if (node == null) {
			return;
		}
		if (node.data < lo) {
			printInRange(node.right, lo, hi);
		}
		if (node.data > hi) {
			printInRange(node.left, lo, hi);
		}
		if (node.data >= lo && node.data <= hi) {
			printInRange(node.left, lo, hi);

			System.out.print(node.data + " ");

			printInRange(node.right, lo, hi);
		}

	}

	public void printDec() {
		printDec(this.root);
		System.out.println();
	}

	private void printDec(Node node) {
		if (node == null) {
			return;
		}
		printDec(node.right);
		System.out.print(node.data + " ");
		printDec(node.left);

	}
	private class HeapMover {
		int sum = 0;
	}

	public void replaceWithSumLarger() {
		replaceWithSumLarger(this.root, new HeapMover());
	}

	private void replaceWithSumLarger(Node node, HeapMover mover) {

		if (node == null) {
			return;
		}

		replaceWithSumLarger(node.right, mover);

		int temp = node.data;
		node.data = mover.sum;
		mover.sum += temp;

		replaceWithSumLarger(node.left, mover);

	}
	public void add(int item) {
		addReturn(this.root, item);
	}

	private void add(Node node, int item) {
		// right
		if (item > node.data) {
			if (node.right == null) {
				Node nn = new Node();
				nn.data = item;
				node.right = nn;
			} else {
				add(node.right, item);
			}
		} else {// left
			if (node.left == null) {
				Node nn = new Node();
				nn.data = item;
				node.left = nn;
			} else {
				add(node.left, item);
			}
		}

	}
	private Node addReturn(Node node, int item) {

		if (node == null) {
			Node nn = new Node();
			nn.data = item;
			return nn;
		}

		if (item <= node.data) {
			node.left = addReturn(node.left, item);
		} else {
			node.right = addReturn(node.right, item);
		}

		return node;

	}
	public void remove(int item) {
		remove(this.root, null, item);
	}

	private void remove(Node node, Node parent, int item) {
		if(node==null) {
			return;
		}
		if (item < node.data) {
			remove(node.left, node, item);
		} else if (item > node.data) {
			remove(node.right, node, item);
		} else {
			if (node.left == null && node.right == null) {
				if (node.data > parent.data) {
					parent.right = null;
				} else {
					parent.left = null;
				}
			} else if (node.left == null && node.right != null) {
				if (node.data > parent.data) {
					parent.right = node.right;
				} else {
					parent.left = node.right;
				}
			} else if (node.left != null && node.right == null) {
				if (node.data > parent.data) {
					parent.right = node.left;
				} else {
					parent.left = node.left;
				}

			} else {
				int lmax = max(node.left);
				node.data = lmax;
				remove(node.left, node, lmax);
			}

		}

	}
	Node deleteNode(Node root, int key) 
    {
	    // Your code here
	    if(root==null){
	        return null;
	    }
	    if(root.data>key){
	        root.left=deleteNode(root.left,key);
	    }else if(root.data<key){
	        root.right=deleteNode(root.right,key);
	    }else{
	        // if node have one one node or no node
	        if(root.left==null){
	            return root.right;
	        }else if(root.right==null){
	            return root.left;
	        }else{// if node have both node
	            root.data=max(root.left);
	            root.left=deleteNode(root.left,root.data);
	            
	        }
	    }
	   return root;
    }
	/*
	 * // Java program to demonstrate insert operation in binary search tree 
	class BinarySearchTree { 
	  
	    /* Class containing left and right child of current node and key value
	    class Node { 
	        int key; 
	        Node left, right; 
	  
	        public Node(int item) { 
	            key = item; 
	            left = right = null; 
	        } 
	    } 
	  
	    // Root of BST 
	    Node root; 
	  
	    // Constructor 
	    BinarySearchTree() {  
	        root = null;  
	    } 
	  
	    // This method mainly calls insertRec() 
	    void insert(int key) { 
	       root = insertRec(root, key); 
	    } 
	      
	    /* A recursive function to insert a new key in BST 
	    Node insertRec(Node root, int key) { 
	  
	        /* If the tree is empty, return a new node 
	        if (root == null) { 
	            root = new Node(key); 
	            return root; 
	        } 
	  
	        /* Otherwise, recur down the tree 
	        if (key < root.key) 
	            root.left = insertRec(root.left, key); 
	        else if (key > root.key) 
	            root.right = insertRec(root.right, key); 
	  
	        /* return the (unchanged) node pointer 
	        return root; 
	    } 
	  
	    // This method mainly calls InorderRec() 
	    void inorder()  { 
	       inorderRec(root); 
	    } 
	  
	    // A utility function to do inorder traversal of BST 
	    void inorderRec(Node root) { 
	        if (root != null) { 
	            inorderRec(root.left); 
	            System.out.println(root.key); 
	            inorderRec(root.right); 
	        } 
	    } 
	  
	    // Driver Program to test above functions 
	    public static void main(String[] args) { 
	        BinarySearchTree tree = new BinarySearchTree(); 
	  
	        /* Let us create following BST 
	              50 
	           /     \ 
	          30      70 
	         /  \    /  \ 
	       20   40  60   80 
	        tree.insert(50); 
	        tree.insert(30); 
	        tree.insert(20); 
	        tree.insert(40); 
	        tree.insert(70); 
	        tree.insert(60); 
	        tree.insert(80); 
	  
	        // print inorder traversal of the BST 
	        tree.inorder(); 
	    } 
	}
	*/












}
