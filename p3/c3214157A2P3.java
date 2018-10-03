//----The University of Newcastle Australia-------------------
//----School of Electrical Engineering and Computer Science---
//----COMP2240---Operating Systems----------------------------
//----Assessment2---------------------------------------------
//----Problem3---Hot or Iced Coffee-------------------------------
//----c3214157---Binbin Wang---2018/10/01---------------------

import java.util.*;
import java.io.*; 

public class c3214157A2P3 {
	
	public static void main(String[] args){
		int clinetNum = 0;			
		String dataLine = null;
		
	
		//Scanner dataIn= new Scanner(System.in); //get data from keyboard
		try{
			FileReader dataFlie = new FileReader(args[0]); //get data from file eg.java c3214157A2P3 xx.txt
     
     
			Scanner dataIn = new Scanner(dataFlie);	
			
			//get the number of total clinets
			clinetNum = Integer.parseInt(dataIn.nextLine());			
			
			//dataLine = dataIn.nextLine();
			
			ArrayList<Client> CustomersList = new ArrayList<Client>();			 
			int lineNum=0;
			while(lineNum<clinetNum){				
				
				dataLine = dataIn.nextLine();
				// format data that from file
				String[] dataPartArr = dataLine.split(" ");
				String clientType = dataPartArr[0].substring(0,1);
				int ID = Integer.parseInt(dataPartArr[0].substring(1));
				
				int brewTime = Integer.parseInt(dataPartArr[1]);
				System.out.print(clientType+"-"+ID+"-"+brewTime);
				// save data into list
				Client customer = new Client(clientType,ID,brewTime);
	
				CustomersList.add(customer);
				
				//System.out.println(" data: "+dataLine+" size: "+dataLine.length());
				
				lineNum++;
				
			}
			
			//System.out.print(CustomersList.get(4).getType());
			//System.out.print(CustomersList.get(4).getID());
			//System.out.println("-"+CustomersList.get(4).getBrewTime());
			System.out.println("total: "+CustomersList.size());
			//A2Problem3Thread threadDemo= new A2Problem3Thread();
			


			//start loop ºÍ p2³ÌÐòºÜÏñ
		
		}
		catch (FileNotFoundException e) {  
			e.printStackTrace();  
		} 

	}
}