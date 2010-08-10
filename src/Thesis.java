/**
 * @(#)Thesis.java
 *
 * This program will generate your Phd thesis, might take a while(like several lifetimes of the universe).
 * Simply change the thesisLength to number of characters you would like your Phd to contain.
 *
 * @Chester Grant  
 * @version 1.00 2010/8/10
 */
import java.io.*; 
public class Thesis {
	
	BufferedReader input; //Use to read in whether you have found your Phd Thesis
	Boolean stop;  //Stop the permutation when you have found your Phd Thesis
	
	public Thesis(){
		input = new BufferedReader(new InputStreamReader(System.in) );
		stop = false;

	}
	public void generateThesis(String alphabet[],String aStr, int pos, int strLength){
          
    	if(pos < strLength){
    		//Permutate through all the possible combination of chars in alphabet to the specific 
    		//length of the thesis
    		pos++;
    		for(int i = 0; i< alphabet.length; i++){
    			String temp = aStr;
    			temp = temp + alphabet[i];
    			generateThesis(alphabet,temp,pos,strLength);
    			if(stop == true){
    				break;
    			}
    			
    		}
    	}else{
    	    //Prints out the Thesis and ask if you found it	   
    		System.out.println(aStr);
    		System.out.println("Is this your Phd Thesis?(Y/y for yes, any other key for no) ");
    		try{
    			String response = input.readLine();
    			//Stops the generation of new Thesis
    	    	if((response.compareTo("Y")==0)||(response.compareTo("y")==0)){
    			   stop = true;
    		    }
    		}catch(IOException ex){
    			System.out.println("Error reading in your answer!");
    		}
    	   
    	}
      
    }
    
     public static void main(String args[]){
     	//Characters to be used in your Phd Thesis
    	String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"," ",",",";",":","!","0","1","2","3","4","5","6","7","8","9"};
    	String aStr = new String(); //Used in storing  permutation of the Thesis
    	
    	//Initialization
    	int thesisLength = 100; //Length of your Phd Thesis in characters
    	aStr ="";
    	
    	//Generates Phd Thesis
    	Thesis myThesis = new Thesis();
    	myThesis.generateThesis(alphabet,aStr,0,thesisLength);
    	
    	
    }
    
}

