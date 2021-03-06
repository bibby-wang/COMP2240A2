//----The University of Newcastle Australia-------------------
//----School of Electrical Engineering and Computer Science---
//----COMP2240---Operating Systems----------------------------
//----Assessment2--------------------------------------------
//----Problem1--Sharing the Bridge---------------------------
//----c3214157---Binbin Wang---2018/09/25---------------------


import java.util.concurrent.Semaphore;

public class A2Problem1Thread implements Runnable {
	final Semaphore semp = new Semaphore(1,true);
	int NEON = 0;
	
	public void run() {
		String Direction="";
		
		String famerName=Thread.currentThread().getName().substring(0,1);
		if (famerName.equals("S")){
			Direction="North";  
		}
		else{
			Direction="South"; 
		}
		//System.out.println(Thread.currentThread().getName() + ": writting for bridge. Going towards " + Direction); 
		while(true){
			//when someone want cross the bridge 
			//first witting the brige empty
			System.out.println(Thread.currentThread().getName() + ": writting for bridge. Going towards " +Direction);  
			
			try{
				//start cross the brige
				//keep one person cross the brige 
				//Control thread to prevent the occurrence of monopoly
				semp.acquire();	
				
				System.out.println(Thread.currentThread().getName() + ": Crossing bridge Step 5.");  
				System.out.println(Thread.currentThread().getName() + ": Crossing bridge Step 10.");  
				System.out.println(Thread.currentThread().getName() + ": Crossing bridge Step 15."); 
				System.out.println(Thread.currentThread().getName() + ": Across the bridge."); 
				//finsh Across the bridge then the neon light add one
				
				NEON++;
				System.out.println("NEON"+ NEON ); //The neon sign counts of farmers
				if (Direction.equals("South")){
					Direction="North";  
				}
				else{
					Direction="South"; 
				}
				semp.release();//release Control
				
				//if (NEON>2) break; //in test Control the loop
				
 			}
			catch(Exception e){
				System.out.println(e);
			}
			
			//if(NEON>10){break;} // stop the loop
		}

	}


}