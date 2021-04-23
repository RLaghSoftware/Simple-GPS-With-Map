package package4;

import java.util.Arrays;
import java.util.Iterator;

import package1.LList.Node;
import package5.LinkedListWithIterator;
import package5.ListWithIteratorInterface;
import package5.Vertex.Edge;


public class Dictionary <K, V> implements DictionaryInterface<K, V> 
{
	

	private Node firstNode;
	private int numberOfEntries; 
	private LinkedListWithIterator<K> KeyList;
	private LinkedListWithIterator<V> ValueList;
	
	
	
	public Dictionary ()
	{
		initializeDataFields();
	 } 
	
	
	

	 
	 private void initializeDataFields()
	 {
	 
	firstNode = null;
	 numberOfEntries = 0;
	 } 
	
	
	
	class Entry <K, V>
	{
		private K key;
		private V value;
		
		private Entry (K searchKey, V dataValue)
		{
			key = searchKey;
			value = dataValue;
			
		} // end constructor
		
		
		
		private K getKey()
		{
			return key;
			
		} // end getKey
		
		private V getValue()
		
		{
			return value;
		} // end getValue
		
		private void setValue (V dataValue)
		{
			value = dataValue;
			
		} // end setValue
	
	}
	
	
	public class Node 
	 {
		 private Entry<K, V> data; 
		 private Node next; 
		 
		
		 
		  private Node(Entry<K,V> dataPortion)
		  {
		  this(dataPortion, null);
		  } 
		  
		 
		  
		  private Node(Entry<K,V> dataPortion, Node nextNode)
		  {
		  data = dataPortion;
		  next = nextNode;
		  } 
		  
		  private Node getNextNode()
		  {
			  return next;
		  }
		 
		  private void setNextNode(Node n)
		  {
			 next = n ;
		  }
		  
		  private Entry<K,V> getEntry()
		  {
			  return data;
		  }
		 
		  private void setEntry(Entry<K,V> n)
		  {
			 data = n ;
		  }
	 }
	
	
	
	
	public V add(K key, V value) 

	{
		if((key == null) || (value == null))
			{
			throw new IllegalArgumentException ("Cannot  add null to this dictionary.");
			}
		else
			
		{ 
			V result = null;
			if (this.contains(key))
		{
				Entry <K,V> E= locateEntry(key);
				
				result = E.getValue();
				
				 E.setValue(value);
		}
		
			 
			 
			 else
			 
			 {	
	//			 KeyList.add(key);
	//				ValueList.add(value);
				 Entry<K,V> E = new Entry<K,V> (key, value);
				 Node n = new Node(E);
				 n.setNextNode(firstNode);
				 firstNode = n;
			 numberOfEntries++;
			 
			 result = E.getValue();
			 
			
		
		} 
			
			return result;
	}
	}
	
	
	
	public Entry<K,V> locateEntry(K key)
	
	{
		int index = 0;
		Node a = new Node(null);
		a= firstNode;
		
		int i;
		
		for (i=0; i<numberOfEntries; i++)
		{
			if (a.getEntry().getKey() != key)
			{
				a = a.getNextNode();
			}
			else
			{
				i = numberOfEntries;
			}
		}
		
		return a.getEntry(); 
	}
	
	
	
	public Node locateNode(Entry<K,V> E)
	{
		Node a = new Node(null);
		
a= firstNode;
		
		int i;
		
		for (i=0; i<numberOfEntries; i++)
		{
			if (a.getEntry() != E)
			{
				a = a.getNextNode();
			}
			else
			{
				i = numberOfEntries;
			}
		}
		
		return a;
		
		
	}
	

	
	public V remove (K key)
	{
		if (this.contains(key))
		{
		V result = null;
		
		Entry <K,V> E= locateEntry(key);
		
		result = E.getValue();
		
		Node n = locateNode(E);
		Node a = new Node(null);
		a= firstNode;
		
		int i;
		
		for (i=0; i<numberOfEntries; i++)
		{
			if (a.getNextNode() != n)
			{
				a = a.getNextNode();
			}
			else
			{
				i = numberOfEntries;
			}
		}
		
		
		a.setNextNode(n.getNextNode());
		
		numberOfEntries --;
		
		KeyList.remove(i+1);
		ValueList.remove(i+1);
		
		return result;
		}
		
		else
		{
			System.out.println("Error: key is not in the dictionary");
			return null;
		}
	
		}

	
	public V getValue (K key) 
	{
		if (this.contains(key))
		{
			
		
		V result = null;
		
		Entry<K,V> E = locateEntry(key);
		
		result = E.getValue();
		
		return result;
		}
		else
		{
			return null;
		}
	}

	
	public boolean contains(K key) 
	{
		boolean c = false;
		
		Node n = new Node(null);
		
		n = firstNode;
		
		int i;
		
		for (i=0; i<numberOfEntries; i++)
		{
			if (n.getEntry().getKey().equals(key))
			{
				c = true;
				i = numberOfEntries+1;
			}
			else
			{
				n = n.getNextNode();
			}
		}
		
				
		return c;
	}

	public Iterator<K> getKeyIterator() 
	{		
			Iterator<K> KeyIterator = KeyList.getIterator();	
		return KeyIterator;
	}

	public Iterator<V> getValueIterator() {
		Iterator<V> ValueIterator = ValueList.getIterator();	
		return ValueIterator;
	}

	
	public boolean isEmpty() {
		
		return (numberOfEntries == 0);
	}

	
	public int getSize() 
	{
		
		return numberOfEntries;
	}

	
	 public void clear()
	 {
	 initializeDataFields();
	 }





	@Override
	public K getKey(int i) {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public V getValue(int i) {
		// TODO Auto-generated method stub
		return null;
	} 
	



}
