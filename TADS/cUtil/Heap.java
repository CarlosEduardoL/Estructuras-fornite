/**
 * 
 */
package cUtil;

/**
 * @author Carlos Eduardo Lizalda Valencia
 *
 */
public interface Heap<T> {
	
	public void add(T item);
	
	public T delete(int index);
	
	public boolean isEmpty();
	

}
