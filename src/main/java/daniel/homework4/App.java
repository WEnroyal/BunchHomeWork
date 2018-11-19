package daniel.homework4;

import java.util.concurrent.CyclicBarrier;



public class App 
{
    public static void main( String[] args )
    {
    	Bunch bunch = new Bunch();
		Truck truck = new Truck();
		CyclicBarrier cb = new CyclicBarrier(3);
		new Worker1("Worker1", truck, bunch, cb );
		new Worker2("Worker2", truck, bunch, cb);
		new Worker3("Worker3", truck, bunch, cb);
    }
}
