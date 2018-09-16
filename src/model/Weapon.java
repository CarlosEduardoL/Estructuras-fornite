package model;

public class Weapon {

	public static final int INFINITE = -1;
	
	private String type;
	private int ammunition;
	
	/**
	 * 
	 * @param type
	 */
	public Weapon(String type) {
		this.type = type;
	}

	public void shoot() {
		ammunition--;
	}

	public int getAmmunition() {
		return ammunition;
	}

}