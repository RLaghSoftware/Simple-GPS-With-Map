package package1;

public interface ListInterface<T>
{
	/** Adds a new entry to the end of this list.Entries currently in the list are unaffected.The list's size is increased by 1.@paramnewEntry The object to be added as a new entry. */
	 public void add(T newEntry);

	/** Adds a new entry at a specified position within this list.Entries originally at and above the specified positionare at the next higher position within the list.The list's size is increased by 1.@paramnewPosition An integer that specifies the desiredposition of the new entry.@paramnewEntry The object to be added as a new entry.@throwsIndexOutOfBoundsException if eithernewPosition < 1 or newPosition > getLength() + 1. */
	public void add(int newPosition, T newEntry);

	/** Removes the entry at a given position from this list.Entries originally at positions higher than the givenposition are at the next lower position within the list,and the list's size is decreased by 1.@paramgivenPosition An integer that indicates the position ofthe entry to be removed.@returnA reference to the removed entry.@throwsIndexOutOfBoundsException if either givenPosition < 1 or givenPosition > getLength(). */

	public T remove (int givenPosition);
	/** Removes all entries from this list. */
	public void clear();
	
	/** Replaces the entry at a given position in this list.@paramgivenPosition An integer that indicates the position ofthe entry to be replaced.@paramnewEntry The object that will replace the entry at theposition givenPosition.@returnThe original entry that was replaced.@throwsIndexOutOfBoundsException if eithergivenPosition < 1 or givenPosition > getLength(). */
	public T replace(int givenPosition, T newEntry);
	
	/** Retrieves the entry at a given position in this list.@paramgivenPosition An integer that indicates the position ofthe desired entry.@returnA reference to the indicated entry.@throwsIndexOutOfBoundsException if eithergivenPosition < 1 or givenPosition > getLength(). */
	public T getEntry(int givenPosition);
	
	/** Retrieves all entries that are in this list in the order in whichthey occur in the list.@returnA newly allocated array of all the entries in the list.If the list is empty, the returned array is empty. */
	public T[] toArray();
	
	/** Sees whether this list contains a given entry.@paramanEntry The object that is the desired entry.@returnTrue if the list contains anEntry, or false if not. */
	public boolean contains(T anEntry);
	
	/** Gets the length of this list.@returnThe integer number of entries currently in the list. */
	public int getLength();
	
	/** Sees whether this list is empty.@returnTrue if the list is empty, or false if not. */
	public boolean isEmpty();


}
