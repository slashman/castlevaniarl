package crl.ui.graphicsUI.effects;

import crl.conf.gfx.data.GFXConfiguration;
import sz.util.Line;
import sz.util.Position;

public abstract class GFXDirectedEffect extends GFXEffect {
	protected Line effectLine;
	protected int depth;
	private Position startPosition;
	
	public GFXDirectedEffect(String id, GFXConfiguration configuration){
		super(id, configuration);
	}

	public GFXDirectedEffect(String id, int delay, GFXConfiguration configuration){
		super(id, delay, configuration);
	}
	
	/*public void drawEffect(GFXUserInterface ui, SwingSystemInterface si){
		Position toPrint = null;
		for (int i = 0; i < depth; i+=10){
			Position next = effectLine.next();
			Position relative = Position.subs(next, ui.getPlayer().getPosition());
			toPrint = Position.add(ui.PC_POS, relative);
			if (!ui.insideViewPort(toPrint))
				break;
		}
		startPosition = Position.add(ui.PC_POS, Position.subs(startPosition, ui.getPlayer().getPosition()));
		toPrint = Position.mul(toPrint, 36);
		startPosition = Position.mul(startPosition, 36);
		depth = Position.distance(startPosition, toPrint);
		effectLine = new Line(startPosition, toPrint);
	}*/
	
	public void set(Position loc, Position startPosition, Position pivotPosition, int depth){
		super.set(loc);
		this.startPosition = new Position(loc);
		effectLine = new Line(startPosition,pivotPosition);
		setDepth(depth);
	}
	
	public int getDepth() {
		return depth;
	}

	public void setDepth(int value) {
		depth = value;
	}
	

}
