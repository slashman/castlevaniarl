package crl.action.invoker;

import sz.util.Position;
import crl.action.Action;
import crl.action.HeartAction;
import crl.action.ProjectileSkill;
import crl.actor.Actor;
import crl.feature.Feature;
import crl.level.Cell;
import crl.level.Level;
import crl.monster.Monster;
import crl.player.Player;


public class Bird extends ProjectileSkill{
	public String getID(){
		return "Bird";
	}
	
	public boolean needsDirection(){
		return true;
	}
	public boolean needsPosition(){
		return false;
	}
	
	public int getDamage() {
		return 5+getPlayer().getSoulPower()*2;
	}

	public int getHit() {
		return 100;
	}

	public int getPathType() {
		return PATH_LINEAR;
	}

	public String getPromptPosition() {
		return null;
	}

	public int getRange() {
		return 20;
	}

	public String getSelfTargettedMessage() {
		return "The bird souls circle you and fly away";
	}

	public String getSFXID() {
		return "SFX_BIRD";
	}

	public String getShootMessage() {
		return null;
	}
	
	public boolean showThrowMessage() {
		return false;
	}

	public String getSpellAttackDesc() {
		return "bird soul";
	}

	public String getSFX(){
		return "wav/birdchrp.wav";
	}
	
	private boolean executing = false;
	public int getHeartCost() {
		if (executing)
			return 0;
		else
			return 2;
	}
	
	public void execute(){
		reduceHearts();
		executing = true;
		Level aLevel = performer.getLevel();
		Player aPlayer = aLevel.getPlayer();
		aLevel.addMessage("You invoke two bird souls!");


		int otherDir1 = 0;
		int otherDir2 = 0;
		switch (targetDirection){
			case Action.UP:
				otherDir1 = Action.UPLEFT;
				otherDir2 = Action.UPRIGHT;
				break;
			case Action.DOWN:
				otherDir1 = Action.DOWNLEFT;
				otherDir2 = Action.DOWNRIGHT;
				break;
			case Action.LEFT:
				otherDir1 = Action.UPLEFT;
				otherDir2 = Action.DOWNLEFT;
				break;
			case Action.RIGHT:
				otherDir1 = Action.UPRIGHT;
				otherDir2 = Action.DOWNRIGHT;
				break;
			case Action.UPRIGHT:
				otherDir1 = Action.UP;
				otherDir2 = Action.RIGHT;
				break;
			case Action.UPLEFT:
				otherDir1 = Action.UP;
				otherDir2 = Action.LEFT;
				break;
			case Action.DOWNLEFT:
				otherDir1 = Action.LEFT;
				otherDir2 = Action.DOWN;
				break;
			case Action.DOWNRIGHT:
				otherDir1 = Action.RIGHT;
				otherDir2 = Action.DOWN;
				break;
			case Action.SELF:
				aLevel.addMessage("The birds fly away!");
	        	return;
		}
		targetPosition = Position.add(aPlayer.getPosition(), directionToVariation(otherDir1));
		super.execute();
		targetPosition = Position.add(aPlayer.getPosition(), directionToVariation(otherDir2));
		super.execute();
		executing = false;
	}

	public int getCost(){
		Player p = (Player) performer;
		return (int)(p.getCastCost() * 1.3);
	}
	
	public String getPromptDirection(){
		return "Where do you want to call the birds?";
	}
}