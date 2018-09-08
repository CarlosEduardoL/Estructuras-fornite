/**
 * @author Carlos Eduardo Lizalda Valencia
 */
package cUtil;

public interface Queue<T> {

	/**
	 * this method adds an element to the end of the queue </br>
	 * <b>Pre: </b> None </br>
	 * <b>Post: </b> a new element has been added to the end of the queue </br> 
	 * @param item
	 */
	public void enqueue(T item);
	
	/**
	 * this method retrieves and removes the item at the front of the queue. </br>
	 * <b>Pre: </b> the queue is not empty</br>
	 * <b>Post: </b> the element at the beginning of the queue has been retrieved and removed </br>
	 * @return if exist, the element at the beginning
	 * @throws EmptyQueueExeption
	 */
	public T dequeue() throws EmptyQueueExeption;
	
	/**
	 * this method retrieves the item at the front of the queue. </br>
	 * <b>Pre: </b> the queue is not empty</br>
	 * <b>Post: </b> the element at the beginning of the queue has been retrieved </br>
	 * @return if exist, the element at the beginning
	 * @throws EmptyQueueExeption
	 */
	public T front() throws EmptyQueueExeption;
	
	/**
	 * this method determines if the queue is empty </br>
	 * <b>Pre: </b> None </br>
	 * <b>Post: </b> has been returned if the queue is empty or not </br>
	 * @return true if it is empty, false in the opposite case
	 */
	public boolean isEmpty();
	
	public int getSize();
	
}
