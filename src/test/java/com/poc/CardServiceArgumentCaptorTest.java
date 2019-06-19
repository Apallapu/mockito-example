package com.poc;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CardServiceArgumentCaptorTest {

	@Mock
	private CardDao cardDao;
	@InjectMocks
	private CardService cardService;
	@Captor
	private ArgumentCaptor<Card> cardArgument;

	public CardServiceArgumentCaptorTest() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void addCardTest() {
		Card card = new Card();
		card.setCardId(12);
		card.setCardName("Mater card");

		cardService.addCard(card);

		verify(cardDao).addCard(cardArgument.capture());
		
		assertThat(cardArgument.getValue().getCardId(), is(notNullValue()));
		
		// verify(cardDao,only(1)).addCard(any(Card.class));
		// verify(cardDao,calls(1)).addCard(any(Card.class));

		// verify(cardDao,never()).addCard(any(Card.class));

	}

	
}
