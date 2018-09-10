/**
 * @author Carlos Eduardo Lizalda Valencia
 */
package cUtil;

public class CQueue<T> implements Queue<T> {
	
	  //---------------------------------------\\
	 //---------------parameters----------------\\
	//-------------------------------------------\\
	
	/**
	 * node that contains the first element of the queue
	 */
	private Node<T> first;
	/**
	 * node that contains the last element of the queue
	 */
	private Node<T> last;
	
	/**
	 * integer representing the size of the queue
	 */
	private int size;

	//------------------Constructors----------------\\
	/**
	 * build an empty queue
	 */
	public CQueue() {
		first = null;
		last = null;
		size = 0;
	}
	
	/**
	 * builds a queue with the elements of an array </br>
	 * @param arr - generic data type array
	 */
	public CQueue(T[] arr) {
		first = null;
		last = null;
		size = arr.length;
		for (int i = 0; i < arr.length; i++) {
			enqueue(arr[i]);
		}
	}
	
	//------------------Methods----------------\\
	/**
	 * this method adds an element to the end of the queue </br>
	 * <b>Pre: </b> None </br>
	 * <b>Post: </b> a new element has been added to the end of the queue </br> 
	 * @param item
	 */
	@Override
	public void enqueue(T item){
		if (first == null) {
			first = new CNode<T>(item);
			last = first;
		}else {
			CNode<T> temp = new CNode<T>(item);
			last.setNext(temp);
			last = temp;
		}
		size++;
	}

	/**
	 * this method retrieves and removes the item at the front of the queue. </br>
	 * <b>Pre: </b> the queue is not empty</br>
	 * <b>Post: </b> the element at the beginning of the queue has been retrieved and removed </br>
	 * @return if exist, the element at the beginning
	 * @throws EmptyQueueExeption
	 */
	@Override
	public T dequeue() throws EmptyQueueExeption{
		if (isEmpty()) {
			throw new EmptyQueueExeption("the queue is empty");
		}
		Node<T> temp = first;
		first = first.getNext();
		size--;
		return temp.getItem();
	}

	/**
	 * this method retrieves the item at the front of the queue. </br>
	 * <b>Pre: </b> the queue is not empty</br>
	 * <b>Post: </b> the element at the beginning of the queue has been retrieved </br>
	 * @return if exist, the element at the beginning
	 * @throws EmptyQueueExeption
	 */
	@Override
	public T front() throws EmptyQueueExeption{
		if (isEmpty()) {
			throw new EmptyQueueExeption("the queue is empty");
		}
		return first.getItem();
	}

	/**
	 * this method determines if the queue is empty </br>
	 * <b>Pre: </b> None </br>
	 * <b>Post: </b> has been returned if the queue is empty or not </br>
	 * @return true if it is empty, false in the opposite case
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/* (non-Javadoc)
	 * @see cUtil.Queue#getSize()
	 */
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}
	
}
