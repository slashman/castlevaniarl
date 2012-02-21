package crl.action.invoker;

import sz.util.Position;
import crl.action.Action;
import crl.action.BeamProjectileSkill;
import crl.feature.Feature;
import crl.level.Level;
import crl.monster.Monster;
import crl.player.Player;

public class DrakeSoul extends BeamProjectileSkill{
	
	public int getDamage() {
		return 1+getPlayer().getSoulPower()*3;
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
		return "The dragonfire rises as a flaming column!";
	}
	
	public boolean allowsSelfTarget() {
		return true;
	}

	public String getSFXID() {
		return "SFX_DRAGONFIRE";
	}

	public String getShootMessage() {
		return "You invoke Drake Fire";
	}

	public String getSpellAttackDesc() {
		return "drakefire";
	}

	public int getHeartCost() {
		return 10;
	}

	public String getID(){
		return "DrakeSoul";
	}
	
	public String getSFX(){
		return "wav/fire.wav";
	}

	public int getCost(){
		Player p = (Player) performer;
		return (int)(p.getCastCost() * 1.1);
	}
	
	public String getPromptPosition(){
		return "Where do you want to invoke dragonfire?";
	}
	
	public void execute() {
		if (targetPosition.equals(getPlayer().getPosition())){
			reduceHearts();
			getPlayer().getLevel().addMessage("The dragonfire rises as a flaming column!");
			hit (Position.add(performer.getPosition(), Action.directionToVariation(Action.UP)), getDamage());
			hit (Position.add(performer.getPosition(), Action.directionToVariation(Action.UPLEFT)), getDamage());
			hit (Position.add(performer.getPosition(), Action.directionToVariation(Action.LEFT)), getDamage());
			hit (Position.add(performer.getPosition(), Action.directionToVariation(Action.DOWNLEFT)), getDamage());
			hit (Position.add(performer.getPosition(), Action.directionToVariation(Action.DOWN)), getDamage());
			hit (Position.add(performer.getPosition(), Action.directionToVariation(Action.DOWNRIGHT)), getDamage());
			hit (Position.add(performer.getPosition(), Action.directionToVariation(Action.RIGHT)), getDamage());
			hit (Position.add(performer.getPosition(), Action.directionToVariation(Action.UPRIGHT)), getDamage());
		}
		else
			super.execute();
	}
	
	private boolean hit (Position destinationPoint, int damage){
		StringBuffer message = new StringBuffer();
		Level aLevel = performer.getLevel();
        Player aPlayer = aLevel.getPlayer();
		Feature destinationFeature = aLevel.getFeatureAt(destinationPoint);
        if (destinationFeature != null && destinationFeature.isDestroyable()){
	       	message.append("The drakefire burns the "+destinationFeature.getDescription());
			destinationFeature.damage(aPlayer, damage);
			aLevel.addMessage(message.toString());
        	return true;
		}
        Monster targetMonster = performer.getLevel().getMonsterAt(destinationPoint);
        if (
			targetMonster != null &&
			!(targetMonster.isInWater() && targetMonster.canSwim())
			){
        		if (targetMonster.wasSeen())
        			message.append("The drakefire burns the "+targetMonster.getDescription());
				targetMonster.damage(message, damage);
	        	if (targetMonster.isDead()){
		        	message.append(", finishing it!");
				}
				aLevel.addMessage(message.toString());

				return true;
			}
		return false;
	}
}