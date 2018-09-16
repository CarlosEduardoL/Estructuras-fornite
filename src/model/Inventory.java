package model;

import cUtil.Stack;
import cUtil.StackException;

public class Inventory {
	
	private Stack<Weapon> weapons;
	private Weapon current;

	/**
	 * 
	 * @return
	 */
	public Weapon getLastWeapon() {
		if (current.getAmmunition() == 0) {
			try {
				current = weapons.pop();
			} catch (StackException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return current;
	}

	/**
	 * 
	 * @param weapon
	 */
	public void addWeapon(Weapon weapon) {
		weapons.push(weapon);
	}

}