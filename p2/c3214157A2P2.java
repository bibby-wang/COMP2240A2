//----The University of Newcastle Australia-------------------
//----School of Electrical Engineering and Computer Science---
//----COMP2240---Operating Systems----------------------------
//----Assessment2---------------------------------------------
//----Problem2---Ice-cream time-------------------------------
//----c3214157---Binbin.wang---2018/10/01---------------------

import java.util.*;
import java.io.*; 

class c3214157A2P2 {

	public static void main(String[] args){
		int time = 0;
		int fiveSets = 5;	
		//Scanner dataIn= new Scanner(System.in); //get data from keyboard
		try{
			FileReader dataFlie = new FileReader(args[0]); //get data from file eg.java c3214157A2P2 xx.txt
     
			//FileReader dataFlie = new FileReader("p2.txt"); //get data from file
     
			Scanner dataIn= new Scanner(dataFlie);		
			ArrayList<A2Problem2Customers> CustomersList = new ArrayList<A2Problem2Customers>();			 
			while(true){
				 
				
				
				String dataLine = dataIn.nextLine();
				
				if (dataLine.equals("END")){break;}
				Scanner dataFromat= new Scanner(dataLine);
				// format data that from user typed
				int cArriveTime = Integer.parseInt(dataFromat.next());
				String cName = dataFromat.next();
				int cEatTime = Integer.parseInt(dataFromat.next());
				int cSeat = cArriveTime;

				
				// save data into list
				A2Problem2Customers customer = new A2Problem2Customers(cArriveTime,cName,cEatTime,cSeat);
				
				
				CustomersList.add(customer);
					

				
			}
			
			//System.out.println(CustomersList.get(1).name);
			//System.out.println(CustomersList.size());
			
			//A2Problem2Thread threadDemo= new A2Problem2Thread();
			
			
			System.out.println ("Customer   arrives   Seats   Leaves");			
			boolean fullFlag = true;
			boolean timeDoLoop = true;
			while(timeDoLoop){
				
				for (int i=0; i< CustomersList.size() ; i++){
					String cID = CustomersList.get(i).name;
					int cArrive = CustomersList.get(i).arrives;
					int cSeat = CustomersList.get(i).seats;
					int cLeaves = cSeat+CustomersList.get(i).eatingTime;
					
					
					
					if (time == cArrive | time == cSeat ){
						
						if ( fiveSets > 0 && fullFlag){
							//data format
						A2Problem2Thread threadCustomer= new A2Problem2Thread();

						threadCustomer.getData(cID,cArrive,cSeat,cLeaves);
						new Thread(threadCustomer).start();
				
						
						
	//System.out.println ("ID-"+ cID + " Arrive-" + cArrive+ " Seat-" + cSeat + "Leaves-" +cLeaves);

						
						String loopOut = CustomersList.get(CustomersList.size()-1).name;
						if (cID.equals(loopOut)){timeDoLoop = false;}
						
						fiveSets--;
						if (fiveSets == 0){fullFlag = false;}
						}else{							
						CustomersList.get(i).seats = cSeat + 1;
						}
					
					}
					if (time == cLeaves){
						fiveSets++;
						if (fiveSets == 5){fullFlag = true;}
					}
				
				}
				
				time++;
				
				
			}
			
			
			
			
		}catch (FileNotFoundException e) {  
               e.printStackTrace();  
		} 



	}

}