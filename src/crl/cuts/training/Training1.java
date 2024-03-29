package crl.cuts.training;

import crl.cuts.Unleasher;
import crl.game.Game;
import crl.level.Level;
import crl.ui.Display;
import crl.ui.UserInterface;

public class Training1 extends Unleasher {
	public void unleash(Level level, Game game){
		Display.thus.showScreen("Dracula has been defeated, and Christopher Belmont lives a peaceful life with his family; his son Soleiyu is growing strong and is about to begin his training.");
		Display.thus.showScreen("Use WASD+QEZC or directional keys to move, 'L' to look at the different sign posts, '?' for help. Press 'Q' to exit this training.");
		UserInterface.getUI().setPersistantMessage("Movement \n \n Use WASD+QEZC or directional keys to move, exit through the door and bump into the signposts to follow the tutorial. \n \n Press '?' for help and 'Q' to exit.");

		enabled = false;
	}
}
