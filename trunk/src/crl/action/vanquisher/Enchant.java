package crl.action.vanquisher;

import crl.action.HeartAction;
import crl.player.Consts;

public class Enchant extends HeartAction{
	public int getHeartCost() {
		return 5;
	}
	
	public String getID() {
		return "ENCHANT";
	}
	
	public void execute() {
		super.execute();
		if (getPlayer().getWeapon() == null){
			getPlayer().getLevel().addMessage("The energy flies away");
		} else {
			getPlayer().getWeapon().setCounter(Consts.C_WEAPON_ENCHANTMENT, 50+getPlayer().getSoulPower());
			getPlayer().addCounteredItem(getPlayer().getWeapon());
			getPlayer().getLevel().addMessage("The "+getPlayer().getWeapon().getDescription()+" glows in a blue aura!");
		}

	}
}
