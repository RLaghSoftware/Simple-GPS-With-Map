package package4;

import java.util.Iterator;

public interface DictionaryInterface<K, V> 
{

	/** Adds a new entry to this dictionary. If the given search key alreadyexists in the dictionary,
	 *   replaces the corresponding  value.@paramkey    An object search key of the new entry.
	 *   @paramvalue  An object associated  with the search key.@returnEither null if the new entry
	 *    was added to the dictionaryor the value that was associated with key if that valuewas replaced. */
	
	public V add(K key, V value);
	
	/** Removes a specific entry from this dictionary.@paramkey 
	 *  An object search key of the entry to be removed.@returnEither
	 *   the value that was associated with the search keyor null if no such object exists. */
	
	public V remove(K key);
	
	/** Retrieves from this dictionary  the value associated with a givensearch key.
	 * @paramkey  An object search key of the entry to be retrieved.@returnEither the 
	 * value that is associated with the search key or null if no such object exists. */
	
	public V getValue(K key);
	
	/** Sees whether a specific entry is in this dictionary.@paramkey  An object search key
	 *  of the desired entry.@returnTrue if key is associated with an entry in the dictionary.  */
	
	public boolean contains(K  key);
	
	/** Creates an iterator that traverses all search keys in this dictionary.@returnAn iterator
	 *  that provides  sequential  access to the searchkeys in the dictionary. */
	
	public Iterator <K> getKeyIterator();
	/** Creates an iterator that traverses all values in this dictionary.
	 * @returnAn iterator that provides  sequential  access to the valuesin this dictionary. */
	
	public Iterator<V> getValueIterator();
	
	/** Sees whether this dictionary  is empty.@returnTrue if the dictionary  is empty. */
	
	public boolean isEmpty();
	
	/** Gets the size of this dictionary.@returnThe number of entries (key-value pairs)
	 *  currentlyin the dictionary.  */
	
	public int getSize();
	/** Removes all entries from this dictionary.  */
	
	public void clear();
	
	public K getKey (int i);
	
	public V getValue (int i);
	
}
// end DictionaryInterface
	
	

