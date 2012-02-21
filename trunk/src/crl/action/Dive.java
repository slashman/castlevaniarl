package crl.action;

import sz.util.Position;
import crl.actor.Actor;
import crl.level.Cell;
import crl.level.Level;
import crl.player.Player;

public class Dive extends Action{
	public String getID() {
		return "DIVE";
	}
	
	public void execute() {
		Player aPlayer = (Player)performer;
		Level aLevel = aPlayer.getLevel();
		Cell currentCell = aLevel.getMapCell(aPlayer.getPosition());
		if (currentCell.isShallowWater()){
			if (aPlayer.getPosition().z != aLevel.getDepth()-1){
				Position deep = new Position(aPlayer.getPosition());
				deep.z++;
				if (!aLevel.getMapCell(deep).isSolid()){
					aLevel.addMessage("You dive into the water");
					aPlayer.landOn(deep, false);
				} else {
					aLevel.addMessage("You can't dive lower");
				}
			}
		}
		
	}
	
	public boolean canPerform(Actor a) {
		Player aPlayer = getPlayer(performer);		
		Level aLevel = aPlayer.getLevel();
		Cell currentCell = aLevel.getMapCell(aPlayer.getPosition());
		if (currentCell.isShallowWater()){
			if (aPlayer.getPosition().z == aLevel.getDepth()-1){
				invalidationMessage = "You can't dive lower";
				return false;
			}
		} else {
			invalidationMessage = "You can only dive on water";
			return false;
		}
		return true;
	}
}
