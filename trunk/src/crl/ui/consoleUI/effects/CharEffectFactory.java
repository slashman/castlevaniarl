package crl.ui.consoleUI.effects;

import java.util.Hashtable;

import sz.csi.ConsoleSystemInterface;
import sz.util.Position;
import crl.game.Game;
import crl.ui.effects.Effect;
import crl.ui.effects.EffectFactory;

public class CharEffectFactory extends EffectFactory{
	private Hashtable effects = new Hashtable();
	
	public void setEffects(Effect[] effectsA){
		for (int i = 0; i < effectsA.length; i++){
			effects.put(effectsA[i].getID(), effectsA[i]);
		}
	}

	public Effect createDirectedEffect(Position start, Position end, String ID, int length) {
		try {
			CharDirectedEffect ef = (CharDirectedEffect) effects.get(ID);
			ef.set(start,start,end,length);
			return ef;
		} catch (ClassCastException cce){
			Game.addReport("ClassCastException with effect "+ID+" to Directed Effect");
			return null;
		} catch (NullPointerException cce){
			Game.addReport("NullPointerException with effect "+ID);
			return null;
		}
	}
	
	public Effect createDirectionalEffect(Position start, int direction, int depth, String ID) {
		try {
			CharDirectionalEffect ef = (CharDirectionalEffect) effects.get(ID);
			ef.set(start, direction, depth);
			return ef;
		} catch (ClassCastException cce){
			Game.addReport("ClassCastException with effect "+ID+" to Directed Effect");
			return null;
		} catch (NullPointerException cce){
			Game.addReport("NullPointerException with effect "+ID);
			return null;
		}
	}
	
	public Effect createLocatedEffect(Position location, String ID) {
		try {
			CharEffect ef = (CharEffect) effects.get(ID);
			ef.set(location);
			return ef;
		} catch (ClassCastException cce){
			Game.addReport("ClassCastException with effect "+ID+" to Directed Effect");
			return null;
		} catch (NullPointerException cce){
			Game.addReport("NullPointerException with effect "+ID);
			return null;
		}
	}

}
