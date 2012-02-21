package crl.action.vkiller;

import crl.action.ProjectileSkill;
import crl.player.Player;

public class Axe extends ProjectileSkill{
	public boolean piercesThru() {
		return true;
	}
	
	public int getDamage() {
		return 8 + 
			getPlayer().getShotLevel() + 
			getPlayer().getSoulPower();
	}

	public int getHit() {
		return 100;
	}

	public int getPathType() {
		return ProjectileSkill.PATH_CURVED;
	}

	public int getRange() {
		return 7;
	}

	public String getSelfTargettedMessage() {
		return "You throw an axe upwards!";
	}

	public String getSFXID() {
		return "SFX_AXE";
	}

	public String getShootMessage() {
		return "You throw an Axe";
	}

	public String getSpellAttackDesc() {
		return "axe";
	}

	public int getHeartCost() {
		return 1;
	}

	public String getID(){
		return "Axe";
	}
	
	public int getCost(){
		Player p = (Player) performer;
		return (int)(25 / (p.getShotLevel()+1));
	}
	
	public String getPromptPosition(){
		return "Where do you want to throw the Axe?";
	}
	
	public String getSFX(){
		return "wav/misswipe.wav";
	}
	
}