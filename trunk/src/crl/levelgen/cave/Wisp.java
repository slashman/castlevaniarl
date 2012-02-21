package crl.levelgen.cave;

import sz.util.*;

public class Wisp {
	//Atributes
	private int tolerance, stupidTurns;
	private int[][] level;
	private Wisp friend;
	private int strength;
	
	//Status
	private Position position;
	private int toleranceCounter;
	private int stupidCounter;
	private int xfriend, yfriend;
	
	
	
	public Wisp(Position pPosition, int pTolerance, int pStupidTurns, int pStrength){
		position = new Position(pPosition);
		tolerance = pTolerance;
		stupidTurns = pStupidTurns;
		strength = pStrength;
		toleranceCounter = tolerance;
		stupidCounter = stupidTurns;
	}
	
	
	
	public void setLevel(int[][] map){
		level = map;
	}
	
	public void setFriend(Wisp f){
		friend = f;
	}
	
	public void go(){
		if (stupidCounter > 0){
			int xvar = Util.rand(-1,1);
			int yvar = Util.rand(-1,1);
			if (position.x + xvar == -1 || position.x + xvar == level.length || position.y + yvar == -1 || position.y + yvar == level[0].length)
				;
			else {
				level[position.x][position.y] = 4;
				position.x += xvar;
				position.y += yvar;
				if (level[position.x][position.y] == 1){
					position.x -= xvar;
					position.y -= yvar;
				}
			}
			stupidCounter --;
		} else {
			radarFriend();
			level[position.x][position.y] = 4;
			position.x += xfriend;
			position.y += yfriend;
			if (level[position.x][position.y] == 1){
				toleranceCounter--;
				if (toleranceCounter < 0){
					blastAway();
					toleranceCounter = tolerance;
					stupidCounter = stupidTurns;
				}
				position.x -= xfriend;
				position.y -= yfriend;
			} 
				
		}
			
	}
	
	public Position getPosition(){
		return position;
	}
	
	private void radarFriend(){
		Position fp = friend.getPosition();
		xfriend = Util.sign(fp.x - position.x);
		yfriend = Util.sign(fp.y - position.y);
	}
	
	private void blastAway(){
		for (int i = 0; i < strength; i++){
			rip(position.x + xfriend*i,position.y+yfriend*i);
			rip(position.x + xfriend*i,position.y+yfriend*i - 1);
			rip(position.x + xfriend*i,position.y+yfriend*i + 1);
		}
	}
	
	private void rip(int x, int y){
		if (x > 0 && x < level.length -1 && y > 0 && y < level[0].length-1)
			level[x][y] = 0;
	}
	
}
