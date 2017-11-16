import java.util.concurrent.LinkedBlockingQueue;

public class Producer implements Runnable{
	//Look at Linked Blocking Queue Docs
	public static LinkedBlockingQueue<String> bound = null;
	public static boolean running;
	
	//Empty Constructor:
	public Producer(){
		
	}

	@Override
	public void run() {
		//Create Loop that makes 1000 random doubles as strings.
		// TODO Auto-generated method stub
		//The Queue holds 100 and Producer needs to track/know, how much stuff
		//is in the queue.
		//running = true;
		int count = 0;
		for (int i = 1; i<=1000; i++) {
			double number = Math.random();
			String stringDouble = Double.toString(number);
			try {
				Producer.bound.put(stringDouble);
				if (count % 100 == 0) {
					System.out.println("Current Producer Count: "+count);
					System.out.println(bound);
				}
				count++;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(Producer.bound.size());
		//Producer.running = false;
	
	}//End Run Method.
	public static boolean isRunning() {
		return running;
	}//End isRunning Method.

}//End Class.
