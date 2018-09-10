/**
 * 
 */
package cUtil;


/**
 * @author Carlos Eduardo Lizalda Valencia
 *
 */
public class SuperList<T> implements List<T>, Stack<T>, Queue<T> {
	
	  //---------------------------------------\\
	 //---------------parameters----------------\\
	//-------------------------------------------\\
	
	private Node<T> first;
	
	private Node<T> last;
	
	private int size;

	//------------------Constructors----------------\\
	
	/**
	 * create a new SuperList empty
	 */
	public SuperList() {
	}
	
	/**
	 * TO DO
	 * @param list
	 */
	public SuperList(SuperList<T> list) {
		first = list.getFirstNode();
		last = list.getLastNode();
		size = list.size();
	}
	
	/**
	 * TO DO
	 * @param list
	 */
	public SuperList(List<T> list) {
		for (int i = 0; i < list.size(); i++) {
			add(list.get(i));
		}
	}
	
	/**
	 * TO DO
	 * @param element
	 */
	public SuperList(T element) {
		first = new CNode<T>(element);
		last = first;
	}
	
	public SuperList(T[] arr) {
		for (int i = 0; i < arr.length; i++) {
			add(arr[i]);
		}
	}
	
	//------------------Methods----------------\\
	/* (non-Javadoc)
	 * @see cUtil.Queue#enqueue(java.lang.Object)
	 */
	@Override
	public void enqueue(T item) {
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

	/* (non-Javadoc)
	 * @see cUtil.Queue#dequeue()
	 */
	@Override
	public T dequeue() throws EmptyQueueExeption {
		if (isEmpty()) {
			throw new EmptyQueueExeption("the queue is empty");
		}
		Node<T> temp = first;
		first = first.getNext();
		size--;
		return temp.getItem();
	}

	/* (non-Javadoc)
	 * @see cUtil.Queue#front()
	 */
	@Override
	public T front() throws EmptyQueueExeption {
		if (isEmpty()) {
			throw new EmptyQueueExeption("the queue is empty");
		}
		return first.getItem();
	}

	/* (non-Javadoc)
	 * @see cUtil.Stack#push(java.lang.Object)
	 */
	@Override
	public void push(T newItem) {
		CNode<T> temp = new CNode<T>(newItem);
		temp.setNext(first);
		first = temp;
		size++;
	}

	/* (non-Javadoc)
	 * @see cUtil.Stack#top()
	 */
	@Override
	public T top() throws StackException {
		if (isEmpty()) {
			throw new StackException("the stack is empy");
		}
		return first.getItem();
	}

	/* (non-Javadoc)
	 * @see cUtil.Stack#pop()
	 */
	@Override
	public T pop() throws StackException {
		if (isEmpty()) {
			throw new StackException("the stack is empy");
		}
		Node<T> temp = first;
		first = first.getNext();
		size--;
		return temp.getItem();
	}

	/* (non-Javadoc)
	 * @see cUtil.List#add(java.lang.Object)
	 */
	@Override
	public void add(T item) {
		if (first == null) {
			first = new CNode<T>(item);
			size++;
		}else if(last == null){
			last = new CNode<T>(item);
			first.setNext(last);
			size++;
		}else {
			last.setNext(new CNode<T>(item));
			last = last.getNext();
			size++;
		}
	}

	/* (non-Javadoc)
	 * @see cUtil.List#add(int, java.lang.Object)
	 */
	@Override
	public void add(int index, T item) throws ListIndexOutOfBoundsException {
		if (index < 0 || index > size()) {
			throw new ListIndexOutOfBoundsException("the index " + index + " is out of the list");
		}
		Node<T> actual = first;
		for (int i = 0; i < index; i++) {
			actual = actual.getNext();
		}
		Node<T> temp = actual.getNext();
		actual.setNext(new CNode<T>(item));
		actual.getNext().setNext(temp);
		size++;
	}

	/* (non-Javadoc)
	 * @see cUtil.List#remove(int)
	 */
	@Override
	public void remove(int index) throws ListIndexOutOfBoundsException {
		if (index < 0 || index > size()) {
			throw new ListIndexOutOfBoundsException("the index " + index + " is out of the list");
		}
		if (index == 0) {
			last = first.equals(last)? null:last;
			first = first.getNext();
		}else {
			Node<T> actual = first;
			for (int i = 0; i < index - 1; i++) {
				actual = actual.getNext();
			}
			actual.setNext(actual.getNext().getNext());
		}
		size--;
	}

	/* (non-Javadoc)
	 * @see cUtil.List#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/* (non-Javadoc)
	 * @see cUtil.List#get(int)
	 */
	@Override
	public T get(int index) throws ListIndexOutOfBoundsException {
		if (index < 0 || index > size()) {
			throw new ListIndexOutOfBoundsException("the index " + index + " is out of the list");
		}
		Node<T> actual = first;
		for (int i = 0; i < index; i++) {
			actual = actual.getNext();
		}
		return actual.getItem();
	}

	/* (non-Javadoc)
	 * @see cUtil.List#size()
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	private Node<T> getFirstNode(){
		return first;
	}
	
	private Node<T> getLastNode(){
		return last;
	}

	/* (non-Javadoc)
	 * @see cUtil.List#equals(cUtil.List)
	 */
	@Override
	public boolean equals(List<T> list) {
		boolean equals = false;
		if (list.size() == this.size()) {
			equals = true;
			for (int i = 0; i < list.size() && equals; i++) {
				equals = list.get(i).equals(this.get(i));
			}
		}
		return equals;
	}
	
	public boolean equals(SuperList<T> list) {
		return first.equals(list.getFirstNode());
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
