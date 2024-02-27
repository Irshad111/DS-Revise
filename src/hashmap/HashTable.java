package hashmap;

public class HashTable<K, V> {

	private class HTPair {
		K key;
		V value;

		HTPair(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public boolean equals(Object other) {
			HTPair op = (HTPair) other;
			return this.key.equals(op.key);

		}

		public String toString() {
			return "{" + this.key + " - " + this.value + "}";
		}

	}

	private LinkedList<HTPair>[] bucketArray;
	private int size;

	public HashTable() {
		this.bucketArray = (LinkedList<HTPair>[]) new LinkedList[5];
	}

	public HashTable(int cap) {
		this.bucketArray = (LinkedList<HTPair>[]) new LinkedList[cap];
		this.size = 0;
	}

	public void put(K key, V value) throws Exception {
		int bi = hashFunction(key);

		LinkedList<HTPair> bucket = this.bucketArray[bi];

		HTPair np = new HTPair(key, value);
		if (bucket == null) {
			// If the bucket is null, create a new linked list and add the pair
			bucket = new LinkedList<>();
			bucket.addLast(np);
			this.bucketArray[bi] = bucket;
			this.size++;
		} else {
			// If the bucket is not null, check if the key already exists
			int findidx = bucket.find(np);
			if (findidx == -1) {
				// If the key doesn't exist, add the pair to the end of the linked list
				bucket.addLast(np);
				this.size++;
			} else {
				// If the key exists, update the value of the existing pair
				HTPair pair = bucket.getAt(findidx);
				pair.value = value;
			}
		}

		// Check if rehashing is required
		double lambda = this.size * (0.1) / this.bucketArray.length;
		if (lambda > 2) {
			this.rehash();
		}
	}

	private void rehash() throws Exception {
		LinkedList<HTPair>[] oba=this.bucketArray;
		this.bucketArray = (LinkedList<HTPair>[]) new LinkedList[2*oba.length];
		this.size=0;
		for(LinkedList<HTPair> ob:oba) {
			while(ob!=null&& !ob.isEmpty()) {
				HTPair pair=ob.removeFirst();
				this.put(pair.key, pair.value);
				
			}
			
		}

		
		
	}

	private int hashFunction(K key) {
		int hc = key.hashCode();
		hc = Math.abs(hc);
		int bi = hc % this.bucketArray.length;
		return bi;// base bucket index
	}

	public void display() throws Exception {
		for (LinkedList<HTPair> bucket : this.bucketArray) {
			if (bucket != null && !bucket.isEmpty()) {
				bucket.display();
			} else {
				System.out.println("Null");
			}
		}
		System.out.println("------------------");
	}

	public V get(K key) throws Exception {
		int bi = hashFunction(key);
		LinkedList<HTPair> bucket = this.bucketArray[bi];

		HTPair ptf = new HTPair(key, null);
		if (bucket == null) {
			return null;
		} else {

			int findidx = bucket.find(ptf);
			if (findidx == -1) {
				return null;
			} else {
				HTPair pair = bucket.getAt(findidx);
				return pair.value;
			}

		}

	}
	public V remove(K key) throws Exception {
		int bi = hashFunction(key);
		LinkedList<HTPair> bucket = this.bucketArray[bi];

		HTPair ptf = new HTPair(key, null);
		if (bucket == null) {
			return null;
		} else {

			int findidx = bucket.find(ptf);
			if (findidx == -1) {
				return null;
			} else {
				HTPair pair = bucket.getAt(findidx);
				bucket.removeAt(findidx);
				this.size--;
				return pair.value;
			}

		}

	}
	


}
