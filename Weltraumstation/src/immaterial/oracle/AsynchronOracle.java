package immaterial.oracle;

import java.util.Timer;
import java.util.TimerTask;

public class AsynchronOracle extends Oracle{
	

	private static final long serialVersionUID = 1L;

	public AsynchronOracle() {
		super.setType("Orakel der Asynchronität");
	}
	
	
	 public void timer(int seconds, Runnable runnable) {
	        Timer timer = new Timer();

	        TimerTask task = new TimerTask() {
	            @Override
	            public void run() {
	                runnable.run();
	            }
	        };

	        timer.schedule(task, seconds);

	        timer.schedule(new TimerTask() {
	            @Override
	            public void run() {
	                task.cancel();
	                timer.cancel();
	                System.out.println("Timer cleared!");
	            }
	        }, (seconds + 500));
	    }
	
	
	
	public void threadSleep(int seconds) throws InterruptedException{
            Thread.sleep(seconds); 
	}

}
