package model;

import cUtil.*;

public class Ranking {

	private Heap<Player> rank;

	public Ranking() {
		rank = new CHeap<Player>(10);
	}

}