package crl.levelgen;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.Vector;

public class LevelMetaData implements Serializable{
	private String levelID;
	private int levelNumber = -1;
	private Vector exits = new Vector();
	private Hashtable hexits = new Hashtable();
	public Vector getExits() {
		return exits;
	}
	public void addExits(String exit, String exitID) {
		exits.add(exit);
		hexits.put(exitID, exit);
	}
	public String getLevelID() {
		return levelID;
	}
	public void setLevelID(String levelID) {
		this.levelID = levelID;
	}
	public int getLevelNumber() {
		return levelNumber;
	}
	public void setLevelNumber(int levelNumber) {
		this.levelNumber = levelNumber;
	}
	
	public String getExit(int number){
		return (String) exits.elementAt(number);
	}
	
	public String getExit (String exitID){
		return (String) hexits.get(exitID);
	}
}
