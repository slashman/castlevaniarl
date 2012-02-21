package crl.ui.consoleUI.effects;

import sz.csi.ConsoleSystemInterface;
import sz.util.Position;
import crl.ui.consoleUI.ConsoleUserInterface;
import crl.ui.effects.Effect;

public abstract class CharEffect extends Effect{
	public CharEffect(String id){
		super(id);
	}

	public CharEffect(String id, int delay){
		super(id, delay);
	}

	public abstract void drawEffect(ConsoleUserInterface ui, ConsoleSystemInterface si);
	

}
