/**
 * @author Carlos Eduardo Lizalda Valencia
 */
package cUtil;

public class Node<T> {

	  //---------------------------------------\\
	 //---------------parameters----------------\\
	//-------------------------------------------\\

	/**
	 * object in the data structure
	 */
	private T item;

	/**
	 * next node
	 */
	private Node<T> next;

	//------------------Constructors----------------\\
	/**
	 * build an empty node
	 */
	public Node() {
		item = null;
		next = null;
	}	
	
	/**
	 * build a node with a given item </br>
	 * @param item - Item with generic data type
	 */
	public Node(T item) {
		this.item = item;
		next = null;
	}

	//------------------Methods----------------\\

	/**
	 * returns the item of the node, if it does not exist it returns null </br>
	 * @return Item with generic data type
	 */
	public T getItem() {
		return item;
	}
	
	/**
	 * returns the next node, if the current node is the last one returns null
	 * @return generic node
	 */
	public Node<T> getNext() {
		return next;
	}
	
	/**
	 * change the node item
	 * @param item - Item with generic data type
	 */
	public void setItem(T item) {
		this.item = item;
	}
	
	/**
	 * change the next node
	 * @param next - generic node
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}

}
