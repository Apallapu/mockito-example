package com.poc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CardDaoTest {

	CardDao cardDao;

	@Before
	public void init() {
		cardDao = new CardDaoImpl();
	}

	@After
	public void destory() {
		cardDao = null;
	}

	@Test
	public void addCardTest() {

		Card card = new Card();
		card.setCardId(12);
		card.setCardName("MASTER CARD");
		 assertTrue(cardDao.addCard(card));
		// assertFalse(cardDao.addCard(card));
		// assertNotNull(cardDao.addCard(card));
		// assertNull(cardDao.addCard(card));

	}

	@Test(expected = NullPointerException.class)
	public void addCardTestException() {
		Card card = null;
		assertNull(cardDao.addCard(card));

	}

	

	@Test
	public void getCards() {
		List<Card> cardsListExpected = new ArrayList<Card>();
		Card card = new Card();
		card.setCardId(12);
		card.setCardName("VISA");

		Card cardOne = new Card();
		cardOne.setCardId(13);
		cardOne.setCardName("MASTER CARD");
		cardsListExpected.add(card);
		cardsListExpected.add(cardOne);
		List<Card> actualList = cardDao.getCards();
		assertNotNull(cardDao.getCards());
		assertEquals(cardsListExpected.get(0).getCardId(), actualList.get(0).getCardId());

	}
	
	@Test
	public void removeCardTest() {

		Card card = new Card();
		card.setCardId(12);
		card.setCardName("MASTER CARD");
		assertTrue(cardDao.removeCard(card));
		assertNotNull(cardDao.removeCard(card));

	}

	@Test(expected = NullPointerException.class)
	public void removeCardTestException() {
		Card card = null;
		 assertTrue(cardDao.removeCard(card));

	}

}
