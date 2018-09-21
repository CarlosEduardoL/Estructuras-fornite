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
		weapons = new SuperList<Weapon>(new Weapon("/axe.png",Weapon.INFINITE));
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
	 * @throws StackException 
	 */
	public Weapon getLastWeapon() throws StackException {
		if (weapons.top().getAmmunition() > 1 || weapons.top().getType().equals("/axe.png")) {
			try {
				current = weapons.top();
				
			} catch (StackException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				current = weapons.pop();
			} catch (StackException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		current.shoot();
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