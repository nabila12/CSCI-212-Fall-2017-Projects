import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
public class DateGUI extends JFrame {

	//	Given an input file of dates represented as Strings, read the dates from the file and display them in a
	//	GUI. The dates will be in the form yyyymmdd (such as 20171001 for October 1, 2017). The GUI should
	//	have a GridLayout with one row and two columns. The left column should display the dates in the
	//	format read from the file, and the right column should display the dates as Date212 object in sorted
	//	order (using Selection Sort).

	public TextArea Unsorted, Sorted;
	static TreeMap< Date212, String>sorted = new TreeMap<Date212,String>();
	static DateList unsorted = new UnsortedDateList();

	public DateGUI() {//constructor that is setting the component of the UGI with Jframe

		Unsorted = new TextArea();
		Sorted= new TextArea();

		setTitle("Dates");
		getContentPane().setLayout(new GridLayout(1,2));
		getContentPane().add(Unsorted);
		getContentPane().add(Sorted);
		setSize(400, 400);
		setLocation(200, 200);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createMenu();
		setVisible(true);
	}


	private void createMenu( ) {
		JMenuItem   item;
		JMenuBar    menuBar  = new JMenuBar();

		JMenu       fileMenu = new JMenu("File");
		JMenu		  editMenu = new JMenu("Edit");
		FileMenuHandler fmh  = new FileMenuHandler(this);
		EditMenuHandler temp  = new EditMenuHandler(this);

		item = new JMenuItem("Open");    //Open
		item.addActionListener( fmh );
		fileMenu.add( item );
		fileMenu.addSeparator();           //add a horizontal separator line

		item = new JMenuItem("Insert"); //Insert
		item.addActionListener(temp);
		editMenu.add(item);
		editMenu.addSeparator();

		item = new JMenuItem("Quit");       //Quit
		item.addActionListener( fmh );
		fileMenu.add( item );

		setJMenuBar(menuBar);
		menuBar.add(fileMenu);

		setJMenuBar(menuBar);
		menuBar.add(editMenu);

	} //createMenu

	void printToLeft() {
		Unsorted.setText(unsorted.toString());
	}

	void printToRight() {
		Sorted.setText("");
		 for(Date212 d: sorted.keySet()) {
	    	  	Sorted.append(sorted.get(d) + "\n");
	      }
	}

}//end of class DateGUI


