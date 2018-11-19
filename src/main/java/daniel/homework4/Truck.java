package daniel.homework4;

import java.util.concurrent.CountDownLatch;

public class Truck {

	Bunch bunch;
	public  int size;
	public volatile boolean flag;
	public void putSmth(int a) 
	{
		bunch.kg-=a;
		size = a;
		
		
	}
	
	
}
