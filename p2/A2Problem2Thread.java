//----The University of Newcastle Australia-------------------
//----School of Electrical Engineering and Computer Science---
//----COMP2240---Operating Systems----------------------------
//----Assessment2---------------------------------------------
//----Problem2---Ice-cream time-------------------------------
//----c3214157---Binbin.wang---2018/10/01---------------------



import java.util.concurrent.Semaphore;

public class A2Problem2Thread implements Runnable {
		
 	String name;
	int arrives;
	int cleaves;
	int cEatTime;
	int cSeat;
	
	public void setData(String cName,int cArriveTime,int cSeat,int cleaves){

		this.name = cName;
		this.arrives = cArriveTime;
		this.cSeat=cSeat;
		this.cleaves=cleaves;
	}
	
	
	final Semaphore sempP2 = new Semaphore(5,true);	
	
	public void run() {
		
		try{
			
			sempP2.acquire();
			System.out.println (name + "	     " + arrives+ "	      " + cSeat + "      " +cleaves);
			sempP2.release();
			
		}
		catch(Exception e){
			System.out.println(e);
		}

	}


}