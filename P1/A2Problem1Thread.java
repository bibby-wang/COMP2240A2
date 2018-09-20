//----The University of Newcastle Australia-------------------
//----School of Electrical Engineering and Computer Science---
//----COMP2240---Operating Systems----------------------------
//----Assessment2--------------------------------------------
//----Problem1--Sharing the Bridge---------------------------
//----c3214157---Binbin.wang---2016/10/07---------------------


import java.util.concurrent.Semaphore;

class A2Problem1Thread implements Runnable {
	final Semaphore semp = new Semaphore(1,true);
	int NEON = 0;
	public void run() {
		
		while(true){
			//when someone want cross the bridge 
			//first witting the brige empty
			System.out.println(Thread.currentThread().getName() + ": writting for bridge.");  
			
			try{
				//start cross the brige
				//keeep one person cross the brige 
				//Control thread to prevent the occurrence of monopoly
				semp.acquire();	
				
				System.out.println(Thread.currentThread().getName() + ": Crossing bridge Step 5.");  
				System.out.println(Thread.currentThread().getName() + ": Crossing bridge Step 10."); 
				System.out.println(Thread.currentThread().getName() + ": Crossing bridge Step 15."); 
				System.out.println(Thread.currentThread().getName() + ": Across the bridge."); 
				//finsh Across the bridge then the neon light add one
				
				NEON++;
				System.out.println("NEON"+ NEON ); //The neon sign counts of farmers
				
				semp.release();//release Control
				
 			}
			catch(Exception e){
				System.out.println(e);
			}
			
			//if(NEON>10){break;} // stop the loop
		}

	}


}