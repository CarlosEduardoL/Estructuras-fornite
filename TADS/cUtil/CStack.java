/**
 * 
 */
package cUtil;

/**
 * @author Carlos Eduardo Lizalda Valencia
 *
 */
public class CStack<T> implements Stack<T> {
	
	  //---------------------------------------\\
	 //---------------parameters----------------\\
	//-------------------------------------------\\
	/**
	 * the size of the Stack
	 */
	private int size;
	/**
	 * main node
	 */
	private Node<T> top;
	
	//------------------Constructors----------------\\
	
	/**
	 * Build an empty Stack
	 */
	public CStack() {
		size = 0;
	}
	
	//------------------Methods----------------\\
	
	/* (non-Javadoc)
	 * @see cUtil.Stack#push(java.lang.Object)
	 */
	@Override
	public void push(T newItem) {
		Node<T> temp = new CNode<T>(newItem);
		temp.setNext(top);
		top = temp;
		size++;
	}

	/* (non-Javadoc)
	 * @see cUtil.Stack#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/* (non-Javadoc)
	 * @see cUtil.Stack#top()
	 */
	@Override
	public T top() throws StackException {
		if (isEmpty()) {
			throw new StackException("the stack is empy");
		}
		return top.getItem();
	}

	/* (non-Javadoc)
	 * @see cUtil.Stack#pop()
	 */
	@Override
	public T pop() throws StackException {
		if (isEmpty()) {
			throw new StackException("the stack is empy");
		}
		Node<T> temp = top;
		top = top.getNext();
		size--;
		return temp.getItem();
	}

}
