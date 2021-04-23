package package5;

import java.util.Iterator; 
 import java.util.NoSuchElementException;

import package1.LList;
import package1.LList.Node; 
 public class LinkedListWithIterator<T> implements ListWithIteratorInterface<T> 
 
 { 
 private Node firstNode; 
 private int numberOfEntries; 
 
 private Node tracker;
	private Node tracker2;
	private Node tracker3;
	
 public LinkedListWithIterator() 
 { 
  initializeDataFields(); 
 } 

 public Iterator<T> iterator() 
 { 
return new IteratorForLinkedList(); 
 } 
public Iterator<T> getIterator() 
 { 
 return iterator(); 
 } 
private class IteratorForLinkedList implements Iterator 
{ 
 private Node nextNode; 
 private IteratorForLinkedList() 
 { 
nextNode = firstNode; 
 }

public boolean hasNext() {
	return nextNode != null;
}

public Object next() 
{
	T result;
	 if (hasNext()) 
	{
	 result = nextNode.getData();
	 nextNode = nextNode.getNextNode();
	  } 
	else
	{ 
	throw new NoSuchElementException("Illegal call to next(); " + "iterator is after end of list.");
	}
	 return result;

} 
}
private void initializeDataFields()
{


firstNode = null;
numberOfEntries = 0;
} 

private Node getNodeAt(int givenPosition)
{

	 Node currentNode = new Node(null);
	 currentNode = firstNode.getNextNode();
	 
	 for (int counter = 1; counter < givenPosition; counter++)
	 { currentNode = currentNode.getNextNode();}
		 
		 return currentNode;
} // end getNodeAt

class Node 
{
	 private T data; 
	 private Node next; 
	 
	 private int position;
	 
	  private Node(T dataPortion)
	  {
	  this(dataPortion, null);
	  } 
	  
	  public T getData()
	  {
		
		return  data;
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
	 
		Node t = new Node(newEntry);
		
		
		
		
			t.next = firstNode;
			
			 numberOfEntries++;
				
			 t.position = numberOfEntries;
			 firstNode = t;
			
			 
			
		
	
}

public int getLength()
{
//	System.out.println(numberOfEntries);
	return numberOfEntries;
}


public boolean isEmpty()
{
//	System.out.println(numberOfEntries);
	return (numberOfEntries == 0);
}


public void add(int newPosition, T newEntry)
{
	if (newPosition < numberOfEntries)
	{
		System.out.println("Error: invalid position");
		
	}
	else
		
	{
	tracker = (Node)getEntry(newPosition);
	tracker2 =(Node) newEntry;
	tracker3 = (Node)getEntry(newPosition-1);
	tracker2.next = tracker;
	tracker3.next = tracker2;
	
	tracker2.position = newPosition;

	
	Node t = firstNode;
	
		
				
	while(newPosition > t.position)
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
	if (givenPosition <= 0)
	{
		System.out.println("Error: invalid position");
		return null;
	}
	else
		
	{
	tracker =  getNode(getEntry(givenPosition));
	tracker2 = tracker.next;
	tracker3 = getNode(getEntry(givenPosition+1));
	tracker3.next = tracker2;
	tracker = new Node(null);
	
	Node t = firstNode;
	
		
				
	while(givenPosition < t.position)
	{
		t.position --;
		t= t.next;
		
	}
	
	numberOfEntries--;
	
	return null;
	}
}


private LinkedListWithIterator<T>.Node getNode(T entry) 
{
	Node n = firstNode;
	
	while (!n.getData().equals(entry))
	{
		n = n.getNextNode();
	}
	if (n.getData().equals(entry))
	{
		return n;
	}
	else
		
	return null;
}

public T replace(int givenPosition, T newEntry) {
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


public T getEntry(int givenPosition) {
	Node t = firstNode;
	if (givenPosition > 0 && givenPosition <=numberOfEntries)
		
	{			
	while(givenPosition != t.position)
	{
		t= t.next;
		
	}
		
	return t.getData();
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
		t= (Node)getEntry(i);
		System.out.print(t.data+" ");
	
	}
	return null;
}


public boolean contains(T anEntry) {
	int i;
	boolean found = false;
	Node t;
	Node a= (Node)anEntry;
	for (i=1; i<=numberOfEntries; i++)
	{
		t= (Node)getEntry(i);
		if (a.data == t.data)
		{
			found = true;
		}
	
	}
	return found;

}


@Override
public void clear() {
	// TODO Auto-generated method stub
	
} 


}
