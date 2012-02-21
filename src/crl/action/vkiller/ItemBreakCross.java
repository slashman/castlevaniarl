package crl.action.vkiller;

import sz.util.Position;
import sz.util.Util;
import crl.action.ProjectileSkill;
import crl.game.SFXManager;
import crl.player.Player;

public class ItemBreakCross extends ProjectileSkill{
	public int getDamage() {
		return 5 + 
		getPlayer().getShotLevel() + 
		2* getPlayer().getSoulPower();
	}

	public int getHit() {
		return 100;
	}

	public boolean showThrowMessage(){
		return false;
	}
	
	public boolean piercesThrough(){
		return true;
	}
	
	public int getPathType() {
		return PATH_LINEAR;
	}

	public int getRange() {
		return 7;
	}

	public String getSelfTargettedMessage() {
		return "You throw the holy cross!";
	}

	public String getSFXID() {
		return "SFX_CROSS";
	}
	
	

	public String getShootMessage() {
		return "You throw the holy cross!";
	}

	public String getSpellAttackDesc() {
		return "cross";
	}

	private boolean executing = false;
	public int getHeartCost() {
		if (executing)
			return 0;
		else
			return 5;
	}

	public String getID(){
		return "Cross";
	}
	
	public String getPromptPosition(){
		return "Where do you want to throw the Cross?";
	}
	
	public boolean needsPosition(){
		return false;
	}
	public int getCost(){
		if (performer instanceof Player){
			Player p = (Player) performer;
			return (int)(25 / (p.getShotLevel()+1));
		} else
			return 40;
	}
	
	public String getSFX(){
		return "wav/misswipe.wav";
	}
	
	public void execute(){
		getPlayer().reduceHearts(getHeartCost());
		executing = true;
		Position destinationPoint = Position.add(getPlayer().getPosition(), new Position(0,1));
		setPosition(destinationPoint);
		super.execute();
		destinationPoint = Position.add(getPlayer().getPosition(), new Position(0,-1));
		setPosition(destinationPoint);
		SFXManager.play(getSFX());
		super.execute();
		destinationPoint = Position.add(getPlayer().getPosition(), new Position(1,0));
		setPosition(destinationPoint);
		SFXManager.play(getSFX());
		super.execute();
		destinationPoint = Position.add(getPlayer().getPosition(), new Position(-1,0));
		setPosition(destinationPoint);
		SFXManager.play(getSFX());
		super.execute();
		for (int i = 0; i < 5; i++){
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