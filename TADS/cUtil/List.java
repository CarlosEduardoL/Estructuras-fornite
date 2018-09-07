/**
 * @author Carlos Eduardo Lizalda Valencia
 */
package cUtil;

public interface List<T> {
	
	/**
	 * <b>Pre: </b> None </br>
	 * <b>Post: </b> added the item in the last position of the List </br>
	 */
	public void add(T item);
	
	/**
	 * <b>Pre: </b> index indicates the position at which the item should be inserted in the list </br>
	 * <b>Post: </b> If insertion is successful, item is at position index, and other items are renumbered accordingly. </br>
	 * @Throws ListIndexOutOfBoundsException when index < 0 or index > size()
	 */
	public void add(int index, T item) throws ListIndexOutOfBoundsException;
	
	/**
	 * <b>Pre: </b> index indicates the position in the list of the item to be removed </br>
	 * <b>Post: <b> if 1<= index <= size(), the item at position index is deleted, and other items are renumbered accordingly <br>
	 * @Throws: ListIndexOutOfBoundsException if index < 0 or index > size().
	 */
	public void remove(int index) throws ListIndexOutOfBoundsException;
	
	/**
	 * <b>Pre: </b> None </br>
	 * <b>Post: </b> if the list is empty it returns true otherwise it returns false </br>
	 */
	public boolean isEmpty();
	
	/**
	 * <b>Pre: </b> index indicates the position in the list of the object to be returned </br>
	 * <b>Post: </b> if 1<= index <= size(), the item at position index is returned </br>
	 *  @throws ListIndexOutOfBoundsException if index < 0 or index >= size()
	 */
	public T get(int index) throws ListIndexOutOfBoundsException;
	
	/**
	 * <b>Pre: </b> None <br>
	 * <b>Post: </b> Returns the number of items currently in the list </br>
	 */
	public int size();

}
