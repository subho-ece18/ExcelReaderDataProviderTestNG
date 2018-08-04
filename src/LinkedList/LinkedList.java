package LinkedList;

public class LinkedList {
	
	Node head;
	class Node{
	int data;
	Node next;
	Node(int d)
	{
		data=d;
	    next=null;
		
	}
	}
	
	public void printMiddle()
	{
		Node first_ptr=head;
		Node last_ptr=head;
		
		if(head!=null)
		{
			while(first_ptr!=null && first_ptr.next!=null)
			{
				first_ptr=first_ptr.next.next;
				last_ptr=last_ptr.next;
			}
			//System.out.println("Middle Element->"+last_ptr.data);
					
		}
		System.out.println("Middle Element->"+last_ptr.data);

	}
	
	public void push(int new_data)
	{
		Node new_node= new Node(new_data);
		new_node.next=head;
		head=new_node;
		
	}
	
	public void traversal()
	{
		Node tnode=head;
		
		while(tnode!=null)
		{
			System.out.print(tnode.data+"->");
		 tnode=tnode.next;
		}
		System.out.println("NULL");
		
	}

	
	public static void main(String args[])
	{
		LinkedList li= new LinkedList();
		for(int i=5;i>=0;i--)
		{
			li.push(i);
			li.traversal();
			li.printMiddle();
			
		}
		
	}
}
