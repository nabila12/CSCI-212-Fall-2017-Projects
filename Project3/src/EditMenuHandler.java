import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class EditMenuHandler implements ActionListener {
   DateGUI jframe;
   public EditMenuHandler (DateGUI jf) {
      jframe = jf;
   }
   public void actionPerformed(ActionEvent event) {
      String menuName = event.getActionCommand();
      
      if (menuName.equals("Insert")) {
    	  	String  date = JOptionPane.showInputDialog("Please insert a date in yyyymmdd format");  
    	  	try{
    	  		Date212 k = new Date212(date);
    	  		int sortedLength = jframe.sorted.toString().length();
    	  		jframe.sorted.add(k);
    	  		jframe.unsorted.add(k);
    	  		//jframe.Sorted = new TextArea(jframe.sorted.toString());//creating a new text area
    	  		//jframe.Unsorted = new TextArea(jframe.unsorted.toString());
    	  		jframe.Sorted.replaceRange(jframe.sorted.toString(), 0, sortedLength);
    	  		jframe.Unsorted.replaceRange(jframe.unsorted.toString(), 0, sortedLength);
    	  	}
    	  	catch( Data212Exception e) {
    	  		System.out.println(e);
    	  	}
      } 
   }//actionPerformed
}//EditMenuHandler