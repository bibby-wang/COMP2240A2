//----The University of Newcastle Australia-------------------
//----School of Electrical Engineering and Computer Science---
//----COMP2240---Operating Systems----------------------------
//----Assessment2---------------------------------------------
//----Problem2---Ice-cream time-------------------------------
//----c3214157---Binbin.wang---2018/10/01---------------------

import java.util.*;
import java.io.*; 

public class c3214157A2P2 {

	public static void main(String[] args){
		int time = 0;
		int fiveSets = 5;	
		//Scanner dataIn= new Scanner(System.in); //get data from keyboard
		try{
			FileReader dataFlie = new FileReader(args[0]); //get data from file eg.java c3214157A2P2 xx.txt
     
			//FileReader dataFlie = new FileReader("p2.txt"); //get data from file
     
			Scanner dataIn= new Scanner(dataFlie);		
			ArrayList<Customers> customersList = new ArrayList<Customers>();			 
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
				Customers customer = new Customers(cArriveTime,cName,cEatTime,cSeat);
				
				
				customersList.add(customer);
				

				
			}
			
			//System.out.println(customersList.get(1).name);
			//System.out.println(customersList.size());
			
			//A2Problem2Thread threadDemo= new A2Problem2Thread();
			
			
			System.out.println ("Customer   arrives   Seats   Leaves");			
			boolean fullFlag = true;
			boolean timeDoLoop = true;
			while(timeDoLoop){
				
				for (int i=0; i< customersList.size() ; i++){
					String cID = customersList.get(i).name;
					int cArrive = customersList.get(i).arrives;
					int cSeat = customersList.get(i).seats;
					int cLeaves = cSeat+customersList.get(i).eatingTime;
					
					
					
					if (time == cArrive | time == cSeat ){
						
						if ( fiveSets > 0 && fullFlag){
							//data format
							A2Problem2Thread threadCustomer= new A2Problem2Thread();

							threadCustomer.setData(cID,cArrive,cSeat,cLeaves);
							new Thread(threadCustomer).start();
					
							
							

							
							String loopOut = customersList.get(customersList.size()-1).name;
							if (cID.equals(loopOut)){timeDoLoop = false;}
							
							fiveSets--;
							if (fiveSets == 0){fullFlag = false;}
						}else{							
							customersList.get(i).seats = cSeat + 1;
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