package Tree;

public class BTClient {

	public static void main(String[] args) {

		BTree bt=new BTree();
		//10 true 20 true 40 false false true 50 false false true 30 false false
		//10 true 20 true 40 true 50 true 60 true 70 false false false false false true 80 false true 90 
		bt.display();
		//System.out.println(bt.diameter1());
		System.out.println(bt.ht());
		bt.preorder();
		bt.preorderI();
		bt.postorder();
		bt.postorderI();
		bt.inorder();
		bt.inorderI();


		

	}

}
