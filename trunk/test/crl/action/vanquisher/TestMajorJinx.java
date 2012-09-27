package crl.action.vanquisher;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.hamcrest.Matchers.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import crl.item.Item;
import crl.level.Level;
import crl.player.Player;

/**
 * Tests for major jinx
 * 
 * @author Tuukka Turto
 *
 */
public class TestMajorJinx {

	private Player player;
	private MajorJinx jinx;
	private Level level;
	
	@Before
	public void setUp() throws Exception {
		level = mock(Level.class);
		when(level.isDay()).thenReturn(true);
		
		player = new Player();
		player.setHeartMax(250);
		player.setHearts(50);
		player.setHitsMax(30);
		player.setHits(30);
		player.setLevel(level);
		
		jinx = new MajorJinx();
		jinx.setPerformer(player);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void castingMinorJinxShouldIncreaseHearts() {
		int oldHearts = player.getHearts();
		
		jinx.execute();
		
		assertThat(player.getHearts(), greaterThan(oldHearts));
	}
	
	@Test
	public void castingMinorJinxShouldDecreaseHits() {
		int oldHits = player.getHits();
		
		jinx.execute();
		
		assertThat(player.getHits(), lessThan(oldHits));
	}
	
	@Test
	public void armourShouldNotDecreaseDamageWhenCastingMinorJinx() {
		int oldHits = player.getHits();
		Item armour = mock(Item.class);
		when(armour.getDefense()).thenReturn(10);
		
		player.setArmor(armour);
		
		jinx.execute();
		
		assertThat(player.getHits(), equalTo(oldHits - 5));
	}

}
