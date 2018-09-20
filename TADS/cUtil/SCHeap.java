/**
 * 
 */
package cUtil;

import java.util.Comparator;

/**
 * @author Carlos Eduardo Lizalda Valencia
 * @author Santiago Chasqui Córdoba
 *
 */
public class SCHeap<T extends Comparable<T>> implements Heap<T>,Comparator<T> {

	/**
	 * Constant that defines the factor with which the real array of the heap grows
	 */
	private final double GROWTH_FACTOR = 0.5;

	private T[] array;
	private int capacity;
	private int heapLast;
	private int corretion;

	/**
	 * 
	 */
	public SCHeap(int maxSize) {

		array = (T[]) new Comparable[maxSize + 1];
		capacity = array.length;
		heapLast = 0;

	}
	
	private void bubbleUp() {
        int index = size();
        
        while (hasParent(index) && (parent(index).compareTo(array[index]) <  0)) {
            // parent/child are out of order; swap them
        	
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }        
    }

	/**
	 * @param index
	 * @return
	 */
	private int parentIndex(int index) {
		// TODO Auto-generated method stub
		return index/2;
	}

	/**
	 * @param index
	 * @return
	 */
	private T parent(int index) {
		// TODO Auto-generated method stub
		return array[(parentIndex(index))];
	}

	/**
	 * @param index
	 * @return
	 */
	private boolean hasParent(int index) {
		return index>1;
	}

	/* (non-Javadoc)
	 * @see cUtil.Heap#add(java.lang.Object)
	 */
	@Override
	public void add(T element) {

		if (size() == capacity-1) {
			resizeArray(1);
			capacity = array.length;
		}
		
		heapLast++;
		array[heapLast] = element;
//		maxHeapify(); 
		
		int n = size();

		// One by one extract an element from heap
		for (int i=n/2; i>0; i--)
		{
			// call max heapify on the reduced heap
			maxHeapify(array, n+1, i);
		}
		

	}


	@Override
	public void maxHeapify() {
		maxHeapify(array, heapLast,1);
	}

	public void maxHeapify(T arr[], int n, int i) {
		int largest = i; // Initialize largest as root
		int l = 2*i ; // left = 2*i + 1
		int r = 2*i + 1; // right = 2*i + 2

		// If left child is larger than root
		if (l < n && arr[l].compareTo(arr[largest]) > 0)
			largest = l;

		// If right child is larger than largest so far
		if (r < n && arr[r].compareTo(arr[largest])>0)
			largest = r;

		// If largest is not root
		if (largest != i)
		{
			T swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;

			// Recursively heapify the affected sub-tree
			maxHeapify(arr, n, largest);
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
		int n = size();

		// One by one extract an element from heap
		for (int i=n/2; i>0; i--)
		{
			// call max heapify on the reduced heap
			maxHeapify(array, n, i);
		}
		for (int i=n-1; i>0; i--)
        {
			// Move current root to end
			T temp = array[1];
			array[1] = array[i];
			array[i] = temp;
			maxHeapify(array, i, 1);
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
			maxHeapify(arrayMax, n+1, i);

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
		array = (T[]) new Comparable[(int) (array.length * (1 + GROWTH_FACTOR * factor) )];
		for (int i = 1; i < temp.length && temp[i] != null; i++) {
			array[i] = temp[i];
		}
	}
	
	public T getMin(){
		if (corretion > capacity) {
			corretion = 0;
		}
		return array[corretion++];
	}

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(T o1, T o2) {
		// TODO Auto-generated method stub
		return ((T)o1).compareTo((T)o2);
	}

	/* (non-Javadoc)
	 * @see cUtil.Heap#getElement(int)
	 */
	@Override
	public T getElement(int index) {
		// TODO Auto-generated method stub
		return array[index];
	}
}
