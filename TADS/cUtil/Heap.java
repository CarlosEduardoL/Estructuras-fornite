package cUtil;

/**
 * @author Santiago Chasqui
 *
 */
public interface Heap <T>{
	
	
	/**
	 * Preserves the heap property by rearranging the array
	 * <b>Pre: </b> The heap is != null </br>
	 * <b>Post: </b> The element gets in the heap and it increases its length by one </br>
	 * @param element - Is the item to be added to the heap.
	 */
	public void add(T element);
	
	/**
	 * Preserves the heap property by rearranging the array
	 * <b>Pre: </b> The Heap is not empty </br>
	 * <b>Post: </b> The array is reorganized with heap properties </br>
	 */
	public void maxHeapify();
	
	/**
	 * Sorts the array that represents the heap in dicreasing order.
	 * <b>Pre: </b> The Heap is not empty </br>
	 * <b>Post: </b> The array which contain the heap is sorted </br>
	 */
	public void heapSort();
	
	/**
	 * Removes an element from the heap maintaining the heap's properties.
	 * <b>Pre: </b> The Heap is not empty </br>
	 * <b>Post: </b> The element is removed from the heap </br>
	 */
	public void remove();
	
	/**
	 * Sorts the array that represents the heap in decreasing order.
	 * <b>Pre: </b> The Heap is not empty </br>
	 * <b>Post: </b> The array which contain the heap is sorted </br>
	 */
	public boolean isEmpty();
	
	/**
	 * Method which give the size of the heap.
	 * <b>Pre: </b> None </br>
	 * <b>Post: </b> None </br>
	 * @return size - Is the size of the heap
	 */
	public int size();

	/**
	 * @param array
	 * @return
	 */
	public T[] buildMaxHeap(T[] array);
	
	public T getElement(int index);
	
}
