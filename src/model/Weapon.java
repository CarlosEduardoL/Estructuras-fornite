package model;

public class Weapon {

	public static final int INFINITE = -1;
	
	private String type;
	private int ammunition;
	
	/**
	 * 
	 * @param type
	 */
	
	public Weapon(String type, int ammunition) {
		this.type = type;
		this.ammunition = ammunition;
	}

	public void shoot() {
		ammunition--;
	}

	public int getAmmunition() {
		return ammunition;
	}

	/**
	 * @return
	 */
	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}

}