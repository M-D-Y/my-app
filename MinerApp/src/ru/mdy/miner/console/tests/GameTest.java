/**
 * TODO: comments
 */
package ru.mdy.miner.console.tests;

import org.junit.Test;

import ru.mdy.miner.console.ConsoleCell;
import ru.mdy.miner.console.ConsoleField;
import ru.mdy.miner.logic.Cell;
import ru.mdy.miner.logic.CellsGenerator;
import ru.mdy.miner.logic.LogicImpl;
import ru.mdy.miner.logic.UserActionImpl;

/**
 * TODO: comments
 * 
 * @author admin
 *
 * @since 17 апр. 2016 г.
 */
public class GameTest {
	final UserActionImpl testAction = new UserActionImpl(new ConsoleField(), new CellsGenerator() {
		public Cell[][] generate() {
			return new Cell[][] { { new ConsoleCell(false), new ConsoleCell(true), new ConsoleCell(false) },
					{ new ConsoleCell(true), new ConsoleCell(false), new ConsoleCell(false) } };
		}
	}, new LogicImpl());

	@Test
	public void successGameTest() {
		System.out.println("success game test\n__________________________________\n");
		testAction.startGame();
		testAction.select(0, 0, false);
		testAction.select(0, 1, true);
		testAction.select(0, 2, false);
		testAction.select(1, 0, true);
		testAction.select(1, 1, false);
		testAction.select(1, 2, false);
	}

	@Test
	public void failureGameTest() {
		System.out.println("failure game test\n__________________________________\n");
		testAction.startGame();
		testAction.select(0, 0, true);
		testAction.select(0, 1, false);
		testAction.select(0, 2, false);
		testAction.select(1, 0, true);
		testAction.select(1, 1, false);
		testAction.select(1, 2, false);
	}

}
