package crl.monster;

import java.util.*;

import sz.util.*;

public class VMonster implements java.io.Serializable{
	private Vector monsters;
	//private Hashtable mLocs;

	public void addMonster(Monster what){
		monsters.add(what);
//		Debug.say(what.getPosition().toString());
		//mLocs.put(what.getPosition().toString(), what);
	}

	public Monster elementAt(int i){
		return (Monster) monsters.elementAt(i);
	}
	
	public boolean contains(Monster who){
		return monsters.contains(who);
	}

	public void removeAll(Collection c){
		monsters.removeAll(c);
	}

	public Enumeration elements(){
		return monsters.elements();
	}

	public Monster getMonsterAt(Position p){
		for (int i = 0; i < monsters.size(); i++)
			if (((Monster) monsters.elementAt(i)).getPosition().equals(p))
				return (Monster) monsters.elementAt(i);
		return null;
	}

	public VMonster(int size){
		monsters = new Vector(size);
	}

	public Vector getVector(){
		return monsters;
	}

	public void remove(Object o){
		monsters.remove(o);
	}

	public int size(){
		return monsters.size();
	}
	
	public void removeAll(){
		monsters.removeAllElements();
	}

}