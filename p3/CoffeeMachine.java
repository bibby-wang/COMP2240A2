//----The University of Newcastle Australia-------------------
//----School of Electrical Engineering and Computer Science---
//----COMP2240---Operating Systems----------------------------
//----Assessment2--------------------------------------------
//----Problem1--Sharing the Bridge---------------------------
//----c3214157---Binbin Wang---2018/09/30---------------------


public class CoffeeMachine {
	private int ID=0;
	private int	usingTime=0;
	private String currentType="C";
	private int dispenserNumber=0;

	

	//Construction
	CoffeeMachine(String currentType,int usingTime,int dispenserNumber){
		this.severType=severType;
		this.usingTime=usingTime;
		this.dispenserNumber=dispenserNumber;
	}
	
	CoffeeMachine(String severType,int ID,int usingTime,int dispenserNumber){
		this.ID = ID;
		CoffeeMachine(severType,usingTime,dispenserNumber);
	}

	//set coffee machine ID
	public void setID(int ID){
		this.ID = ID;
	}
	//change the type to new type
	public void setType(String newType){
		this.currentType = newType;
	}
	
	//add using time
	public void addUsingTime(int usingTime){
		this.usingTime+=usingTime;
	}
	//get Coffee Machine ID
	public int getID(){
		return ID;
	}
	//get severs type H(hot) or C(cool)
	public String currentType(){
		return currentType;
	}
	//get using time
	public int getUsingTime(){
		return usingTime;
	}

}
 