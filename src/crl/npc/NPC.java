package crl.npc;

import sz.csi.textcomponents.ListItem;
import crl.actor.*;
import crl.ai.*;
import crl.ai.npc.VillagerAI;
import crl.ui.*;
import crl.monster.*;

//public class NPC extends Actor{
public class NPC extends Monster {
	private transient NPCDefinition definition;
	private String defID;
	private ActionSelector selector;
	
//	private final static MonsterDefinition NPC_MONSTER_DEFINITION = new MonsterDefinition("NPC", "NPC", "VOID", "NULL_SELECTOR", 0, 2, 0, 5, 0, false, false, true, false, 0, 0, 0, 0);
	
	public final static MonsterDefinition NPC_MONSTER_DEFINITION = new MonsterDefinition("NPC");
	static {
		NPC_MONSTER_DEFINITION.setDescription("Innocent Being");
		NPC_MONSTER_DEFINITION.setAppearance(AppearanceFactory.getAppearanceFactory().getAppearance("VOID"));
		NPC_MONSTER_DEFINITION.setDefaultSelector(SelectorFactory.getSelectorFactory().getSelector("NULL_SELECTOR"));
		NPC_MONSTER_DEFINITION.setScore(-100);
		NPC_MONSTER_DEFINITION.setMaxHits(2);
		NPC_MONSTER_DEFINITION.setAttack(0);
		NPC_MONSTER_DEFINITION.setSightRange(5);
		NPC_MONSTER_DEFINITION.setBloodContent(30);
	}

	public NPC (NPCDefinition def){
		super(NPC_MONSTER_DEFINITION);
		definition = def;
		defID = def.getID();
		npcID = def.getID();
		selector = getNDefinition().getDefaultSelector().derive();
		hits = def.getHits();
	}
	
	public Appearance getAppearance(){
		
		return getNDefinition().getAppearance();
    }

	public ActionSelector getSelector(){
		return selector;
    }

	public String getDescription(){
		return getNDefinition().getDescription();
	}
	
	private NPCDefinition getNDefinition(){
		if (definition == null){
			definition = NPCFactory.getFactory().getDefinition(defID);
		}
		return definition;
	}

	public String getTalkMessage(){
		if (talkMessage == null)
			return getNDefinition().getTalkMessage();
		else
			return talkMessage;
	}

	public void message(String mess){
		try {
			if (mess.equals("ATTACK_PLAYER"))
				((VillagerAI)getSelector()).setAttackPlayer(true);
			else
			if (mess.equals("EVT_MURDERER")){
				if (getHits()>1)
					((VillagerAI)getSelector()).setAttackPlayer(true);
				else
					((VillagerAI)getSelector()).setOnDanger(true);
			}
		} catch (ClassCastException cce){

		}
	}

	@Override
	public void damage (StringBuffer buff, int dam){
		try {
			((VillagerAI)getSelector()).setOnDanger(true);
			if (getHits() > 1)
				((VillagerAI)getSelector()).setAttackPlayer(true);
			level.signal(getPosition(), 8, "EVT_MURDERER");
		} catch (ClassCastException cce){

		}
		super.damage(buff, dam);
	}

	public int getAttack (){
		return getNDefinition().getAttack();
	}
	
	public ListItem getSightListItem(){
		return getNDefinition().getSightListItem();
	}
	
	public String getAngryMessage(){
		return getNDefinition().getAngryMessage();
	}
	
	public String getDangerMessage(){
		return getNDefinition().getDangerMessage();
	}
	
	public boolean isHostile(){
		return ((VillagerAI)getSelector()).isHostile(); 
	}
	
	public boolean isPriest(){
		return getNDefinition().isPriest();
	}
	
	private String npcID;
	private String talkMessage = null;
	
	public String getNPCID(){
		return npcID;
	}
	
	public void setTalkMessage(String message){
		talkMessage = message;
	}
}
