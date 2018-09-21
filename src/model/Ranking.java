package model;

//import cUtil.CHeap;
//import cUtil.Heap;
import cUtil.SCHeap;

public class Ranking {
	
	private SCHeap<Player> rank;
	
	// Temporal mientras se termina heap
	
	
 	public Ranking() {
		rank = new SCHeap<Player>(100000);		
	}
 	
 	public void addPlayer(Player p) {
 		rank.add(p);
 	}
 	
 	public Player[] getRanking() {
 		
 		Player[] ranking = new Player[rank.size()];
 		for (int i = ranking.length-1; i >=0 ; i--) {
			ranking[i] = rank.getMin();
		}
 		return ranking;
 	}

	/**
	 * 
	 */
	public void sort() {
		rank.heapSort();
	}
}