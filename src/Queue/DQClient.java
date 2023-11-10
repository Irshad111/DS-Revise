package Queue;

public class DQClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Queue q=new DynamicQueue();
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		q.enqueue(60);
		q.enqueue(70);
		q.display();
		
		DynamicQueue q1=new DynamicQueue();
		q1.enqueuecheck(10);
		q1.enqueuecheck(20);
		q1.enqueuecheck(30);
		q1.enqueuecheck(40);
		q1.enqueuecheck(50);
		q1.enqueuecheck(60);
		q1.enqueuecheck(70);
		q1.display();
		



	}

}
