package crl.action.invoker;

import crl.action.ProjectileSkill;
import crl.player.Player;

public class Cat extends ProjectileSkill{
	public int getDamage() {
		return 10+getPlayer().getSoulPower()*2;
	}

	public int getHit() {
		return 100;
	}

	public int getPathType() {
		return PATH_HOVER;
	}
	
	public boolean piercesThru() {
		return true;
	}

	public int getRange() {
		return 20;
	}

	public String getSelfTargettedMessage() {
		return "You summon a jumping cat! The cat roars like mad!! The cat falls, scratching all around!";
	}

	public String getSFXID() {
		return "SFX_CAT";
	}

	public String getShootMessage() {
		return "You summon a quick running cat!";
	}

	public String getSpellAttackDesc() {
		return "cat soul";
	}

	public int getHeartCost() {
		return 3;
	}
	
	public String getID(){
		return "Cat";
	}
	
	public String getSFX(){
		return "wav/kitty.wav";
	}

	public int getCost(){
		Player p = (Player) performer;
		return (int)(p.getCastCost() * 1.4);
	}
	
	public String getPromptPosition(){
		return "Where do you want to invoke the kitty?";
	}
}