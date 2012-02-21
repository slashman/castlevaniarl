package crl.action.vkiller;

import sz.util.Position;
import sz.util.Util;
import crl.action.ProjectileSkill;
import crl.game.SFXManager;
import crl.player.Player;

public class ItemBreakAxe extends ProjectileSkill{
	public int getDamage() {
		return 8 + 
		getPlayer().getShotLevel() + 
		getPlayer().getSoulPower();
	}

	public int getHit() {
		return 100;
	}

	public int getPathType() {
		return ProjectileSkill.PATH_LINEAR;
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

	private boolean executing = false;
	public int getHeartCost() {
		if (executing)
			return 0;
		else
			return 5;
	}
	
	

	
	public String getID(){
		return "Axe";
	}
	
	public boolean needsPosition(){
		return false;
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
	
	public boolean showThrowMessage() {
		return false;
	}
	public void execute(){
		getPlayer().reduceHearts(getHeartCost());
		executing = true;
		Position destinationPoint = Position.add(getPlayer().getPosition(), new Position(1,1));
		setPosition(destinationPoint);
		super.execute();
		destinationPoint = Position.add(getPlayer().getPosition(), new Position(1,-1));
		setPosition(destinationPoint);
		SFXManager.play(getSFX());
		super.execute();
		destinationPoint = Position.add(getPlayer().getPosition(), new Position(-1,1));
		setPosition(destinationPoint);
		SFXManager.play(getSFX());
		super.execute();
		destinationPoint = Position.add(getPlayer().getPosition(), new Position(-1,-1));
		setPosition(destinationPoint);
		SFXManager.play(getSFX());
		super.execute();
		for (int i = 0; i < 2; i++){
			int xdif = 3-Util.rand(0,6);
			int ydif = 3-Util.rand(0,6);
			destinationPoint = Position.add(getPlayer().getPosition(), new Position(xdif,ydif));
			setPosition(destinationPoint);
			SFXManager.play(getSFX());
			super.execute();
		}
		executing = false;
	}
}