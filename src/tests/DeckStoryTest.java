package tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import components.Card;
import components.Deck;
import components.Dryad;
import components.Elf;
import components.Hand;

public class DeckStoryTest {

	private Hand hand;
	private Deck deck;
	
	@Before
	public void setUp() throws Exception {
		hand = new Hand();
		deck = new Deck();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Elf elf = new Elf();
		Dryad dryad = new Dryad();
		
		deck.Add(elf);
		deck.Add(dryad);
		List<Card> expectedDeck = new ArrayList<Card>();
		expectedDeck.add(elf);
		expectedDeck.add(dryad);
	    List<Card> expectedHand = new ArrayList<Card>();
	    
	    //Assert.assertEquals(expectedDeck, deck.getCards());
	    //Assert.assertEquals(expectedHand, hand.getCards());
	    
	    hand.Draw(deck);
	    
	    expectedHand.add(elf);
	    expectedDeck.remove(elf);
	    
	    Assert.assertEquals(expectedDeck, deck.getCards());
	    Assert.assertEquals(expectedHand, hand.getCards());
	    
	}

}
