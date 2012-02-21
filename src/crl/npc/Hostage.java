package crl.npc;

import crl.item.Item;
import sz.util.*;

public class Hostage extends NPC {
	private int reward;
	private Item itemReward;
	private String hostrinchLevel;
	private String rescuedMessage;
	private boolean rescued;
	
	public boolean isRescued() {
		return rescued;
	}

	public void setRescued(boolean rescued) {
		this.rescued = rescued;
		rescuedMessage = Util.randomElementOf(HOSTAGE_TIPS);
	}
	
	public String getTalkMessage(){
		if (!rescued)
			return super.getTalkMessage();
		else
			return rescuedMessage;
	}
	
	private static String[] HOSTAGE_TIPS = new String[] {
		"If you dont kill the Aluras quickly, you are dead",
		"The Nova Skeleton has a deadly secret, dont let him let you know about it",
		"It is better to run from Iron Golems!",
		"All caves have two keys to find!",
		"You must not face Dracula unless you have enough shields",
		"Dracula turns into a Demon uppon death",
		"I met a Knight which could use all the ultimate weapon skills"
	};

	public Hostage (NPCDefinition def){
		super(def);
	}
	
	public int getReward(){
		return reward;
	}
	
	public void setReward(int l){
		reward = l;
	}

	public String getHostrinchLevel() {
		return hostrinchLevel;
	}

	public void setHostrinchLevel(String hostrinchLevel) {
		this.hostrinchLevel = hostrinchLevel;
	}

	public Item getItemReward() {
		return itemReward;
	}

	public void setItemReward(Item itemReward) {
		this.itemReward = itemReward;
	}
	
	
}
