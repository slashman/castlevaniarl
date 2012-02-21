package crl.ui;

import java.util.*;

import sz.util.*;

import crl.action.*;
//import crl.action.vkiller.Whip;
import crl.ui.effects.*;
import crl.player.*;
import crl.item.*;
import crl.level.*;
import crl.npc.*;
import crl.actor.*;


/** 
 *  Shows the level
 *  Informs the Actions and Commands of the player.
 * 	Must be listening to a System Interface
 */

public abstract class UserInterface implements CommandListener/*, Runnable*/{
	//Attributes
	//private String[] quitMessages;
	protected String[] quitMessages = new String[]{
		"Do you really want to abandon Transylvania?",
		"Quit now, and let the evil count roam the world free?",
		"Leave now, and lose this unique chance to fight for freedom?",
		"Abandon the people of Transylvania?",
		"Deceive everybody who trusted you?",
		"Throw your weapons away and live a 'peaceful' life?"
		
	};
	
	
	//Status
	protected Vector monstersOnSight = new Vector();
	protected Vector featuresOnSight = new Vector();
	protected Vector itemsOnSight = new Vector();
	protected Action actionSelectedByCommand;
	
	//Components
	
	protected boolean eraseOnArrival; // Erase the buffer upon the arrival of a new msg
   	
	protected String lastMessage; 
	protected Level level;
    // Relations
	protected Player player;

	// Setters
	/** Sets the object which will be informed of the player commands.
     * this corresponds to the Game object */
	
	
	//Getters
    public Player getPlayer() {
		return player;
	}

    // Smart Getters
	
    
    //  Final attributes
    
    public final static String verboseSkills[] = new String []{
		"Unskilled", 
		"Mediocre(1)", 
		"Mediocre(2)", 
		"Mediocre(3)", 
		"Trained(1)",
		"Trained(2)",
		"Trained(3)", 
		"Skilled(1)",
		"Skilled(2)",
		"Skilled(3)",
		"Master"
	};

    //private final int WEAPONCODE = CharKey.SPACE;

    private boolean [][] FOVMask;
    //Interactive Methods
    public abstract void doLook();
    
    public abstract void launchMerchant(Merchant who);
    
    public abstract void chat (NPC who);
    
    public abstract boolean promptChat (NPC who);

    // Drawing Methods
	public abstract void drawEffect(Effect what);
	
	public boolean isOnFOVMask(int x, int y){
		return FOVMask[x][y];
	}

	public abstract void addMessage(Message message);
	public abstract Vector getMessageBuffer();

	public void setPlayer(Player pPlayer){
		player = pPlayer;
		level = player.getLevel();
	}

	public void init(UserCommand[] gameCommands){
		//uiSelector = selector;
		FOVMask = new boolean[80][25];
		for (int i = 0; i < gameCommands.length; i++)
			this.gameCommands.put(gameCommands[i].getKeyCode()+"", gameCommands[i]);
		addCommandListener(this);
	}

	protected int getRelatedCommand(int keyCode){
		Debug.enterMethod(this, "getRelatedCommand", keyCode+"");
    	UserCommand uc = (UserCommand ) gameCommands.get(keyCode+"");
    	if (uc == null){
    		Debug.exitMethod(CommandListener.NONE);
    		return CommandListener.NONE;
    	}

    	int ret = uc.getCommand();
    	Debug.exitMethod(ret+"");
    	return ret;
	}
	

	

	
	
	public abstract boolean isDisplaying(Actor who);

    public void levelChange(){
		level = player.getLevel();
	}
    
	protected void informPlayerCommand(int command) {
	    Debug.enterMethod(this, "informPlayerCommand", command+"");
	    for (int i =0; i < commandListeners.size(); i++){
	    	((CommandListener)commandListeners.elementAt(i)).commandSelected(command);
	    }
		Debug.exitMethod();
    }
	
	public void addCommandListener(CommandListener pCl) {
		commandListeners.add(pCl);
    }
	
	public void removeCommandListener(CommandListener pCl){
		commandListeners.remove(pCl);
	}
	
	protected Hashtable gameCommands = new Hashtable(); 
	private Vector commandListeners = new Vector (5); // Class CommandListener

    
    /**
     * Prompts for Yes or NO
     */
    public abstract boolean prompt ();

	public abstract void refresh();


 	/**
     * Shows a message inmediately; useful for system
     * messages.
     *  
     * @param x the message to be shown
     */
	public abstract void showMessage(String x);

	public abstract void showImportantMessage(String x);
	/**
     * Shows a message inmediately; useful for system
     * messages. Waits for a key press or something.
     *  
     * @param x the message to be shown
     */
	public abstract void showSystemMessage(String x);
	
    /* Shows a level was won, lets pick a random spirit */
	public abstract void levelUp();
	
	public abstract void processQuit();
	
	public abstract void processSave();
	
	public abstract void showPlayerStats();
	
	public abstract Action showInventory() throws ActionCancelException;
	
	public abstract Action showSkills() throws ActionCancelException;
	
	public void commandSelected (int commandCode){
		switch (commandCode){
			case CommandListener.PROMPTQUIT:
				processQuit();
				break;
			case CommandListener.PROMPTSAVE:
				processSave();
				break;
			case CommandListener.HELP:
				Display.thus.showHelp();
				break;
			case CommandListener.LOOK:
				doLook();
				break;
			case CommandListener.SHOWSTATS:
				showPlayerStats();
				break;
			case CommandListener.SHOWINVEN:
				try {
					actionSelectedByCommand = showInventory();
				} catch (ActionCancelException ace){

				}
				break;
			case CommandListener.SHOWSKILLS:
				try {
					if (!player.isSwimming()){
						actionSelectedByCommand = showSkills();
					} else {
						player.getLevel().addMessage("You can't do that!");
					}
				} catch (ActionCancelException ace){

				}
				break;
		}
	}
	
	private boolean gameOver;
	
	public void setGameOver(boolean bal){
		
		gameOver = bal;
	}
	
	public boolean gameOver(){
		return gameOver;
	}
	
	//	 Singleton
	private static UserInterface singleton;
	
	public static void setSingleton(UserInterface ui){
		singleton = ui;
	}
	public static UserInterface getUI (){
		return singleton;
	}
	
	public abstract void setTargets(Action a) throws ActionCancelException;
	public abstract void showMessageHistory();

	public abstract void setPersistantMessage(String description) ;
}