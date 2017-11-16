import java.util.concurrent.LinkedBlockingQueue;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedBlockingQueue<String> bounded = new LinkedBlockingQueue<String>();
		Producer.bound = bounded;
		Producer producer = new Producer();
		Consumer one = new Consumer();
		Consumer two = new Consumer();
		Consumer three = new Consumer();
		producer.run();
		one.run();
		two.run();
		three.run();
	}

}
