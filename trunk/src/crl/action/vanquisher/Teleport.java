package crl.action.vanquisher;

import sz.util.Line;
import sz.util.Position;
import crl.action.Action;
import crl.action.HeartAction;
import crl.actor.Actor;
import crl.level.Cell;
import crl.level.Level;
import crl.player.Player;
import crl.ui.UserInterface;
import crl.ui.effects.EffectFactory;

public class Teleport extends HeartAction{
	public String getID(){
		return "Teleport2";
	}
	
	public int getHeartCost() {
		return 5;
	}
	
	public boolean needsPosition(){
		return true;
	}

	public String getPromptPosition(){
		return "Where do you want to teleport?";
	}

	public void execute(){
		super.execute();
		Player player = (Player) performer;
		Level level = player.getLevel();
		level.addMessage("You dematerialize!");
		if (targetPosition.equals(performer.getPosition())){
        	level.addMessage("You appear in the same place!");
        	return;
        }

		Line line = new Line(player.getPosition(), targetPosition);
		Position runner = line.next();
		Position prerunner = new Position(runner);
		int i = 0;
		for (; i < 6; i++){
			prerunner.x = runner.x;
			prerunner.y = runner.y;
			prerunner.z = runner.z;
			runner = line.next();
        	Cell destinationCell = performer.getLevel().getMapCell(runner);
			if (level.isWalkable(runner) &&	
				destinationCell.getHeight() == level.getMapCell(player.getPosition()).getHeight() 
			)
				;
			else
				break;
		}
		drawEffect(EffectFactory.getSingleton().createDirectedEffect(player.getPosition(), targetPosition, "SFX_TELEPORT", i));
		
		player.landOn(prerunner);
		player.see();
		UserInterface.getUI().refresh();
		
	}

	public int getCost(){
		Player p = (Player) performer;
		return (int)(p.getCastCost() * 1.4);
	}
	
	public String getSFX(){
		return "wav/scrch.wav";
	}
}