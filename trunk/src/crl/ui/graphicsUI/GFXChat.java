package crl.ui.graphicsUI;

import java.awt.Image;
import java.util.Vector;

public class GFXChat {
	private Vector portraits = new Vector(10);
	private Vector names  = new Vector(10);
	private Vector conversations = new Vector(10);
	
	public void add(String name, String conversation, Image portrait){
		names.add(name);
		conversations.add(conversation);
		portraits.add(portrait);
	}
	
	public void add(String name, String conversation){
		names.add(name);
		conversations.add(conversation);
		portraits.add(null);
	}
	
	public int getConversations(){
		return conversations.size();
	}
	
	public Image getPortrait(int i){
		return (Image) portraits.elementAt(i);
	}
	
	public String getConversation(int i){
		return (String) conversations.elementAt(i);
	}
	
	public String getName(int i){
		return (String) names.elementAt(i);
	}
}
