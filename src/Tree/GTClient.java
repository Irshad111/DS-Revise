package Tree;

public class GTClient {

	public static void main(String[] args) {
		// 10 3 20 2 50 0 60 0 30 0 40 1 70 0

		GTree gt = new GTree();
		gt.display();
		System.out.println(gt.size());
		System.out.println(gt.find(60));
		System.out.println(gt.height());
		gt.levelorder();
		System.out.println("----------LevelOrderZZ---------");
		gt.levelorderZZ();
		System.out.println("------------LevelOrderLinewise------------");
		gt.levelorderlinewise();


		
	}

}
