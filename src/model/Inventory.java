package model;

import cUtil.Stack;
import cUtil.StackException;
import cUtil.SuperList;

public class Inventory {
	
	private Stack<Weapon> weapons;
	private Weapon current;
	
	/**
	 * 
	 */
	public Inventory() {
		weapons = new SuperList<Weapon>(new Weapon("axe",Weapon.INFINITE));
		try {
			current = weapons.top();
		} catch (StackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

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