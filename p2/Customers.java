//----The University of Newcastle Australia-------------------
//----School of Electrical Engineering and Computer Science---
//----COMP2240---Operating Systems----------------------------
//----Assessment2---------------------------------------------
//----Problem2---Ice-cream time-------------------------------
//----c3214157---Binbin.wang---2018/10/01---------------------

//
public class Customers {

	String name;
	int arrives;
	int eatingTime;
	int seats;	
	//Construction
	
	Customers(int arrives,String name,int eatingTime,int seats){
		this.arrives = arrives;
		this.name = name;
		this.eatingTime = eatingTime;
		this.seats = seats;
	}
}
