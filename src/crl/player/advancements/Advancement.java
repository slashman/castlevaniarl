package crl.player.advancements;

import java.io.Serializable;

import crl.player.Player;

public abstract class Advancement implements Serializable{
	public abstract String[] getRequirements();
	public abstract String getID();
	public abstract void advance(Player p);
	public abstract String getDescription();
	public abstract String getName();
	
	private String[] bans = new String[0];
	public String[] getBans(){
		return bans;
	}
	
	public String [] NO_REQUIREMENTS = new String[]{};
}
