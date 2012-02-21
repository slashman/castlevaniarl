package crl.conf.gfx.data;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import sz.csi.ConsoleSystemInterface;
import sz.util.ImageUtils;

import crl.feature.Feature;
import crl.game.Game;
import crl.ui.*;
import crl.ui.consoleUI.CharAppearance;
import crl.ui.graphicsUI.*;

public class GFXAppearances {
	/*private static final int WIDTH_HALF = 16;
	private static final int CELL_HEIGHT = 49;
	private static final int WIDTH_NORMAL = 32;*/
	
	private static final int WIDTH_BIG = 48 * 2;
	private static final int WIDTH_HALF = 16 * 2;
	private static final int CELL_HEIGHT = 49 * 2;
	private static final int WIDTH_NORMAL = 32 * 2;

	private Hashtable images = new Hashtable();
	// JLabel shortcut = new JLabel();
	
	private Appearance [] defs = new Appearance[]{
		createTAppearance("VOID", 4,5),
		new GFXAppearance("NOTHING", null, null,null,null,0,0),
		
		/*NEEDED*/
		//createAppearance("COFFIN", "crl_items_2x.gif", 1,1),
		createTAppearance("COFFIN", 14, 2),
		
		createTAppearance("DOOR", 11,2),
		
		createAppearance("SHADOW", "shadow_2x.gif", 1,1),
		
		createAppearance("CHRISTOPHER_B", "crl_chars_2x.gif", 1,5),
		
		createAppearance("SOLIEYU_B", "crl_chars_2x.gif", 2,5),
		createAppearance("BADBELMONT", "crl_chars_2x.gif", 2,6),
		createBAppearance("PRELUDE_DRACULA", "crl_mons48_2x.gif", 4, 5),
		
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
		createTAppearance("TOWN_STAIRSUP", WIDTH_HALF, 1),
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
		createAppearance("MOAT_DOWN", "crl_terrain_2x.gif", 128, 164,WIDTH_NORMAL,WIDTH_NORMAL,0,0),
		createAppearance("MOAT_UP", "crl_terrain_2x.gif", 160, 154,WIDTH_NORMAL,42,0,10),
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
		
		createAppearance("TELEPORT", "crl_terrain_2x.gif", 193,99,WIDTH_NORMAL,CELL_HEIGHT,0,WIDTH_HALF),
		
		// Sacred weapons
		createIAppearance("ART_CARD_SOL", "crl_items_2x.gif", 1, 1),
		createIAppearance("ART_CARD_MOONS", "crl_items_2x.gif", 2, 1),
		createIAppearance("ART_CARD_DEATH", "crl_items_2x.gif", 3, 1),
		createIAppearance("ART_CARD_LOVE", "crl_items_2x.gif", 4, 1),
		createIAppearance("RED_CARD", "crl_items_2x.gif", 5, 1),
		createIAppearance("GOLDEN_MEDALLION", "crl_items_2x.gif", 6, 1),
		createIAppearance("SILVER_MEDALLION", "crl_items_2x.gif", 7, 1),
		createIAppearance("THORN_BRACELET", "crl_items_2x.gif", 8, 1),
		createIAppearance("LIFE_POTION", "crl_items_2x.gif", 9, 1),
		createIAppearance("FLAME_BOOK", "crl_items_2x.gif", 1, 2),
		createIAppearance("ICE_BOOK", "crl_items_2x.gif", 2, 2),
		createIAppearance("LIT_BOOK", "crl_items_2x.gif", 3, 2),
		createIAppearance("HEART_CONTAINER", "crl_items_2x.gif", 4, 2),
		createIAppearance("MIRACLE_POTION", "crl_items_2x.gif", 5, 2),
		createIAppearance("TEPES_RING", "crl_items_2x.gif", 6, 2),
		createIAppearance("CLUE_PAGE2", "crl_items_2x.gif", 8, 2),
		createIAppearance("CLUE_PAGE3", "crl_items_2x.gif", 9, 2),
		createIAppearance("JUKEBOX", "crl_items_2x.gif", 9, 2),
		createIAppearance("CLUE_PAGE1", "crl_items_2x.gif", 7, 2),
		createIAppearance("JUMPING_WING", "crl_items_2x.gif", 1, 3),
		createIAppearance("FIRE_GEM", "crl_items_2x.gif", 2, 3),
		createIAppearance("FLAME_ITEM", "crl_items_2x.gif", 3, 3),
		createIAppearance("MAGIC_SHIELD", "crl_items_2x.gif", 8, 4),
		createIAppearance("LIGHT_CRYSTAL", "crl_items_2x.gif", 4, 3),
		createIAppearance("LANTERN", "crl_items_2x.gif", 5, 3),
		createIAppearance("SOUL_RECALL", "crl_items_2x.gif", 6, 3),
		createIAppearance("SUN_CARD", "crl_items_2x.gif", 7, 3),
		createIAppearance("MOON_CARD", "crl_items_2x.gif", 8, 3),
		createIAppearance("HEAL_POTION", "crl_items_2x.gif", 9, 3),
		createIAppearance("HEAL_HERB", "crl_items_2x.gif", 1, 4),
		createIAppearance("OXY_HERB", "crl_items_2x.gif", 1, 4),
		createIAppearance("BIBUTI", "crl_items_2x.gif", 2, 4),
		createIAppearance("GARLIC", "crl_items_2x.gif", 4, 4),
		createIAppearance("TORCH", "crl_items_2x.gif", 5, 4),
		createIAppearance("SILK_BAG", "crl_items_2x.gif", 6, 4),
		createIAppearance("LAUREL", "crl_items_2x.gif", 7, 4),
		createIAppearance("VARMOR", "crl_items_2x.gif", 1, 8),
		createIAppearance("VEST", "crl_items_2x.gif", 2, 8),
		createIAppearance("STUDDED_LEATHER", "crl_items_2x.gif", 3, 8),
		createIAppearance("LEATHER_ARMOR", "crl_items_2x.gif", 4, 8),
		createIAppearance("CLOTH_TUNIC", "crl_items_2x.gif", 5, 8),
		createIAppearance("FINE_GARMENT", "crl_items_2x.gif", 5, 8),
		createIAppearance("CUIRASS", "crl_items_2x.gif", 6, 8),
		createIAppearance("SUIT", "crl_items_2x.gif", 7, 8),
		createIAppearance("PLATE", "crl_items_2x.gif", 8, 8),
		createIAppearance("DIAMOND_PLATE", "crl_items_2x.gif", 9, 8),
		createIAppearance("BOW", "crl_items_2x.gif", 1, 11),
		createIAppearance("HOLBEIN_DAGGER", "crl_items_2x.gif", 2, 11),
		createIAppearance("WEREBANE", "crl_items_2x.gif", 3, 11),
		createIAppearance("SHOTEL", "crl_items_2x.gif", 4, 11),
		createIAppearance("COMBAT_KNIFE", "crl_items_2x.gif", 5, 11),
		createIAppearance("STAKE", "crl_items_2x.gif", 6, 11),
		createIAppearance("BASELARD", "crl_items_2x.gif", 7, 11),
		createIAppearance("KAISER_KNUCKLE", "crl_items_2x.gif", 1, 12),
		createIAppearance("MARTIAL_ARMBAND", "crl_items_2x.gif", 2, 12),
		createIAppearance("TULKAS_FIST", "crl_items_2x.gif", 3, 12),
		createIAppearance("SPIKY_KNUCKLES", "crl_items_2x.gif", 4, 12),
		createIAppearance("COMBAT_GAUNTLET", "crl_items_2x.gif", 5, 12),
		createIAppearance("KNUCKLES", "crl_items_2x.gif", 6, 12),
		createIAppearance("GAUNTLET", "crl_items_2x.gif", 7, 12),
		createIAppearance("HAMMER_JUSTICE", "crl_items_2x.gif", 1, 13),
		createIAppearance("MORNING_STAR", "crl_items_2x.gif", 2, 13),
		createIAppearance("FLAIL", "crl_items_2x.gif", 3, 13),
		createIAppearance("MACE", "crl_items_2x.gif", 4, 13),
		createIAppearance("SILVER_HANDGUN", "crl_items_2x.gif", 1, 14),
		createIAppearance("REVOLVER", "crl_items_2x.gif", 2, 14),
		createIAppearance("HANDGUN", "crl_items_2x.gif", 3, 14),
		createIAppearance("AGUEN", "crl_items_2x.gif", 4, 14),
		createIAppearance("CROSSBOW", "crl_items_2x.gif", 5, 14),
		createIAppearance("ROD", "crl_items_2x.gif", 1, 15),
		createIAppearance("STAFF", "crl_items_2x.gif", 2, 15),
		createIAppearance("BLADE_RINGSET", "crl_items_2x.gif", 1, 16),
		createIAppearance("COMBAT_RINGS", "crl_items_2x.gif", 2, 16),
		createIAppearance("SPIKED_RINGS", "crl_items_2x.gif", 3, 16),
		createIAppearance("RINGS", "crl_items_2x.gif", 4, 16),
		createIAppearance("TOWER_SHIELD", "crl_items_2x.gif", 1, 17),
		createIAppearance("BUCKLER", "crl_items_2x.gif", 2, 17),
		createIAppearance("WOODEN_SHIELD", "crl_items_2x.gif", 3, 17),
		createIAppearance("ROUND_SHIELD", "crl_items_2x.gif", 4, 17),
		createIAppearance("SHIELD", "crl_items_2x.gif", 5, 17),
		createIAppearance("DUALBLADE_SPEAR", "crl_items_2x.gif", 1, 18),
		createIAppearance("HALBERD", "crl_items_2x.gif", 2, 18),
		createIAppearance("ALCARDE_SPEAR", "crl_items_2x.gif", 3, 18),
		createIAppearance("BATTLE_SPEAR", "crl_items_2x.gif", 4, 18),
		createIAppearance("LONG_SPEAR", "crl_items_2x.gif", 5, 18),
		createIAppearance("SHORT_SPEAR", "crl_items_2x.gif", 6, 18),
		createIAppearance("MASAMUNE", "crl_items_2x.gif", 1, 19),
		createIAppearance("CRISSAEGRIM", "crl_items_2x.gif", 2, 19),
		createIAppearance("TERMINUS", "crl_items_2x.gif", 3, 19),
		createIAppearance("MOURNEBLADE", "crl_items_2x.gif", 4, 19),
		createIAppearance("OSAFUNE", "crl_items_2x.gif", 5, 19),
		createIAppearance("MORMEGIL", "crl_items_2x.gif", 6, 19),
		createIAppearance("GRAM", "crl_items_2x.gif", 7, 19),
		createIAppearance("RAPIER", "crl_items_2x.gif", 8, 19),
		createIAppearance("BASTARDSWORD", "crl_items_2x.gif", 9, 19),
		createIAppearance("BROADSWORD", "crl_items_2x.gif", 1, 22),
		createIAppearance("VORPAL_BLADE", "crl_items_2x.gif", 1, 20),
		createIAppearance("FIREBRAND", "crl_items_2x.gif", 2, 20),
		createIAppearance("ICEBRAND", "crl_items_2x.gif", 3, 20),
		createIAppearance("GURTHANG", "crl_items_2x.gif", 4, 20),
		createIAppearance("KATANA", "crl_items_2x.gif", 5, 20),
		createIAppearance("FALCHION", "crl_items_2x.gif", 6, 20),
		createIAppearance("HARPER", "crl_items_2x.gif", 7, 20),
		createIAppearance("HADOR", "crl_items_2x.gif", 8, 20),
		createIAppearance("GLADIUS", "crl_items_2x.gif", 9, 20),
		createIAppearance("CUTLASS", "crl_items_2x.gif", 1, 21),
		createIAppearance("CLAYMORE", "crl_items_2x.gif", 2, 21),
		createIAppearance("ETHANOS_BLADE", "crl_items_2x.gif", 3, 21),
		createIAppearance("FLAMBERGE", "crl_items_2x.gif", 4, 21),
		createIAppearance("SABRE", "crl_items_2x.gif", 5, 21),
		createIAppearance("MABLUNG", "crl_items_2x.gif", 6, 21),
		createIAppearance("SCIMITAR", "crl_items_2x.gif", 7, 21),
		createIAppearance("ESTOC", "crl_items_2x.gif", 8, 21),
		createIAppearance("SHORT_SWORD", "crl_items_2x.gif", 9, 21),
		createIAppearance("BWAKA_KNIFE", "crl_items_2x.gif", 1, 24),
		createIAppearance("CHAKRAM", "crl_items_2x.gif", 2, 24),
		createIAppearance("BUFFALO_STAR", "crl_items_2x.gif", 3, 24),
		createIAppearance("SHURIKEN", "crl_items_2x.gif", 4, 24),
		createIAppearance("THROWING_KNIFE", "crl_items_2x.gif", 5, 24),
		createIAppearance("LIT_WHIP", "crl_items_2x.gif", 1, 25),
		createIAppearance("FLAME_WHIP", "crl_items_2x.gif", 2, 25),
		createIAppearance("VKILLERW", "crl_items_2x.gif", 3, 25),
		createIAppearance("WHIP", "crl_items_2x.gif", 4, 25),
		createIAppearance("CHAIN_WHIP", "crl_items_2x.gif", 5, 25),
		createIAppearance("THORN_WHIP", "crl_items_2x.gif", 6, 25),
		createIAppearance("LEATHER_WHIP", "crl_items_2x.gif", 7, 25),

		


		// Monsters
		createAppearance("R_SKELETON", "crl_mons32_2x.gif", 1, 1),
		createAppearance("GZOMBIE", "crl_mons32_2x.gif", 4, 2),
        createAppearance("ZOMBIE", "crl_mons32_2x.gif", 7, 8),
        createAppearance("WHITE_SKELETON", "crl_mons32_2x.gif", 1, 1),
        createAppearance("PANTHER", "crl_mons32_2x.gif", 5, 3),
        createBAppearance("WARG", "crl_mons48_2x.gif", 7, 1),
        createAppearance("BLACK_KNIGHT", "crl_mons32_2x.gif", 9, 4),
        createAppearance("APE_SKELETON", "crl_mons32_2x.gif", 7, 3),
        createBAppearance("PARANTHROPUS", "crl_mons48_2x.gif", 1, 1),
        createAppearance("BAT", "crl_mons32_2x.gif", 8, 3),
        createAppearance("SKULL_HEAD", "crl_mons32_2x.gif", 2, 6),
        createAppearance("SKULL_LORD", "crl_mons32_2x.gif", 3, 6),
        createAppearance("MERMAN", "crl_mons32_2x.gif", 9, 5),
        createAppearance("WEREBEAR", "crl_mons32_2x.gif", 6, 6),
        createAppearance("HUNCHBACK", "crl_mons32_2x.gif", 6, 7),
        createAppearance("BONE_ARCHER", "crl_mons32_2x.gif", 2, 1),
        createAppearance("SKELETON_PANTHER", "crl_mons32_2x.gif", 6, 3),
        createAppearance("BONE_PILLAR", "crl_mons32_2x.gif", 9, 6),
        createAppearance("AXE_KNIGHT", "crl_mons32_2x.gif", 1, 5),
        createAppearance("MEDUSA_HEAD", "crl_mons32_2x.gif", 4, 6),
        createAppearance("DURGA", "crl_mons32_2x.gif", 1, 4),
        createAppearance("SKELETON_ATHLETE", "crl_mons32_2x.gif", 3, 1),
        createAppearance("BLADE_SOLDIER", "crl_mons32_2x.gif", 1, 2),
        createAppearance("BONE_HALBERD", "crl_mons32_2x.gif", 4, 1),
        createAppearance("CROW", "crl_mons32_2x.gif", 4, 8),
        createAppearance("BLOOD_SKELETON", "crl_mons32_2x.gif", 9, 1),
        createAppearance("LIZARD_SWORDSMAN", "crl_mons32_2x.gif", 7, 5),
        createBAppearance("COCKATRICE", "crl_mons48_2x.gif", 4, 1),
        createAppearance("COOPER_ARMOR", "crl_mons32_2x.gif", 10, 4),
        createAppearance("GHOUL", "crl_mons32_2x.gif", 8, 8),
        createAppearance("SALOME", "crl_mons32_2x.gif", 7, 4),
        createAppearance("ECTOPLASM", "crl_mons32_2x.gif", 3, 3),
        createBAppearance("RULER_SWORD_LV1", "crl_mons48_2x.gif", 2, 2),
        createBAppearance("BEAST_DEMON", "crl_mons48_2x.gif", 2, 1),
        createBAppearance("DEVIL", "crl_mons48_2x.gif", 3, 1),
        createAppearance("BALLOON_POD", "crl_mons32_2x.gif", 5, 7),
        createAppearance("LILITH", "crl_mons32_2x.gif", 5, 4),
        createAppearance("BONE_MUSKET", "crl_mons32_2x.gif", 5, 1),
        createAppearance("KILLER_PLANT", "crl_mons32_2x.gif", 3, 7),
        createAppearance("VAMPIRE_BAT", "crl_mons32_2x.gif", 9, 3),
        createBAppearance("DEATH_MANTIS", "crl_mons48_2x.gif", 5, 2),
        createAppearance("DHURON", "crl_mons32_2x.gif", 7, 2),
        createAppearance("DRAGON_SKULL_CANNON", "crl_mons32_2x.gif", 10, 6),
        createAppearance("MUMMY_MAN", "crl_mons32_2x.gif", 5, 2),
        createAppearance("ZELDO", "crl_mons32_2x.gif", 8, 2),
        createAppearance("MUD_MAN", "crl_mons32_2x.gif", 2, 3),
        createAppearance("CAGNAZOO", "crl_mons32_2x.gif", 4, 5),
        createBAppearance("ALRAUNE", "crl_mons48_2x.gif", 4, 4),
        createBAppearance("GOLEM", "crl_mons48_2x.gif", 2, 3),
        createAppearance("ARACHNE", "crl_mons32_2x.gif", 3, 4),
        createAppearance("SPEAR_SKELETON", "crl_mons32_2x.gif", 8, 1),
        
        createAppearance("KNIFE_MERMAN", "crl_mons32_2x.gif", 10, 5),
        createAppearance("MASTER_LIZARD", "crl_mons32_2x.gif", 8, 5),
        createAppearance("WHIP_SKELETON", "crl_mons32_2x.gif", 6, 1),
        createAppearance("FROZEN_SHADE", "crl_mons32_2x.gif", 10, 2),
        createAppearance("MINOTAUR", "crl_mons32_2x.gif", 7, 6),
        createBAppearance("TRITON", "crl_mons48_2x.gif", 6, 2),
        createAppearance("NOVA_SKELETON", "crl_mons32_2x.gif", 10, 1),
        createBAppearance("ARMOR_LORD", "crl_mons48_2x.gif", 1, 3),
        createAppearance("FLEA_ARMOR", "crl_mons32_2x.gif", 7, 7),
        createAppearance("BUER", "crl_mons32_2x.gif", 4, 7),
        createAppearance("WIGHT", "crl_mons32_2x.gif", 9, 2),
        createAppearance("SPECTER", "crl_mons32_2x.gif", 4, 3),
        createBAppearance("RULER_SWORD_LV2", "crl_mons48_2x.gif", 3, 2),
        createAppearance("CURLY", "crl_mons32_2x.gif", 2, 4),
        createBAppearance("FIRE_WARG", "crl_mons48_2x.gif", 1, 2),
        createAppearance("BONE_ARK", "crl_mons32_2x.gif", 1, 7),
        createAppearance("MIMIC", "crl_mons32_2x.gif", 5, 6),
        createBAppearance("MANTICORE", "crl_mons48_2x.gif", 7, 2),
        createAppearance("FLAME_KNIGHT", "crl_mons32_2x.gif", 2, 5),
        createBAppearance("ARMOR_GUARDIAN", "crl_mons48_2x.gif", 1, 4),
        createBAppearance("DEMON_LORD", "crl_mons48_2x.gif", 6, 1),
        createAppearance("HEAT_SHADE", "crl_mons32_2x.gif", 1, 3),
        createBAppearance("FLESH_GOLEM", "crl_mons48_2x.gif", 4, 3),
        createAppearance("WEREWOLF", "crl_mons32_2x.gif", 8, 6),
        createBAppearance("ALURA_UNE", "crl_mons48_2x.gif", 5, 4),
        createAppearance("DRAHIGNAZOO", "crl_mons32_2x.gif", 5, 5),
        createAppearance("SUCCUBUS", "crl_mons32_2x.gif", 6, 4),
        createAppearance("BLADE_MASTER", "crl_mons32_2x.gif", 2, 2),
        createBAppearance("BASILISK", "crl_mons48_2x.gif", 5, 1),
        createAppearance("GARGOYLE", "crl_mons32_2x.gif", 6, 5),
        createAppearance("HARPY", "crl_mons32_2x.gif", 4, 4),
        createAppearance("KICKER_SKELETON", "crl_mons32_2x.gif", 7, 1),
        createBAppearance("BEHEMOTH", "crl_mons48_2x.gif", 6, 3),
        createBAppearance("DISCUS_LORD", "crl_mons48_2x.gif", 7, 3),
        createBAppearance("GIANT_ARMOR", "crl_mons48_2x.gif", 2, 4),
        createAppearance("WITCH", "crl_mons32_2x.gif", 8, 4),
        createAppearance("MANDRAGORA", "crl_mons32_2x.gif", 8, 7),
        createBAppearance("IRON_GOLEM", "crl_mons48_2x.gif", 2, 3),
        createBAppearance("VICTORY_ARMOR", "crl_mons48_2x.gif", 3, 4),
        createBAppearance("RULER_SWORD_LV3", "crl_mons48_2x.gif", 4, 2),
        createAppearance("SPEAR_KNIGHT", "crl_mons32_2x.gif", 3, 9),
        createAppearance("FLYING_SPEAR_SKELETON", "crl_mons32_2x.gif", 4, 9), 

        createBAppearance("GIANTBAT", "crl_mons48_2x.gif", 2, 5),
        createBAppearance("DEATH", "crl_mons48_2x.gif", 3, 5),
        createAppearance("SICKLE", "crl_mons32_2x.gif", 2, 9),
        createBAppearance("DRACULA", "crl_mons48_2x.gif", 4, 5),
        createBAppearance("MEDUSA", "crl_mons48_2x.gif", 1, 5),
        createAppearance("SNAKE", "crl_mons32_2x.gif", 1, 9),
        createBAppearance("FRANK", "crl_mons48_2x.gif", 7, 4),
    	createAppearance("IGOR", "crl_mons32_2x.gif", 10, 8),
    	createBAppearance("DEMON_DRACULA", "crl_mons48_2x.gif", 5, 5),
    	createBAppearance("AKMODAN", "crl_mons48_2x.gif", 6, 5),
    	createBAppearance("DRAGON_KING", "crl_mons48_2x.gif", 1, 6),
    	createBAppearance("ORLOX", "crl_mons48_2x.gif", 4, 6),
    	createBAppearance("WATER_DRAGON", "crl_mons48_2x.gif", 2, 6),
    	createBAppearance("LEGION", "crl_mons48_2x.gif", 7, 5),
    	createBAppearance("CERBERUS", "crl_mons48_2x.gif", 3, 6),
    	createAppearance("DOPPELGANGER", "crl_mons32_2x.gif", 6, 5), /*Pending*/
    	
    	
    	
    	createAppearance("S_CAT", "crl_mons32_2x.gif", 5, 9),
    	createAppearance("S_BIRD", "crl_mons32_2x.gif", 6, 9),
    	createAppearance("S_TURTLE", "crl_mons32_2x.gif", 7, 9),
    	createBAppearance("S_TIGER", "crl_mons32_2x.gif", 8, 9),
    	createAppearance("S_EAGLE", "crl_mons32_2x.gif", 9, 9),
    	createAppearance("S_TORTOISE", "crl_mons32_2x.gif", 7, 9), /*Pending*/
    	createBAppearance("S_DRAGON", "crl_mons32_2x.gif", 6, 5), /*Pending*/
    	
		// Features
		createXAppearance("CANDLE", "crl_features_2x.gif", 0,112,WIDTH_HALF,WIDTH_NORMAL),
		createIAppearance("SMALLHEART", "crl_features_2x.gif", 2, 1),
		createIAppearance("DAGGER", "crl_features_2x.gif", 3, 1),
		createIAppearance("AXE", "crl_features_2x.gif", 4, 1),
		createIAppearance("VIAL", "crl_features_2x.gif", 8, 1),
		createIAppearance("CROSS", "crl_features_2x.gif", 5, 1),
		createIAppearance("CLOCK", "crl_features_2x.gif", 6, 1),
		createIAppearance("BIGHEART", "crl_features_2x.gif", 1, 2),
		createIAppearance("KEY", "crl_features_2x.gif", 2, 2),
		createIAppearance("UPGRADE", "crl_features_2x.gif", 3, 2),
		createIAppearance("ROSARY", "crl_features_2x.gif", 5, 2),
		createIAppearance("COIN", "crl_features_2x.gif", 6, 2),
		createIAppearance("RED_MONEY_BAG", "crl_features_2x.gif", 7, 2),
		createIAppearance("BLUE_MONEY_BAG", "crl_features_2x.gif", 8, 2),
		createIAppearance("WHITE_MONEY_BAG", "crl_features_2x.gif", 9, 2),
		createIAppearance("CROWN", "crl_features_2x.gif", 1, 3),
		createIAppearance("CHEST", "crl_features_2x.gif", 2, 3),
		createIAppearance("MOAUI_HEAD", "crl_features_2x.gif", 3, 3),
		createIAppearance("RAINBOW_MONEY_BAG", "crl_features_2x.gif", 10, 2),
		createIAppearance("POT_ROAST", "crl_features_2x.gif", 4, 3),
		createIAppearance("INVISIBILITY_POTION", "crl_features_2x.gif", 5, 3),
		createIAppearance("BIBLE", "crl_features_2x.gif", 7, 1),
		createIAppearance("CRYSTAL", "crl_features_2x.gif", 9, 1),
		createIAppearance("FIST", "crl_features_2x.gif", 10, 1),
		createIAppearance("REBOUND_CRYSTAL", "crl_features_2x.gif", 9, 1),
		createIAppearance("MUPGRADE", "crl_features_2x.gif", 4, 2),
		createXAppearance("URN_FLAME", "crl_features_2x.gif", WIDTH_NORMAL,112,WIDTH_HALF,WIDTH_NORMAL,12),
		createIAppearance("BLAST_CRYSTAL", "crl_features_2x.gif", 9, 1),

		createXAppearance("FLAME", "crl_effects_2x.gif", 416, 446,WIDTH_NORMAL,WIDTH_NORMAL),
		createAppearance("MOUND", "crl_effects_2x.gif", 11, 17),

        //Characters
		createAppearance("VKILLER", "crl_chars_2x.gif", 1, 1),
		createAppearance("VANQUISHER", "crl_chars_2x.gif", 3, 1),
		createAppearance("RENEGADE", "crl_chars_2x.gif", 5, 1),
        createAppearance("INVOKER", "crl_chars_2x.gif", 1, 2),
        createAppearance("MANBEAST", "crl_chars_2x.gif", 3, 2),
        createAppearance("BEAST", "crl_chars_2x.gif", 5, 2),
        createAppearance("KNIGHT", "crl_chars_2x.gif", 1, 3),
        
        createAppearance("VKILLER_W", "crl_chars_2x.gif", 2, 1),
        createAppearance("SONIA_B", "crl_chars_2x.gif", 2, 1),
		createAppearance("VANQUISHER_W", "crl_chars_2x.gif", 4, 1),
		createAppearance("RENEGADE_W", "crl_chars_2x.gif", 6, 1),
        createAppearance("INVOKER_W", "crl_chars_2x.gif", 2, 2),
        createAppearance("MANBEAST_W", "crl_chars_2x.gif", 4, 2),
        createAppearance("BEAST_W", "crl_chars_2x.gif", 6, 2),
        createAppearance("KNIGHT_W", "crl_chars_2x.gif", 2, 3),
        
        createAppearance("MORPHED_WOLF", "crl_mons32_2x.gif", 1, 10), 
        createAppearance("MORPHED_WOLF2", "crl_mons32_2x.gif", 2, 10), 
        createAppearance("MORPHED_BAT", "crl_mons32_2x.gif", 3, 10), 
        createAppearance("MORPHED_BAT2", "crl_mons32_2x.gif", 4, 10), 
        createAppearance("MORPHED_MYST", "crl_mons32_2x.gif", 5, 10), 
        createAppearance("MORPHED_MYST2", "crl_mons32_2x.gif", 6, 10), 
        createAppearance("MORPHED_WEREBEAR", "crl_mons32_2x.gif", 7, 10), 
        createAppearance("MORPHED_WEREDEMON", "crl_mons32_2x.gif", 8, 10), 
        createAppearance("MORPHED_WEREWOLF", "crl_mons32_2x.gif", 10, 10), 
        createAppearance("MORPHED_WEREBEAST", "crl_mons32_2x.gif", 9, 10),
        createAppearance("MORPHED_LUPINE", "crl_chars_2x.gif", 5, 2), 
        
        
        createAppearance("SOLIEYU_B_KID", "crl_chars_2x.gif", 6, 6),
   		createAppearance("MAN", "crl_chars_2x.gif", 3, 3),
        createAppearance("WOMAN", "crl_chars_2x.gif", 4, 3),
        createAppearance("OLDMAN", "crl_chars_2x.gif", 5, 3),
        createAppearance("OLDWOMAN", "crl_chars_2x.gif", 6, 3),
        createAppearance("MERCHANT", "crl_chars_2x.gif", 1, 4),
        createAppearance("PRIEST", "crl_chars_2x.gif", 2, 4),
        createAppearance("DOG", "crl_chars_2x.gif", 3, 4),
        createAppearance("HOSTAGE_GUY", "crl_chars_2x.gif", 4, 4),
        createAppearance("HOSTAGE_GIRL", "crl_chars_2x.gif", 5, 4),
        createAppearance("CLARA", "crl_chars_2x.gif", 1, 6),
        createAppearance("VINDELITH", "crl_chars_2x.gif", 1, 6),
        createAppearance("CLAW", "crl_chars_2x.gif", 5, 5),
        createAppearance("MAIDEN", "crl_chars_2x.gif", 4, 5),
        createAppearance("MELDUCK", "crl_chars_2x.gif", 3, 5),
        createAppearance("ICEY", "crl_chars_2x.gif", 4, 6),
        createAppearance("LARDA", "crl_chars_2x.gif", 3, 3),
        createAppearance("CHRISTOPHER_BELMONT_NPC", "crl_chars_2x.gif", 3, 6),
        createAppearance("BARRETT", "crl_chars_2x.gif", 5, 6),
        
		// Weapons
        };

	public Appearance[] getAppearances() {
		return defs;
	}
	
	
	private Component TRACKER;
	
	public GFXAppearance createAppearance(String ID, String filename, int xpos, int ypos){
		xpos--;
		ypos--;
		filename = "gfx/"+filename;
		BufferedImage bigImage = (BufferedImage) images.get(filename);
		if (bigImage == null){
			try {
				//bigImage = ImageUtils.crearImagen(filename, TRACKER);
				bigImage = ImageUtils.createImage(filename);
			} catch (Exception e){
				Game.crash("Error loading image "+filename, e);
			}
			images.put(filename, bigImage);
		}
		try {
			BufferedImage img = ImageUtils.crearImagen(bigImage, xpos*WIDTH_NORMAL, ypos*WIDTH_NORMAL, WIDTH_NORMAL, WIDTH_NORMAL);
			GFXAppearance ret = new GFXAppearance(ID, img,0,0);
			return ret;
		} catch (Exception e){
			Game.crash("Error loading image "+filename, e);
		}
		return null;
	}
	
	public GFXAppearance createAppearance(String ID, String filename, int xpos, int ypos, int width, int height,int superw, int superh){
		xpos--;
		ypos--;
		filename = "gfx/"+filename;
		BufferedImage bigImage = (BufferedImage) images.get(filename);
		if (bigImage == null){
			try {
				//bigImage = ImageUtils.crearImagen(filename, TRACKER);
				bigImage = ImageUtils.createImage(filename);
			} catch (Exception e){
				Game.crash("Error loading image "+filename, e);
			}
			images.put(filename, bigImage);
		}
		try {
			BufferedImage img = ImageUtils.crearImagen(bigImage, xpos, ypos, width, height);
			GFXAppearance ret = new GFXAppearance(ID, img,superw,superh);
			return ret;
		} catch (Exception e){
			Game.crash("Error loading image "+filename, e);
		}
		return null;
	}
	
	public GFXAppearance createXAppearance(String ID, String filename, int xpos, int ypos, int width, int height){
		filename = "gfx/"+filename;
		BufferedImage bigImage = (BufferedImage) images.get(filename);
		if (bigImage == null){
			try {
				bigImage = ImageUtils.createImage(filename);
			} catch (Exception e){
				Game.crash("Error loading image "+filename, e);
			}
			images.put(filename, bigImage);
		}
		try {
			BufferedImage img = ImageUtils.crearImagen(bigImage, xpos, ypos, width, height);
			GFXAppearance ret = new GFXAppearance(ID, img,(width-WIDTH_NORMAL)/2,height-WIDTH_NORMAL);
			return ret;
		} catch (Exception e){
			Game.crash("Error loading image "+filename, e);
		}
		return null;
	}
	
	public GFXAppearance createXAppearance(String ID, String filename, int xpos, int ypos, int width, int height, int yoff){
		filename = "gfx/"+filename;
		BufferedImage bigImage = (BufferedImage) images.get(filename);
		if (bigImage == null){
			try {
				bigImage = ImageUtils.createImage(filename);
			} catch (Exception e){
				Game.crash("Error loading image "+filename, e);
			}
			images.put(filename, bigImage);
		}
		try {
			BufferedImage img = ImageUtils.crearImagen(bigImage, xpos, ypos, width, height);
			GFXAppearance ret = new GFXAppearance(ID, img,(width-WIDTH_NORMAL)/2,height-WIDTH_NORMAL+yoff);
			return ret;
		} catch (Exception e){
			Game.crash("Error loading image "+filename, e);
		}
		return null;
	}
	
	public GFXAppearance createTAppearance(String ID, int xpos, int ypos){
		xpos--;
		ypos--;
		BufferedImage bigImage = (BufferedImage) images.get("gfx/crl_terrain_2x.gif");
		BufferedImage bigDarkImage = (BufferedImage) images.get("gfx/crl_terrain_d_2x.gif");
		BufferedImage bigNiteImage = (BufferedImage) images.get("gfx/crl_terrain_night_2x.gif");
		BufferedImage bigDarkNiteImage = (BufferedImage) images.get("gfx/crl_terrain_night_d_2x.gif");
		if (bigImage == null){
			try {
				bigImage = ImageUtils.createImage("gfx/crl_terrain_2x.gif");
			} catch (Exception e){
				Game.crash("Error loading image "+"gfx/crl_terrain_2x.gif", e);
			}
			try {
				bigDarkImage = ImageUtils.createImage("gfx/crl_terrain_d_2x.gif");
			} catch (Exception e){
				Game.crash("Error loading image "+"gfx/crl_terrain_d_2x.gif", e);
			}
			try {
				bigNiteImage = ImageUtils.createImage("gfx/crl_terrain_night_2x.gif");
			} catch (Exception e){
				Game.crash("Error loading image "+"gfx/crl_terrain_night_2x.gif", e);
			}
			try {
				bigDarkNiteImage = ImageUtils.createImage("gfx/crl_terrain_night_d_2x.gif");
			} catch (Exception e){
				Game.crash("Error loading image "+"gfx/crl_terrain_night_d_2x.gif", e);
			}
			images.put("gfx/crl_terrain_2x.gif", bigImage);
			images.put("gfx/crl_terrain_d_2x.gif", bigDarkImage);
			images.put("gfx/crl_terrain_night_2x.gif", bigNiteImage);
			images.put("gfx/crl_terrain_night_d_2x.gif", bigDarkNiteImage);
		}
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
		BufferedImage bigImage = (BufferedImage) images.get("gfx/crl_terrain.gif");
		BufferedImage bigDarkImage = (BufferedImage) images.get("gfx/crl_terrain_d.gif");
		BufferedImage bigNiteImage = (BufferedImage) images.get("gfx/crl_terrain_night.gif");
		BufferedImage bigDarkNiteImage = (BufferedImage) images.get("gfx/crl_terrain_night_d.gif");
		if (bigImage == null){
			try {
				bigImage = ImageUtils.createImage("gfx/crl_terrain_2x.gif");
			} catch (Exception e){
				Game.crash("Error loading image "+"gfx/crl_terrain_2x.gif", e);
			}
			try {
				bigDarkImage = ImageUtils.createImage("gfx/crl_terrain_d_2x.gif");
			} catch (Exception e){
				Game.crash("Error loading image "+"gfx/crl_terrain_d_2x.gif", e);
			}
			try {
				bigNiteImage = ImageUtils.createImage("gfx/crl_terrain_night_2x.gif");
			} catch (Exception e){
				Game.crash("Error loading image "+"gfx/crl_terrain_night_2x.gif", e);
			}
			try {
				bigDarkNiteImage = ImageUtils.createImage("gfx/crl_terrain_night_d_2x.gif");
			} catch (Exception e){
				Game.crash("Error loading image "+"gfx/crl_terrain_night_d_2x.gif", e);
			}
			images.put("gfx/crl_terrain_2x.gif", bigImage);
			images.put("gfx/crl_terrain_d_2x.gif", bigDarkImage);
			images.put("gfx/crl_terrain_night_2x.gif", bigNiteImage);
			images.put("gfx/crl_terrain_night_d_2x.gif", bigDarkNiteImage);
		}
		try {
			BufferedImage img = ImageUtils.crearImagen(bigImage, xpos*WIDTH_NORMAL, ypos*CELL_HEIGHT, WIDTH_NORMAL, CELL_HEIGHT);
			BufferedImage darkimg = ImageUtils.crearImagen(bigDarkImage, xpos*WIDTH_NORMAL, ypos*CELL_HEIGHT, WIDTH_NORMAL, CELL_HEIGHT);
			BufferedImage niteimg = ImageUtils.crearImagen(bigNiteImage, xpos*WIDTH_NORMAL, ypos*CELL_HEIGHT, WIDTH_NORMAL, CELL_HEIGHT);
			BufferedImage darkniteimg = ImageUtils.crearImagen(bigDarkNiteImage, xpos*WIDTH_NORMAL, ypos*CELL_HEIGHT, WIDTH_NORMAL, CELL_HEIGHT);
			GFXAppearance ret = new GFXAppearance(ID, img, darkimg, niteimg, darkniteimg, xoff,yoff);
			return ret;
		} catch (Exception e){
			Game.crash("Error loading terrain image ", e);
		}
		return null;
	}
	
	public GFXAppearance createBAppearance(String ID, String filename, int xpos, int ypos){
		xpos--;
		ypos--;
		filename = "gfx/"+filename;
		BufferedImage bigImage = (BufferedImage) images.get(filename);
		if (bigImage == null){
			try {
				bigImage = ImageUtils.createImage(filename);
			} catch (Exception e){
				Game.crash("Error loading image "+filename, e);
			}
			images.put(filename, bigImage);
		}
		try {
			BufferedImage img = ImageUtils.crearImagen(bigImage, xpos*WIDTH_BIG, ypos*WIDTH_BIG, WIDTH_BIG, WIDTH_BIG);
			GFXAppearance ret = new GFXAppearance(ID, img,WIDTH_HALF/2,WIDTH_HALF);
			return ret;
		} catch (Exception e){
			Game.crash("Error loading image "+filename, e);
		}
		return null;
	}
	
	public GFXAppearance createIAppearance(String ID, String filename, int xpos, int ypos){
		xpos--;
		ypos--;
		filename = "gfx/"+filename;
		BufferedImage bigImage = (BufferedImage) images.get(filename);
		if (bigImage == null){
			try {
				bigImage = ImageUtils.createImage(filename);
			} catch (Exception e){
				Game.crash("Error loading image "+filename, e);
			}
			images.put(filename, bigImage);
		}
		try {
			BufferedImage img = ImageUtils.crearImagen(bigImage, xpos*WIDTH_HALF, ypos*WIDTH_HALF, WIDTH_HALF, WIDTH_HALF);
			//GFXAppearance ret = new GFXAppearance(ID, img,-8,-16);
			GFXAppearance ret = new GFXAppearance(ID, img,-8,0);
			return ret;
		} catch (Exception e){
			Game.crash("Error loading image "+filename, e);
		}
		return null;
	}
	
}