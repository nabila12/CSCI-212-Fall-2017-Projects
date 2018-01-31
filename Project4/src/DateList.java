import java.util.TreeMap;

public abstract class DateList {

	DateNode head;
	DateNode tail;
	protected int length;//number of date items in the list 
	
	public DateList() {
		DateNode dummy = new DateNode(new Date212("20120101"));
		head = dummy;
		tail = dummy;
		this.length = 0;
	}
	
	public int getLength() {
		return length;
	}
	
	public abstract void add(Date212 d); //abstract add method.
		
	public void append(Date212 d) {// adds in the end of the list 
		DateNode node = new DateNode(d);
		tail.next = node;
		tail = node;
		this.length++;
		
	}
	
	public String toString() {
		String result = "";
		for( DateNode i = head.next; i != null; i= i.next) {// iterates one node at a time.
			result+= i.date.toString() + "\n";
		}
		return result;
	}
	
	
	
}
