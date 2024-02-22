package crl.conf.gfx.data;
import java.awt.image.BufferedImage;

import sz.util.ImageUtils;

import crl.game.Game;
import crl.ui.*;
import crl.ui.graphicsUI.*;

public class GFXAppearances {
	private int WIDTH_BIG;
	private int UI_SCALE;
	private int WIDTH_HALF;
	private int WIDTH_QUARTER;
	private final static int ICON_SIZE = 16;
	private int CELL_HEIGHT;
	private int WIDTH_NORMAL;
	
	protected GFXConfiguration configuration;
	
	public GFXAppearances(GFXConfiguration configuration) {
		this.configuration = configuration;
		
		WIDTH_BIG = configuration.getBigTileWidth();
		WIDTH_HALF = configuration.getHalfTileWidth();
		UI_SCALE = configuration.getViewportUserInterfaceScale();
		WIDTH_QUARTER = (int) Math.floor(configuration.getHalfTileWidth() / 2);
		CELL_HEIGHT = configuration.getCellHeight();
		WIDTH_NORMAL = configuration.getNormalTileWidth();
		
		SetAppearances();
	}
	
	private Appearance [] defs;
	
	
	protected void SetAppearances() {
		GFXImageConfiguration imgConfig = configuration.getImageConfiguration();
		defs = new Appearance[]{
		createTAppearance("VOID", 4,5),
		new GFXAppearance("NOTHING", null, null,null,null,0,0),

		createAppearance("BLOOD1", imgConfig.getEffectsImage(), 5, 4),
		createAppearance("BLOOD2", imgConfig.getEffectsImage(), 6, 4),
		createAppearance("BLOOD3", imgConfig.getEffectsImage(), 7, 4),
		
		/*NEEDED*/
		//createAppearance("COFFIN", imgConfig.getItemsImage(), 1,1),
		createTAppearance("COFFIN", 14, 2),
		
		createTAppearance("DOOR", 11,2),
		
		createAppearance("SHADOW", imgConfig.getShadowImage(), 1,1),
		
		createAppearance("CHRISTOPHER_B", imgConfig.getCharactersImage(), 1,5),
		
		createAppearance("SOLIEYU_B", imgConfig.getCharactersImage(), 2,5),
		createAppearance("BADBELMONT", imgConfig.getCharactersImage(), 2,6),
		createBAppearance("PRELUDE_DRACULA", imgConfig.getBigMonstersImage(), 4, 5),
		
		/*Town*/
		createTAppearance("TOWN_GRASS", 4, 1),
		createTAppearance("TOWN_WALL", 1, 1),
		createTAppearance("HOUSE_FLOOR",9, 1),
		createTAppearance("TOWN_DOOR", 1, 11),
		createTAppearance("MIDWALKWAY", 2, 1),
		createTAppearance("TOWN_CHURCH_FLOOR", 10, 1),
		createTAppearance("TOWN_WATERWAY", 7, 1),
		createTAppearance("BRICKWALKWAY", 6, 1),
		createTAppearance("BRICKWALKWAY2", 10, 1),
		createTAppearance("TOWN_ROOF", 14, 1),
		createTAppearance("TOWN_STAIRSDOWN", 15, 1),
		createTAppearance("TOWN_STAIRSUP", 16, 1),
		createTAppearance("TOWN_TREE", 12, 1),
		createTAppearance("TOWN_STAIRS", 3, 1),
		
		/*Dark Forest*/
		createTAppearance("FOREST_TREE", 8, 1),
		createTAppearance("FOREST_TREE_1", 12, 1),
		createTAppearance("FOREST_TREE_2", 13, 1),
		createTAppearance("FOREST_GRASS", 17, 1),
		createTAppearance("FOREST_DIRT", 19, 1),
		createTAppearance("WRECKED_CHARRIOT", 15, 2),
		createTAppearance("WRECKED_WHEEL", 14, 2),
		createTAppearance("SIGN_POST", 16,2),
		
		/*Castle Bridge*/
		createTAppearance("WOODEN_BRIDGE", 17, 3),
		createTAppearance("DARK_LAKE", 13, 3),
		createTAppearance("BRIDGE_WALKWAY", 16, 3),
		createTAppearance("BRIDGE_COLUMN", 14, 3),
		createTAppearance("STONE_BLOCK", 1, 1),
		
		/*Castle Garden*/
		createTAppearance("GARDEN_GRASS", 17, 1),
		createTAppearance("GARDEN_WALKWAY", 19, 1),
		createTAppearance("DEAD_STUMP", 4, 2),
		createTAppearance("GARDEN_TREE", 5, 2),
		createTAppearance("GARDEN_TORCH", 3, 2),
		createTAppearance("GARDEN_FENCE", 6, 2),
		createTAppearance("CASTLE_DOOR", 11, 2),
		createTAppearance("GARDEN_FOUNTAIN_CENTER", 9, 2),
		createTAppearance("GARDEN_FOUNTAIN_AROUND", 7, 2),
		createTAppearance("GARDEN_FOUNTAIN_POOL", 8, 2),
		createTAppearance("GARGOYLESTATUE", 2, 2),
		createTAppearance("HUMANSTATUE", 1, 2),
		createTAppearance("GARDEN_DOOR", 11, 1),
		createTAppearance("GARDEN_WALL", 10, 2),
		createTAppearance("CASTLE_WALL", 10, 2),

		/*Marble Hall*/
		createTAppearance("GRAY_COLUMN", 15, 3),
		createTAppearance("MARBLE_COLUMN", 5, 3),
		createTAppearance("MARBLE_FLOOR", 1, 3),
		createTAppearance("MARBLE_STAIRS", 2, 3),
		createTAppearance("MARBLE_MIDFLOOR", 3, 3),
		createTAppearance("BIG_WINDOW", 8, 3),
		createTAppearance("RED_CURTAIN", 6, 3),
		createTAppearance("GODNESS_STATUE", 7, 3),
		createTAppearance("RED_CARPET", 4, 3),
		
		/*Moat*/
		createTAppearance("MOSS_COLUMN", 7, 4),
		createTAppearance("MOSS_FLOOR", 2, 4),
		createTAppearance("RUSTY_PLATFORM", 3, 10),
		createTAppearance("MOSS_WATERWAY_ETH", 8, 4, 0,-10),
		createTAppearance("MOSS_WATERWAY", 8, 4, 0,-10),
		/*createAppearance("MOAT_DOWN", 
				imgConfig.getTerrainImage(), 
				128, 164,WIDTH_NORMAL,WIDTH_NORMAL,
				0,0),
		createAppearance("MOAT_UP", 
				imgConfig.getTerrainImage(), 
				160, 154,WIDTH_NORMAL,42,
				0,10),*/
		createTAppearance("MOAT_DOWN", 5, 4, 0, 8),
		createTAppearance("MOAT_UP", 6, 4, 0, 8),
		createTAppearance("MOSS_MIDFLOOR", 4, 4),
		createTAppearance("MOSS_STAIRS", 3, 4),
		//createTAppearance("MOAT_UP", 6, 4),
		
		/*Sewers*/
		createTAppearance("SEWERS_FLOOR", 8, 4),
		createTAppearance("SEWERS_WALL", 1, 4),
		createTAppearance("SEWERS_DOWN", 9, 10),
		createTAppearance("SEWERS_UP", 10, 10),
		createTAppearance("WEIRD_MACHINE",8,10),
		
		/*Alchemy Lab*/
		createTAppearance("RED_FLOOR", 3, 5),
		createTAppearance("RED_WALL", 1, 5),
		createTAppearance("SMALL_WINDOW", 2, 5),
		
		/*Chapel*/
		createTAppearance("CHURCH_WALL", 11, 4),
		createTAppearance("CHURCH_FLOOR", 13, 4),
		createTAppearance("CHURCH_WOODEN_BARRIER_H", 19, 4),
		createTAppearance("CHURCH_WOODEN_BARRIER_V", 20, 4),
		createTAppearance("CHURCH_CHAIR", 18, 4),
		createTAppearance("CHURCH_CONFESSIONARY", 11, 5),
		createTAppearance("CHURCH_CARPET", 14, 4),
		createTAppearance("ATRIUM", 14, 5),
		createTAppearance("CHURCH_STAINED_WINDOW", 12, 4),
		createTAppearance("CHURCH_FLOOR_H", 13, 4),
		
		createTAppearance("QUARTERS_WALL", 11, 4),/*Pending*/
		createTAppearance("QUARTERS_FLOOR", 13, 4), /*Pending*/
		
		/*left some unused*/
		
		/*Ruins*/
		/**/createTAppearance("STONE_WALL", 4, 1),
		/**/createTAppearance("STONE_FLOOR", 4, 1),

		/*Ruins*/ 
		createTAppearance("RUINS_COLUMN", 4, 6),
		createTAppearance("RUINS_FLOOR", 2, 6),
		createTAppearance("RUINS_WALL", 1, 6),
		createTAppearance("RUINS_FLOOR_H", 5, 6),
		createTAppearance("RUINS_STAIRS", 6, 6),
		createTAppearance("RUINS_DOOR", 3, 11),
		
		/*Caves*/
		createTAppearance("CAVE_WALL", 1, 7),
		createTAppearance("CAVE_FLOOR", 2, 7),
		createTAppearance("CAVE_WATER", 5, 7), /*Missing*/
		createTAppearance("LAVA", 4, 7),
		
		/*Warehouse*/
		createTAppearance("WAREHOUSE_WALL", 1, 12),
		createTAppearance("WAREHOUSE_FLOOR", 2, 12),
		
		/*Courtyard*/ /*Missing*/
		createTAppearance("COURTYARD_WALL", 1, 6), 
		createTAppearance("COURTYARD_FLOOR", 2, 6),
		createTAppearance("COURTYARD_COLUMN", 4, 6),
		createTAppearance("COURTYARD_FENCE", 6, 2),
		createTAppearance("COURTYARD_GRASS", 18, 1),
		createTAppearance("COURTYARD_FLOWERS", 13, 2),
		createTAppearance("COURTYARD_FOUNTAIN_CENTER", 9, 2),
		createTAppearance("COURTYARD_FOUNTAIN_AROUND", 7, 2),
		createTAppearance("COURTYARD_FOUNTAIN_POOL", 8, 2),
		createTAppearance("COURTYARD_TREE", 12, 2),
		createTAppearance("COURTYARD_RUINED_WALL", 1, 6),
		createTAppearance("COURTYARD_STAIRS",6, 6),
		
		createTAppearance("DINING_CHAIR",15, 5), /*Missing*/
		createTAppearance("DINING_TABLE",8, 10), /*Missing*/
		createTAppearance("MARBLE_STAIRSUP",6, 4),
		createTAppearance("MARBLE_STAIRSDOWN",5, 4),
		
		
		/*Dungeon*/ 
		createTAppearance("DUNGEON_FLOOR", 2, 10),
		createTAppearance("DUNGEON_DOOR", 4, 11),
		createTAppearance("DUNGEON_WALL", 1, 10),
		createTAppearance("DUNGEON_PASSAGE", 3, 10),
		createTAppearance("DUNGEON_DOWN", 9, 10),
		createTAppearance("DUNGEON_UP", 10, 10),
		
		/*Frank Lab, goes with Dungeon Theme*/
		createTAppearance("WIRES", 7, 10),
		createTAppearance("FRANK_TABLE", 8, 10),
		
		/*Clock Tower*/ /*Missing*/
		createTAppearance("TOWER_FLOOR", 13, 4),
		createTAppearance("TOWER_WALL", 11, 4),
		createTAppearance("TOWER_COLUMN", 4, 6),
		createTAppearance("TOWER_WINDOW",11, 4),
		createTAppearance("TOWER_DOWN", 9, 10),
		createTAppearance("TOWER_UP", 10, 10),
		createTAppearance("CAMPANARIUM", 13, 4),
		createTAppearance("TOWER_FLOOR_H", 5, 10),
		createTAppearance("TOWER_STAIRS", 4, 10),
		createTAppearance("CLOCK_GEAR_1", 4, 6),
		createTAppearance("CLOCK_GEAR_2", 4, 6),
		createTAppearance("CLOCK_GEAR_3", 4, 6),
		createTAppearance("CLOCK_GEAR_4", 4, 6),
		
		/*Castle Keep*/ 
		createTAppearance("BARRED_WINDOW", 2, 8),
		createTAppearance("DRACULA_THRONE1", 6, 8),
		createTAppearance("DRACULA_THRONE2", 5, 8),
		createTAppearance("DRACULA_THRONE2_X", 4, 8),
		createTAppearance("BALCONY", 3, 8),
		createTAppearance("STONE_STAIRWAY", 8, 8),
		createTAppearance("KEEP_FLOOR", 7, 8),
		createTAppearance("KEEP_WALL", 1, 8),
		createTAppearance("KEEP_CARPET",16,4),
		
		/*Void*/
		createTAppearance("VOID_STAR", 1, 9),
		createTAppearance("VOID_SUN", 2, 9),
		
		createAppearance("TELEPORT", imgConfig.getTerrainImage(), 193,99,WIDTH_NORMAL,CELL_HEIGHT,0, 16),
		
		// Sacred weapons
		createIAppearance("ART_CARD_SOL", false, 1, 1),
		createIAppearance("ART_CARD_MOONS", false, 2, 1),
		createIAppearance("ART_CARD_DEATH", false, 3, 1),
		createIAppearance("ART_CARD_LOVE", false, 4, 1),
		createIAppearance("RED_CARD", false, 5, 1),
		createIAppearance("GOLDEN_MEDALLION", false, 6, 1),
		createIAppearance("SILVER_MEDALLION", false, 7, 1),
		createIAppearance("THORN_BRACELET", false, 8, 1),
		createIAppearance("LIFE_POTION", false, 9, 1),
		createIAppearance("FLAME_BOOK", false, 1, 2),
		createIAppearance("ICE_BOOK", false, 2, 2),
		createIAppearance("LIT_BOOK", false, 3, 2),
		createIAppearance("HEART_CONTAINER", false, 4, 2),
		createIAppearance("MIRACLE_POTION", false, 5, 2),
		createIAppearance("TEPES_RING", false, 6, 2),
		createIAppearance("CLUE_PAGE2", false, 8, 2),
		createIAppearance("CLUE_PAGE3", false, 9, 2),
		createIAppearance("JUKEBOX", false, 9, 2),
		createIAppearance("CLUE_PAGE1", false, 7, 2),
		createIAppearance("JUMPING_WING", false, 1, 3),
		createIAppearance("FIRE_GEM", false, 2, 3),
		createIAppearance("FLAME_ITEM", false, 3, 3),
		createIAppearance("MAGIC_SHIELD", false, 8, 4),
		createIAppearance("LIGHT_CRYSTAL", false, 4, 3),
		createIAppearance("LANTERN", false, 5, 3),
		createIAppearance("SOUL_RECALL", false, 6, 3),
		createIAppearance("SUN_CARD", false, 7, 3),
		createIAppearance("MOON_CARD", false, 8, 3),
		createIAppearance("HEAL_POTION", false, 9, 3),
		createIAppearance("HEAL_HERB", false, 1, 4),
		createIAppearance("OXY_HERB", false, 1, 4),
		createIAppearance("BIBUTI", false, 2, 4),
		createIAppearance("GARLIC", false, 4, 4),
		createIAppearance("TORCH", false, 5, 4),
		createIAppearance("SILK_BAG", false, 6, 4),
		createIAppearance("LAUREL", false, 7, 4),
		createIAppearance("VARMOR", false, 1, 8),
		createIAppearance("VEST", false, 2, 8),
		createIAppearance("STUDDED_LEATHER", false, 3, 8),
		createIAppearance("LEATHER_ARMOR", false, 4, 8),
		createIAppearance("CLOTH_TUNIC", false, 5, 8),
		createIAppearance("FINE_GARMENT", false, 5, 8),
		createIAppearance("CUIRASS", false, 6, 8),
		createIAppearance("SUIT", false, 7, 8),
		createIAppearance("PLATE", false, 8, 8),
		createIAppearance("DIAMOND_PLATE", false, 9, 8),
		createIAppearance("BOW", false, 1, 11),
		createIAppearance("HOLBEIN_DAGGER", false, 2, 11),
		createIAppearance("WEREBANE", false, 3, 11),
		createIAppearance("SHOTEL", false, 4, 11),
		createIAppearance("COMBAT_KNIFE", false, 5, 11),
		createIAppearance("STAKE", false, 6, 11),
		createIAppearance("BASELARD", false, 7, 11),
		createIAppearance("KAISER_KNUCKLE", false, 1, 12),
		createIAppearance("MARTIAL_ARMBAND", false, 2, 12),
		createIAppearance("TULKAS_FIST", false, 3, 12),
		createIAppearance("SPIKY_KNUCKLES", false, 4, 12),
		createIAppearance("COMBAT_GAUNTLET", false, 5, 12),
		createIAppearance("KNUCKLES", false, 6, 12),
		createIAppearance("GAUNTLET", false, 7, 12),
		createIAppearance("HAMMER_JUSTICE", false, 1, 13),
		createIAppearance("MORNING_STAR", false, 2, 13),
		createIAppearance("FLAIL", false, 3, 13),
		createIAppearance("MACE", false, 4, 13),
		createIAppearance("SILVER_HANDGUN", false, 1, 14),
		createIAppearance("REVOLVER", false, 2, 14),
		createIAppearance("HANDGUN", false, 3, 14),
		createIAppearance("AGUEN", false, 4, 14),
		createIAppearance("CROSSBOW", false, 5, 14),
		createIAppearance("ROD", false, 1, 15),
		createIAppearance("STAFF", false, 2, 15),
		createIAppearance("BLADE_RINGSET", false, 1, 16),
		createIAppearance("COMBAT_RINGS", false, 2, 16),
		createIAppearance("SPIKED_RINGS", false, 3, 16),
		createIAppearance("RINGS", false, 4, 16),
		createIAppearance("TOWER_SHIELD", false, 1, 17),
		createIAppearance("BUCKLER", false, 2, 17),
		createIAppearance("WOODEN_SHIELD", false, 3, 17),
		createIAppearance("ROUND_SHIELD", false, 4, 17),
		createIAppearance("SHIELD", false, 5, 17),
		createIAppearance("DUALBLADE_SPEAR", false, 1, 18),
		createIAppearance("HALBERD", false, 2, 18),
		createIAppearance("ALCARDE_SPEAR", false, 3, 18),
		createIAppearance("BATTLE_SPEAR", false, 4, 18),
		createIAppearance("LONG_SPEAR", false, 5, 18),
		createIAppearance("SHORT_SPEAR", false, 6, 18),
		createIAppearance("MASAMUNE", false, 1, 19),
		createIAppearance("CRISSAEGRIM", false, 2, 19),
		createIAppearance("TERMINUS", false, 3, 19),
		createIAppearance("MOURNEBLADE", false, 4, 19),
		createIAppearance("OSAFUNE", false, 5, 19),
		createIAppearance("MORMEGIL", false, 6, 19),
		createIAppearance("GRAM", false, 7, 19),
		createIAppearance("RAPIER", false, 8, 19),
		createIAppearance("BASTARDSWORD", false, 9, 19),
		createIAppearance("BROADSWORD", false, 1, 22),
		createIAppearance("VORPAL_BLADE", false, 1, 20),
		createIAppearance("FIREBRAND", false, 2, 20),
		createIAppearance("ICEBRAND", false, 3, 20),
		createIAppearance("GURTHANG", false, 4, 20),
		createIAppearance("KATANA", false, 5, 20),
		createIAppearance("FALCHION", false, 6, 20),
		createIAppearance("HARPER", false, 7, 20),
		createIAppearance("HADOR", false, 8, 20),
		createIAppearance("GLADIUS", false, 9, 20),
		createIAppearance("CUTLASS", false, 1, 21),
		createIAppearance("CLAYMORE", false, 2, 21),
		createIAppearance("ETHANOS_BLADE", false, 3, 21),
		createIAppearance("FLAMBERGE", false, 4, 21),
		createIAppearance("SABRE", false, 5, 21),
		createIAppearance("MABLUNG", false, 6, 21),
		createIAppearance("SCIMITAR", false, 7, 21),
		createIAppearance("ESTOC", false, 8, 21),
		createIAppearance("SHORT_SWORD", false, 9, 21),
		createIAppearance("BWAKA_KNIFE", false, 1, 24),
		createIAppearance("CHAKRAM", false, 2, 24),
		createIAppearance("BUFFALO_STAR", false, 3, 24),
		createIAppearance("SHURIKEN", false, 4, 24),
		createIAppearance("THROWING_KNIFE", false, 5, 24),
		createIAppearance("LIT_WHIP", false, 1, 25),
		createIAppearance("FLAME_WHIP", false, 2, 25),
		createIAppearance("VKILLERW", false, 3, 25),
		createIAppearance("WHIP", false, 4, 25),
		createIAppearance("CHAIN_WHIP", false, 5, 25),
		createIAppearance("THORN_WHIP", false, 6, 25),
		createIAppearance("LEATHER_WHIP", false, 7, 25),

		


		// Monsters
		createAppearance("R_SKELETON", imgConfig.getMonstersImage(), 1, 1),
		createAppearance("GZOMBIE", imgConfig.getMonstersImage(), 4, 2),
        createAppearance("ZOMBIE", imgConfig.getMonstersImage(), 7, 8),
        createAppearance("WHITE_SKELETON", imgConfig.getMonstersImage(), 1, 1),
        createAppearance("PANTHER", imgConfig.getMonstersImage(), 5, 3),
        createBAppearance("WARG", imgConfig.getBigMonstersImage(), 7, 1),
        createAppearance("BLACK_KNIGHT", imgConfig.getMonstersImage(), 9, 4),
        createAppearance("APE_SKELETON", imgConfig.getMonstersImage(), 7, 3),
        createBAppearance("PARANTHROPUS", imgConfig.getBigMonstersImage(), 1, 1),
        createAppearance("BAT", imgConfig.getMonstersImage(), 8, 3),
        createAppearance("SKULL_HEAD", imgConfig.getMonstersImage(), 2, 6),
        createAppearance("SKULL_LORD", imgConfig.getMonstersImage(), 3, 6),
        createAppearance("MERMAN", imgConfig.getMonstersImage(), 9, 5),
        createAppearance("WEREBEAR", imgConfig.getMonstersImage(), 6, 6),
        createAppearance("HUNCHBACK", imgConfig.getMonstersImage(), 6, 7),
        createAppearance("BONE_ARCHER", imgConfig.getMonstersImage(), 2, 1),
        createAppearance("SKELETON_PANTHER", imgConfig.getMonstersImage(), 6, 3),
        createAppearance("BONE_PILLAR", imgConfig.getMonstersImage(), 9, 6),
        createAppearance("AXE_KNIGHT", imgConfig.getMonstersImage(), 1, 5),
        createAppearance("MEDUSA_HEAD", imgConfig.getMonstersImage(), 4, 6),
        createAppearance("DURGA", imgConfig.getMonstersImage(), 1, 4),
        createAppearance("SKELETON_ATHLETE", imgConfig.getMonstersImage(), 3, 1),
        createAppearance("BLADE_SOLDIER", imgConfig.getMonstersImage(), 1, 2),
        createAppearance("BONE_HALBERD", imgConfig.getMonstersImage(), 4, 1),
        createAppearance("CROW", imgConfig.getMonstersImage(), 4, 8),
        createAppearance("BLOOD_SKELETON", imgConfig.getMonstersImage(), 9, 1),
        createAppearance("LIZARD_SWORDSMAN", imgConfig.getMonstersImage(), 7, 5),
        createBAppearance("COCKATRICE", imgConfig.getBigMonstersImage(), 4, 1),
        createAppearance("COOPER_ARMOR", imgConfig.getMonstersImage(), 10, 4),
        createAppearance("GHOUL", imgConfig.getMonstersImage(), 8, 8),
        createAppearance("SALOME", imgConfig.getMonstersImage(), 7, 4),
        createAppearance("ECTOPLASM", imgConfig.getMonstersImage(), 3, 3),
        createBAppearance("RULER_SWORD_LV1", imgConfig.getBigMonstersImage(), 2, 2),
        createBAppearance("BEAST_DEMON", imgConfig.getBigMonstersImage(), 2, 1),
        createBAppearance("DEVIL", imgConfig.getBigMonstersImage(), 3, 1),
        createAppearance("BALLOON_POD", imgConfig.getMonstersImage(), 5, 7),
        createAppearance("LILITH", imgConfig.getMonstersImage(), 5, 4),
        createAppearance("BONE_MUSKET", imgConfig.getMonstersImage(), 5, 1),
        createAppearance("KILLER_PLANT", imgConfig.getMonstersImage(), 3, 7),
        createAppearance("VAMPIRE_BAT", imgConfig.getMonstersImage(), 9, 3),
        createBAppearance("DEATH_MANTIS", imgConfig.getBigMonstersImage(), 5, 2),
        createAppearance("DHURON", imgConfig.getMonstersImage(), 7, 2),
        createAppearance("DRAGON_SKULL_CANNON", imgConfig.getMonstersImage(), 10, 6),
        createAppearance("MUMMY_MAN", imgConfig.getMonstersImage(), 5, 2),
        createAppearance("ZELDO", imgConfig.getMonstersImage(), 8, 2),
        createAppearance("MUD_MAN", imgConfig.getMonstersImage(), 2, 3),
        createAppearance("CAGNAZOO", imgConfig.getMonstersImage(), 4, 5),
        createBAppearance("ALRAUNE", imgConfig.getBigMonstersImage(), 4, 4),
        createBAppearance("GOLEM", imgConfig.getBigMonstersImage(), 2, 3),
        createAppearance("ARACHNE", imgConfig.getMonstersImage(), 3, 4),
        createAppearance("SPEAR_SKELETON", imgConfig.getMonstersImage(), 8, 1),
        
        createAppearance("KNIFE_MERMAN", imgConfig.getMonstersImage(), 10, 5),
        createAppearance("MASTER_LIZARD", imgConfig.getMonstersImage(), 8, 5),
        createAppearance("WHIP_SKELETON", imgConfig.getMonstersImage(), 6, 1),
        createAppearance("FROZEN_SHADE", imgConfig.getMonstersImage(), 10, 2),
        createAppearance("MINOTAUR", imgConfig.getMonstersImage(), 7, 6),
        createBAppearance("TRITON", imgConfig.getBigMonstersImage(), 6, 2),
        createAppearance("NOVA_SKELETON", imgConfig.getMonstersImage(), 10, 1),
        createBAppearance("ARMOR_LORD", imgConfig.getBigMonstersImage(), 1, 3),
        createAppearance("FLEA_ARMOR", imgConfig.getMonstersImage(), 7, 7),
        createAppearance("BUER", imgConfig.getMonstersImage(), 4, 7),
        createAppearance("WIGHT", imgConfig.getMonstersImage(), 9, 2),
        createAppearance("SPECTER", imgConfig.getMonstersImage(), 4, 3),
        createBAppearance("RULER_SWORD_LV2", imgConfig.getBigMonstersImage(), 3, 2),
        createAppearance("CURLY", imgConfig.getMonstersImage(), 2, 4),
        createBAppearance("FIRE_WARG", imgConfig.getBigMonstersImage(), 1, 2),
        createAppearance("BONE_ARK", imgConfig.getMonstersImage(), 1, 7),
        createAppearance("MIMIC", imgConfig.getMonstersImage(), 5, 6),
        createBAppearance("MANTICORE", imgConfig.getBigMonstersImage(), 7, 2),
        createAppearance("FLAME_KNIGHT", imgConfig.getMonstersImage(), 2, 5),
        createBAppearance("ARMOR_GUARDIAN", imgConfig.getBigMonstersImage(), 1, 4),
        createBAppearance("DEMON_LORD", imgConfig.getBigMonstersImage(), 6, 1),
        createAppearance("HEAT_SHADE", imgConfig.getMonstersImage(), 1, 3),
        createBAppearance("FLESH_GOLEM", imgConfig.getBigMonstersImage(), 4, 3),
        createAppearance("WEREWOLF", imgConfig.getMonstersImage(), 8, 6),
        createBAppearance("ALURA_UNE", imgConfig.getBigMonstersImage(), 5, 4),
        createAppearance("DRAHIGNAZOO", imgConfig.getMonstersImage(), 5, 5),
        createAppearance("SUCCUBUS", imgConfig.getMonstersImage(), 6, 4),
        createAppearance("BLADE_MASTER", imgConfig.getMonstersImage(), 2, 2),
        createBAppearance("BASILISK", imgConfig.getBigMonstersImage(), 5, 1),
        createAppearance("GARGOYLE", imgConfig.getMonstersImage(), 6, 5),
        createAppearance("HARPY", imgConfig.getMonstersImage(), 4, 4),
        createAppearance("KICKER_SKELETON", imgConfig.getMonstersImage(), 7, 1),
        createBAppearance("BEHEMOTH", imgConfig.getBigMonstersImage(), 6, 3),
        createBAppearance("DISCUS_LORD", imgConfig.getBigMonstersImage(), 7, 3),
        createBAppearance("GIANT_ARMOR", imgConfig.getBigMonstersImage(), 2, 4),
        createAppearance("WITCH", imgConfig.getMonstersImage(), 8, 4),
        createAppearance("MANDRAGORA", imgConfig.getMonstersImage(), 8, 7),
        createBAppearance("IRON_GOLEM", imgConfig.getBigMonstersImage(), 2, 3),
        createBAppearance("VICTORY_ARMOR", imgConfig.getBigMonstersImage(), 3, 4),
        createBAppearance("RULER_SWORD_LV3", imgConfig.getBigMonstersImage(), 4, 2),
        createAppearance("SPEAR_KNIGHT", imgConfig.getMonstersImage(), 3, 9),
        createAppearance("FLYING_SPEAR_SKELETON", imgConfig.getMonstersImage(), 4, 9), 

        createBAppearance("GIANTBAT", imgConfig.getBigMonstersImage(), 2, 5),
        createBAppearance("DEATH", imgConfig.getBigMonstersImage(), 3, 5),
        createAppearance("SICKLE", imgConfig.getMonstersImage(), 2, 9),
        createBAppearance("DRACULA", imgConfig.getBigMonstersImage(), 4, 5),
        createBAppearance("MEDUSA", imgConfig.getBigMonstersImage(), 1, 5),
        createAppearance("SNAKE", imgConfig.getMonstersImage(), 1, 9),
        createBAppearance("FRANK", imgConfig.getBigMonstersImage(), 7, 4),
    	createAppearance("IGOR", imgConfig.getMonstersImage(), 10, 8),
    	createBAppearance("DEMON_DRACULA", imgConfig.getBigMonstersImage(), 5, 5),
    	createBAppearance("AKMODAN", imgConfig.getBigMonstersImage(), 6, 5),
    	createBAppearance("DRAGON_KING", imgConfig.getBigMonstersImage(), 1, 6),
    	createBAppearance("ORLOX", imgConfig.getBigMonstersImage(), 4, 6),
    	createBAppearance("WATER_DRAGON", imgConfig.getBigMonstersImage(), 2, 6),
    	createBAppearance("LEGION", imgConfig.getBigMonstersImage(), 7, 5),
    	createBAppearance("CERBERUS", imgConfig.getBigMonstersImage(), 3, 6),
    	createAppearance("DOPPELGANGER", imgConfig.getMonstersImage(), 6, 5), /*Pending*/
    	
    	
    	
    	createAppearance("S_CAT", imgConfig.getMonstersImage(), 5, 9),
    	createAppearance("S_BIRD", imgConfig.getMonstersImage(), 6, 9),
    	createAppearance("S_TURTLE", imgConfig.getMonstersImage(), 7, 9),
    	createBAppearance("S_TIGER", imgConfig.getMonstersImage(), 8, 9),
    	createAppearance("S_EAGLE", imgConfig.getMonstersImage(), 9, 9),
    	createAppearance("S_TORTOISE", imgConfig.getMonstersImage(), 7, 9), /*Pending*/
    	createBAppearance("S_DRAGON", imgConfig.getMonstersImage(), 6, 5), /*Pending*/
    	
		// Features
		createXAppearance("CANDLE",
			imgConfig.getFeaturesImage(),
			0,
			7 * WIDTH_HALF,
			WIDTH_HALF,
			WIDTH_NORMAL
		), 
		createXAppearance("URN_FLAME",
			imgConfig.getFeaturesImage(),
			2 * WIDTH_HALF,
			7 * WIDTH_HALF,
			WIDTH_HALF,
			WIDTH_NORMAL,
			12
		),
		createAppearance("FLAME",
			imgConfig.getEffectsImage(),
			13 * WIDTH_NORMAL,
			14 * WIDTH_NORMAL,
			WIDTH_NORMAL,
			WIDTH_NORMAL,
			0,
			0
		),

		createIAppearance("SMALLHEART", true, 2, 1),
		createIAppearance("DAGGER", true, 3, 1),
		createIAppearance("AXE", true, 4, 1),
		createIAppearance("VIAL", true, 8, 1),
		createIAppearance("CROSS", true, 5, 1),
		createIAppearance("CLOCK", true, 6, 1),
		createIAppearance("BIGHEART", true, 1, 2),
		createIAppearance("KEY", true, 2, 2),
		createIAppearance("UPGRADE", true, 3, 2),
		createIAppearance("ROSARY", true, 5, 2),
		createIAppearance("COIN", true, 6, 2),
		createIAppearance("RED_MONEY_BAG", true, 7, 2),
		createIAppearance("BLUE_MONEY_BAG", true, 8, 2),
		createIAppearance("WHITE_MONEY_BAG", true, 9, 2),
		createIAppearance("CROWN", true, 1, 3),
		createIAppearance("CHEST", true, 2, 3),
		createIAppearance("MOAUI_HEAD", true, 3, 3),
		createIAppearance("RAINBOW_MONEY_BAG", true, 10, 2),
		createIAppearance("POT_ROAST", true, 4, 3),
		createIAppearance("INVISIBILITY_POTION", true, 5, 3),
		createIAppearance("BIBLE", true, 7, 1),
		createIAppearance("CRYSTAL", true, 9, 1),
		createIAppearance("FIST", true, 10, 1),
		createIAppearance("REBOUND_CRYSTAL", true, 9, 1),
		createIAppearance("MUPGRADE", true, 4, 2),
		createIAppearance("BLAST_CRYSTAL", true, 9, 1),

		createAppearance("MOUND", imgConfig.getEffectsImage(), 11, 17),

        //Characters
		createAppearance("VKILLER", imgConfig.getCharactersImage(), 1, 1),
		createAppearance("VANQUISHER", imgConfig.getCharactersImage(), 3, 1),
		createAppearance("RENEGADE", imgConfig.getCharactersImage(), 5, 1),
        createAppearance("INVOKER", imgConfig.getCharactersImage(), 1, 2),
        createAppearance("MANBEAST", imgConfig.getCharactersImage(), 3, 2),
        createAppearance("BEAST", imgConfig.getCharactersImage(), 5, 2),
        createAppearance("KNIGHT", imgConfig.getCharactersImage(), 1, 3),
        
        createAppearance("VKILLER_W", imgConfig.getCharactersImage(), 2, 1),
        createAppearance("SONIA_B", imgConfig.getCharactersImage(), 2, 1),
		createAppearance("VANQUISHER_W", imgConfig.getCharactersImage(), 4, 1),
		createAppearance("RENEGADE_W", imgConfig.getCharactersImage(), 6, 1),
        createAppearance("INVOKER_W", imgConfig.getCharactersImage(), 2, 2),
        createAppearance("MANBEAST_W", imgConfig.getCharactersImage(), 4, 2),
        createAppearance("BEAST_W", imgConfig.getCharactersImage(), 6, 2),
        createAppearance("KNIGHT_W", imgConfig.getCharactersImage(), 2, 3),
        
        createAppearance("MORPHED_WOLF", imgConfig.getMonstersImage(), 1, 10), 
        createAppearance("MORPHED_WOLF2", imgConfig.getMonstersImage(), 2, 10), 
        createAppearance("MORPHED_BAT", imgConfig.getMonstersImage(), 3, 10), 
        createAppearance("MORPHED_BAT2", imgConfig.getMonstersImage(), 4, 10), 
        createAppearance("MORPHED_MYST", imgConfig.getMonstersImage(), 5, 10), 
        createAppearance("MORPHED_MYST2", imgConfig.getMonstersImage(), 6, 10), 
        createAppearance("MORPHED_WEREBEAR", imgConfig.getMonstersImage(), 7, 10), 
        createAppearance("MORPHED_WEREDEMON", imgConfig.getMonstersImage(), 8, 10), 
        createAppearance("MORPHED_WEREWOLF", imgConfig.getMonstersImage(), 10, 10), 
        createAppearance("MORPHED_WEREBEAST", imgConfig.getMonstersImage(), 9, 10),
        createAppearance("MORPHED_LUPINE", imgConfig.getCharactersImage(), 5, 2), 
        
        
        createAppearance("SOLIEYU_B_KID", imgConfig.getCharactersImage(), 6, 6),
   		createAppearance("MAN", imgConfig.getCharactersImage(), 3, 3),
        createAppearance("WOMAN", imgConfig.getCharactersImage(), 4, 3),
        createAppearance("OLDMAN", imgConfig.getCharactersImage(), 5, 3),
        createAppearance("OLDWOMAN", imgConfig.getCharactersImage(), 6, 3),
        createAppearance("MERCHANT", imgConfig.getCharactersImage(), 1, 4),
        createAppearance("PRIEST", imgConfig.getCharactersImage(), 2, 4),
        createAppearance("DOG", imgConfig.getCharactersImage(), 3, 4),
        createAppearance("HOSTAGE_GUY", imgConfig.getCharactersImage(), 4, 4),
        createAppearance("HOSTAGE_GIRL", imgConfig.getCharactersImage(), 5, 4),
        createAppearance("CLARA", imgConfig.getCharactersImage(), 1, 6),
        createAppearance("VINDELITH", imgConfig.getCharactersImage(), 1, 6),
        createAppearance("CLAW", imgConfig.getCharactersImage(), 5, 5),
        createAppearance("MAIDEN", imgConfig.getCharactersImage(), 4, 5),
        createAppearance("MELDUCK", imgConfig.getCharactersImage(), 3, 5),
        createAppearance("ICEY", imgConfig.getCharactersImage(), 4, 6),
        createAppearance("LARDA", imgConfig.getCharactersImage(), 3, 3),
        createAppearance("CHRISTOPHER_BELMONT_NPC", imgConfig.getCharactersImage(), 3, 6),
        createAppearance("BARRETT", imgConfig.getCharactersImage(), 5, 6),
        
		// Weapons
        };
	}

	public Appearance[] getAppearances() {
		return defs;
	}
	
	public GFXAppearance createAppearance(String ID, BufferedImage bigImage, int xpos, int ypos){
		xpos--;
		ypos--;

		try {
			BufferedImage img = ImageUtils.crearImagen(bigImage, 
					xpos*WIDTH_NORMAL, ypos*WIDTH_NORMAL, 
					WIDTH_NORMAL, WIDTH_NORMAL);
			GFXAppearance ret = new GFXAppearance(ID, img,0,0);
			return ret;
		} catch (Exception e){
			Game.crash("Error loading image ", e);
		}
		return null;
	}
	
	public GFXAppearance createAppearance(String ID, BufferedImage bigImage, int xpos, int ypos, int width, int height,int superw, int superh){
		xpos--;
		ypos--;
		try {
			BufferedImage img = ImageUtils.crearImagen(bigImage, xpos, ypos, width, height);
			GFXAppearance ret = new GFXAppearance(ID, img,superw,superh);
			return ret;
		} catch (Exception e){
			Game.crash("Error loading image ", e);
		}
		return null;
	}
	
	public GFXAppearance createXAppearance(String ID, BufferedImage bigImage, int xpos, int ypos, int width, int height){
		return createXAppearance(ID, bigImage, xpos, ypos, width, height, 0);
	}
	
	public GFXAppearance createXAppearance(String ID, BufferedImage bigImage, int xpos, int ypos, int width, int height, int yoff){
		try {
			BufferedImage img = ImageUtils.crearImagen(bigImage, xpos, ypos, width, height);
			GFXAppearance ret = new GFXAppearance(ID, img,(width-48)/2,(height-64)/2+yoff);
			return ret;
		} catch (Exception e){
			Game.crash("Error loading image ", e);
		}
		return null;
	}
	
	public GFXAppearance createTAppearance(String ID, int xpos, int ypos){
		xpos--;
		ypos--;
		GFXImageConfiguration imgConfig = configuration.getImageConfiguration();
		BufferedImage bigImage = imgConfig.getTerrainImage();
		BufferedImage bigDarkImage = imgConfig.getDarkTerrainImage();
		BufferedImage bigNiteImage = imgConfig.getNightTerrainImage();
		BufferedImage bigDarkNiteImage = imgConfig.getDarkNightTerrainImage();
		
		try {
			BufferedImage img = ImageUtils.crearImagen(bigImage, xpos*WIDTH_NORMAL, ypos*CELL_HEIGHT, WIDTH_NORMAL, CELL_HEIGHT);
			BufferedImage darkimg = ImageUtils.crearImagen(bigDarkImage, xpos*WIDTH_NORMAL, ypos*CELL_HEIGHT, WIDTH_NORMAL, CELL_HEIGHT);
			BufferedImage niteimg = ImageUtils.crearImagen(bigNiteImage, xpos*WIDTH_NORMAL, ypos*CELL_HEIGHT, WIDTH_NORMAL, CELL_HEIGHT);
			BufferedImage darkniteimg = ImageUtils.crearImagen(bigDarkNiteImage, xpos*WIDTH_NORMAL, ypos*CELL_HEIGHT, WIDTH_NORMAL, CELL_HEIGHT);
			GFXAppearance ret = new GFXAppearance(ID, img, darkimg, niteimg, darkniteimg, 0,0);
			return ret;
		} catch (Exception e){
			Game.crash("Error loading terrain image ", e);
		}
		return null;
	}
	
	public GFXAppearance createTAppearance(String ID, int xpos, int ypos, int xoff, int yoff){
		xpos--;
		ypos--;
		GFXImageConfiguration imgConfig = configuration.getImageConfiguration();
		BufferedImage bigImage = imgConfig.getTerrainImage();
		BufferedImage bigDarkImage = imgConfig.getDarkTerrainImage();
		BufferedImage bigNiteImage = imgConfig.getNightTerrainImage();
		BufferedImage bigDarkNiteImage = imgConfig.getDarkNightTerrainImage();
		
		try {
			BufferedImage img = ImageUtils.crearImagen(bigImage, xpos*WIDTH_NORMAL, ypos*CELL_HEIGHT, WIDTH_NORMAL, CELL_HEIGHT);
			BufferedImage darkimg = ImageUtils.crearImagen(bigDarkImage, xpos*WIDTH_NORMAL, ypos*CELL_HEIGHT, WIDTH_NORMAL, CELL_HEIGHT);
			BufferedImage niteimg = ImageUtils.crearImagen(bigNiteImage, xpos*WIDTH_NORMAL, ypos*CELL_HEIGHT, WIDTH_NORMAL, CELL_HEIGHT);
			BufferedImage darkniteimg = ImageUtils.crearImagen(bigDarkNiteImage, xpos*WIDTH_NORMAL, ypos*CELL_HEIGHT, WIDTH_NORMAL, CELL_HEIGHT);
			GFXAppearance ret = new GFXAppearance(ID, img, darkimg, niteimg, darkniteimg, xoff * UI_SCALE, yoff * UI_SCALE);
			return ret;
		} catch (Exception e){
			Game.crash("Error loading terrain image ", e);
		}
		return null;
	}
	
	public GFXAppearance createBAppearance(String ID, BufferedImage bigImage, int xpos, int ypos){
		xpos--;
		ypos--;
		try {
			BufferedImage img = ImageUtils.crearImagen(bigImage, xpos*WIDTH_BIG, ypos*WIDTH_BIG, WIDTH_BIG, WIDTH_BIG);
			GFXAppearance ret = new GFXAppearance(ID, img, 8, 16);
			return ret;
		} catch (Exception e){
			Game.crash("Error loading image ", e);
		}
		return null;
	}
	
	public GFXAppearance createIAppearance(String ID, boolean isFeature, int xpos, int ypos){
		BufferedImage bigImage = isFeature ? this.configuration.imageConfiguration.getFeaturesImage() : this.configuration.imageConfiguration.getItemsImage();
		BufferedImage iconImage = isFeature ? this.configuration.imageConfiguration.FeatureIconsImage : this.configuration.imageConfiguration.ItemIconsImage;
		xpos--;
		ypos--;
		try {
			BufferedImage img = ImageUtils.crearImagen(bigImage, xpos*WIDTH_HALF, ypos*WIDTH_HALF, WIDTH_HALF, WIDTH_HALF);
			BufferedImage iconImg = ImageUtils.crearImagen(
				iconImage, xpos * ICON_SIZE, ypos * ICON_SIZE, ICON_SIZE, ICON_SIZE);
			GFXAppearance ret = new GFXAppearance(ID, img, iconImg, -8, -8);
			return ret;
		} catch (Exception e){
			Game.crash("Error loading image ", e);
		}
		return null;
	}
	
}