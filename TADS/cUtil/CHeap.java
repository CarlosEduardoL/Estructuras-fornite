/**
 * 
 */
package cUtil;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Santiago Chasqui
 * @author Carlos Eduardo Lizalda V.
 */
public class CHeap <T extends Comparable<? super T>> implements Heap<T> {

	/**
	 * Constant that defines the initial size of the actual array of the heap
	 */
	private final int INITIAL_SIZE = 10;

	/**
	 * Constant that defines the factor with which the real array of the heap grows
	 */
	private final double GROWTH_FACTOR = 0.5;

	private T[] array;
	private int capacity;
	private int heapLast;

	/**
	 * 
	 */
	public CHeap() {

		capacity = INITIAL_SIZE+1;
		array = (T[]) new Comparable[capacity];
		heapLast = 0;

	}

	/* (non-Javadoc)
	 * @see cUtil.Heap#add(java.lang.Object)
	 */
	@Override
	public void add(T element) {

		if (heapLast == capacity) {
			resizeArray(1);
			System.out.println("Flag in add - class CHEAP");
		}
		
		heapLast++;
		int i = heapLast - 1;
		array[i] = element;
		
		maxHeapify();    

	}


	@Override
	public void maxHeapify() {
		
		maxHeapify(array, 0);
	}

	public void maxHeapify(T arr[], int i) {
		int largest = i; // Initialize largest as root
		int l = 2*i + 1; // left = 2*i + 1
		int r = 2*i + 2; // right = 2*i + 2

		// If left child is larger than roots
		if (l < heapLast && arr[l].compareTo((T)arr[largest]) > 0)
			largest = l;
		else largest = i;
		// If right child is larger than largest so far
		if ( r < heapLast && arr[r].compareTo((T)arr[largest])>0)
			largest = r;

		// If largest is not root
		if (largest != i)
		{
			T swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;

			// Recursively heapify the affected sub-tree
			maxHeapify(arr, largest);
		}
	}



	/**
	 * @param index
	 * @param parent
	 */
	public void swap(int index, int parent) {
		T temp = array[index];
		array[index] = array[parent];
		array[index] = temp;

	}

	/* (non-Javadoc)
	 * @see cUtil.Heap#heapSort()
	 */
	@Override
	public void heapSort() {
		// TODO Auto-generated method stub
		int n = array.length;

		// One by one extract an element from heap
		for (int i=n-1; i>=0; i--)
		{
			// Move current root to end
			T temp = array[0];
			array[0] = array[i];
			array[i] = temp;

			// call max heapify on the reduced heap
			maxHeapify(array, i, 0);
		}


	}

	/* (non-Javadoc)
	 * @see cUtil.Heap#remove()
	 */
	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see cUtil.Heap#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T[] buildMaxHeap(T[] arrayN){
		T[] arrayMax = arrayN;
		int n = arrayN.length;

		for (int i = n / 2 - 1; i >= 0; i--)
			maxHeapify(arrayMax, n, i);

		return arrayMax;
	}

	/* (non-Javadoc)
	 * @see cUtil.Heap#size()
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return heapLast;
	}

	@SuppressWarnings("unused")
	private void resizeArray(int factor) {
		T[] temp = array.clone();
		array = (T[]) new Object[(int) (array.length * (1 + GROWTH_FACTOR * factor) )];
		for (int i = 0; i < temp.length && temp[i] != null; i++) {
			array[i] = temp[i];
		}
	}



	/* (non-Javadoc)
	 * @see cUtil.Heap#getElement(int)
	 */
	@Override
	public T getElement(int index) {
		// TODO Auto-generated method stub
		if(index <= heapLast && index>=0) {
			
		}else {
			//HeapOutOfBounds Exception
		}
		return array[index];
	}


}
