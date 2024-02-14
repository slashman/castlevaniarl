package crl.conf.gfx.data;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Properties;

import crl.game.Game;

import sz.util.ImageUtils;
import sz.util.Position;
import sz.util.PropertyFilters;

/**
 * Configuration settings for GFX UI
 * 
 * @author Tuukka Turto
 */
public class GFXConfiguration {

	protected int bigTileWidth;
	protected int halfTileWidth;
	protected int normalTileWidth;
	protected int cellHeight;
	
	protected int screenWidth;
	protected int screenHeight;
	protected int screenWidthInTiles;
	protected int screenHeightInTiles;
	protected Position playerLocationOnScreen;
	
	protected Color windowBackgroundColour;
	protected Color borderColourIn;
	protected Color borderColourOut;
	
	protected Font messageBoxFont;
	protected Font persistantMessageBoxFont;
	
	protected BufferedImage statusScreenBackground;

	protected BufferedImage UserInterfaceBackgroundImage;
	protected GFXImageConfiguration imageConfiguration;
	
	protected double screenScale;

	protected int effectsScale;
	protected int viewportUserInterfaceScale;
	
	/**
	 * Default constructor
	 */
	public GFXConfiguration() {
		
	}
	
	/**
	 * Load configuration from given properties
	 */
	public void LoadConfiguration(Properties p) {	
		//this.screenScale = 1.28;
		this.screenScale = PropertyFilters.getDouble(p.getProperty("SCREEN_SCALE"));
		this.effectsScale = PropertyFilters.inte(p.getProperty("EFFECTS_SCALE"));
		this.viewportUserInterfaceScale = PropertyFilters.inte(p.getProperty("VIEWPORT_UI_SCALE"));
		this.bigTileWidth = PropertyFilters.inte(p.getProperty("BIG_TILESIZE"));
		this.normalTileWidth = PropertyFilters.inte(p.getProperty("TILESIZE"));
		this.halfTileWidth = PropertyFilters.inte(p.getProperty("HALF_TILESIZE"));
		this.cellHeight = PropertyFilters.inte(p.getProperty("CELL_HEIGHT"));
		
		this.screenWidthInTiles = PropertyFilters.inte(p.getProperty("XRANGE"));
		this.screenHeightInTiles = PropertyFilters.inte(p.getProperty("YRANGE"));
		this.playerLocationOnScreen = PropertyFilters.getPosition(p.getProperty("PC_POS"));
		
		this.windowBackgroundColour = PropertyFilters.getColor(p.getProperty("COLOR_WINDOW_BACKGROUND"));
		this.borderColourIn = PropertyFilters.getColor(p.getProperty("COLOR_BORDER_IN"));
		this.borderColourOut = PropertyFilters.getColor(p.getProperty("COLOR_BORDER_OUT"));
		
		this.screenWidth = PropertyFilters.inte(p.getProperty("WINDOW_WIDTH"));
		this.screenHeight = PropertyFilters.inte(p.getProperty("WINDOW_HEIGHT"));		
		
		try {
			this.messageBoxFont = PropertyFilters.getFont(p.getProperty("FNT_MESSAGEBOX"),p.getProperty("FNT_MESSAGEBOX_SIZE"));
			this.persistantMessageBoxFont = PropertyFilters.getFont(p.getProperty("FNT_PERSISTANTMESSAGEBOX"),p.getProperty("FNT_PERSISTANTMESSAGEBOX_SIZE"));
			
		} catch (FontFormatException ffe){
			Game.crash("Error loading the font", ffe);
		} catch (IOException ioe){
			Game.crash("Error loading the font", ioe);
		}
		
		/*-- Load UI Images */
		try {
			this.statusScreenBackground = ImageUtils.createImage(p.getProperty("IMG_STATUSSCR_BGROUND"));
			this.UserInterfaceBackgroundImage = ImageUtils.createImage(p.getProperty("IMG_INTERFACE"));
			
		} catch (Exception e){
			Game.crash(e.getMessage(),e);
		}
		
		imageConfiguration = new GFXImageConfiguration();
		imageConfiguration.LoadConfiguration(p);
	}

	/**
	 * @return the width of big tile
	 */
	public int getBigTileWidth() {
		return bigTileWidth;
	}

	/**
	 * @return the width of half tile
	 */
	public int getHalfTileWidth() {
		return halfTileWidth;
	}

	/**
	 * @return the width of normal tile
	 */
	public int getNormalTileWidth() {
		return normalTileWidth;
	}

	/**
	 * @return the cell height
	 */
	public int getCellHeight() {
		return cellHeight;
	}

	/**
	 * @return the width of screen in tiles
	 */
	public int getScreenWidthInTiles() {
		return screenWidthInTiles;
	}

	/**
	 * @return the height of screen in tiles
	 */
	public int getScreenHeightInTiles() {
		return screenHeightInTiles;
	}

	/**
	 * @return the player location on screen
	 */
	public Position getPlayerLocationOnScreen() {
		return playerLocationOnScreen;
	}

	/**
	 * @return the background colour of window
	 */
	public Color getWindowBackgroundColour() {
		return windowBackgroundColour;
	}

	/**
	 * @return the inner border colour
	 */
	public Color getBorderColourIn() {
		return borderColourIn;
	}

	/**
	 * @return the outer border colour
	 */
	public Color getBorderColourOut() {
		return borderColourOut;
	}

	/**
	 * @return the font for message box
	 */
	public Font getMessageBoxFont() {
		return messageBoxFont;
	}

	/**
	 * @return the font for persistent message box
	 */
	public Font getPersistantMessageBoxFont() {
		return persistantMessageBoxFont;
	}

	/**
	 * @return the status screen background
	 */
	public BufferedImage getStatusScreenBackground() {
		return statusScreenBackground;
	}

	public double getScreenScale() {
		return screenScale;
	}
	
	public int getScreenWidth() {
		return screenWidth;
	}
	
	public int getScreenHeight() {
		return screenHeight;
	}
	
	public BufferedImage getUserInterfaceBackgroundImage() {
		return UserInterfaceBackgroundImage;
	}
	
	public GFXImageConfiguration getImageConfiguration() {
		return imageConfiguration;
	}

	public int getViewportUserInterfaceScale() {
		return viewportUserInterfaceScale;
	}
}
