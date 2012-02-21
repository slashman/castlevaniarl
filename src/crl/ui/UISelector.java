package crl.ui;

import java.util.Hashtable;
import java.util.Properties;

import sz.csi.CharKey;
import sz.util.Debug;
import sz.util.Position;
import crl.action.Action;
import crl.ai.ActionSelector;
import crl.level.Level;
import crl.player.Player;

public abstract class UISelector implements ActionSelector  {
	protected Hashtable gameActions = new Hashtable();
	
	protected Action advance;
	protected Action attack;
	protected Action target;
	protected Position defaultTarget;
	protected Player player;
	protected Level level;
	public static int WEAPON_KEY;
	public int DONOTHING1_KEY;
	public int DONOTHING2_KEY;
	public static int UP1_KEY, UP2_KEY, LEFT1_KEY, LEFT2_KEY, RIGHT1_KEY, RIGHT2_KEY, DOWN1_KEY, DOWN2_KEY, UPRIGHT1_KEY, UPRIGHT2_KEY,
	UPLEFT1_KEY, UPLEFT2_KEY, DOWNLEFT1_KEY, DOWNLEFT2_KEY, DOWNRIGHT1_KEY, DOWNRIGHT2_KEY, SELF1_KEY, SELF2_KEY;
	

	public void setPlayer (Player p){
		player = p;
		level = player.getLevel();
	}
	protected Action getRelatedAction(int keyCode){
    	Debug.enterMethod(this, "getRelatedAction", keyCode+"");
    	UserAction ua = (UserAction) gameActions.get(keyCode+"");
    	if (ua == null){
    		Debug.exitMethod("null");
    		return null;
    	}
    	Action ret = ua.getAction();
		Debug.exitMethod(ret);
		return ret;
	}

	private transient UserInterface ui;
	
	public UserInterface getUI(){
		if (ui == null)
			ui = UserInterface.getUI();
		return ui;
	}
	
	protected void init(UserAction[] gameActions, Action advance, Action target, Action attack, UserInterface ui, Properties keyBindings){
		this.ui = ui;
		this.advance = advance;
		this.target = target;
		this.attack = attack;
		for (int i = 0; i < gameActions.length; i++){
			this.gameActions.put(gameActions[i].getKeyCode()+"", gameActions[i]);
		}
		WEAPON_KEY = Integer.parseInt(keyBindings.getProperty("WEAPON_KEY"));
		DONOTHING1_KEY = Integer.parseInt(keyBindings.getProperty("DONOTHING1_KEY"));
		DONOTHING2_KEY = Integer.parseInt(keyBindings.getProperty("DONOTHING2_KEY"));
		UP1_KEY = Integer.parseInt(keyBindings.getProperty("UP1_KEY"));
		UP2_KEY = Integer.parseInt(keyBindings.getProperty("UP2_KEY"));
		LEFT1_KEY = Integer.parseInt(keyBindings.getProperty("LEFT1_KEY"));
		LEFT2_KEY = Integer.parseInt(keyBindings.getProperty("LEFT2_KEY"));
		RIGHT1_KEY = Integer.parseInt(keyBindings.getProperty("RIGHT1_KEY"));
		RIGHT2_KEY = Integer.parseInt(keyBindings.getProperty("RIGHT2_KEY"));
		DOWN1_KEY = Integer.parseInt(keyBindings.getProperty("DOWN1_KEY"));
		DOWN2_KEY = Integer.parseInt(keyBindings.getProperty("DOWN2_KEY"));
		UPRIGHT1_KEY = Integer.parseInt(keyBindings.getProperty("UPRIGHT1_KEY"));
		UPRIGHT2_KEY  = Integer.parseInt(keyBindings.getProperty("UPRIGHT2_KEY"));
		UPLEFT1_KEY = Integer.parseInt(keyBindings.getProperty("UPLEFT1_KEY"));
		UPLEFT2_KEY = Integer.parseInt(keyBindings.getProperty("UPLEFT2_KEY"));
		DOWNLEFT1_KEY = Integer.parseInt(keyBindings.getProperty("DOWNLEFT1_KEY"));
		DOWNLEFT2_KEY = Integer.parseInt(keyBindings.getProperty("DOWNLEFT2_KEY"));
		DOWNRIGHT1_KEY = Integer.parseInt(keyBindings.getProperty("DOWNRIGHT1_KEY"));
		DOWNRIGHT2_KEY = Integer.parseInt(keyBindings.getProperty("DOWNRIGHT2_KEY"));
		SELF1_KEY = Integer.parseInt(keyBindings.getProperty("SELF1_KEY"));
		SELF2_KEY  = Integer.parseInt(keyBindings.getProperty("SELF2_KEY"));
	}
	
    public boolean isArrow(CharKey input) {
		return toIntDirection(input) != -1;
	}
    
    public static int toIntDirection(CharKey ck){
		if (isKey(ck, UP1_KEY, UP2_KEY))
			return Action.UP;
		else
		if (isKey(ck, LEFT1_KEY, LEFT2_KEY))
			return Action.LEFT;
		else
		if (isKey(ck, RIGHT1_KEY, RIGHT2_KEY))
			return Action.RIGHT;
		else
		if (isKey(ck, DOWN1_KEY, DOWN2_KEY))
			return Action.DOWN;
		else
		if (isKey(ck, UPRIGHT1_KEY, UPRIGHT2_KEY))
			return Action.UPRIGHT;
		else
		if (isKey(ck, UPLEFT1_KEY, UPLEFT2_KEY))
			return Action.UPLEFT;
		else
		if (isKey(ck, DOWNLEFT1_KEY, DOWNLEFT2_KEY))
			return Action.DOWNLEFT;
		else
		if (isKey(ck, DOWNRIGHT1_KEY, DOWNRIGHT2_KEY))
			return Action.DOWNRIGHT;
		if (isKey(ck, SELF1_KEY, SELF2_KEY))
			return Action.SELF;
		return -1;
	}
	private static boolean isKey(CharKey ck, int key1, int key2) {
		return ck.code == key1 || ck.code == key2; 
	}
	
}
