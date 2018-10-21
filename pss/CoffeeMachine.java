//----The University of Newcastle Australia-------------------
//----School of Electrical Engineering and Computer Science---
//----COMP2240---Operating Systems----------------------------
//----Assessment2--------------------------------------------
//----Problem1--Sharing the Bridge---------------------------
//----c3214157---Binbin Wang---2018/09/30---------------------

public class CoffeeMachine{
	private int machineTime=0;
	private String currentType="";
	private Client client;


	//Construction

	CoffeeMachine(Client client){
		this.client=client;
	}
	

	//change the type to new type
	public void setType(String newType){
		this.currentType = newType;
	}
	
	//add using time
	public void setTime(int time){
		this.machineTime=time;
	}

	//get severs type H(hot) or C(cool)
	public String currentType(){
		return currentType;
	}
	//get using time
	public int getTime(){
		return machineTime;
	}
	

	 synchronized public void run() {
		
		Dispenser dispenser =new Dispenser(client);
		
		try{
			while(!client.getType().equals(currentType)){
				this.wait();	

			}
			new Thread(dispenser).start();		
			

		}catch(Exception e){

			System.out.println(e);
		}

	}

	
	
}
 