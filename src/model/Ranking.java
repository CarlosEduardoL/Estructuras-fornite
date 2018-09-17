package model;

//import cUtil.CHeap;
//import cUtil.Heap;
import cUtil.SCHeap;

public class Ranking {
	
	private SCHeap<Player> rank;
	
	// Temporal mientras se termina heap
	
	
 	public Ranking() {
		rank = new SCHeap<Player>(10);
		
		SCHeap<Integer> test = new SCHeap<Integer>(10); 
		Integer[] arr = {1,5,8,7,2,5,2,41,99};
		for (int i = 0; i < arr.length; i++) {
			test.add(arr[i]);
		}
		test.heapSort();
		
	}
 	
 	public void addPlayer(Player p) {
 		rank.add(p);
 	}
 	
 	public Player[] getRanking() {
 		rank.heapSort();
 		Player[] ranking = new Player[rank.size()];
 		for (int i = ranking.length-1; i >=0 ; i--) {
			ranking[i] = rank.getMin();
		}
 		return ranking;
 	}
}