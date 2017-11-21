import java.util.concurrent.LinkedBlockingQueue;

public class Producer implements Runnable{
	public static LinkedBlockingQueue<String> bound;
	public static boolean running;
	public int uniqueID;
	
	//Empty Constructor:
	public Producer(int uniqueID){
		this.uniqueID = uniqueID;
	}

	@Override
	public void run() {
		//Creates Loop that makes 1000 random doubles as strings.
		running = true;
		int count = 0;
		for (int i = 1; i<= 1000; i++) {
			double number = Math.random();
			String stringDouble = Double.toString(number);
			try {
				Producer.bound.put(stringDouble);
				count++;
				if (count % 100 == 0) {
					System.out.println("Producer "+getUniqueID()+" has produced "+count+" events.");
				}
				
			} catch (InterruptedException e) {
				//Print Stack Trace if there's an Exception.
				e.printStackTrace();
			}
		}//End For Loop
		
	
	running = false;
	
	}//End Run Method.
	
	//Method for other classes to check if Producer is still producing events.
	public static boolean isRunning() {
		return running;
	}//End isRunning Method.
	public int getUniqueID() {
		return uniqueID;
	}

}//End Class.
