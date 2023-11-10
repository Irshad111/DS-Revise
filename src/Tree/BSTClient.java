package Tree;



public class BSTClient {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] in = { 5, 10, 15, 20, 25, 30, 35, 40 };
		BSTree bs = new BSTree(in);
		bs.display();
		System.out.println(bs.max());
		bs.printDec();
		bs.printInRange(7, 15);
		bs.replaceWithSumLarger();
		bs.display();
		bs.add(12);
		bs.display();
		bs.remove(10);
		bs.display();
//		BSTree bs=new BSTree();
//		bs.add(8);
//		bs.add(1);
//		bs.add(3);
//		bs.add(6);
//		bs.add(4);
//		bs.display();

	}


}
