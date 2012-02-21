package crl.action.monster.boss;

import sz.util.Position;
import sz.util.Util;
import crl.action.Action;
import crl.level.Level;
import crl.monster.Monster;
import crl.ui.effects.EffectFactory;

public class Materialize extends Action{
	public String getID(){
		return "MATERIALIZE";
	}
	
	public void execute(){
        Level aLevel = performer.getLevel();
        aLevel.addMessage("Dracula materializes!");
        Monster mon = (Monster)performer;
        mon.setVisible(true);
        Position var = new Position(Util.rand(-5,5),Util.rand(-5,5));
        Position pum =Position.add(aLevel.getPlayer().getPosition(), var);
        mon.setPosition(pum);
        //drawEffect(new SplashEffect(pum, "Oo.", Appearance.WHITE));
        drawEffect(EffectFactory.getSingleton().createLocatedEffect(pum, "SFX_MATERIALIZE"));
	}
}