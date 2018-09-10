/**
 * 
 */
package cUtil;

/**
 * @author Carlos Eduardo Lizalda Valdencia
 *
 */
public interface Map<K,T> {

	/**
	 * order according to the newItem’s search key. </br>
	 * <b>post: </b>Inserts newItem into a table in its proper sorted </br>
	 * @param key - Any Object of type K
	 * @param value - Any Value of type V
	 */
	public void set(K key,T value);
	
	/**
	 * <b>post: </b>Retrieves an item with a given search key from a table </br>
	 * @param key - Any Object of type K
	 * @return - the value that corresponds to the key
	 */
	public T get(K key);
	
	/**
	 * <b>post: </b>Deletes an item with a given search key from the table </br>
	 * @param key - Any Object of type K
	 * @return - the value that corresponds to the key
	 */
	public T remove(K key);
	
	/**
	 * <b>post: </b>Determines whether a table is empty.</br>
	 * @return - a boolean that represent if the map is empty or not
	 */
	public boolean isEmpty();
	
	/**
	 * <b>post: </b>Determines the number of items in the table. </br>
	 * @return - an integer that represent the number of items in the map
	 */
	public int tableLength();
	
	/**
	 * this method convert the key of type K to integer </br> 
	 * @param key - any key of type K
	 * @return - an integer that represent a position in the array
	 */
	public int hash(K key);
	
	public void rehashing();
	
}
