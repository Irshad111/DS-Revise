package hashmap;

public class HashTableClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		HashTable<String,Integer> ht=new HashTable(3);	
		ht.put("a", 1);
		ht.put("b", 2);
		ht.put("c", 3);
		ht.put("d", 4);
		//ht.display();
		ht.put("e", 8);
		ht.put("f", 10);
		ht.put("g", 10);
		ht.put("h", 10);
		ht.put("i", 10);
		ht.put("j", 10);





		ht.display();
		

		

	}

}
