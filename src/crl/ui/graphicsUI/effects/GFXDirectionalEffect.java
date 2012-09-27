package crl.ui.graphicsUI.effects;

import crl.conf.gfx.data.GFXConfiguration;
import sz.util.Position;

public abstract class GFXDirectionalEffect extends GFXEffect{
	protected int direction;
	protected int depth;
	

	
	public GFXDirectionalEffect(String id, GFXConfiguration configuration){
		super(id, configuration);
	}

	public GFXDirectionalEffect(String id, int delay, GFXConfiguration configuration){
		super(id, delay, configuration);
	}
	
	public void set(Position position,int pDirection, int pDepth){
		super.set(position);
		direction = pDirection;
		depth = pDepth;		
	}
}
