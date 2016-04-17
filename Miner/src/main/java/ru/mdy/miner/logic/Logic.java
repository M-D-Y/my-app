/**
 * интерфейс логики игры
 */
package ru.mdy.miner.logic;

/**
 * TODO: comments
 * @author admin
 *
 * @since 17 апр. 2016 г.
 */
public interface Logic {

	boolean finish();
	void loadField(Cell[][] cells);
	boolean shouldBang(int x, int y);
	void suggest(int x, int y, boolean bomb);
}
