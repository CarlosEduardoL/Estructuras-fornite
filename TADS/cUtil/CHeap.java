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

	/* (non-Javadoc)
	 * @see cUtil.Heap#maxHeapify()
	 */
	@Override
	public void maxHeapify() {
		// TODO Auto-generated method stub
        int index = size();
        while (index > 1){
            int parent = index / 2;
            if (compare(array[index], array[parent]) >= 0)
                //break if the parent is greater or equal to the current element
                break;
            swap(index,parent);
            index = parent;
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

	/* (non-Javadoc)
	 * @see cUtil.Heap#size()
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
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
