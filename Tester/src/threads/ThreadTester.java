package threads;

import java.io.Console;

public class ThreadTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String out = "Hello World! This is a delayed thread test. You may try to type things into the console, but it will not display anything!";
		DelayedPrinter dp = new DelayedPrinter("Thread-1", out, 20000);
		dp.start();
	}

}

class DelayedPrinter implements Runnable {
	private Thread t;
	private String threadName;
	private String output;
	private int msdelay;

	DelayedPrinter(String name, String output, int msdelay) {
		threadName = name;
		this.output = output;
		this.msdelay = msdelay;
		System.out.println("Creating " + threadName);
	}

	public void run() {
		for (int i = 0; i < output.length(); i++) {
			System.out.print(output.charAt(i)+"");
			try {
				Thread.sleep(msdelay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void start() {
		System.out.println("Starting " + threadName);
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}
}
