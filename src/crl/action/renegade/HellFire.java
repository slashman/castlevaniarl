package crl.action.renegade;

import crl.action.BeamProjectileSkill;
import crl.player.Player;

public class HellFire extends BeamProjectileSkill{
	
	public int getDamage() {
		return 25+getPlayer().getSoulPower()*3;
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
		return "SFX_HELLFIRE";
	}

	public String getShootMessage() {
		return "Three balls of lava emerge from your cape!";
	}

	public String getSpellAttackDesc() {
		return "hellfire";
	}

	public int getHeartCost() {
		return 15;
	}

	public String getID(){
		return "HellFire";
	}
	
	public String getSFX(){
		return "wav/fire.wav";
	}

	public int getCost(){
		Player p = (Player) performer;
		return (int)(p.getCastCost() * 1.1);
	}
	
	public String getPromptPosition(){
		return "Where do you want to summon Hellfire?";
	}
	
	
}