package com.poc;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CardServiceSpyTest {

	@Mock
	private CardDao cardDao;
	@Spy
	private CardService cardService;

	public CardServiceSpyTest() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void addCardTest() {
		Card card = new Card();
		card.setCardId(12);
		card.setCardName("Mater card");

		assertThat(cardService.addCard(card), is(true));
		verify(cardDao, times(1)).exit(anyString());

		verify(cardDao, never()).exit(anyString());

		verify(cardDao,never()).exitCardIdException(anyString());

		// verify(cardDao,only(1)).addCard(any(Card.class));
		// verify(cardDao,calls(1)).addCard(any(Card.class));

		// verify(cardDao,never()).addCard(any(Card.class));

	}

}
