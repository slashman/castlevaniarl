package crl.ui.graphicsUI.effects;

import java.util.Hashtable;

import sz.util.Position;
import crl.ui.effects.Effect;
import crl.ui.effects.EffectFactory;

public class GFXEffectFactory extends EffectFactory{
	private Hashtable effects = new Hashtable();
	
	public void setEffects(Effect[] effectsA){
		for (int i = 0; i < effectsA.length; i++){
			effects.put(effectsA[i].getID(), effectsA[i]);
		}
	}

	public Effect createDirectedEffect(Position start, Position end, String ID, int length) {
		try {
			GFXDirectedEffect x = (GFXDirectedEffect) effects.get(ID);
			if (x == null){
				System.out.println("Warning! effect "+ID+" is not registered");
				return null;
			}
			x.set(start, start, end, length);
			return x;
		} catch (ClassCastException cce){
			System.out.println("Warning! effect "+ID+" is not directed");
			return null;
		}
	}
	
	public Effect createDirectionalEffect(Position start, int direction, int depth, String ID) {
		try {
			GFXDirectionalEffect x = (GFXDirectionalEffect) effects.get(ID);
			if (x == null){
				System.out.println("Warning! effect "+ID+" is not registered");
				return null;
			}
			x.set(start, direction, depth);
			return x;
		} catch (ClassCastException cce){
			System.out.println("Warning! effect "+ID+" is not directional");
			return null;
		}
	}
	
	public Effect createLocatedEffect(Position location, String ID) {
		try {
			GFXEffect x = (GFXEffect) effects.get(ID);
			if (x == null){
				System.out.println("Warning! effect "+ID+" is not registered");
				return null;
			}
			x.set(location);
			return x;
		} catch (ClassCastException cce){
			System.out.println("Warning! effect "+ID+" is not Located");
			return null;
		}
	}

}
