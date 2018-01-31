import javax.swing.JOptionPane;

public class Project0 {
	
	public static void main(String args[]) {
		
		String userInput=""; //userInput is declared as a string.
		int counter=0; // initialized the variable counter to 0.But, later on inside the for loop the value will increment if the condition it met. 
		int counter1=0; // initialized the variable counter1 to 0.

		while(true) { // while loop to repeat the process till the user decides to exit the program by writing 'stop'.
				
			userInput = JOptionPane.showInputDialog(null, "Please enter a sentence."); // This line asks the user for input by popping out a single window for userInput. 
			
				for(int i=0; i<userInput.length();i++) { // this for loop is to keep count of how many times 'e' appeared in userInput. 
					char c1 = userInput.charAt(i);//using the charAt method.
			
					if(c1 =='e') { // double equals to check if the letter is 'e'
						counter++;
					}
				}
					for(int j=0; j<userInput.length();j++) { // this for loop is to keep count of how many times 'E' appeared in userInput. 
						char c2= userInput.charAt(j);
						if(c2=='E') { // checks is the letter is 'E'
							counter1++;
						}
					}
						if(userInput.equalsIgnoreCase("Stop")) {//equalsIgnoreCase instead of just equals because in this was it will stop the program if the user writes 'Stop' in any form. 
							System.exit(0); // if the user writes 'Stop' in any form,  it will exit the program
						}
		
		
			JOptionPane.showMessageDialog(null, "Number of lower case e's: "+ counter ); // Displays the message and the number of time lowers case 'e' appeared.
			JOptionPane.showMessageDialog(null,"Number of uppercase letter E's: " + counter1);//// Displays the message and the number of time lowers case 'E' appeared.
		}//end of while loop
	}//end of main
}//end of Project0
