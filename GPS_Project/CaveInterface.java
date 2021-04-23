package package5;



public interface CaveInterface<T> 
{
	 
	public T getLabel() ; // returns cave's label
	
	 
	public void visit() ; // marks a cave as visited

	
	public void setExit() ; // marks a cave as "exit"
	
 
	public void unvisit(); // removes visited mark, if it exists
	
	 
	public boolean isVisited() ; // returns true if cave has visited mark, false if it doesnt 
	

	public boolean HasTunnelWith (Cave<T> n) ; // returns true if cave has a tunnel with cave n
	
	
	public boolean connect(Cave<T> endCave) ; // connects cave with endCave and adds endCave to TunnelList
	
	 
	public boolean hasNeighbor() ; // returns true if TunnelList is not empty, false if it is

	 
	public Cave<T> getUnvisitedNeighbor() ; // Returns next neighbor that is not unvisited
	

	public Cave<T> getNeighbor() ; // returns next neighbor, weather or not it is visited
	
	 
	public void setPredecessor(Cave<T> predecessor) ; // sets previousCave to predecessor
	
	 
	public Cave<T> getPredecessor() ; // returns previousCave
	
	
	public int GetSize () ; // returns size of TunnelList
	
	 
	public boolean hasPredecessor() ; // returns true if previousCave is not null
	

}
