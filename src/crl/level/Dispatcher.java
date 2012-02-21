package crl.level;

import java.util.*;

import sz.util.*;
import crl.ui.effects.*;
import crl.actor.*;
import crl.player.*;

import crl.monster.*;

public class Dispatcher implements java.io.Serializable{
	private SZPriorityQueue actors;
	private int countdown;
	private Actor fixed;

	public Dispatcher(){
		actors = new SZPriorityQueue();
	}

	public boolean contains (Actor what){
		return actors.contains(what);
	}

	public Vector getActors(){
		return actors.getVector();
    }

	public static int ixx = 0;
	public Actor getNextActor(){
		//Debug.say("---"+(ixx++)+"--------");
		if (countdown > 0){
			countdown--;
			return fixed;
		}
		
		//actors.printStatus();
		Actor x = (Actor) actors.unqueue();
		//Debug.say(x);

		while (x != null && x.wannaDie()){
			actors.remove(x);
			x  = (Actor) actors.unqueue();
		}
		//actors.enqueue(x);
		return x;
    }
	
	public void returnActor(Actor what){
		if (!actors.contains(what))
			actors.enqueue(what);
	}

    public void addActor(Actor what){
    	if (!actors.contains(what))
    		actors.enqueue(what);
	}

	public void addActor(Actor what, boolean high, Object classObj){
		if (!actors.contains(what))
			actors.forceToFront(what, classObj);
	}

	public void addActor(Actor what, boolean high){
		if (!actors.contains(what))
			actors.forceToFront(what);
	}

	public void removeActor(Actor what){
		actors.remove(what);
	}

	public void setFixed(Actor who, int howMuch){
		countdown = howMuch;
		fixed = who;
	}
	
	public void removeAll(){
		actors.removeAll();
	}
}