//----The University of Newcastle Australia-------------------
//----School of Electrical Engineering and Computer Science---
//----COMP2240---Operating Systems----------------------------
//----Assessment2--------------------------------------------
//----Problem1--Sharing the Bridge---------------------------
//----c3214157---Binbin Wang---2018/09/30---------------------

public class CoffeeMachine{
	private int machineTime=0;
	private static String currentType="";
	int timeAndNum[]={0,0};
	static boolean dispensers[] = {true,true,true};
	static boolean disflg = true;
	
	//Construction

	CoffeeMachine(){
		timeAndNum[0]=0;
		timeAndNum[1]=1;
		
	}
	

	//change the type to new type
	public void setType(String newType){
		this.currentType = newType;
	}
	
	//add using time
	public void setTime(int time){
		this.machineTime+=time;
	}

	//get severs type H(hot) or C(cool)
	public String currentType(){
		return currentType;
	}
	//get using time
	public int getTime(){
		return machineTime;
	}


	
	public synchronized int[] startHotWork(int bTime) {
		currentType="H";
		
		while (!currentType.equals("H")&&!disflg) 
		{
			try { wait(); }
			catch (InterruptedException e) { } 
			finally { } 
		} 		
		
		//GET DISPENSER NUMBER
		if (dispensers[0]){
			timeAndNum[1]=1;
			dispensers[0]=false;
			
		}else 
			if (dispensers[1]){
			timeAndNum[1]=2;
			dispensers[1]=false;
				
		}else 
			if (dispensers[2]){
			timeAndNum[1]=3;
			dispensers[2]=false;
			
		}else{
			disflg=false;
		}
		



		dispensers[timeAndNum[1]-1]=true;
		disflg=true;
			
		notify(); 
		timeAndNum[0]=machineTime;
		setTime(bTime);
		return timeAndNum;
	}
	
	public synchronized int[] startColdWork(int bTime) {
		
		currentType="C";
		
		while (!currentType.equals("C")&&!disflg) 
		{
			try { wait(); }
			catch (InterruptedException e) { } 
			finally { } 
		} 

		//GET DISPENSER NUMBER
		if (dispensers[0]){
			timeAndNum[1]=1;
			dispensers[0]=false;
		}else if (dispensers[1]){
			timeAndNum[1]=2;
			dispensers[1]=false;
		}else if (dispensers[2]){
			timeAndNum[1]=3;
			dispensers[2]=false;
		}else{
			disflg=false;
		}
		

		dispensers[timeAndNum[1]-1]=true;
		disflg=true;	
		notify(); 
		timeAndNum[0]=machineTime;
		setTime(bTime);
		return timeAndNum;
	}

	
	
}
 