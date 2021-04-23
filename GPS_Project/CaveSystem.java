package package5;


import java.util.Stack;

import package4.Dictionary;

public class CaveSystem <T> implements CaveSystemInterface <T>
{
	private Dictionary<T, Cave<T>> caves; // all caves and their labels in this dictionary, label as the key
	private int TunnelCount; // number of tunnels in the system
	
	 public CaveSystem() // constructor
	 { 
	 caves = new Dictionary<>(); 
	 TunnelCount = 0; 
	 }

	
	 
	 
		 
	 
	public boolean addCave(Cave<T> c) // creates cave
	{
		
		Cave<T> addOutcome = caves.add(c.getLabel(), c); // adds cave to dictionary
		return (addOutcome == null);

	}
	 
	

	public boolean addTunnel(T begin, T end) //adds tunnel between two caves
	{
		
		boolean result = false;
		 Cave<T> beginCave = caves.getValue(begin); // returns cave corresponding to keys (labels)
		Cave<T> endCave = caves.getValue(end);
		if ( (beginCave != null) && (endCave != null) )
		 result = beginCave.connect(endCave); // forms a tunnel between caves
		
		if (result)
		{		
			TunnelCount++; // increments number of tunnels
			
	
		if (!hasTunnel(end, begin)) // adds tunnel (pathway) from end cave to beginning cave
		{
			
			addTunnel(end, begin);
		}
		
		}
		
		
	
		return result;

	}

	
	public boolean hasTunnel(T begin, T end) // returns true if two caves have a tunnel
	{
		
		
		boolean found = false;
		 Cave<T> beginCave = caves.getValue(begin); // gets caves corresponding to labels
		 Cave<T> endCave = caves.getValue(end);
		if ( (beginCave != null) && (endCave != null) ) 
		{ 
		
			if (beginCave.HasTunnelWith(endCave)) // checks if a tunnel exists
			{
				
				found = true;
			}
		 } 
		return found;

	}

	
	public boolean isEmpty() // true if no caves exist
	{
		return caves.isEmpty();
	}

	
	public int getNumberOfcaves() // returns amount of caves
	{
		return caves.getSize();
	}
	
	public int getNumberOfTunnels() // returns amount of tunnels
	{
		return TunnelCount;
	}
	
	public void clear() // removes all caves
	{
		caves.clear();  
		TunnelCount = 0;
	}
	
	public Cave<T> fillList ( Cave<T> StartCave, Cave<T> StartingCave, Stack<Cave<T>> Neighbors) // searches starting cave's neighbors, returns either exit or starting cave
	{
	
		boolean found = false;
		Cave <T> e = StartCave; // set to StartCave, but becomes exit if destination is found
	
		
		while ( found == false  && StartingCave.getUnvisitedNeighbor() != null  ) // searches all neighbors to find exit, sets starting cave as predecessor to all neighbors.
			{
				Cave<T> NeighborofStartingCave = StartingCave.getUnvisitedNeighbor();
				
				NeighborofStartingCave.setPredecessor ( StartingCave);
				NeighborofStartingCave.visit(); // marks neighbor as visit so they are not visited twice
					if ( NeighborofStartingCave.IsExit())
						{
							e=NeighborofStartingCave;
							found = true;
							
							
						}
					

					Neighbors.add(NeighborofStartingCave);
			}
		
		return e;
	}
	
	public Cave<T> FindExit (Cave<T> startingCave) // finds path from starting cave to exit
	
	{
	
		Cave<T> Start = startingCave;
	
		Stack<Cave<T>> FirstL = new Stack<Cave<T>>();  // two lists that are going to be filled
		Stack<Cave<T>> SecondL = new Stack<Cave<T>>();

	
		Cave <T> exit = new Cave <T> (null);
	
		exit = fillList(Start, Start, FirstL); // becomes either exit or starting cave (becomes starting cave if exit is not found)
		
		while  (exit.equals(startingCave)) // exit not found
		{
	

				
	
			while (exit.equals(startingCave) && !FirstL.isEmpty()) 
	
			{
				Start= FirstL.pop();
				exit = fillList (exit, Start, SecondL); // fills secondL with neighbors of firstL
				

			}
			
			 FirstL = SecondL; // sets FirstL to SecondL 
			 
			 SecondL = new Stack<Cave<T>>(); //clears SecondL to allow process to occur again
		}

	return exit;
	
	}
	



	

	
}
