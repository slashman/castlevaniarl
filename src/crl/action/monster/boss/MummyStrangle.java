package crl.action.monster.boss;

import crl.action.Action;
import crl.level.Level;
import crl.monster.Monster;
import crl.player.Damage;

public class MummyStrangle extends Action{
	public String getID(){
		return "MUMMY_STRANGLE";
	}
	
	public void execute(){
        Level aLevel = performer.getLevel();
        StringBuffer buff = new StringBuffer("Akmodan strangles you!");
        aLevel.getPlayer().damage(buff, (Monster)performer, new Damage(6, false));
        aLevel.addMessage(buff.toString());
	}
}