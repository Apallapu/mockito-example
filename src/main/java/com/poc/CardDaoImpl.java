package com.poc;

import java.util.ArrayList;
import java.util.List;

public class CardDaoImpl implements CardDao {

	static List<Card> cardsList = new ArrayList<Card>();

	public List<Card> getCards() {

		return getAllCards();
	}

	private List<Card> getAllCards() {
		Card card = new Card();
		card.setCardId(12);
		card.setCardName("VISA");

		Card cardOne = new Card();
		cardOne.setCardId(13);
		cardOne.setCardName("MASTER CARD");
		cardsList.add(card);
		cardsList.add(cardOne);

		return cardsList;
	}

	public Boolean addCard(Card card) {
		if (card == null) {
			throw new NullPointerException("error");
		}
		cardsList.add(card);
		return Boolean.TRUE;

	}

	public Boolean removeCard(Card card) {

		if (card == null) {
			throw new NullPointerException("error");
		}
		cardsList.remove(card);

		return Boolean.TRUE;

	}

	public void exit(String name) {

          System.out.println("name is:"+name);
		
	}
	
	public void exitCardIdException(String name) {

        System.out.println("name is:"+name);
		
	}

}
