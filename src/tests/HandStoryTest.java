package tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import components.Card;
import components.Deck;
import components.Hand;

public class HandStoryTest {
	private Hand hand;
	private Deck deck;
	
	@Before
	public void setUp() throws Exception {
		hand = new Hand();
		deck = new Deck(5);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void seeHand() {
		List<Card> expected = new ArrayList<Card>();
		for (int i = 0; i < 3; i++) {
			expected.add(deck.getCards().get(0));
			hand.Draw(deck);
		}
		Assert.assertEquals(expected, hand.getCards());
	}
}
