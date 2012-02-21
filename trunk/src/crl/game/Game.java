package crl.game;


import java.util.*;

import crl.Main;
import crl.ui.*;
//import crl.action.vkiller.Whip;
import crl.level.*;
import crl.levelgen.*;
import crl.monster.VMonster;
import crl.actor.*;
import crl.npc.*;
import crl.item.*;
import crl.player.*;
import sz.fov.FOV;
import sz.util.*;


public class Game implements CommandListener, PlayerEventListener, java.io.Serializable{
	//Configuration
	private transient UserInterface ui;
	private transient UISelector uiSelector;
	
	private Dispatcher dispatcher;
	private Player player;
	private Level currentLevel;
	private boolean canSave;
	
	public void setCanSave(boolean vl){
		canSave = vl;
	}
	
	public boolean canSave(){
		return canSave;
	}
	
	private Hashtable /*Level*/  storedLevels = new Hashtable();
	private boolean endGame;
	private long turns;
	private boolean isDay = true;
	private int timeSwitch;
	private Hashtable levelMetadata = new Hashtable();
	//private String[] levelPath;

	public void commandSelected (int commandCode){
		if (commandCode == CommandListener.QUIT){
			finishGame();
		} else if (commandCode == CommandListener.SAVE) {
			if (canSave()){
				freezeUniqueRegister();
				GameFiles.saveGame(this, player);
				exitGame();
			}
		}
	}

	private void run(){
		Debug.enterMethod(this, "run");
		player.setFOV(new FOV());
		player.getLevel().addMessage("Greetings "+player.getName()+", welcome to the game... Press '?' for Help");
		ui.refresh();
		checkTimeSwitch();
		while (!endGame){
			Debug.enterMethod(this, "run.innerLoop "+turns);
			Actor actor = dispatcher.getNextActor();
            if (actor == player){
            	player.darken();
            	player.see();
            	if (!player.justJumped())
            		ui.refresh();
				player.getGameSessionInfo().increaseTurns();
				player.checkDeath();
				player.getLevel().checkUnleashers(this);
				
			}
            if (endGame)
            	break;
			actor.act();
			if (endGame)
            	break;
			actor.getLevel().getDispatcher().returnActor(actor);
			
			if (actor == player){
				if (currentLevel != null)
					currentLevel.updateLevelStatus();
				//ui.refresh();
				turns++;
				//player.addScore(1);
				checkTimeSwitch();
			}
			Debug.exitMethod();
		}
		Debug.exitMethod();
	}
	 	
	private void forwardTime(){
		timeSwitch = 0;
		checkTimeSwitch();
	}
	
	private void checkTimeSwitch(){
		if (endGame)
			return;
		timeSwitch --;
		currentLevel.setTimecounter(timeSwitch);
		if (timeSwitch <= 0){
			//Environmental Effects, random
			boolean rain = Util.chance(20);
			boolean thunderstorm = !rain && Util.chance(10);
			boolean fog = !rain && !thunderstorm && Util.chance(10);
			boolean sunnyDay = !isDay && !fog && !rain && !thunderstorm && Util.chance(20);
			
			player.setFlag(Consts.ENV_RAIN, rain);
			player.setFlag(Consts.ENV_THUNDERSTORM, thunderstorm);
			player.setFlag(Consts.ENV_FOG, fog);
			player.setFlag(Consts.ENV_SUNNY, sunnyDay);
			
			if (isDay){
				if (currentLevel.hasNoonMusic()){
					STMusicManagerNew.thus.stopMusic();
					Display.thus.showTimeChange(!isDay, fog, rain, thunderstorm, false);
					STMusicManagerNew.thus.playKey(currentLevel.getMusicKeyNoon());
				} else {
					Display.thus.showTimeChange(!isDay, fog, rain, thunderstorm, false);
				}
			}
			else {


				if (currentLevel.hasNoonMusic()){
					STMusicManagerNew.thus.stopMusic();
					Display.thus.showTimeChange(!isDay, fog, rain, thunderstorm, sunnyDay);
					STMusicManagerNew.thus.playKey(currentLevel.getMusicKeyMorning());
				} else {
					Display.thus.showTimeChange(!isDay, fog, rain, thunderstorm, sunnyDay);
				}
			}
			isDay = !isDay;
			currentLevel.setIsDay(isDay);
			timeSwitch = DAY_LENGTH;
			currentLevel.setTimecounter(timeSwitch);
		}
	}
	
	public final static int DAY_LENGTH = 500;
	
	public void resume(){
		player.setSelector(uiSelector);
		ui.setPlayer(player);
		uiSelector.setPlayer(player);
		ui.addCommandListener(this);
		ui.setGameOver(false);
		player.getLevel().addActor(player);
		player.setPlayerEventListener(this);
		endGame = false;
		turns = player.getGameSessionInfo().getTurns();
		syncUniqueRegister();
		if (currentLevel.hasNoonMusic() && !currentLevel.isDay()){
			STMusicManagerNew.thus.playKey(currentLevel.getMusicKeyNoon());
		} else {
			STMusicManagerNew.thus.playKey(currentLevel.getMusicKeyMorning());
		}
		run();
	}
	
	public void setPlayer(Player p){
		player = p;
		player.setLevel(currentLevel);
		player.setFOV(new FOV());
		currentLevel.setPlayer(player);
		if (player.getGameSessionInfo() == null)
			player.setGameSessionInfo(new GameSessionInfo());
		player.setSelector(uiSelector);
		ui.setPlayer(player);
		uiSelector.setPlayer(player);
		player.setPlayerEventListener(this);
		player.setGame(this);
	}
	
	public void newGame(){
		player = PlayerGenerator.thus.generatePlayer();
		player.setGame(this);
		player.setGameSessionInfo(new GameSessionInfo());
		player.setSelector(uiSelector);
		ui.setPlayer(player);
		uiSelector.setPlayer(player);
		ui.addCommandListener(this);
		ui.setGameOver(false);
		player.setPlayerEventListener(this);
		generateLevelPath();
		Display.thus.showIntro(player);
		
		loadLevel("CHARRIOT_W", 0);
		//loadLevel("DRAGON_KING_LAIR", 15);
		turns = 0;
		timeSwitch = (int)(DAY_LENGTH / 2.0);
		run();
	}
	
	public void training(){
		player = PlayerGenerator.thus.createSpecialPlayer("SOLIEYU_KID");
		player.setGame(this);
		player.setGameSessionInfo(new GameSessionInfo());
		player.setSelector(uiSelector);
		player.setDoNotRecordScore(true);
		ui.setPlayer(player);
		uiSelector.setPlayer(player);
		ui.addCommandListener(this);
		ui.setGameOver(false);
		player.setPlayerEventListener(this);
		//generatePrologueLevelPath();
		//Display.thus.showIntro(player);
		LevelMetaData md = new LevelMetaData();
		md.setLevelID("TRAINING");
		levelMetadata.put("TRAINING", md);
		
		loadLevel("TRAINING");
		turns = 0;
		timeSwitch = DAY_LENGTH;
		run();
	}
	
	public void prologue(){
		player = PlayerGenerator.thus.createSpecialPlayer("CHRIS");
		player.setGame(this);
		player.setGameSessionInfo(new GameSessionInfo());
		player.setSelector(uiSelector);
		player.setDoNotRecordScore(true);
		ui.setPlayer(player);
		uiSelector.setPlayer(player);
		ui.addCommandListener(this);
		ui.setGameOver(false);
		player.setPlayerEventListener(this);
		
		LevelMetaData md = new LevelMetaData();
		md.setLevelID("PROLOGUE_KEEP");
		levelMetadata.put("PROLOGUE_KEEP", md);
		
		loadLevel("PROLOGUE_KEEP");
		currentLevel.setIsDay(false);
		turns = 0;
		timeSwitch = DAY_LENGTH;
		run();
	}
	
	public void arena(){
		player = PlayerGenerator.thus.createSpecialPlayer("SONIA");
		player.setGame(this);
		player.setGameSessionInfo(new GameSessionInfo());
		player.setSelector(uiSelector);
		player.setDoNotRecordScore(false);
		ui.setPlayer(player);
		uiSelector.setPlayer(player);
		ui.addCommandListener(this);
		ui.setGameOver(false);
		player.setPlayerEventListener(this);
		
		LevelMetaData md = new LevelMetaData();
		md.setLevelID("PRELUDE_ARENA");
		levelMetadata.put("PRELUDE_ARENA", md);
		
		loadLevel("PRELUDE_ARENA");
		turns = 0;
		timeSwitch = (int)(DAY_LENGTH / 3.0);
		run();
	}
	
	
	private void processLevelData(String[][] order, int startLevelNumber){
		Vector levels = new Vector(5);
		Vector numbered = new Vector(5);
		int levelCount = startLevelNumber;
		for (int i = 0; i < order.length; i++){
			int n = Util.rand(3,6);
			if (order[i][1].indexOf("ONE")!=-1)
				n = 1;
			for (int j = 0; j < n;j++) {
				levels.add(order[i][0]+j);
				if (order[i][1].indexOf("NONUMBER")==-1)
					numbered.add("yes");
				else
					numbered.add("no");
			}
		}
		
		for (int i = 0; i < levels.size(); i++){
			LevelMetaData md = new LevelMetaData();
			md.setLevelID((String)levels.get(i));
			if (i > 0){
				md.addExits((String)levels.get(i-1), "_BACK");
			}
			if (i < levels.size()-1){
				md.addExits((String)levels.get(i+1), "_NEXT");
			}
			if (numbered.get(i).equals("yes")){
				md.setLevelNumber(levelCount);
				levelCount++;
			}
			
			levelMetadata.put(md.getLevelID(), md);
		}
	}
	private void generateLevelPath(){
		String [][] order = new String [][]{
				{"TOWN", "ONE"},
				{"FOREST", "ONE"},
				{"CASTLE_BRIDGE", "ONE"},
				{"GARDEN", "ONE"},
				{"MAIN_HALLX", "ONE"},
				{"QUARTERS_FORK", "ONE,NONUMBER"}, //Quarters Branch /*5+*/ /*unnumbered*/
				{"MAIN_HALL", ""},
				{"MOAT", "ONE"},
				{"BAT_HALL","ONE"}, 
				{"DEATH_HALL","ONE,NONUMBER"}, /*unnumbered*/
				{"TELEPAD1", "ONE,NONUMBER"}, /*unnumbered*/
				{"LABX", "ONE"},
				{"VINDELITH_MEETING", "ONE,NONUMBER"},
				{"LAB", ""},
				{"MEDUSA_LAIR", "ONE, NONUMBER"}, /*unnumbered*/
				{"CHAPEL", "ONE"}, 
				{"TELEPAD2", "ONE, NONUMBER"}, /*unnumbered*/
				{"RUINSX", "ONE"},
				{"RUINSY", "ONE"},
				{"CLARA_MEETING", "ONE, NONUMBER"}, /*unnumbered*/
				{"RUINS", ""},
				{"MUMMIES_LAIR", "ONE, NONUMBER"}, /*unnumbered*/
				{"CAVESX", "ONE"},
				{"CAVE_FORK", "ONE, NONUMBER"}, //Warehouse branch /*24+*/	/*unnumbered*/			
				{"CAVES", ""},
				{"DRAGON_KING_LAIR", "ONE, NONUMBER"}, /*unnumbered*/
				{"TELEPAD3", "ONE, NONUMBER"}, /*unnumbered*/
				{"COURTYARD", "ONE"},
				{"DUNGEONX", "ONE"},
				{"DUNGEONY", "ONE"},
				{"BADBELMONT", "ONE, NONUMBER"}, /*unnumbered*/
				{"DUNGEON", ""},
				{"FRANK_LAIR", "ONE, NONUMBER"}, /*unnumbered*/
				{"TELEPAD4", "ONE, NONUMBER"}, /*unnumbered*/
				/*{"FINAL_BRIDGE", "*"},*/
				{"CLOCK_BASE", ""},
				{"TOWER", "ONE"},
				{"TOWER_TOP", "ONE"}, /*unnumbered*/
				{"KEEP", "ONE"}, 
				{"VOID", "ONE"} 
		};
		processLevelData(order,0);
		
		// Warehouse Branch
		order = new String [][]{
				{"WAREHOUSEX", "ONE, NONUMBER"}, /*Starts in 6*/
				{"DEEP_FORK", "ONE, NONUMBER"}, /*6+*/
				{"WAREHOUSE", ""},
				{"TELEPADX1", "ONE, NONUMBER"},
				{"CATACOMBS", ""},
				{"LEGION_LAIR", "ONE, NONUMBER"},
				{"TELEPADX2", "ONE, NONUMBER"},
				{"PRIZE_CATACOMBS", "ONE, NONUMBER"},
		};
		processLevelData(order, 8);
		
		// Underground reservoir branch
		order = new String [][]{
				{"RESERVOIR", ""}, /*Start in 7*/
				{"RESERVOIR", ""}, 
				{"WATER_DRAGON_LAIR", "ONE, NONUMBER"},
				{"SPECIAL_RESERVOIR_TELEPAD", "ONE, NONUMBER"},
				{"PRIZE_RESERVOIR", "ONE, NONUMBER"},
		};
		
		processLevelData(order,10);
		
		// Quarters Branch
		order = new String [][]{
				{"INNER_QUARTERS", ""},
				{"INNER_QUARTERS", ""},
				{"INNER_QUARTERS", ""},
				{"TELEPADZ1", "ONE, NONUMBER"},
				{"QUARTERS_PRIZE", "ONE, NONUMBER"},
		};
		
		processLevelData(order,7);
		
		//Sewers Branch
		order = new String [][]{
				{"SPECIAL_SEWERS_ENTRANCE", "ONE, NONUMBER"},
				{"SEWERS", "NONUMBER"},
				{"SEWERSY", "NONUMBER"},
				{"SEWERSZ", "NONUMBER"},
				{"DEEP_SEWERS", "ONE, NONUMBER"},
				{"PRIZE_SEWERS", "ONE, NONUMBER"},
		};
		processLevelData(order, 1);
		
		// End of Branches
		LevelMetaData md = new LevelMetaData();
		md.setLevelID("CHARRIOT_W");
		md.addExits("FOREST0", "_NEXT");
		levelMetadata.put("CHARRIOT_W", md);
		
		md = new LevelMetaData();
		md.setLevelID("DINING_HALL");
		levelMetadata.put("DINING_HALL", md);
		
		md = new LevelMetaData();
		md.setLevelID("TRAINING");
		levelMetadata.put("TRAINING", md);
		
		md = new LevelMetaData();
		md.setLevelID("PROLOGUE_KEEP");
		levelMetadata.put("PROLOGUE_KEEP", md);
		
		md = new LevelMetaData();
		md.setLevelID("PRELUDE_ARENA");
		levelMetadata.put("PRELUDE_ARENA", md);
		
		md = new LevelMetaData();
		md.setLevelID("VILLA");
		levelMetadata.put("VILLA", md);
		
		//levelPath = (String[]) levels.toArray(new String[levels.size()]);
		storedLevels = new Hashtable();
	}
	
	private void resumeScreen(){
		STMusicManagerNew.thus.playKey("GAME_OVER");
		UserInterface.getUI().showMessageHistory();
		if (Display.thus.showResumeScreen(player)){
			GameFiles.saveMemorialFile(player);
		}
    }
	
    public void informEvent(int code){
    	informEvent(code, null);
    }

    private String [] DEATHMESSAGES = new String[]{
		"You are dead... and Dracula is still alive",
		"All hopes are lost.",
		"It's the end.",
		"Let us enjoy this evening for pleasure, the night is still young...",
		"Game Over",
		"Better luck next time, Son of a Belmont"
    };
	public void informEvent(int code, Object param){
		Debug.enterMethod(this, "informEvent", code+","+param);
		switch (code){
			case Player.DEATH:
				ui.refresh();
				ui.showSystemMessage(Util.randomElementOf(DEATHMESSAGES) +  " [Press Space to continue]");
				finishGame();
				break;
			case Player.DROWNED:
				ui.refresh();
				ui.showSystemMessage("You choke with the water and drown!  [Press Space to continue]");
				finishGame();
				break;
			case Player.EVT_SMASHED:
				ui.refresh();
				ui.showSystemMessage("Your body collapses!  [Press Space to continue]");
				finishGame();
				break;
			/*case Player.EVT_NEXT_LEVEL:
				loadNextLevel();
				break;
			case Player.EVT_BACK_LEVEL:
				loadBackLevel();
				break;*/
			case Player.EVT_GOTO_LEVEL:
				loadLevel((String)param);
				break;
			case Player.EVT_MERCHANT:
				ui.launchMerchant((Merchant)param);
				break;
			case Player.EVT_CHAT:
				ui.chat((NPC)param);
				break;
			case Player.EVT_INN:
				if (ui.promptChat((NPC)param)){
					if (player.getGold()>=200){
						forwardTime();
						forwardTime();
						VMonster monsters = player.getLevel().getMonsters();
						for (int i = 0; i < monsters.size(); i++){
							if (monsters.elementAt(i) instanceof Merchant){
								((Merchant)monsters.elementAt(i)).refreshMerchandise(player);
							}
						}
						player.setGold(player.getGold()-200);
					} else {
						ui.showMessage("You don't have enough gold.");
					}
				}
				break;
			case Player.EVT_LEVELUP:
				ui.levelUp();
				break;
			case Player.EVT_FORWARDTIME:
				forwardTime();
				break;
		}
		Debug.exitMethod();
	}

	/*private void endGame(){
		Display.thus.showEndgame(player);
	}*/

	private void finishGame(){
		if (!player.isDoNotRecordScore()){
			GameFiles.updateGraveyard(Main.getMonsterRecord(), player.getGameSessionInfo());
			GameFiles.saveHiScore(player, player.getFlag("ARENA_FIGHTER")?"arena.tbl":"hiscore.tbl");
			resumeScreen();
			Display.thus.showHiscores(GameFiles.loadScores(player.getFlag("ARENA_FIGHTER")?"arena.tbl":"hiscore.tbl"));
		}
		GameFiles.permadeath(player);
		exitGame();
	}
	
	public void exitGame(){
		//levelNumber = -1;
		currentLevel.disableTriggers();
		currentLevel = null;
		ui.removeCommandListener(this);
		ui.setGameOver(true);
		player.setPlayerEventListener(null);
		
		
		endGame = true;
	}

	private void loadLevel(String levelID) {
		loadLevel(levelID, -1);
	}
	
	public void wonGame(){
		Display.thus.showEndgame(player);
		player.getGameSessionInfo().setDeathCause(GameSessionInfo.ASCENDED);
		finishGame();
		return;
	}
	
	private void loadLevel(String levelID, int targetLevelNumber) {
		Debug.enterMethod(this, "loadLevel", levelID+","+targetLevelNumber);
		String formerLevelID = null; 
		if (currentLevel != null){
			if (currentLevel.getBoss() != null && !currentLevel.getBoss().isDead())
				return;
			formerLevelID = currentLevel.getID();
			Level storedLevel = (Level) storedLevels.get(formerLevelID);
			if (storedLevel == null){
				storedLevels.put(formerLevelID, currentLevel);
			}  
		} else {
			formerLevelID = "_BACK";
		}
		Level storedLevel = (Level)storedLevels.get(levelID);
		if (storedLevel != null) {
			currentLevel = storedLevel;
			player.setPosition(currentLevel.getExitFor(formerLevelID));
			currentLevel.setIsDay(isDay);
			currentLevel.setTimecounter(timeSwitch);
			if (currentLevel.isCandled()){
				currentLevel.destroyCandles();
				LevelMaster.lightCandles(currentLevel);
			}
		} else {
			try {
				currentLevel = LevelMaster.createLevel((LevelMetaData)levelMetadata.get(levelID), player);
				currentLevel.setPlayer(player);
				ui.setPlayer(player);
				uiSelector.setPlayer(player);
				currentLevel.setIsDay(isDay);
				currentLevel.setTimecounter(timeSwitch);
				if (currentLevel.getPlayer() != null)
					currentLevel.getPlayer().addHistoricEvent("got to the "+currentLevel.getDescription());
			} catch (CRLException crle){
				crash("Error while creating level "+levelID, crle);
			}
		}
		//currentLevel.setLevelNumber(targetLevelNumber);
		player.setLevel(currentLevel);
		
		if(currentLevel.getExitFor(formerLevelID) != null){
			player.setPosition(currentLevel.getExitFor(formerLevelID));
		} else if(currentLevel.getExitFor("_START") != null) {
			player.setPosition(currentLevel.getExitFor("_START"));
		}
		
		if (currentLevel.isHostageSafe()){
			if (player.hasHostage()){
				//player.setPosition(currentLevel.getExitFor("_NEXT"));
				Hostage h = player.getHostage();
				player.setHostage(null);
				h.setPosition(player.getPosition().x - 3, player.getPosition().y, player.getPosition().z);
				h.setRescued(true);
				currentLevel.addMonster(h);
				player.addHistoricEvent("brought "+h.getDescription()+" to safety");
				Display.thus.showHostageRescue(h);
				player.addGold(h.getReward());
				Item reward = h.getItemReward();
				if (reward != null)
					if (player.canCarry())
						player.addItem(reward);
					else
						player.getLevel().addItem(player.getPosition(), reward);
			}
		}
		dispatcher = currentLevel.getDispatcher();
		if (currentLevel.hasNoonMusic() && !currentLevel.isDay()){
			STMusicManagerNew.thus.playKey(currentLevel.getMusicKeyNoon());
		} else {
			STMusicManagerNew.thus.playKey(currentLevel.getMusicKeyMorning());
		}
		if (currentLevel.isRutinary()){
			currentLevel.anihilateMonsters();
			currentLevel.populate();
		}
		
		if (currentLevel.getBoss() != null){
			currentLevel.getBoss().recoverHits();
		}
		if (!dispatcher.contains(player)){
			dispatcher.addActor(player);
		}
		ui.levelChange();
		Debug.exitMethod();
	}
	
	public void setLevel(Level level){
		currentLevel = level;
		player.setLevel(level);
		dispatcher = currentLevel.getDispatcher();
		if (currentLevel.hasNoonMusic() && !currentLevel.isDay()){
			STMusicManagerNew.thus.playKey(currentLevel.getMusicKeyNoon());
		} else {
			STMusicManagerNew.thus.playKey(currentLevel.getMusicKeyMorning());
		}
		
		//STMusicManager.thus.playForLevel(levelNumber, levelPath[levelNumber], currentLevel.isDay());
		ui.levelChange();
		
		
	}
	public Player getPlayer(){
		return player;
	}
	
	public static String getVersion(){
		return "0.73";
	}
	
	public void setInterfaces(UserInterface pui, UISelector ps){
		ui = pui;
		uiSelector = ps;
	}
	
	public static void crash(String message, Throwable exception){
    	System.out.println("CastlevaniaRL "+Game.getVersion()+": Error");
        System.out.println("");
        System.out.println("Unrecoverable error: "+message);
        System.out.println(exception.getMessage());
        exception.printStackTrace();
        System.exit(-1);
    }
	
	public static void crash(String message){
    	System.out.println("CastlevaniaRL "+Game.getVersion()+": Error");
        System.out.println("");
        System.out.println("Unrecoverable error: "+message);
        System.exit(-1);
    }
	
	private static Vector reports = new Vector(20);
	public static void addReport(String report){
		reports.add(report);
	}
	
	public static Vector getReports(){
		return reports;
	}

	private static Vector uniqueRegister = new Vector();
	private Vector uniqueRegisterObjectCopy = new Vector();
	
	public void syncUniqueRegister(){
		uniqueRegister = uniqueRegisterObjectCopy;
	}
	
	public void freezeUniqueRegister(){
		uniqueRegisterObjectCopy = uniqueRegister;
	}
	
	public static boolean wasUniqueGenerated(String itemID){
		return uniqueRegister.contains(itemID);
	}
	
	public static void registerUniqueGenerated (String itemID){
		uniqueRegister.add(itemID);
	}
	
}