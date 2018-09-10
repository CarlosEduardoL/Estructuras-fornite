/**
 * @author Carlos Eduardo Lizalda Valencia
 */
package cUtil;

public class CNode<T> implements Node<T>{

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
	
	/**
	 * previous node
	 */
	private Node<T> previus;

	//------------------Constructors----------------\\
	/**
	 * build an empty node
	 */
	public CNode() {
		item = null;
		next = null;
	}	
	
	/**
	 * build a node with a given item </br>
	 * @param item - Item with generic data type
	 */
	public CNode(T item) {
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
	
	public boolean equals(Node<T> node) {
		if (node == null) {
			return false;
		}
		return item.equals(node.getItem()) && subEquals(getNext(), node.getNext()) ;
	}
	
	private boolean subEquals(Node<T> a, Node<T> b) {
		if (a == null && b == null) {
			return true;
		}else if(!(a == null && b == null)) {
			return false;
		}else if(a.getItem().equals(b.getItem())){
			return true && subEquals(a.getNext(), b.getNext());
		}else {
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see cUtil.Node#getPrevious()
	 */
	@Override
	public Node<T> getPrevious() {
		return previus;
	}

	/* (non-Javadoc)
	 * @see cUtil.Node#setPrevious(cUtil.Node)
	 */
	@Override
	public void setPrevious(Node<T> previus) {
		this.previus = previus;
	}
}
