package com.poc;

import java.util.List;

public class CardService {
	private CardDao cardDao;

	public List<Card> getCards() {

		return cardDao.getCards();
	}

	public Boolean addCard(Card card) {
		if (card == null) {
			throw new CardNotFoundException("cards are comming as null");
		}
		return cardDao.addCard(card);

	}

	public Boolean removeCard(Card card) {
		if (card == null) {
			throw new CardNotFoundException("cards are comming as null");
		}
		return cardDao.removeCard(card);

	}

	public void exit(String name) {

		cardDao.exit(name);

	}
	public void exitCardIdException(String name) {
		if(name==null) {
			throw new CardNotFoundException("cards are comming as null");
		}

		cardDao.exitCardIdException(name);

	}

}
