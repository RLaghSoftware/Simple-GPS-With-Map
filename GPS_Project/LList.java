package package1;

import java.util.List;

import package1.FixedList.Word;







public class LList<T> implements ListInterface<T> 
{
	
	 private Node lastNode; 
	 private Node firstNode;
	 private int numberOfEntries;
	
	 private Node tracker;
		private Node tracker2;
		private Node tracker3;
		
	 public LList()
	 {
	 initializeDataFields();
	 } 
	
	 public void clear()
	 {
	 initializeDataFields();
	 } 
	

	 
	 private void initializeDataFields()
	 {
	 
	firstNode = null;
	lastNode = null;
	 numberOfEntries = 0;
	 } 

	 private Node getNodeAt(int givenPosition)
	 {
		 if ( givenPosition <= numberOfEntries)
		 {
		 LList<T>.Node currentNode = new Node(null);
		 currentNode = lastNode;
		 
		 for (int counter = 1; counter < givenPosition; counter++)
		 { currentNode = currentNode.getNextNode();
		 
		 }
			 
			 return currentNode;
		 }
		 else
		 {
			 System.out.println("Error: given position is out of bounds");
			 return null;
		 }
	 } // end getNodeAt
	
	 public class Node 
	 {
		 private T data; 
		 private Node next; 
		 
		 private int position;
		 
		  private Node(T dataPortion)
		  {
		  this(dataPortion, null);
		  } 
		  
		  private Node getNextNode()
		  {
			  return next;
		  }
		 
		  private Node(T dataPortion, Node nextNode)
		  {
		  data = dataPortion;
		  next = nextNode;
		  } 
	 }

	 
	public void add(T newEntry)
	{
		{
			Node t = new Node(newEntry);
			
			
			
				t.next = lastNode;	
				 numberOfEntries++;
				 t.position = numberOfEntries;
				 lastNode = t;
				 
				 if (numberOfEntries == 1)
				 {
					 firstNode = t;
				 }
			
			}
		
	}

	
	 
	 
	public void add(int newPosition, T newEntry)
	{
		if (newPosition > numberOfEntries)
		{
			System.out.println("Error: invalid position");
			
		}
		else
			
		{
		tracker = getNodeAt(newPosition);
		tracker2 = new Node (newEntry);
		tracker3 = getNodeAt(newPosition-1);
		tracker2.next = tracker;
		tracker3.next = tracker2;
		
		tracker2.position = newPosition;
	
		
		Node t = tracker.getNextNode();
		
			
					
		while(newPosition < t.position)
		{
			t.position ++;
			t= t.next;
			
		}
		
		tracker.position++;
		
		numberOfEntries++;
		}
	}

	 
	public T remove(int givenPosition)
	{
		if (givenPosition <= 0 || givenPosition > numberOfEntries)
		{
			System.out.println("Error: invalid position");
			return null;
		}
		else
			
		{
		tracker = getNodeAt(givenPosition);
		tracker2 = tracker.next;
		tracker3 = getNodeAt(givenPosition-1);
		tracker3.next = tracker2;
		tracker = new Node(null);
		
		Node t = tracker2;
		
			
					
		while(t != null)
		{
			t.position --;
			
			t= t.next;
			
		}
		
		numberOfEntries--;
		
		return null;
		}
	}

	 
	public T replace(int givenPosition, T newEntry) 
	{
		if (givenPosition > 0 && givenPosition <= numberOfEntries)
		{
		this.remove(givenPosition);
		this.add(givenPosition, newEntry);
		return newEntry;
		}
		else
		{
			System.out.println("error: position is out of bounds.");
			return null;
		}
	}

	 
	public T getEntry(int givenPosition)
	{
		
		if (givenPosition > 0 && givenPosition <=numberOfEntries)
			
		{			
		Node t = getNodeAt(givenPosition);
		return t.data;
		}
		
		else
			
		{	
			System.out.println("error: position is out of bounds.");
			return null;
		}
	}

	 
	public T[] toArray() {
		int i;
		Node t;
	
		System.out.println("The list contains:");
		
		for (i=1; i<=numberOfEntries; i++)
		{
			t= getNodeAt(i);
			System.out.print(t.data+" ");
		
		}
		return null;
	}

	 
	public boolean contains(T anEntry) 
	{
		int i;
		boolean found = false;
		Node t;
		Node a= new Node(anEntry);
		for (i=1; i<=numberOfEntries; i++)
		{
			t= getNodeAt(i);
			if (a.data.equals(t.data) )
			{
				found = true;
			}
		
		}
		return found;
	
	}

	 
	public int getLength() 
	{
		
		return numberOfEntries;
	}

	 
	public boolean isEmpty() 
	{
	
		return (numberOfEntries == 0);
	} 
	 
}
