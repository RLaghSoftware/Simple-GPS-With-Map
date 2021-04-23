package package1;

// import package1.TokenLists.Token;
 // 
public class FixedList<T> implements FixedSizeList<T>
{


	private Word lastWordID; 
	private Word tracker;
	private Word tracker2;
	private Word tracker3;
	 
	private int Length;
	private int limit;
	class Word
	 {
	 private String word; 
	 private Word next; 
	 int position;

	 public Word ()
	 {
		word = null;

		 
	 }
	 
	 public Word (String n)
	 {
		 word = n;
		 
		 
	 }
	public String Getword ()
	{
		return word;
	}
	}

	public void add(T newEntry) 
	{
		if (CheckLimit(Length+1))
		{
			System.out.println("Error: adding a new entry will cause the list to exceed its limit");
		}
		else
	{
		Word t = new Word();
		t = (Word)newEntry;
		
		
			t.next = lastWordID;	
			 Length++;
			 t.position = Length;
			 lastWordID = t;
		
		}
	}
	
	public void add(int newPosition, T newEntry) 
	{
if (newPosition > 0 && newPosition <= Length)
			
		{
		
		tracker = (Word)getEntry(newPosition);
		tracker2 =(Word) newEntry;
		tracker3 = (Word)getEntry(newPosition-1);
		tracker2.next = tracker;
		tracker3.next = tracker2;
		
		tracker2.position = newPosition;
	
		
		Word t = lastWordID;
		
			
					
		while(newPosition > t.position)
		{
			t.position ++;
			t= t.next;
			
		}
		
		tracker.position++;
		
		Length++;
		
		
		}
		else
		{	
		System.out.println("error: position is out of bounds.");
	
		}
		
	}

	
	
	public T remove(int givenPosition)
	{
		if (givenPosition > 0 && givenPosition <= Length && !CheckLimit(Length+1))
			
		{
		
		tracker = (Word)getEntry(givenPosition);
		tracker2 = tracker.next;
		tracker3 = (Word)getEntry(givenPosition+1);
		tracker3.next = tracker2;
		tracker = new Word();
		
		Word t = lastWordID;
		
			
					
		while(givenPosition < t.position)
		{
			t.position --;
			t= t.next;
			
		}
		
		Length--;
		
		return null;
		
		}
		else
		{	
		System.out.println("error: position is out of bounds.");
		return null;
		}
	}


	
	public void clear() {
		 
		 lastWordID= null;
		 Length = 0;
		
	}
	
	

	public T replace(int givenPosition, T newEntry)
	{
		if (givenPosition > 0 && givenPosition <= Length)
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
		Word t = lastWordID;
		if (givenPosition > 0 && givenPosition <= Length)
			
		{			
		while(givenPosition != t.position)
		{
			t= t.next;
			
		}
			
		return (T)t;
		}
		
		else
			
		{	
			System.out.println("error: position is out of bounds.");
			return null;
		}
	}



	public T[] toArray()
	{
		int i;
		Word t;
	
		System.out.println("The Identifiers are:");
		
		for (i=1; i<=Length; i++)
		{
			t= (Word)getEntry(i);
			System.out.print(t.word+" ");
		
		}
		return null;
	}


		

	public boolean contains(T anEntry)
	{
		
		int i;
		boolean found = false;
		Word t;
		Word a= (Word)anEntry;
		for (i=1; i<=Length; i++)
		{
			t= (Word)getEntry(i);
			if (a.word == t.word)
			{
				found = true;
			}
		
		}
		return found;
	}
	
	public void AddWord (String s)
	{
		Word t = new Word(s);
		T a = (T) t;
		this.add(a);
	}
	
	public int getLength()
	{
		
		return Length;
	}


	
	public boolean isEmpty()
	{
		
		return (Length ==0);
	}
	


	public void SetLimit (int l) 
	{
		limit = l; 

	}


	public boolean CheckLimit(int l) 
	{
		return (l>limit);
	}




}
