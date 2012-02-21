package crl.ui.effects;

import sz.util.*;
import crl.*;
import crl.ui.*;

public abstract class Effect {
	private Position position;
	protected int animationDelay = 50;

	private String id;
	
	public String getID(){
		return id;
	}
	
	public void set(Position loc){
		setPosition(loc);
	}
	
	public Effect(String id){
		this.id = id;
	}

	public Effect(String id, int delay){
		this.id = id;
		animationDelay = delay;
	}

	//public abstract void drawEffect(UserInterface ui, ConsoleSystemInterface si);
	
	protected final void animationPause(){
		try {Thread.sleep(animationDelay);}catch (Exception e){}
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position value) {
		position = value;
	}

	public void setAnimationDelay(int value) {
		animationDelay = value;
	}
}