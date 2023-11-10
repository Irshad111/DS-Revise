package Tree;

import java.util.Scanner;
import java.util.Stack;

public class BTree {

	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;

	Scanner sc = new Scanner(System.in);

	public BTree() {
		this.root = construct(null, false);
	}

	private Node construct(Node parent, boolean ilc) {
		if (parent == null)
			System.out.println("Enter data for root node");
		else {
			if (ilc) {
				System.out.println("Enter data for left child of " + parent.data);
			} else {
				System.out.println("Enter data for right child of " + parent.data);
			}
		}
		int item = sc.nextInt();
		Node nn = new Node();
		nn.data = item;
		System.out.println(nn.data + " has left child?");

		boolean hlc = sc.nextBoolean();
		if (hlc) {
			nn.left = construct(nn, true);
		}

		System.out.println(nn.data + " has right child?");

		boolean hrc = sc.nextBoolean();
		if (hrc) {
			nn.right = construct(nn, false);
		}

		return nn;
	}

	// o(n)
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

		if (node == null) {
			return Integer.MIN_VALUE;
		}
		int tm = node.data;// total max
		int lm = max(node.left);
		if (lm > tm)
			tm = lm;
		int rm = max(node.right);
		if (rm > tm)
			tm = rm;
		return tm;
	}

	public boolean find(int item) {
		return find(this.root, item);
	}

	private boolean find(Node node, int item) {
		if (node == null) {
			return false;
		}
		if (node.data == item) {
			return true;
		}
		boolean lc = find(node.left, item);
		if (lc) {
			return true;
		}
		boolean rc = find(node.right, item);
		if (rc) {
			return true;
		}
		return false;

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

	// using global varibale
	// o(n^2)
	private int diameterans = Integer.MIN_VALUE;

	public int diameter1() {
		diameter1(this.root);
		return diameterans;
	}

	private void diameter1(Node node) {
		if (node == null) {
			return;
		}
		int diameter = ht(node.left) + ht(node.right) + 2;
		diameterans = Math.max(diameterans, diameter);
		diameter1(node.left);
		diameter1(node.right);

	}

	// m2
	public int diameter2() {
		return diameter2(this.root);
	}

	// o(n^2)
	private int diameter2(Node node) {
		if (node == null) {
			return 0;
		}
		int ld = diameter2(node.left);
		int rd = diameter2(node.right);
		int sd = ht(node.left) + ht(node.right) + 2;

		return Math.max(sd, Math.max(ld, rd));
	}

	// m3 in o(n)
	private class DiaPair {
		int ht = -1;
		int diameter = 0;
	}

	public int diameter3() {
		return diameter3(this.root).diameter;
	}

	private DiaPair diameter3(Node node) {
		if (node == null) {
			return new DiaPair();
		}
		DiaPair ldp = diameter3(node.left);
		DiaPair rdp = diameter3(node.right);
		DiaPair ndp = new DiaPair();
		ndp.ht = Math.max(ldp.ht, rdp.ht) + 1;

		int ld = ldp.diameter;
		int rd = rdp.diameter;
		int sd = ldp.ht + rdp.ht + 2;
		ndp.diameter = Math.max(Math.max(ld, rd), sd);

		return ndp;
	}

	private class BalPair {
		int ht = -1;
		boolean isbal = true;
	}

	public boolean isBalance() {
		return isBalance(this.root).isbal;
	}

	private BalPair isBalance(Node node) {
		if (node == null) {
			return new BalPair();
		}
		BalPair lbp = isBalance(node.left);
		BalPair rbp = isBalance(node.right);
		BalPair nbp = new BalPair();
		nbp.ht = Math.max(lbp.ht, rbp.ht) + 1;
		int bf = Math.abs(lbp.ht - rbp.ht);
		if (lbp.isbal && rbp.isbal && bf <= 1)
			nbp.isbal = true;
		else
			nbp.isbal = false;
		return nbp;
	}

	public class Pairsum{
		int max=Integer.MIN_VALUE;
		int sum=0;
	}
	public int maxSubTreeSum() {
		return maxSubTreeSum(this.root).max;
	}

	private Pairsum maxSubTreeSum(Node node) {
		if(node==null) {
			return new Pairsum();
		}
		Pairsum lsp=maxSubTreeSum(node.left);
		Pairsum rsp=maxSubTreeSum(node.right);
		Pairsum np=new Pairsum();
		np.sum=lsp.sum+rsp.sum+node.data;
		np.max=Math.max(Math.max(lsp.max, rsp.max),np.sum);

		return np;
	}


	public void preorder() {
		preorder(this.root);
		System.out.println();
	}

	private void preorder(Node node) {
		if (node == null) {
			return;
		}
		// node
		System.out.print(node.data + " ");

		// left
		preorder(node.left);

		// right
		preorder(node.right);

	}

	public void postorder() {
		postorder(this.root);
		System.out.println();
	}

	private void postorder(Node node) {
		if (node == null) {
			return;
		}

		// left
		postorder(node.left);

		// right
		postorder(node.right);
		// node
		System.out.print(node.data + " ");

	}

	public void inorder() {
		inorder(this.root);
		System.out.println();
	}

	private void inorder(Node node) {
		if (node == null) {
			return;
		}

		// left
		inorder(node.left);
		// node
		System.out.print(node.data + " ");

		// right
		inorder(node.right);

	}

	private class Pair {
		Node node;
		boolean selfdone;
		boolean leftdone;
		boolean rightdone;
	}

	public void preorderI() {
		Stack<Pair> s = new Stack<>();
		Pair np = new Pair();
		np.node = this.root;
		s.push(np);
		while (!s.isEmpty()) {
			Pair tp = s.peek();
			if (tp.node == null) {
				s.pop();
				continue;
			}

			if (tp.selfdone == false) {
				System.out.print(tp.node.data + " ");
				tp.selfdone = true;
			} else if (tp.leftdone == false) {
				// make new for left node
				Pair n = new Pair();
				// put left node of tp node in new node
				n.node = tp.node.left;
				s.push(n);
				tp.leftdone = true;
			} else if (tp.rightdone == false) {
				// make new for for right nodde
				Pair n = new Pair();
				// put right node of tp node in new node
				n.node = tp.node.right;
				s.push(n);
				tp.rightdone = true;
			} else {
				// when you did complete work of node then remove
				s.pop();
			}
		}
		System.out.println();

	}

	public void postorderI() {
		Stack<Pair> s = new Stack<>();
		Pair np = new Pair();
		np.node = this.root;
		s.push(np);
		while (!s.isEmpty()) {
			Pair tp = s.peek();
			if (tp.node == null) {
				s.pop();
				continue;
			}

			if (tp.leftdone == false) {
				// make new for for left node
				Pair n = new Pair();
				// put left node of tp node in new node
				n.node = tp.node.left;
				s.push(n);
				tp.leftdone = true;
			} else if (tp.rightdone == false) {
				// make new for for right nodde
				Pair n = new Pair();
				// put right node of tp node in new node
				n.node = tp.node.right;
				s.push(n);
				tp.rightdone = true;
			} else if (tp.selfdone == false) {
				System.out.print(tp.node.data + " ");
				tp.selfdone = true;
			} else {
				// when you did complete work of node then remove
				s.pop();
			}
		}
		System.out.println();

	}

	public void inorderI() {
		Stack<Pair> s = new Stack<>();
		Pair np = new Pair();
		np.node = this.root;
		s.push(np);
		while (!s.isEmpty()) {
			Pair tp = s.peek();
			if (tp.node == null) {
				s.pop();
				continue;
			}

			if (tp.leftdone == false) {
				// make new for for left node
				Pair n = new Pair();
				// put left node of tp node in new node
				n.node = tp.node.left;
				s.push(n);
				tp.leftdone = true;
			} else if (tp.selfdone == false) {
				System.out.print(tp.node.data + " ");
				tp.selfdone = true;
			} else if (tp.rightdone == false) {
				// make new for for right nodde
				Pair n = new Pair();
				// put right node of tp node in new node
				n.node = tp.node.right;
				s.push(n);
				tp.rightdone = true;
			} else {
				// when you did complete work of node then remove
				s.pop();
			}
		}
		System.out.println();

	}
// A flip operation is defined as: Choose any node and swap the left and right subtrees of that node.
	public boolean flipEquivalent(BTree other) {
		return flipEquivalent(this.root, other.root);
	}

	private boolean flipEquivalent(Node root1, Node root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null && root2 != null) {
			return false;
		}
		if (root1 != null && root2 == null) {
			return false;
		}

		if (root1.data != root2.data) {
			return false;
		}

		boolean ll = flipEquivalent(root1.left, root2.left);
		boolean rr = flipEquivalent(root1.right, root2.right);
		boolean lr = flipEquivalent(root1.left, root2.right);
		boolean rl = flipEquivalent(root1.right, root2.left);

		return (ll && rr) || (lr && rl);
	}

	public int sum() {
		return sum(this.root);
	}

	private int sum(Node node) {
		if (node == null) {
			return 0;
		}
		int ls=sum(node.left);
		int rs=sum(node.right);
		return ls+rs+node.data;
	}
	

	public BTree(int[] pre, int[] in) {
		this.root = construct(pre, 0, pre.length - 1, in, 0, in.length - 1);

	}

	private Node construct(int[] pre, int plo, int phi, int[] in, int ilo, int ihi) {
		if (plo > phi || ilo > ihi) {
			return null;
		}
		Node nn = new Node();
		nn.data = pre[plo];

		int si = -1;
		for (int i = ilo; i <=ihi; i++) {
			if (pre[plo] == in[i]) {
				si = i;
				break;
			}
		}
		int noele = si - ilo;
		nn.left = construct(pre, plo + 1, plo + noele, in, ilo, si - 1);
		nn.right = construct(pre, plo + noele + 1, phi, in, si + 1, ihi);
		return nn;

	}


}
