package crl.level;

import crl.monster.*;
import sz.util.*;
import crl.actor.*;
import crl.feature.Feature;

public class Emerger extends Actor{
	private Monster monster;
	private Feature mound;
	private Position point;
	private int counter;

	public Emerger(Monster pMonster, Position point, int counter, Feature pMound){
		mound = pMound;
		monster = pMonster;
		this.point = point;
		this.counter = counter;
 	}
	
	public Emerger(Monster pMonster, Position point, int counter){
		monster = pMonster;
		this.point = point;
		this.counter = counter;
 	}

	public Position getPoint() {
		return point;
	}

	public String getDescription(){
		return "Emergie";
	}
	
	public int getCounter() {
		return counter;
	}

	public Monster getMonster() {
		return monster;
	}
	
	public Feature getMound(){
		return mound;
	}
}