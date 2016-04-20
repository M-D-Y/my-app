package ru.mdy.miner.logic;
/**
 * интерфейс, описывающий поле
 */

/**
 * TODO: comments
 * 
 * @author admin
 *
 * @since 17 апр. 2016 г.
 */
public interface CellsField {

	public void drawBang();

	public void drawCongratulations();

	public void drawField(Cell[][] cells);

	public void drawCell(int x, int y);
}
