package crl.ai.npc;

import sz.util.Position;
import sz.util.Util;
import crl.action.Action;
import crl.action.npc.PeaceWalk;
import crl.actor.Actor;

public class PriestAI extends VillagerAI {
	 public Action selectAction(Actor who){
	 	if (onDanger || attackPlayer)
	 		return super.selectAction(who);
	 	if (Position.flatDistance(who.getPosition(), who.getLevel().getPlayer().getPosition()) < 3)
	 		if (who.getLevel().getPlayer().getHits() < who.getLevel().getPlayer().getHitsMax()){
	 			who.getLevel().getPlayer().informPlayerEvent(crl.player.Player.EVT_CHAT, who);
		 		//who.getLevel().addMessage("The priest says: 'Rest here for a while'");
		 		who.getLevel().getPlayer().heal();
		 	}
		if (Util.chance(10)){
	 		Action ret = new PeaceWalk();
			ret.setDirection(Util.rand(0,7));
			return ret;
	 	}
		return null;
	}

	public String getID(){
		 return "HEALPLAYER";
	}
}