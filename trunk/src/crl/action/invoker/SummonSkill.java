package crl.action.invoker;

import sz.util.Position;
import sz.util.Util;
import crl.action.HeartAction;
import crl.level.Level;
import crl.monster.Monster;
import crl.monster.MonsterFactory;
import crl.player.Consts;

public abstract class SummonSkill extends HeartAction{
	public abstract String getMonsterID();
	
	public void execute(){
		super.execute();
		Level aLevel = performer.getLevel();
		Position randPos = null;
		if (Util.chance(100)){ //TODO: This is related to soul
			int count = 20;
			out: while (count > 0){
				randPos = Position.add(performer.getPosition(), new Position(Util.rand(-1,1), Util.rand(-1,1),0));
				if (aLevel.isWalkable(randPos)){
					break out;
				}
				count--;
			}
			if (count > 0){
				Monster m = MonsterFactory.getFactory().buildMonster(getMonsterID());
				aLevel.addMessage("A "+m.getDescription()+" rises from the floor!");
				m.setCounter(Consts.C_MONSTER_CHARM, 9999999);
				m.setPosition(randPos);
				m.increaseHits(getHitBonus());
				aLevel.addMonster(m);
			}
		} else {
			aLevel.addMessage("Nothing happens.");
		}
			
	}
	
	public int getHitBonus(){
		return 0;
	}
}
