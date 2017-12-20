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
import components.Gnome;
import components.Goblin;
import components.Hand;
import components.Kingdom;
import components.Korrigan;
import components.Troll;
import processing.core.PVector;

public class ApplyPowerStoryTest {
	private Kingdom kingdom;
	private Kingdom opponentKingdom;
	private Hand hand;
	private Hand opponentHand;
	private Deck deck;
	List<Card> expectedKingdom;
	List<Card> expectedOpponentKingdom;
	List<Card> expectedHand;
	List<Card> expectedOpponentHand;
	List<Card> expectedDeck;
	
	@Before
	public void setUp() throws Exception {
		kingdom = new Kingdom(new PVector(0f,0f),new PVector(0f,0f));
		opponentKingdom = new Kingdom(new PVector(0f,0f),new PVector(0f,0f));
		hand = new Hand();
		opponentHand = new Hand();
		deck = new Deck();
		expectedKingdom = new ArrayList<Card>();
		expectedOpponentKingdom = new ArrayList<Card>();
		expectedHand = new ArrayList<Card>();
		expectedOpponentHand = new ArrayList<Card>();
		expectedDeck = new ArrayList<Card>();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void DryadPowerTest() {
		/*
		 * The Dryad's power steals an opponent card from its kingdom and places
         * it into our kingdom. It doesn't apply the power of the card stolen
         * 
         * For this test we set in :
         * - our hand : a dryad to test its power
         * - the opponent kingdom : an elf
		 */
		Dryad dryad = new Dryad();
		Elf elf = new Elf();
		hand.Add(dryad);
		opponentKingdom.Add(elf);
		Card expectedStolenCard = opponentKingdom.getCards().get(0);
		
		//Assert.assertEquals(1, opponentKingdom.Length());
		//Assert.assertEquals(0, kingdom.Length());
		
		hand.Use(hand, opponentHand, kingdom, opponentKingdom, deck, dryad);
		
		Assert.assertEquals(0, opponentKingdom.Length());
		Assert.assertEquals(2, kingdom.Length());
		Assert.assertEquals(expectedStolenCard, kingdom.getCards().get(0));
	}

	@Test
	public void ElfPowerTest() {
		/*
		 * Elf power : copy a random card from our kingdom and uses its power
		 * 
		 * For this test we set in :
		 * our kingdom : a gnome
		 * our hand : an elf to test its power
		 * our deck : the deck only contains two dryads for this test
		 */
		Elf elf = new Elf();
		Gnome gnome = new Gnome();
		Dryad dryad1 = new Dryad();
		Dryad dryad2 = new Dryad();
		
		
		hand.Add(elf);
		expectedHand.add(elf);
		kingdom.Add(gnome);
		expectedKingdom.add(gnome);
		deck.Add(dryad1);
		deck.Add(dryad2);
		expectedDeck.add(dryad1);
		expectedDeck.add(dryad2);
		
		//Assert.assertEquals(expectedHand, hand.getCards());
		//Assert.assertEquals(expectedDeck, deck.getCards());
		//Assert.assertEquals(expectedKingdom, kingdom.getCards());
		
		hand.Use(hand, opponentHand, kingdom, opponentKingdom, deck, elf);
		
		expectedHand.clear();
		expectedHand.add(dryad1);
		expectedHand.add(dryad2);
		expectedKingdom.add(gnome);
		expectedKingdom.add(elf);
		expectedDeck.clear();
		
		Assert.assertEquals(expectedHand, hand.getCards());
		Assert.assertEquals(expectedDeck, deck.getCards());
		Assert.assertEquals(expectedKingdom, kingdom.getCards());
	}
	
	@Test
	public void GnomePowerTest() {
		/*
		 * The power of Gnome draws two cards from the deck and place them in Hand
		 * 
		 * For this test we set in :
		 * - our deck : one dryad and one elf
		 * - our hand : one gnome whose power is tested
		 */
		Gnome gnome = new Gnome();
		Dryad dryad = new Dryad();
		Elf elf = new Elf();
		
		hand.Add(gnome);
		expectedHand.add(gnome);
		deck.Add(dryad);
		deck.Add(elf);
		expectedDeck.add(dryad);
		expectedDeck.add(elf);
		
		//Assert.assertEquals(expectedKingdom, kingdom.getCards());
		//Assert.assertEquals(expectedHand, hand.getCards());
		//Assert.assertEquals(expectedDeck, deck.getCards());
		
		hand.Use(hand, opponentHand, kingdom, opponentKingdom, deck, gnome);
		
		expectedDeck.clear();
		expectedHand.clear();
		expectedHand.add(dryad);
		expectedHand.add(elf);
		expectedKingdom.add(gnome);
		
		Assert.assertEquals(expectedKingdom, kingdom.getCards());
		Assert.assertEquals(expectedHand, hand.getCards());
		Assert.assertEquals(expectedDeck, deck.getCards());
	}

	@Test
	public void GoblinPowerTest() {
		/*
		 * Switch the hand of the two players
		 * 
		 * For this test we set in :
		 * - our hand : a goblin whose power is tested and an elf
		 * - our opponent hand : a dryad
		 */
		Goblin goblin = new Goblin();
		Elf elf = new Elf();
		Dryad dryad = new Dryad();
		
		hand.Add(goblin);
		hand.Add(elf);
		expectedHand.add(goblin);
		expectedHand.add(elf);
		opponentHand.Add(dryad);
		expectedOpponentHand.add(dryad);
		
		//Assert.assertEquals(expectedHand, hand.getCards());
		//Assert.assertEquals(expectedOpponentHand, opponentHand.getCards());
		//Assert.assertEquals(expectedKingdom, kingdom.getCards());
		
		hand.Use(hand, opponentHand, kingdom, opponentKingdom, deck, goblin);
		
		expectedHand.clear();
		expectedHand.add(dryad);
		expectedOpponentHand.clear();
		expectedOpponentHand.add(elf);
		expectedKingdom.add(goblin);
		
		Assert.assertEquals(expectedHand, hand.getCards());
		Assert.assertEquals(expectedOpponentHand, opponentHand.getCards());
		Assert.assertEquals(expectedKingdom, kingdom.getCards());
	}

	@Test
	public void KorriganPowerTest() {
		/*
		 * The power of the Korrigan makes the current player draw twice in the opponent hand.
		 * 
		 * For this test we put in :
		 * - our hand : a korrigan
		 * - our opponent hand : an elf and a dryad
		 */
		Korrigan korrigan = new Korrigan();
		Elf elf = new Elf();
		Dryad dryad = new Dryad();
		
		hand.Add(korrigan);
		expectedHand.add(korrigan);
		opponentHand.Add(elf);
		opponentHand.Add(dryad);
		expectedOpponentHand.add(elf);
		expectedOpponentHand.add(dryad);
		
		//Assert.assertEquals(expectedHand, hand.getCards());
		//Assert.assertEquals(expectedOpponentHand, opponentHand.getCards());
		//Assert.assertEquals(expectedKingdom, kingdom.getCards());
		
		hand.Use(hand, opponentHand, kingdom, opponentKingdom, deck, korrigan);
		
		int expectedHandNb = 2;
		expectedKingdom.add(korrigan);
		expectedOpponentHand.clear();
		
		Assert.assertEquals(expectedHandNb, hand.getCards().size());
		Assert.assertEquals(expectedOpponentHand, opponentHand.getCards());
		Assert.assertEquals(expectedKingdom, kingdom.getCards());
	}

	@Test
	public void TrollPowerTest() {
		/*
		 * Switch the kingdom of the two players
		 * 
		 * In this test we put in :
		 * - our hand : a troll
		 * - our kingdom : an elf
		 * - our opponent kingdom : a dryad
		 */
		Troll troll = new Troll();
		Elf elf = new Elf();
		Dryad dryad = new Dryad();
		
		hand.Add(troll);
		expectedHand.add(troll);
		kingdom.Add(elf);
		expectedKingdom.add(elf);
		opponentKingdom.Add(dryad);
		expectedOpponentKingdom.add(dryad);
		
		//Assert.assertEquals(expectedHand, hand.getCards());
		//Assert.assertEquals(expectedKingdom, kingdom.getCards());
		//Assert.assertEquals(expectedOpponentKingdom, opponentKingdom.getCards());
		
		hand.Use(hand, opponentHand, kingdom, opponentKingdom, deck, troll);
		
		expectedHand.clear();
		expectedKingdom.clear();
		expectedKingdom.add(dryad);
		expectedKingdom.add(troll);
		expectedOpponentKingdom.clear();
		expectedOpponentKingdom.add(elf);
		
		Assert.assertEquals(expectedHand, hand.getCards());
		Assert.assertEquals(expectedKingdom, kingdom.getCards());
		Assert.assertEquals(expectedOpponentKingdom, opponentKingdom.getCards());
	}
}
