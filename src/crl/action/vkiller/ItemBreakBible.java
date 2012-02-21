package crl.action.vkiller;

import crl.action.BeamProjectileSkill;
import crl.player.Player;

public class ItemBreakBible extends BeamProjectileSkill{
	
	public int getDamage() {
		return 7 + 
		getPlayer().getShotLevel() + 
		getPlayer().getSoulPower()*2;
	}
	
	public boolean piercesThru() {
		return true;
	}

	public int getHit() {
		return 100;
	}

	public int getPathType() {
		return PATH_LINEAR;
	}

	public int getRange() {
		return 15;
	}

	public String getSelfTargettedMessage() {
		return "The fireball flies to the heavens";
	}
	
	public boolean allowsSelfTarget() {
		return false;
	}

	public String getSFXID() {
		return "SFX_ITEMBREAKBIBLE";
	}

	public String getShootMessage() {
		return "The bible opens and shreds a beam of light!";
	}

	public String getSpellAttackDesc() {
		return "beam of light";
	}

	public int getHeartCost() {
		return 2;
	}

	public String getID(){
		return "ItemBreakBible";
	}
	
	public String getSFX(){
		return "wav/fire.wav";
	}

	public int getCost(){
		Player p = (Player) performer;
		return (int)(p.getCastCost() * 1.1);
	}
	
	public String getPromptPosition(){
		return "Where?";
	}
	
	
}