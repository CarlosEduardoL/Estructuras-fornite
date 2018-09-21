/**
 * 
 */
package cUtil;

/**
 * @author Carlos Eduardo Lizalda Valencia
 *
 */
public class CHashTable<K, T> implements Map<K, T> {
	
	private static final int INITIAL_SIZE = 100;
	private static final double GROWTH_FACTOR = 0.5;
	
	private double alpha;
	private List<HashNode<T, K>>[] array;
	private int numberOfElements;
	
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public CHashTable() {
		array = (List<HashNode<T, K>>[]) new List[INITIAL_SIZE];
	}
	
	public CHashTable(int size) {
		array = (List<HashNode<T, K>>[]) new List[size];
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
		alpha = numberOfElements/array.length;
		if (alpha > 0.7) {
			rehashing();
		}
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
					alpha = numberOfElements/array.length;
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
		return numberOfElements;
	}
	/*
	 * (non-Javadoc)
	 * @see cUtil.Map#hash(java.lang.Object)
	 */
	public int hash(K key) {
		return Math.abs(key.hashCode() % array.length);
	}

	/* (non-Javadoc)
	 * @see cUtil.Map#rehashing()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void rehashing() {
		List<HashNode<T, K>>[] temp = array.clone();
		array = (List<HashNode<T, K>>[]) new List[(int) (array.length * (1 + GROWTH_FACTOR) )];
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] != null) {
				for (int j = 0; j < temp[i].size(); j++) {
					set(temp[i].get(j).getKey(), temp[i].get(j).getData());
				}
			}
		}
	}
	
	public int getArrayLength() {
		return array.length;
	}

}
