/**
 * 
 */
package cUtil;

import java.util.Comparator;

/**
 * @author Santiago Chasqui
 *
 */
public class CHeap <T extends Comparable<T>> implements Heap<T> , Comparator<T>{
	
	
	
	private T[] array;
	private int capacity;
	private int heapLast;
	
	/**
	 * 
	 */
	public CHeap(int maxSize) {
		
		array = (T[]) new Object[maxSize + 1];
		capacity = maxSize;
		heapLast = 0;
		
	}

	/* (non-Javadoc)
	 * @see cUtil.Heap#add(java.lang.Object)
	 */
	@Override
	public void add(T element) {
		
	       if (size() == capacity) {
//	            throw new HeapException("Heap overflow.");
	       }else{
	            heapLast++;
	            array[heapLast] = element;
	            maxHeapify();
	        }     
		
	}
	
	
	@Override
	public void maxHeapify() {
		maxHeapify(array, heapLast,0);
	}
	
	public void maxHeapify(T arr[], int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2*i + 1; // left = 2*i + 1
        int r = 2*i + 2; // right = 2*i + 2
 
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


	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(T o1, T o2) {
		// TODO Auto-generated method stub
		return ((T)o1).compareTo((T)o2);
	}


}
