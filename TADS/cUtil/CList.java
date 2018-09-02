/**
 * @author Carlos Eduardo Lizalda Valencia
 */
package cUtil;

public class CList<T> implements List<T>{
	
	     //--------------------------------\\
	    //-------------constants------------\\
	   //------------------------------------\\
	
	/**
	 * Constant that defines the initial size of the actual array of the list
	 */
	private final int INITIAL_SIZE = 10;
	
	/**
	 * Constant that defines the factor with which the real array of the list grows
	 */
	private final int GROWTH_FACTOR = 2;
	
	  //---------------------------------------\\
	 //---------------parameters----------------\\
	//-------------------------------------------\\
	
	/**
	 * size of the list
	 */
	private int size;
	
	/**
	 * the array of the list
	 */
	private T[] array;
	
	//------------------Constructors----------------\\
	
	/**
	 * Build an empty Clist type object
	 */
	@SuppressWarnings("unchecked")
	public CList() {
		array = (T[]) new Object[INITIAL_SIZE];
		size = 0;
	}
	
	/**
	 * Build a Clist object with the elements of another list
	 * @param list - an instance of the interface List
	 */
	@SuppressWarnings("unchecked")
	public CList(List<T> list){
		array = (T[]) new Object[INITIAL_SIZE];
		size = 0;
		for (int i = 0; i < list.size(); i++) {
			add(list.get(i));
		}
	}
	
	/**
	 * Build a Clist object with the elements of an array
	 * @param arr - arrat of type T
	 */
	@SuppressWarnings("unchecked")
	public CList(T[] arr){
		array = (T[]) new Object[INITIAL_SIZE];
		size = 0;
		for (int i = 0; i < arr.length; i++) {
			add(arr[i]);
		}
	}
	//------------------Methods----------------\\

	/**
	 * <b>Pre: </b> None </br>
	 * <b>Post: </b> added the item in the last position of the List </br>
	 */
	@Override
	public void add(T item) {
		array[size] = item;
		size++;
		if (size == array.length) {
			resizeArray();
		}
	}

	/**
	 * <b>Pre: </b> index indicates the position at which the item should be inserted in the list </br>
	 * <b>Post: </b> If insertion is successful, item is at position index, and other items are renumbered accordingly. </br>
	 * @Throws ListIndexOutOfBoundsException when index < 0 or index > size()
	 */
	@Override
	public void add(int index, T item) throws ListIndexOutOfBoundsException {
		if (index < 0 || index > size()) {
			throw new ListIndexOutOfBoundsException("the index " + index + " is out of the list");
		}
		T[] temp = array.clone();
		array[index] = item;
		size++;
		for (int i = index + 1; i < size; i++) {
			array[i] = temp[i-1];
		}
		if (size == array.length) {
			resizeArray();
		}
	}

	/**
	 * <b>Pre: </b> index indicates the position in the list of the item to be removed </br>
	 * <b>Post: <b> if 1<= index <= size(), the item at position index is deleted, and other items are renumbered accordingly <br>
	 * @Throws: ListIndexOutOfBoundsException if index < 0 or index > size().
	 */
	@Override
	public void remove(int index) throws ListIndexOutOfBoundsException {
		if (index <0 || index > size()) {
			throw new ListIndexOutOfBoundsException("the index " + index + " is out of the list");
		}
		
		T[] temp = array.clone();
		array[index] = null;
		size--;
		for (int i = index+1; i < size; i++) {
			array[i-1] = temp[i];
		}
		
	}

	/**
	 * <b>Pre: </b> None </br>
	 * <b>Post: </b> if the list is empty it returns true otherwise it returns false </br>
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * <b>Pre: </b> index indicates the position in the list of the object to be returned </br>
	 * <b>Post: </b> if 1<= index <= size(), the item at position index is returned </br>
	 *  @throws ListIndexOutOfBoundsException if index < 0 or index >= size()
	 */
	@Override
	public T get(int index) {
		if (index <0 || index > size()) {
			throw new ListIndexOutOfBoundsException("the index " + index + " is out of the list");
		}
		return array[index];
	}

	/**
	 * <b>Pre: </b> None <br>
	 * <b>Post: </b> Returns the number of items currently in the list </br>
	 */
	@Override
	public int size() {
		return size;
	}
	
	private void resizeArray() {
		T[] temp = array.clone();
		array = (T[]) new Object[array.length * GROWTH_FACTOR];
		for (int i = 0; i < temp.length; i++) {
			array[i] = temp[i];
		}
	}
	
	public boolean equals(CList<T> list) {
		boolean equals = false;
		if (list.size() == this.size()) {
			equals = true;
			for (int i = 0; i < list.size() && equals; i++) {
				equals = list.get(i).equals(this.get(i));
			}
		}
		return equals;
	}

}
