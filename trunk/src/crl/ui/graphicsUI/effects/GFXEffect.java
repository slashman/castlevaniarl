package crl.ui.graphicsUI.effects;

import crl.conf.gfx.data.GFXConfiguration;
import crl.ui.effects.Effect;
import crl.ui.graphicsUI.GFXUserInterface;
import crl.ui.graphicsUI.SwingSystemInterface;

public abstract class GFXEffect extends Effect {
	
	protected GFXConfiguration configuration;
	
	public GFXEffect(String ID, GFXConfiguration configuration){
		super(ID);
		this.configuration = configuration;
	}
	
	public GFXEffect(String id, int delay, GFXConfiguration configuration){
		super(id, delay);
		this.configuration = configuration;
	}
	
	public abstract void drawEffect(GFXUserInterface ui, SwingSystemInterface si);

}
