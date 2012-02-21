package crl.action.monster.boss;

import sz.util.Position;
import sz.util.Util;
import crl.action.Action;
import crl.level.Level;
import crl.monster.Monster;

public class Teleport extends Action{
	public String getID(){
		return "TELEPORT";
	}
	
	public void execute(){
        Level aLevel = performer.getLevel();
        Monster mon = (Monster)performer;
        do {
        	Position dest = Position.add(aLevel.getPlayer().getPosition(), new Position(Util.rand(-2,2),Util.rand(-2,2)));
        	if (!aLevel.isWalkable(dest))
        		continue;
        	mon.setPosition(dest);
        	break;
        } while (true);
	}
}