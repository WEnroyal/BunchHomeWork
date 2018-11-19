package daniel.homework4;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class Worker1 implements Runnable {

	private String name;
	private Truck truck;
	private Bunch bunch;
	private CyclicBarrier cb;
	Worker1(String name, Truck truck, Bunch bunch, CyclicBarrier cb)
	{
		this.name = name;
		this.truck = truck;
		this.bunch = bunch;
		this.cb = cb;
		new Thread(this).start();
	}
	public void run() {
		try {
			while(bunch.kg > 0) 
			{
				cb.await();
				if(bunch.kg < 6) 
				{
					System.out.println(bunch.kg + " kg dollars for us Guys )))");
					break;
					
				}
				System.out.println(bunch.kg);
					System.out.println("Put 6 kg in truck");
					TimeUnit.SECONDS.sleep(3);
					truck.putSmth(6);
					System.out.println("Pick truck with 6 kg and give it to Worker2");
					cb.await();
					TimeUnit.SECONDS.sleep(6);
					System.out.println("Take the truck from Worker2");
					
				
				
			}
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	
		
	}
	
	
	
}
