package crl.item;

import sz.csi.textcomponents.MenuItem;
import crl.ui.*;
import crl.ui.consoleUI.CharAppearance;

//TODO: Delete this no longer used class
public class ShopMenuItem implements MenuItem{
	private transient Item x;
	private String defId;
	
	public ShopMenuItem(Item x){
		this.x = x;
		defId = x.getFullID();
	}

	public String getMenuDescription(){
		return getItem().getAttributesDescription() + " : "+getItem().getMenuDescription() + " ($"+getItem().getGoldPrice()+")";
	}

	/*Unsafe, Coupled*/
	public char getMenuChar() {
		return ((CharAppearance)getItem().getAppearance()).getChar();
	}
	
	/*Unsafe, Coupled*/
	public int getMenuColor() {
		return ((CharAppearance)getItem().getAppearance()).getColor();
	}

	public Item getItem(){
		return x;
	}
}