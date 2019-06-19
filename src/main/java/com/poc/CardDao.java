package com.poc;

import java.util.List;

public interface CardDao {

	public List<Card> getCards();

	public Boolean addCard(Card card);

	public Boolean removeCard(Card card);

	public void exit(String name);

	public void exitCardIdException(String name);

}
