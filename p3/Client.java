//----The University of Newcastle Australia-------------------
//----School of Electrical Engineering and Computer Science---
//----COMP2240---Operating Systems----------------------------
//----Assessment2--------------------------------------------
//----Problem1--Sharing the Bridge---------------------------
//----c3214157---Binbin Wang---2018/09/30---------------------


public class Client {
	private int ID;
	private int	brewTime;
	private String clientType;

	

	//Construction
	Client(String clientType,int ID,int brewTime){
		this.ID=ID;
		this.clientType=clientType;
		this.brewTime=brewTime;
	}
	//get clinet ID
	public int getID(){
		return ID;
	}
	//get type hot(H) or cool(C)
	public String getType(){
		return clientType;
	}
	//get using time
	public int getBrewTime(){
		return brewTime;
	}

}