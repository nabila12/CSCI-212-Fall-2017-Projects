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
    	  		jframe.sorted.put(k, k.toString());
    	  		jframe.unsorted.add(k);
    	  		jframe.printToLeft();
    	  		jframe.printToRight();
    	  	}
    	  	catch( Data212Exception e) {
    	  		System.out.println(e);
    	  	}
      } 
   }//actionPerformed
}//EditMenuHandler