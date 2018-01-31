import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
public class FileMenuHandler implements ActionListener {
	
   DateGUI jframe;
   
   public FileMenuHandler (DateGUI jf) {
      jframe = jf;
   }
   public void actionPerformed(ActionEvent event) {
      String menuName = event.getActionCommand();
     
      if (menuName.equals("Open"))
         openFile();
      else if (menuName.equals("Quit"))
         System.exit(0);
      	
   } //actionPerformed
   
   public void openFile() {
	   JFileChooser choose = new JFileChooser();
	   
	   if(choose.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
		   readSource( choose.getSelectedFile().getAbsolutePath());
	
   }
   
   private void readSource(String file) {
	   SortedDateList sorted = new SortedDateList();
	   UnsortedDateList unsorted = new UnsortedDateList();
	   
	   TextFileInput input = new TextFileInput(file);
	   
	   String line = input.readLine();
	   while (line != null) {
			Scanner dates = new Scanner(line);
			dates.useDelimiter(",");
		
			while (dates.hasNext()) {
				String date = dates.next();
				Date212 d = new Date212(date);
		//	System.out.println(date);
				sorted.add(d);
				unsorted.add(d);
				
			}
			line = input.readLine();
			
	   }
	   jframe.Unsorted.append(unsorted.toString());
	   jframe.Sorted.append(sorted.toString());
	   
	   
   }
}