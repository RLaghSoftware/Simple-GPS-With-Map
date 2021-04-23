package package5;

import java.util.Iterator;
import java.util.NoSuchElementException;




public class Cave<T> implements CaveInterface<T>
{
	private T label; // "name" of the location, represented as an integer in this case
	private LinkedListWithIterator<Tunnel> TunnelList; // list of all neighbors shared with this cave
	 
	private boolean visited; // True if visited
	public boolean exit;    // True if exit;
	private Cave<T> previousCave; // On path to this Cave
	
	public Cave(T CaveLabel) // constructor with Label given
	 { 
	label = CaveLabel; 
	TunnelList = new LinkedListWithIterator<>();
	 visited = false;
	 exit = false;
	 previousCave = null; 
	 
	}


	public class Tunnel // used to represent a path between two locations
	{
	private Cave<T> Cave; // Cave at end of Tunnel
	 


	protected Tunnel(Cave<T> endCave) 
	{ 
	Cave = endCave; 
	 
	} 
	
	protected Cave<T> getEndCave() // end getEndCave
	 {
	return Cave; 
	} 
 
	}
	
	private class NeighborIterator implements Iterator<Cave<T>>
	 {
		
		Cave<T> current;
	int tracker;
 
	private NeighborIterator()
	 { 

		tracker=0;
	} 
	public boolean hasNext() // true if end of list hasnt been reached
	{
	
		return (tracker < TunnelList.getLength());
	} 
	public Cave<T> next() // iterates tracker and sets current cave to next neighboring cave in tunnel list
	{
	 Cave<T> nextNeighbor = current;
	if ( hasNext() ) 
	{ 
		

		tracker++;
		Tunnel TunnelToNextNeighbor = TunnelList.getEntry(tracker);
	 nextNeighbor = TunnelToNextNeighbor.getEndCave();
	 }
	else 
	{
	
		tracker =0;
		throw new NoSuchElementException();
		
	}
	current = nextNeighbor;
	return nextNeighbor; 
	}

	
	 }
	
	
	 
	public T getLabel() // returns label (int that marks the name of the cave)
	{
		
		return label;
	}

	 
	public void visit() // "visits" the cave (used to find path to exit
	{
	
		visited = true;
	}
	
	public void setExit() // sets cave as destination
	{
	
		exit = true;
	}

	public boolean IsExit() // true if cave is the destination
	{
		return (exit == true);
	}
	 
	public void unvisit() // cave is not yet visited
	{
		visited = false;	
	}

	 
	public boolean isVisited() //true if cave has been visited
	{
		return (	visited == true);
	}

	public boolean HasTunnelWith (Cave<T> GivenCave)   // Determines if Cave has a tunnel with GivenCave
	{
		Boolean hasTunnel = false;
		Cave<T> CavetoCompareWith = null;
		int i;
		int NumberofNeighbors = TunnelList.getLength();
		
		if (NumberofNeighbors> 0)
		{
			CavetoCompareWith = TunnelList.getEntry(1).getEndCave(); // first neighbor in the list
		}
		else
		{
			return hasTunnel;
		}
		for (i=2; i<=NumberofNeighbors; i++)
		{
			if (CavetoCompareWith.equals(GivenCave)) // compares given cave to first neighbor in the list
			{
				hasTunnel = true;
				return hasTunnel;
			}
			else
			{
				CavetoCompareWith = TunnelList.getEntry(i).getEndCave(); //goes down the list
			}
		}
		if (CavetoCompareWith.equals(GivenCave))
		{
			hasTunnel = true;
			
		}
		return hasTunnel;
	}
	
	public boolean connect(Cave<T> endCave)  //Adds a tunnel with endCave
	{
		boolean result = false;
		if (!this.equals(endCave)) 
		{ 
			
		if (!this.HasTunnelWith(endCave))
		 { 										
			
		TunnelList.add(new Tunnel(endCave)); // forms a tunnel
		
		
		 result = true; 
		} 
		
		
		}
		return result;

	}

	 
	public boolean equals (Object other) // custom equals method
	{
		boolean result;
		if ((other == null) || (getClass() != other.getClass())) // false if object is null or an object of a different class than "cave"
		 result = false;
		else 
		{
		@SuppressWarnings("unchecked") 
		Cave<T> otherCave = (Cave<T>)other; 
		 result = label.equals(otherCave.label); // if labels are equal, caves are equal
		 } 
		return result;

	}
	
	
	 
	
	 
	
	 
	public boolean hasNeighbor() // true if cave has a neighbor
	{
		
		return (!this.TunnelList.isEmpty());
	}

	 
	public Cave<T> getUnvisitedNeighbor()  //returns neighbor that has not been visited yet
	{
		Cave<T> result = null; 
		if (!this.hasNeighbor())
		{
			return null;
		}
	
		NeighborIterator neighbors = new NeighborIterator();
		while ( neighbors.hasNext() && (result == null) )  //goes down neighbords list until unvisited neighbor is found
		{ 
		Cave<T> nextNeighbor = neighbors.next();
		if (!nextNeighbor.isVisited()) 
		result = nextNeighbor;
		 } // end while
		return result;

	}

	public Cave<T> getNeighbor() //returns next neighbor
	{
		Cave<T> result = null; 

		NeighborIterator neighbors = new NeighborIterator(); //returns next neighbor
		if ( neighbors.hasNext() ) 
		{ 
		Cave<T> nextNeighbor = neighbors.next();
		 
		result = nextNeighbor;
		 } // end while
		return result;

	}
	
	 
	public void setPredecessor(Cave<T> predecessor) //sets cave as previous step in pathway
	{
		 previousCave = predecessor; 
		
	}

	 
	public Cave<T> getPredecessor() //returns previous step in pathway
	{	
		return previousCave;
	}

	public int GetSize () //returns number of neighbors
	{
		return TunnelList.getLength();
	}
	 
	public boolean hasPredecessor() //true if there is a previous step in the pathway to this cave
	{
		
		return (previousCave != null);
	}

	 
	

	 

}
