package daniel.homework4;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class Worker3 implements Runnable {

	private String name;
	private Truck truck;
	private Bunch bunch;
	private CyclicBarrier cb;
	Worker3(String name, Truck truck, Bunch bunch, CyclicBarrier cb)
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
					TimeUnit.SECONDS.sleep(8);
					System.out.println("Worker3 pick truck from Worker2");
					System.out.println("Worker3 unload the truck");
					TimeUnit.SECONDS.sleep(3);
					cb.await();
					System.out.println("Give it to Worker2");
					TimeUnit.SECONDS.sleep(1);
				
				
				
			}
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	
		
	}
	
	
	
}


