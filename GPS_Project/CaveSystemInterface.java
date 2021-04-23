package package5;

public interface CaveSystemInterface<T> 
{
	public boolean addCave(Cave<T> c); // Adds a new cave with the given Label to the Cave System
	
	

	public boolean addTunnel(T begin, T end); // Connects 2 caves and adds 1 value to each caves edge list,
	// which consists of the other cave in the tunnel
	

	
	public boolean hasTunnel(T begin, T end); // checks if a tunnel exists from begin -> end
	

	
	public boolean isEmpty() ; // returns true if cave system is empty
	
	
	public int getNumberOfcaves(); // returns number of caves
	
	public int getNumberOfTunnels(); // returns number of tunnels
	
	
	public void clear(); // clears cave
	
}
