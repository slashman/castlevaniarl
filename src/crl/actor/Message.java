package crl.actor;

import sz.util.Position;

public class Message{
	private String text;
	private Position location;

/*	public void act(){
		die();
	}   */

	public Message (String pText, Position pLocation){
		text = pText;
		location = pLocation;
	}

	public String getText() {
		return text;
	}

	public Position getLocation() {
		return location;
	}

	public String toString(){
		return getText();
	}
}