/**
 * 
 */
package cUtil;

/**
 * @author ZeroN
 *
 */
public class HashNode<T, K> {

	private T data;
	
	private K key;
	
	public HashNode(T data, K key){
		this.data = data;
		this.key = key;
	}

	public T getData() {
		return data;
	}

	public K getKey() {
		return key;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setKey(K key) {
		this.key = key;
	}

}
