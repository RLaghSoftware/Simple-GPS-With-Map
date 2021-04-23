package package5;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;


public class Vertex<T> implements VertexInterface<T>
{

	private T label;
	private LinkedListWithIterator<Edge> edgeList;
	 // Edges to neighbors
	private boolean visited; // True if visited
	private VertexInterface<T> previousVertex; // On path to this vertex
	private double cost; // Of path to this vertex
	public Vertex(T vertexLabel)
	 { 
	label = vertexLabel; 
	edgeList = new LinkedListWithIterator<>();
	 visited = false;
	 previousVertex = null; 
	cost = 0; 
	}


	public class Edge
	{
	private VertexInterface<T> vertex;
	 // Vertex at end of edge
	private double weight;
	protected Edge(VertexInterface<T> endVertex, double edgeWeight) 
	{ 
	vertex = endVertex;
	 weight = edgeWeight;
	 } 
	// end constructor
	protected Edge(VertexInterface<T> endVertex) 
	{ 
	vertex = endVertex; 
	weight = 0; 
	} 
	// end constructor
	protected VertexInterface<T> getEndVertex()
	 {
	return vertex; 
	} // end getEndVertex
	protected double getWeight() 
	{
	return weight; 
	} 
	}
	
	private class NeighborIterator implements Iterator<VertexInterface<T>>
	 {
	private Iterator<Edge> edges;
	private NeighborIterator()
	 { 
	edges = edgeList.getIterator(); 
	} 
	public boolean hasNext() 
	{
		
	return edges.hasNext(); 
	} 
	public VertexInterface<T> next() 
	{
	 VertexInterface<T> nextNeighbor = null;
	if (edges.hasNext() && edges.next() != null) 
	{ 
	Edge edgeToNextNeighbor = edges.next();
	 nextNeighbor = edgeToNextNeighbor.getEndVertex();
	 }
	else 
	{
		throw new NoSuchElementException();
		
	}
	return nextNeighbor; 
	}

	
	 } 
	
	private class WeightIterator implements Iterator<Double>
	 {
	private Iterator<Edge> edges;
	private WeightIterator()
	 { 
	edges = edgeList.getIterator(); 
	} 
	public boolean hasNext() 
	{
	return edges.hasNext(); 
	} 
	public Double next() 
	{
	 VertexInterface<T> nextNeighbor = null;
	if (edges.hasNext()) 
	{ 
	Edge edgeToNextNeighbor = edges.next();
	 nextNeighbor = edgeToNextNeighbor.getEndVertex();
	 }
	else 
	throw new NoSuchElementException();
	return nextNeighbor.getCost(); 
	}

	
	 }
	
	 
	public T getLabel() 
	{
		
		return label;
	}

	 
	public void visit() 
	{
	
		visited = true;
	}

	 
	public void unvisit()
	{
		visited = false;	
	}

	 
	public boolean isVisited() 
	{
		return (	visited == true);
	}

	
	public boolean connect(VertexInterface<T> endVertex, double edgeWeight)
	{
		boolean result = false;
		if (!this.equals(endVertex)) 
		{ 
		 Iterator<VertexInterface<T>> neighbors = getNeighborIterator();
		boolean duplicateEdge = false;
/**	if (edgeList.getLength() != 0)
		{
			
	while (!duplicateEdge && neighbors.hasNext() /** && neighbors.next()!=null   )
		 {
			if (neighbors.hasNext())
			{
		 VertexInterface<T> nextNeighbor = neighbors.next();
		if (endVertex.equals(nextNeighbor))
			duplicateEdge = true;
			}
		 }
		}
		if  (!duplicateEdge)  **/
		 { 										
			
		edgeList.add(new Edge(endVertex, edgeWeight));
		
		 result = true; 
		} 
		 } 
		return result;

	}

	 
	public boolean equals (Object other)
	{
		boolean result;
		if ((other == null) || (getClass() != other.getClass()))
		 result = false;
		else 
		{
		@SuppressWarnings("unchecked") 
		Vertex<T> otherVertex = (Vertex<T>)other;
		 result = label.equals(otherVertex.label);
		 } 
		return result;

	}
	
	public boolean connect(VertexInterface<T> endVertex)
	{
		return connect(endVertex, 0);
	}

	 
	public Iterator<VertexInterface<T>> getNeighborIterator() 
	{
		return new NeighborIterator();
	}

	 
	public Iterator<Double> getWeightIterator()
	{
		// TODO Auto-generated method stub
		return new WeightIterator();
	}

	 
	public boolean hasNeighbor() 
	{
		return (!edgeList.isEmpty());
	}

	 
	public VertexInterface<T> getUnvisitedNeighbor() 
	{
		VertexInterface<T> result = null; 
		Iterator<VertexInterface<T>> neighbors = getNeighborIterator();
		while ( neighbors.hasNext() && (result == null) ) 
		{ 
		VertexInterface<T> nextNeighbor = neighbors.next();
		if (!nextNeighbor.isVisited()) 
		result = nextNeighbor;
		 } // end while
		return result;

	}

	public VertexInterface<T> getNeighbor() 
	{
		VertexInterface<T> result = null; 
		Iterator<VertexInterface<T>> neighbors = getNeighborIterator();
		if ( neighbors.hasNext() ) 
		{ 
		VertexInterface<T> nextNeighbor = neighbors.next();
		 
		result = nextNeighbor;
		 } // end while
		return result;

	}
	
	 
	public void setPredecessor(VertexInterface<T> predecessor)
	{
		 previousVertex = predecessor;
		
	}

	 
	public VertexInterface<T> getPredecessor() 
	{	
		return previousVertex;
	}

	public int GetSize ()
	{
		return edgeList.getLength();
	}
	 
	public boolean hasPredecessor() 
	{
		
		return (previousVertex != null);
	}

	 
	public void setCost(double newCost) 
	{
		cost = newCost;
		
	}

	 
	public double getCost() 
	{
		
		return cost;
	}
	


}
