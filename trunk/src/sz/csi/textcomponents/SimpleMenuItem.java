package sz.csi.textcomponents;

import sz.csi.ConsoleSystemInterface;

public class SimpleMenuItem implements MenuItem{
	private char number;
	private String description;
	private int value;
	public int getValue() {
		return value;
	}

	public SimpleMenuItem(char number, String description, int value){
		this.number = number;
		this.description = description;
		this.value = value;
	}
	
	public char getMenuChar() {
		return number;
	}

	public int getMenuColor() {
		return ConsoleSystemInterface.WHITE;
	}

	public String getMenuDescription() {
		return description;
	}

}
