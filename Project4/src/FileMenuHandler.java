import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
import java.util.TreeMap;
public class FileMenuHandler implements ActionListener {
	
	//static TreeMap< Date212, Integer>sorted = new TreeMap<Date212,Integer>();
	//static DateList unsorted = new UnsortedDateList();
	
   DateGUI jframe; 
   
   public FileMenuHandler (DateGUI jf) {
      jframe = jf;
   }
   public void actionPerformed(ActionEvent event) {
      String menuName = event.getActionCommand();
     
      if (menuName.equals("Open")) {//if clicked on "Open" then open the file as instructed in that method.
         openFile();
      }
      else if (menuName.equals("Quit")) // if clicked on "Quit" exit the program
         System.exit(0);
      	
   } //actionPerformed
   
   public void openFile() { //to open a file 
	   JFileChooser choose = new JFileChooser();
	   
	   if(choose.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
		   readSource( choose.getSelectedFile().getAbsolutePath());
	
   }
   
   private void readSource(String file) {
	   jframe.unsorted = new UnsortedDateList();
	  jframe.sorted =   new TreeMap<Date212, String>();
	   
	   TextFileInput input = new TextFileInput(file);
	   String line = input.readLine();
	   while (line != null) {
			   
			Scanner datesIn = new Scanner(line);
			datesIn.useDelimiter(",");
			while (datesIn.hasNext()) {
				String date = datesIn.next();
				try {
				Date212 d = new Date212(date);
			//System.out.println(date); - just to see if it actually getting the list,if so printing it to the consul.
				
				jframe.unsorted.add(d);
				jframe.sorted.put(d, d.toString());//puts items (dates) in the tree map.
				}
				catch (Data212Exception e) {
					System.out.println(e);
				}
			line = input.readLine();
			}
	   }
	   jframe.printToLeft();
	   jframe.printToRight();
     
   }
}