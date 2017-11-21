import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable{
	//LinkedBlockingQueue<String> bounded = new LinkedBlockingQueue<String>();
	public static int globalCounter = 0;
	public static LinkedBlockingQueue<String> consumerBound;
	public int counter = 0;
	public int uniqueID;
	
	//Constructor
	public Consumer(int uniqueID) {
		this.uniqueID = uniqueID;
	}

	@Override
	public void run() {
		
		
		int count = 0;
		boolean running = Producer.isRunning();
		while (running || Producer.bound.size() >= 1) {
			int consumerBoundSize = consumerBound.size();
			if (consumerBoundSize >= 1) {
				try {
					consumerBound.poll(5000L, TimeUnit.MILLISECONDS);
					counter++;
					count++;
					//Thread.sleep(10);
					if (count % 100 == 0) {
						System.out.println("Consumer "+getUniqueID()+" Has Consumed "+count+" Events");
						//System.out.println("Current Producer Size:" + Producer.bound.size());

					}

					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				
			} // End if Loop
			running = Producer.isRunning();
		}//End While
		
	}//End Run Method
	public int getConsumerCount() {
		
		return counter;
	}
	public int getUniqueID() {
		return this.uniqueID;
	}

}//End Class
