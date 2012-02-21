package crl.action.weapon;

import sz.util.Position;
import crl.action.Action;
import crl.actor.Actor;
import crl.feature.Feature;
import crl.level.Cell;
import crl.level.Level;
import crl.monster.Monster;
import crl.player.Player;

public class DivingSlide extends Action{
	public String getID(){
		return "DivingSlide";
	}
	
   	public boolean needsDirection(){
		return true;

	}

	public String getPromptDirection(){
		return "Where do you want to slide?";
	}


	public void execute(){
		Player aPlayer = (Player) performer;
        if (!checkHearts(8))
        	return;

        Position var = directionToVariation(targetDirection);

        Level aLevel = performer.getLevel();
  		if (aPlayer.getWeapon() == null){
  			aLevel.addMessage("You can't slide without a proper weapon");
  			return;
  		}
        int startingHeight = aLevel.getMapCell(performer.getPosition()).getHeight();
        Position startingPosition = new Position(aPlayer.getPosition());
        int jumpingRange = 3;
        if (aPlayer.hasIncreasedJumping())
        	jumpingRange++;

        for (int i = 1; i <= jumpingRange; i++){
        	Position destinationPoint = Position.add(startingPosition, Position.mul(var, i));
			Cell destinationCell = aLevel.getMapCell(destinationPoint);
  		    Cell currentCell = aLevel.getMapCell(performer.getPosition());
        	if (destinationCell == null)
        		return;
       		if (destinationCell.getHeight() > startingHeight+2){
				aLevel.addMessage("You bump into the wall!");
				aPlayer.land();
				return;
			}
			else {
				if (destinationCell.getHeight() < startingHeight)
					aLevel.addMessage("You jump from the platform!");
				if (!destinationCell.isSolid()){
					hit(destinationPoint, aLevel, aPlayer);
/*					if (i < jumpingRange-1)
						aPlayer.setPosition(destinationPoint);
					else             */
						aPlayer.landOn(destinationPoint);
				}
				else {
					aLevel.addMessage("You bump into the "+destinationCell.getShortDescription());
					aPlayer.land();
					return;
				}
			}
		}
	}

	private void hit(Position destinationPoint, Level aLevel, Player player){
		StringBuffer message = new StringBuffer();
		Feature destinationFeature = aLevel.getFeatureAt(destinationPoint);
		if (destinationFeature != null && destinationFeature.isDestroyable()){
			message.append("You slice the "+destinationFeature.getDescription());
			Feature prize = destinationFeature.damage(player, player.getWeapon().getAttack());
			if (prize != null){
		       	message.append(", and cut it apart!");
			}
			aLevel.addMessage(message.toString());
		}

		Monster targetMonster = performer.getLevel().getMonsterAt(destinationPoint);
		message = new StringBuffer();
		if (
			targetMonster != null &&
			!(targetMonster.isInWater() && targetMonster.canSwim())
		){
			message.append("You slice the "+targetMonster.getDescription());
			targetMonster.damageWithWeapon(message, player.getWeaponAttack());
        	if (targetMonster.isDead()){
	        	message.append(", and cut it apart!");
				//performer.getLevel().removeMonster(targetMonster);
			}
        	if (targetMonster.wasSeen())
        		aLevel.addMessage(message.toString());
		}
	}
	
	public boolean canPerform(Actor a){
		Player aPlayer = (Player) a;
        Level aLevel = performer.getLevel();
        if (aPlayer.getHearts() < 8){
        	invalidationMessage = "You need more energy!";
            return false;
		}
        return true;
	}
}