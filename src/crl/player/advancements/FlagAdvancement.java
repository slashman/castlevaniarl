package crl.player.advancements;

import crl.player.Player;

public abstract class FlagAdvancement extends Advancement{
	public abstract String getFlagName();
	public final void advance(Player p){
		p.setFlag(getFlagName(), true);
		p.setFlag(getID(), true);
	}
}
