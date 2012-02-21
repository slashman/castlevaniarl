package crl.action.npc;

import sz.util.Position;
import crl.action.Action;
import crl.feature.SmartFeature;
import crl.level.Cell;
import crl.level.Level;
import crl.monster.Monster;

public class PeaceWalk extends Action{
	public String getID(){
		return "PeaceWalk";
	}
	
	public boolean needsDirection(){
		return true;
	}

	public void execute(){

        Position var = directionToVariation(targetDirection);
        Position destinationPoint = Position.add(performer.getPosition(), var);
        Level aLevel = performer.getLevel();
        if (!aLevel.isValidCoordinate(destinationPoint))
        	return;
        Cell destinationCell = aLevel.getMapCell(destinationPoint);
        Cell currentCell = aLevel.getMapCell(performer.getPosition());
        Monster destinationMonster = aLevel.getMonsterAt(destinationPoint);
        //SmartFeature standing = aLevel.getSmartFeature(performer.getPosition());
        if (destinationCell != null)
			if (!destinationCell.isSolid())
				if (destinationMonster == null)
					if (currentCell == null || destinationCell.getHeight() == currentCell.getHeight())
						if (!destinationCell.isWater() && !destinationCell.isShallowWater())
							if (!aLevel.getPlayer().getPosition().equals(destinationPoint))
								if (destinationCell.isEthereal())
									performer.setPosition(aLevel.getDeepPosition(destinationPoint));
								else
									performer.setPosition(destinationPoint);
	}

}