/**
 * 
 */
package cUtil;

/**
 * @author Carlos Eduardo Lizalda Valencia
 *
 */
public interface Stack<T> {

	/**
	 * <b>Pre: </b>None</br>
	 * <b>Post: </b>If insertion is successful, item is on the top of the stack.</br>
	 * @param newItem - item is the new item to be added
	 */
	public void push(T newItem);
	
	/**
	 * <b>Pre: </b>None</br>
	 * <b>Post: </b>None</br>
	 * @return Returns true if the stack is empty, otherwise returns false.
	 */
	public boolean isEmpty();

	/**
	 * <b>Pre: </b>None</br>
	 * <b>Post: </b>None</br>
	 * @return - If stack is not empty, the item on the top is returned. The stack is left unchanged
	 * @throws StackException - if the stack is empty
	 */
	public T top( ) throws StackException;
	
	/**
	 * <b>Pre: </b>None</br>
	 * <b>Post: </b>If deletion is successful, the next item is on the top of the stack.</br>
	 * @return - If stack is not empty, the item on the top is returned and deleted
	 * @throws StackException - if the stack is empty
	 */
	public T pop( ) throws StackException;
	//Pre: none
	//Post: If stack is not empty, the item on the top is removed from the stack.
	//Post: Throws StackException if the stack is empty.
	
}
