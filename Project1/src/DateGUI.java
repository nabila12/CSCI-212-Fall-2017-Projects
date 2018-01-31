import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.util.Scanner;
import java.util.Arrays;
import javax.swing.JFrame;
public class DateGUI {

//	Given an input file of dates represented as Strings, read the dates from the file and display them in a
//	GUI. The dates will be in the form yyyymmdd (such as 20171001 for October 1, 2017). The GUI should
//	have a GridLayout with one row and two columns. The left column should display the dates in the
//	format read from the file, and the right column should display the dates as Date212 object in sorted
//	order (using Selection Sort).
	static TextFileInput inFile;
	static String inFileName = "dates.txt";
	static JFrame myFrame;
	static Container cPane;
	static TextArea Unsorted, Sorted ;
	static Date212[] unsortedDates;
	static Date212[] sortedDates;
	static int counter = 0;

	
	public DateGUI() {//constructor that is setting the component of the UGI with Jframe
		unsortedDates = new Date212[100]; 
		sortedDates = new Date212[100];
		inFile = new TextFileInput(inFileName);
		Unsorted = new TextArea();
		Sorted= new TextArea();
		myFrame = new JFrame();
		myFrame.setLayout(new GridLayout(1, 2));
		myFrame.setTitle("Dates");
		cPane = myFrame.getContentPane();
		cPane.add(Unsorted);
		cPane.add(Sorted);
		myFrame.setSize(400, 400);
		myFrame.setLocation(200, 200);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		readFromFile(inFileName);
	}
	public void readFromFile(String fileName) {
		
		String line;
		line = inFile.readLine();
		int cIndex = 0;
		
		while (line != null) {
			Scanner dates = new Scanner(line);
			dates.useDelimiter(",");
		
			while (dates.hasNext()) {
				String date = dates.next();
				Date212 d = new Date212(date);
			//	System.out.print(d.toString());
				unsortedDates[cIndex] = d;
				sortedDates[cIndex] = d;
				cIndex++;
				counter++;
			}
			Arrays.toString(unsortedDates);
			line = inFile.readLine();
				
		} // while
		
		// once the array has been filled, it prints the array to the unsorted side (left)
		printToLeft();
		
		// for printing the array to the sorted side (right)
		sortDate();
		
		myFrame.setVisible(true);//allows to see all the setting that was made for the GUI.
	}
	
	private void printToLeft() {	//to show the unsorted dates in the unsorted side(left side)
		//
		for(int i=0; i< unsortedDates.length;i++) {
			Unsorted.append(unsortedDates[i] + "\n");
		}
	}
	
	private void sortDate() { 
		for(int i=0; i<counter;i++) { //finds the smallest one put it to the 1st element
			Date212 lowest=sortedDates[i]; 
			int location =i;//keeps tracks of the location of the smallest one 
			for(int j=i; j<counter-1; j++) {//rechecks everything else to find the 2nd smallest and i= j b/c where ever i left off, J takes the current value of i.
				int score =lowest.compareTo(sortedDates[j+1]);//compares first date to the next one  and it is being stored in score which acts like a temporary variable to sort and swap them as it is being iterating through the loop.
				if(score>0) {// lowest > the date we checked 
					lowest = sortedDates[j+1];
					location = j+1;
				}
				if(score==0) {// if they are  the same keep them the same  
					lowest = sortedDates[j];
					location = j;
				}
			}
			sortedDates[location] = sortedDates[i];//swaps them
			sortedDates[i]= lowest; //swaps them
		}
		
		for(int i=0; i< sortedDates.length;i++) {//to show the sorted dates in the sorted side(right side)
		Sorted.append(sortedDates[i] + "\n");
		}
	}// End of method sortDate
}//end of class DateGUI


