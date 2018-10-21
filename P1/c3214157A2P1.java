//----The University of Newcastle Australia-------------------
//----School of Electrical Engineering and Computer Science---
//----COMP2240---Operating Systems----------------------------
//----Assessment2--------------------------------------------
//----Problem1--Sharing the Bridge---------------------------
//----C3214157---Binbin.wang---2018/09/25---------------------


//import java.util.Scanner;



class c3214157A2P1{
	public static void main(String[] args) {
		//get how many Farmers form user input eg.-----> java A2Problem1 N=<NumN>, S=<NumS>
		//int NumN =  Integer.parseInt(args[0].substring(2,3)); //get the number of North farmers
		//int NumS =  Integer.parseInt(args[1].substring(2,3)); //get the number of South farmers 
		
		//get how many Farmers form user input eg.-----> java A2Problem1 <NumN> <NumS>
		int NumN =  Integer.parseInt(args[0]); //get the number of North farmers
        int NumS =  Integer.parseInt(args[1]); //get the number of South farmers 
		
		A2Problem1Thread threadFamer= new A2Problem1Thread();
		
		//System.out.println(Thread.currentThread().getName() + ": Start main");
		
		//named thread to become different farmers
		//number from the user input
		for(int i=1; i <= NumS; i++){
			// Create and initialize the threadFamer type object of South Farmers
			new Thread(threadFamer,"S_Farmer" + i ).start(); 
			
		}
		
		for(int i=1; i <= NumN; i++){
			// Create and initialize the threadFamer type object of North Farmers
			new Thread(threadFamer,"N_Farmer" + i ).start(); 
			
		}		

		
	
		
		

		
	}
}
