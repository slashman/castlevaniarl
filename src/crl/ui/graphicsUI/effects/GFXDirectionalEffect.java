package crl.ui.graphicsUI.effects;

import crl.ui.graphicsUI.GFXUserInterface;
import crl.ui.graphicsUI.SwingSystemInterface;
import sz.util.Position;

public abstract class GFXDirectionalEffect extends GFXEffect{
	protected int direction;
	protected int depth;
	

	
	public GFXDirectionalEffect(String id){
		super(id);
	}

	public GFXDirectionalEffect(String id, int delay){
		super(id, delay);
	}
	
	public void set(Position position,int pDirection, int pDepth){
		super.set(position);
		direction = pDirection;
		depth = pDepth;		
	}
}
