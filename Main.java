import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * --------------------Creates a LinkedBlockingQueue----------------------*
		 *  Links Consumer & Producer Linked Blocking Queue's to the Queue created*
		 *  in the main method. Sets the size of the the queue to 100. Creates----*
		 *  instances of each class.----------------------------------------------*
		 *  ----------------------------------------------------------------------*
		 */
		
		LinkedBlockingQueue<String> bounded = new LinkedBlockingQueue<String>(100);
		Producer.bound = bounded;
		Consumer.consumerBound = bounded;
		Producer producer = new Producer(1);
		Consumer one = new Consumer(1);
		Consumer two = new Consumer(2);
		Consumer three = new Consumer(3);

		/*
		 * ---------------------Executer Service ---------------------------------*
		 * For tracking progress of one or more asynchronous tasks----------------*
		 * Provides methods to manage termination and that can produce results for* 
		 * asynchronous computations of one or more asynchronous tasks.-----------*
		 * -----------------------------------------------------------------------*
		 */
		ExecutorService executor = Executors.newCachedThreadPool();
		executor.submit(producer);
		executor.submit(one);
		executor.submit(two);
		executor.submit(three);
		
		
		/*
		 * ------------------Begin Shutdown & Await Termination of threads.---------------------*
		 * Blocks until all tasks have completed execution after a shutdown request,------------*
		 * or the timeout occurs, or the current thread is interrupted, whichever happens first.*
		 * -------------------------------------------------------------------------------------*
		 */
		executor.shutdown();
		executor.awaitTermination(800, TimeUnit.MILLISECONDS);
		System.out.println("Consumer "+one.getUniqueID()+" Consumed "+one.getConsumerCount());
		System.out.println("Consumer "+two.getUniqueID()+" Consumed "+two.getConsumerCount());
		System.out.println("Consumer "+three.getUniqueID()+" Consumed "+three.getConsumerCount());
		

	}

}
