package package5;

import package1.ListInterface;
import java.util.Iterator; 

public interface ListWithIteratorInterface<T> extends ListInterface<T>, Iterable<T>
{
	public Iterator<T> getIterator();  
}
