package crl.ui.graphicsUI.effects;

import java.awt.Image;

import sz.csi.ConsoleSystemInterface;
import sz.util.Position;
import crl.action.Action;
import crl.ui.UserInterface;
import crl.ui.consoleUI.ConsoleUserInterface;
import crl.ui.consoleUI.effects.CharDirectedEffect;
import crl.ui.graphicsUI.GFXUserInterface;
import crl.ui.graphicsUI.SwingSystemInterface;

public class GFXDirectionalMissileEffect extends GFXDirectedEffect {
	private Image[] missile;
	
	private int solveDirection(Position old, Position newP){
		if (newP.x() == old.x()){
			if (newP.y() > old.y()){
				return Action.DOWN;
			} else {
                 return Action.UP;
			}
		} else
		if (newP.y() == old.y()){
			if (newP.x() > old.x()){
				return Action.RIGHT;
			} else {
				return Action.LEFT;
			}
		} else
		if (newP.x() < old.x()){
			if (newP.y() > old.y())
				return Action.DOWNLEFT;
			else
				return Action.UPLEFT;
		} else {
            if (newP.y() > old.y())
				return Action.DOWNRIGHT;
			else
				return Action.UPRIGHT;
		}
	}
	
	
	public void drawEffect(GFXUserInterface ui, SwingSystemInterface si){
		Image icon = null;
		si.saveBuffer();
		setAnimationDelay(animationDelay);
		Position oldPoint = effectLine.next();
		for (int i = 0; i < depth; i++){
			Position next = effectLine.next();
			
			//int direction = solveDirection(getPosition(), oldPoint);
			int direction = solveDirection(oldPoint, next);
			oldPoint = new Position(next);
			switch (direction){
				case Action.RIGHT:
					icon = missile[0];
					break;
				case Action.UP:
					icon = missile[1];
					break;
				case Action.LEFT:
					icon = missile[2];
					break;
				case Action.DOWN:
					icon = missile[3];
					break;
				case Action.DOWNRIGHT:
					icon = missile[4];
					break;
				case Action.DOWNLEFT:
					icon = missile[5];
					break;
				case Action.UPLEFT:
					icon = missile[6];
					break;
				case Action.UPRIGHT:
					icon = missile[7];
					break;
			}
			int height = 0;
			if (ui.getPlayer().getLevel().getMapCell(next) != null)
				height = ui.getPlayer().getLevel().getMapCell(next).getHeight();
			Position relative = Position.subs(next, ui.getPlayer().getPosition());
			Position toPrint = Position.add(ui.PC_POS, relative);
			if (!ui.insideViewPort(toPrint))
				break;
			si.drawImage(toPrint.x()*32, toPrint.y()*32-4*height, icon);
			si.refresh();
			animationPause();
			si.restore();
		}
		
		/*
		for (int i = 0; i < depth; i++){
			si.drawImage(next.x(), next.y(), icon);
			si.refresh();
			animationPause();
			si.restore();
			for (int j = 0; j < 2; j++, i++   )
				next = effectLine.next();
		}
		setAnimationDelay(animationDelay * 36);*/
	}

	public GFXDirectionalMissileEffect(String ID, Image[] missile, int delay){
		super(ID, delay);
		setMissile(missile);
	}

	public void setMissile(Image[] value) {
		missile = value;
	} 

}