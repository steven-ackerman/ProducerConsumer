import java.util.concurrent.LinkedBlockingQueue;

public class Consumer implements Runnable{
	LinkedBlockingQueue<String> bounded = new LinkedBlockingQueue<String>();
	//Constructor
	public Consumer() {
		//this.bounded = Producer.bound;
		this.bounded = Producer.bound;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//if (bounded != null) {
		int count = 0;
		boolean running = Producer.isRunning();
		//while (running = true) {
			
		for (int i = 1; i <= 1000; i++) {
			try {
				// String dataTaken = this.bounded.take();
				this.bounded.take();
				running = Producer.isRunning();
				count++;
				if (count % 100 == 0) {
					System.out.println("Current Consumer Count: " + count);
					// System.out.println(bounded);
					System.out.println("Current Size:" + this.bounded.size());
				} else if (count <= 100) {
					System.out.println("Current Consumer Count: " + count);
					System.out.println("Current Size: " + this.bounded.size());
				}

				// Thread.sleep(1000);
			} catch (InterruptedException e) {
				// Catch Block if retrieve and remove does not work for the element at the head
				// of this queue.
				e.printStackTrace();
			} // End Catch

		} // End For Loop
			
		//}//End While
		
	}//End Run Method
	public static int getConsumerCount() {
		int currentObjectCount = 0;
		return currentObjectCount;
	}

}//End Class
