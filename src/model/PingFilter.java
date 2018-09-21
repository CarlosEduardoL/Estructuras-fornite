/**
 * 
 */
package model;

import cUtil.CList;
import cUtil.CQueue;
import cUtil.EmptyQueueExeption;
import cUtil.HashNode;
import cUtil.List;
import cUtil.Map;

/**
 * @author Santiago Chasqui
 *
 */
public class PingFilter<K,T> implements Map<K,T>{
	
	private static final int INITIAL_SIZE = 100;
	private static final double GROWTH_FACTOR = 0.5;
	
	private double alpha;
	private CQueue<Player>[] queue;
	private int numberOfElements;
	private CList<Match> readyMatches;
	
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public PingFilter() {
		queue = (CQueue<Player>[]) new List[INITIAL_SIZE];
	}
	

	/* (non-Javadoc)
	 * @see cUtil.Map#set(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void set(K key, T value) {
		if (queue[hash(key)] == null) {
			queue[hash(key)] = new CQueue<Player>();
			queue[hash(key)].enqueue((Player) value);
		} else {
			queue[hash(key)].enqueue((Player)value);
			
			if(queue[hash(key)].getSize() == 100) {
				Player[] setOfReadyPlayers = new Player[100];
				for (int i = 0; i < 100; i++) {
					try {
						setOfReadyPlayers[i] = queue[hash(key)].dequeue();
						if(i == 99) {
							readyMatches.add(new Match(setOfReadyPlayers));
						}
					} catch (EmptyQueueExeption e) {
						// TODO Auto-generated catch block
						System.out.println("El método set de la clase PingFilter ha fallado");
						e.printStackTrace();
					}
				}
			}
		}
		numberOfElements++;
//		alpha = numberOfElements/queue.length;
//		if (alpha > 0.7) {
//			rehashing();
//		}
	}

	/* (non-Javadoc)
	 * @see cUtil.Map#get(java.lang.Object)
	 */
	@Override
	public T get(K key) {
		T value = null;
//		List<HashNode<T, K>> list = queue[hash(key)];
//		if (list != null) {
//			for (int i = 0; i < list.size(); i++) {
//				if (list.get(i).getKey().equals(key)) {
//					value = list.get(i).getData();
//				}
//			}
//		}
		return value;
	}

	/* (non-Javadoc)
	 * @see cUtil.Map#remove(java.lang.Object)
	 */
	@Override
	public T remove(K key) {
		T value = null;
//		int index = -1;
//		CQueue<HashNode<T, K>> list = queue[hash(key)];
//		if (list != null) {
//			for (int i = 0; i < list.getSize(); i++) {
//				if (list.get(i).getKey().equals(key)) {
//					value = list.get(i).getData();
//					index = i;
//					numberOfElements--;
//					alpha = numberOfElements/queue.length;
//				}
//			}
//		}
//		if (index != -1) {
//			queue[hash(key)].remove(index);
//		}
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
		return Math.abs(key.hashCode() % queue.length);
	}

	/* (non-Javadoc)
	 * @see cUtil.Map#rehashing()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void rehashing() {
		CQueue<T>[] temp = (CQueue<T>[]) queue.clone();
		queue = (CQueue<Player>[]) new List[(int) (queue.length * (1 + GROWTH_FACTOR) )];
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] != null) {
//				for (int j = 0; j < temp[i].size(); j++) {
//					set(temp[i].get(j).getKey(), temp[i].get(j).getData());
//				}
			}
		}
	}
	
	public int getqueueLength() {
		return queue.length;
	}
	
	public CList<Match> getReadyMatches(){
		return readyMatches;
	}

}
