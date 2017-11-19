import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		LinkedBlockingQueue<String> bounded = new LinkedBlockingQueue<String>(100);
		Producer.bound = bounded;
		Consumer.consumerBound = bounded;
		Producer producer = new Producer(1);
		Consumer one = new Consumer(1);
		Consumer two = new Consumer(2);
		Consumer three = new Consumer(3);

		
		//Executer
		ExecutorService executor = Executors.newCachedThreadPool();
		executor.submit(producer);
		executor.submit(one);
		executor.submit(two);
		executor.submit(three);
		
		//Await Termination 
		executor.shutdown();
		executor.awaitTermination(800, TimeUnit.MILLISECONDS);
		//System.out.println("Consumer "+getUniqueID()+" Has Consumed "+count+" Events");
		System.out.println("Consumer "+one.getUniqueID()+" Consumed "+one.getConsumerCount());
		System.out.println("Consumer "+two.getUniqueID()+" Consumed "+two.getConsumerCount());
		System.out.println("Consumer "+three.getUniqueID()+" Consumed "+three.getConsumerCount());
		//System.out.println(executor.isShutdown());
		//Either producer or consumer is not ending.

	}

}
