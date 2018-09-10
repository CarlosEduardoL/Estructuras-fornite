/**
 * 
 */
package cUtil;

/**
 * @author Carlos Eduardo Lizalda Valencia
 *
 */
public class CHashTable<K, T> implements Map<K, T> {
	
	private static final int INITIAL_SIZE = 10;
	
	private List<HashNode<T, K>>[] array;
	private int numberOfElements;
	
	/**
	 * 
	 */
	public CHashTable() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see cUtil.Map#set(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void set(K key, T value) {
		if (array[hash(key)] == null) {
			array[hash(key)] = new CList<HashNode<T, K>>();
			array[hash(key)].add(new HashNode<T, K>(value, key));
		} else {
			array[hash(key)].add(new HashNode<T, K>(value, key));
		}
		numberOfElements++;
	}

	/* (non-Javadoc)
	 * @see cUtil.Map#get(java.lang.Object)
	 */
	@Override
	public T get(K key) {
		T value = null;
		List<HashNode<T, K>> list = array[hash(key)];
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getKey().equals(key)) {
					value = list.get(i).getData();
				}
			}
		}
		return value;
	}

	/* (non-Javadoc)
	 * @see cUtil.Map#remove(java.lang.Object)
	 */
	@Override
	public T remove(K key) {
		T value = null;
		int index = -1;
		List<HashNode<T, K>> list = array[hash(key)];
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getKey().equals(key)) {
					value = list.get(i).getData();
					index = i;
					numberOfElements--;
				}
			}
		}
		if (index != -1) {
			array[hash(key)].remove(index);
		}
		return value;
	}

	/* (non-Javadoc)
	 * @see cUtil.Map#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return numberOfElements == 0;
	}

	/* (non-Javadoc)
	 * @see cUtil.Map#tableLength()
	 */
	@Override
	public int tableLength() {
		return array.length;
	}
	
	private int hash(K key) {
		return key.hashCode() % array.length;
	}

}
