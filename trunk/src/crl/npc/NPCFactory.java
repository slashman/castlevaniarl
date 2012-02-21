package crl.npc;

import java.util.*;
import crl.ui.*;
import crl.player.*;
import crl.game.Game;
import crl.item.*;
import crl.monster.*;
import sz.util.*;

public class NPCFactory {
	private final static NPCFactory singleton = new NPCFactory();
	private Hashtable definitions;
	private Vector hostages = new Vector();

	public static NPCFactory getFactory(){
		return singleton;
	}

	public NPC buildNPC (String id){
		return new NPC((NPCDefinition) definitions.get(id));
	}
	
	public Merchant buildMerchant(int merchandiseType){
		return new Merchant((NPCDefinition) definitions.get("MERCHANT"), merchandiseType);
	}
	
	public Hostage buildHostage(){
		Hostage ret = new Hostage((NPCDefinition) definitions.get((String)Util.randomElementOf(hostages)));
		if (UserInterface.getUI().getPlayer().getPlayerClass() != Player.CLASS_VAMPIREKILLER) {
			int artifactCategory = ((int) (UserInterface.getUI().getPlayer().getPlayerLevel() / 6.0d));
			ret.setItemReward(ItemFactory.getItemFactory().createWeapon(Util.randomElementOf(hostageArtifacts[artifactCategory]),""));
		}
		return ret;
	}

	public NPCDefinition getDefinition (String id){
		return (NPCDefinition) definitions.get(id);
	}

	public void addDefinition(NPCDefinition definition){
		definitions.put(definition.getID(), definition);
		if (definition.isHostage())
			hostages.add(definition.getID());
	}

	public NPCFactory(){
		definitions = new Hashtable(40);
	}
	
	private static String [][] hostageArtifacts = new String[][]{
		{"HOLBEIN_DAGGER", "SHOTEL"},
		{"WEREBANE", "ALCARDE_SPEAR", "ETHANOS_BLADE"},
		{"FIREBRAND", "GURTHANG", "HADOR"},
		{"ICEBRAND", "MORMEGIL", "VORPAL_BLADE"},
		{"GRAM", "CRISSAEGRIM"},
		{"KAISER_KNUCKLE", "OSAFUNE", "MASAMUNE"}
	};
}