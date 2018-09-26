//----The University of Newcastle Australia-------------------
//----School of Electrical Engineering and Computer Science---
//----COMP2240---Operating Systems----------------------------
//----Assessment2---------------------------------------------
//----Problem3---Hot or Iced Coffee-------------------------------
//----c3214157---Binbin Wang---2018/10/01---------------------

import java.util.*;
import java.io.*; 

class c3214157A2P3 {

	public static void main(String[] args){
		int time = 0;
		int fiveSets = 5;	
		//Scanner dataIn= new Scanner(System.in); //get data from keyboard
		try{
			FileReader dataFlie = new FileReader(args[0]); //get data from file eg.java c3214157A2P3 xx.txt
     
			//FileReader dataFlie = new FileReader("a.txt"); //get data from file
     
			Scanner dataIn= new Scanner(dataFlie);		
			ArrayList<A2Problem3Customers> CustomersList = new ArrayList<A2Problem3Customers>();			 
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
				A2Problem3Customers customer = new A2Problem3Customers(cArriveTime,cName,cEatTime,cSeat);
	
				CustomersList.add(customer);

			}
			
			//System.out.println(CustomersList.get(1).name);
			//System.out.println(CustomersList.size());
			//A2Problem3Thread threadDemo= new A2Problem3Thread();
			
			System.out.println ("Customer   arrives   Seats   Leaves");			
			boolean fullFlag = true;
			boolean timeDoLoop = true;
			//start loop 和 p2程序很像
		
		}
		catch (FileNotFoundException e) {  
			e.printStackTrace();  
		} 

	}
}