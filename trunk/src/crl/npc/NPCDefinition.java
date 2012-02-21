package crl.npc;

import sz.csi.textcomponents.BasicListItem;
import sz.csi.textcomponents.ListItem;
import crl.ui.*;
import crl.ai.*;

public class NPCDefinition {
	private String ID;
	private String description;
	private Appearance appearance;
	private ActionSelector defaultSelector;
	private String talkMessage;
	private int attack;
	private int hits;
	private ListItem sightListItem;
	private String angryMessage;
	private String dangerMessage;
	private boolean isHostage;
	private boolean isPriest;

	public NPCDefinition (String pID, String pDescription, String pAppearance,
	String pDefaultSelector, String pTalkMessage, int pAttack, int pHits, String pAngryMessage, String pDangerMessage, boolean pHostage, boolean pPriest){
		ID = pID;
		description = pDescription;
		appearance = AppearanceFactory.getAppearanceFactory().getAppearance(pAppearance);
		defaultSelector = SelectorFactory.getSelectorFactory().createSelector(pDefaultSelector);
		//sightListItem = new BasicListItem(appearance.getChar(), appearance.getColor(), description);
		talkMessage = pTalkMessage;
		
		attack = pAttack;
		hits = pHits;
		angryMessage = pAngryMessage;
		dangerMessage = pDangerMessage;
		isHostage = pHostage;
		isPriest = pPriest;
	}

	public String getDescription() {
		return description;
	}

	public Appearance getAppearance() {
		return appearance;
	}

	public ActionSelector getDefaultSelector() {
		return defaultSelector;
	}

	public String getTalkMessage() {
		return talkMessage;
	}

	public String getID() {
		return ID;
	}

	public int getAttack() {
		return attack;
	}

	public int getHits() {
		return hits;
	}
	
	public ListItem getSightListItem(){
		return sightListItem;
	}

	public String getAngryMessage(){
		return angryMessage;
	}
	
	public String getDangerMessage(){
		return dangerMessage;
	}

	public boolean isHostage() {
		return isHostage;
	}

	public void setHostage(boolean isHostage) {
		this.isHostage = isHostage;
	}

	public boolean isPriest() {
		return isPriest;
	}

	public void setPriest(boolean isPriest) {
		this.isPriest = isPriest;
	}
	
}


