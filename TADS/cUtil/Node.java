/**
 * 
 */
package cUtil;

/**
 * @author ZeroN
 *
 */
public interface Node<T> {

	/**
	 * returns the item of the node, if it does not exist it returns null </br>
	 * @return Item with generic data type
	 */
	public T getItem();
	
	/**
	 * returns the next node, if the current node is the last one returns null
	 * @return generic node
	 */
	public Node<T> getNext();
	
	/**
	 * returns the previous node, if the current node is the first one returns null
	 * @return generic node
	 */
	public Node<T> getPrevious();
	
	/**
	 * change the node item
	 * @param item - Item with generic data type
	 */
	public void setItem(T item);
	
	/**
	 * change the next node
	 * @param next - generic node
	 */
	public void setNext(Node<T> next);
	
	/**
	 * check if two nodes are equals
	 * @param node - the other node
	 * @return - a boolean that represent if the nodes are equals or not
	 */
	public boolean equals(Node<T> node);
	
	
}
