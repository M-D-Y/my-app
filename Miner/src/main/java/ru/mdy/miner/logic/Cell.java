package ru.mdy.miner.logic;
/**
 * интерфейс описывающий ячейку поля 
 */

/**
 * TODO: comments
 * 
 * @author admin
 *
 * @since 17 апр. 2016 г.
 */
public interface Cell<T> {

	public boolean isBomb();

	public boolean isSuggestBomb();

	public boolean isSuggestEmpty();

	public void suggestBomb();

	public void suggestEmpty();

	public void draw(T paint, boolean real);
}
