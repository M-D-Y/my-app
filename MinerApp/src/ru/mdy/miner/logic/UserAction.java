/**
 * интерфейс действий пользователя
 */
package ru.mdy.miner.logic;

/**
 * TODO: comments
 * 
 * @author admin
 *
 * @since 17 апр. 2016 г.
 */
public interface UserAction {

	void select(int x, int y, boolean isBomb);

	void startGame();

}
