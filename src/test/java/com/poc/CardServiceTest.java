package com.poc;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CardServiceTest {

	@Mock
	private CardDao cardDao;
	@InjectMocks
	private CardService cardService;

	

	public CardServiceTest() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void addCardTest() {
		Card card = new Card();
		card.setCardId(12);
		card.setCardName("Mater card");
		when(cardDao.addCard(card)).thenReturn(Boolean.TRUE);

		assertEquals(Boolean.TRUE, cardService.addCard(card));

		verify(cardDao).addCard(any(Card.class));
		verify(cardDao, times(1)).addCard(any(Card.class));
		verify(cardDao, atLeast(1)).addCard(any(Card.class));
		verify(cardDao, atMost(1)).addCard(any(Card.class));
		verify(cardDao, atLeastOnce()).addCard(any(Card.class));
		// verify(cardDao,only(1)).addCard(any(Card.class));
		// verify(cardDao,calls(1)).addCard(any(Card.class));

		// verify(cardDao,never()).addCard(any(Card.class));

	}

	@Test
	public void removeCardTest() {
		Card card = new Card();
		card.setCardId(12);
		card.setCardName("Mater card");
		when(cardDao.removeCard(card)).thenReturn(Boolean.TRUE);

		assertEquals(Boolean.TRUE, cardService.removeCard(card));

	}

	@Test
	public void getCardsTest() {
		Card card = new Card();
		card.setCardId(12);
		card.setCardName("Mater card");
		List<Card> cards = new ArrayList<Card>();
		cards.add(card);
		when(cardDao.getCards()).thenReturn(cards);
		List<Card> actualcards = cardService.getCards();

		assertEquals(cards.get(0).getCardId(), actualcards.get(0).getCardId());

	}

	@Test
	public void exitTest() {

		Mockito.doNothing().when(cardDao).exit(anyString());

		cardService.exit(anyString());

	}

	@Test(expected = CardNotFoundException.class)
	public void addExceptionTest() {

		Card card = null;
		when(cardDao.addCard(card)).thenThrow(new CardNotFoundException("cards are comming as null"));

		assertEquals(Boolean.TRUE, cardService.addCard(card));

	}

	@Test(expected = CardNotFoundException.class)
	public void removeExceptionTest() {

		Card card = null;
		when(cardDao.removeCard(card)).thenThrow(new CardNotFoundException("cards are comming as null"));

		assertEquals(is(true), cardService.removeCard(card));

	}

	@Test(expected = CardNotFoundException.class)
	public void exitCardIdExceptionTest() {

		doThrow(CardNotFoundException.class).when(cardDao).exitCardIdException(any(String.class));
		
		cardService.exitCardIdException(null);
	}
	
	@Test
	public void exitCardIdTest(){

		Mockito.doNothing().when(cardDao).exitCardIdException(anyString());

		cardService.exitCardIdException(anyString());

	}
}
