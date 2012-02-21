package crl.cuts;

import java.io.Serializable;

import crl.game.Game;
import crl.level.Level;

public abstract class Unleasher implements Serializable {
	protected boolean enabled = true;
	
	public boolean enabled(){
		return enabled;
	}
	
	public void disable(){
		enabled = false;
	}
	
	public abstract void unleash(Level level, Game game);
	/*This must check condition first*/
	
}
