package crl.action.monster.boss;

import sz.util.Position;
import sz.util.Util;
import crl.action.Action;
import crl.level.Level;
import crl.monster.Monster;
import crl.monster.MonsterFactory;

public class UnleashSickles extends Action{
	public String getID(){
		return "UNLEASH_SICKLES";
	}
	
	public int getCost(){
		return 40;
	}
	
	public void execute(){
        Level aLevel = performer.getLevel();
        aLevel.addMessage("Death invokes tiny flying sickles!");
        int sickles = Util.rand(5,10);
        for (int i=0; i<sickles; i++){
        	int xvar = Util.rand(-8,8);
        	int yvar = Util.rand(-8,8);
			Position destinationPoint = Position.add(performer.getPosition(),
				new Position(xvar, yvar));
			Monster sickle = MonsterFactory.getFactory().buildMonster("SICKLE");
			sickle.setPosition(destinationPoint);
			aLevel.addMonster(sickle);
		}
	}
}