package crl.cuts.intro;

import sz.util.Position;
import sz.util.Util;
import crl.cuts.Unleasher;
import crl.game.Game;
import crl.game.STMusicManagerNew;
import crl.level.Level;
import crl.monster.Monster;
import crl.monster.MonsterFactory;
import crl.ui.UserInterface;

public class Intro3 extends Unleasher {

	public void unleash(Level level, Game game) {
		if (level.getFlag("INTRO2")&& level.getCounter("COUNTBACK_INTRO_2").isOver()){
			level.addMessage("A monstruous Warg appears out of nowhere! Remember to 'j'ump and 'a'ttack from safe distance!");
			Position playerFloor = new Position(level.getPlayer().getPosition());
			playerFloor.z = 2;
			while (true) {
				int xpos = Util.rand(3,5) * (Util.chance(50) ? 1 : -1);
				int ypos = Util.rand(3,5) * (Util.chance(50) ? 1 : -1);
				Position wargPosition = Position.add(playerFloor, new Position(xpos, ypos));
				if (level.isWalkable(wargPosition)){
					Monster warg = MonsterFactory.getFactory().buildMonster("WARG");
					warg.setPosition(wargPosition);
					level.addMonster(warg);
					break;
				}
			}
			STMusicManagerNew.thus.playKey("WRECKAGE");
			level.setMusicKeyMorning("WRECKAGE");
			if (level.getNPCByID("MELDUCK") != null)
				level.getNPCByID("MELDUCK").setTalkMessage("On your way! I will take care of anything you leave here");
			enabled = false;
			level.removeCounter("COUNTBACK_INTRO_2");
			level.getPlayer().see();
			UserInterface.getUI().refresh();
		}
	}

}