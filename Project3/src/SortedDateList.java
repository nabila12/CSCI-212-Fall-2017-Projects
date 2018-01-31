
public class SortedDateList extends DateList{

	public SortedDateList() {
		super();
	}
	
	public void add(Date212 d) {
		DateNode i = head;
		
		while (i.next != null && d.compareTo(i.next.date)>0 )// till one of the condition is false it will continue.
			i = i.next;
		DateNode n = new DateNode(d);// creating a new DateNode object.
		n.next = i.next;
		i.next = n; // set the old node to the new node 
		
	}
}
