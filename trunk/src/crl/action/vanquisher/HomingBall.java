package crl.action.vanquisher;

import crl.action.ProjectileSkill;
import crl.player.Player;

public class HomingBall extends ProjectileSkill{
	public int getDamage() {
		return 5+(int)Math.round(getPlayer().getSoulPower()*1.5d);
	}

	public int getHit() {
		return 100;
	}

	public int getPathType() {
		return PATH_DIRECT;
	}

	public String getPromptPosition() {
		return "Where will you throw a homing ball?";
	}

	public int getRange() {
		return 10;
	}

	public String getSelfTargettedMessage() {
		return "The ball flies around yourself!";
	}

	public String getSFXID() {
		return "SFX_MISSILE_HOMING_BALL";
	}

	public String getShootMessage() {
		return "You invoke a homing ball!";
	}

	public String getSpellAttackDesc() {
		return "homing ball";
	}

	public int getHeartCost() {
		return 2;
	}

	public String getID(){
		return "HomingBall";
	}

	public int getCost(){
		Player p = (Player) performer;
		return (int)(p.getCastCost() * 1.2);
	}
}