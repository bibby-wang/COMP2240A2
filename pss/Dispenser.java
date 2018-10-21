//----The University of Newcastle Australia-------------------
//----School of Electrical Engineering and Computer Science---
//----COMP2240---Operating Systems----------------------------
//----Assessment2--------------------------------------------
//----Problem1--Sharing the Bridge---------------------------
//----c3214157---Binbin Wang---2018/09/30---------------------

import java.util.concurrent.Semaphore;
public class Dispenser implements Runnable{

	private int dispenserNum=1;
	private boolean dispenserFull=false;
	
	private Client client;


	//Construction

	Dispenser(Client client){
		this.client=client;
	}
	final Semaphore sempDispenser = new Semaphore(3);

	public void run() {
		
		try{
			

			sempDispenser.acquire();			

			System.out.println("("+client.getStartTime()+")"+client.getType()+client.getID()+" uses dispenser "+dispenserNum+" (time: "+client.getBrewTime()+")");

			
	
			//System.out.println(client.getType()+client.getID()+"tt="+client.getBrewTime());
			
			sempDispenser.release();

		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}