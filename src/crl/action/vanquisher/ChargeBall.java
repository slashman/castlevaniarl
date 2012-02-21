package crl.action.vanquisher;

import crl.action.ProjectileSkill;
import crl.player.Player;

public class ChargeBall extends ProjectileSkill{
	public int getDamage() {
		return 8+(int)Math.round(getPlayer().getSoulPower()*2.5d);
	}

	public int getHit() {
		return 100;
	}

	public int getPathType() {
		return PATH_LINEAR;
	}

	public int getRange() {
		return 10;
	}

	public String getSelfTargettedMessage() {
		return "The ball of energy explodes";
	}
	
	public boolean allowsSelfTarget() {
		return false;
	}

	public String getSFXID() {
		return "SFX_CHARGE_BALL";
	}

	public String getShootMessage() {
		return "You concentrate and launch a charge ball!";
	}

	public String getSpellAttackDesc() {
		return "charge ball";
	}

	public int getHeartCost() {
		return 6;
	}

	public String getID(){
		return "ChargeBall";
	}
	
	public int getCost(){
		Player p = (Player) performer;
		return (int)(p.getCastCost() * 1.5);
	}
	
	public String getPromptPosition(){
		return "Where do you want to throw the charge Ball?";
	}
}