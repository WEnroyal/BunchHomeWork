package daniel.homework4;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class Worker2 implements Runnable {

	private String name;
	private Truck truck;
	private Bunch bunch;
	private CyclicBarrier cb;
	Worker2(String name, Truck truck, Bunch bunch, CyclicBarrier cb)
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
						break;
					}
					TimeUnit.SECONDS.sleep(4);
					System.out.println("Worker2 pick truck from Worker1");
					System.out.println("Worker2 riding with truck");
					TimeUnit.SECONDS.sleep(3);
					System.out.println("Give it to Worker3");
					cb.await();
					TimeUnit.SECONDS.sleep(2);
					System.out.println("Worker2 take the truck from Worker3");
					TimeUnit.SECONDS.sleep(3);
					System.out.println("Give it to Worker1");
				
				
			}
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	
		
	}
	
	
	
}

