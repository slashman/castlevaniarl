package crl.ui.graphicsUI.effects;

import crl.ui.effects.Effect;
import crl.ui.graphicsUI.GFXUserInterface;
import crl.ui.graphicsUI.SwingSystemInterface;

public abstract class GFXEffect extends Effect {
	
	public GFXEffect(String ID){
		super(ID);
	}
	
	public GFXEffect(String id, int delay){
		super(id, delay);
	}
	
	public abstract void drawEffect(GFXUserInterface ui, SwingSystemInterface si);

}
