package crl.ui.consoleUI.effects;

import sz.util.Position;

public abstract class CharDirectionalEffect extends CharEffect{
	protected int direction;
	protected int depth;
	
	public CharDirectionalEffect(String id){
		super(id);
	}

	public CharDirectionalEffect(String id, int delay){
		super(id, delay);
	}
	
	public void set(Position position,int pDirection, int pDepth){
		super.set(position);
		direction = pDirection;
		depth = pDepth;		
	}
}
