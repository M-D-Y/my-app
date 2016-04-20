/**
 * TODO: comments
 */
package ru.mdy.miner.ui.tests;

import ru.mdy.miner.logic.Cell;
import ru.mdy.miner.logic.CellsGenerator;
import ru.mdy.miner.logic.LogicImpl;
import ru.mdy.miner.logic.UserAction;
import ru.mdy.miner.logic.UserActionImpl;
import ru.mdy.miner.ui.UICell;
import ru.mdy.miner.ui.UIField;

/**
 * TODO: comments
 * 
 * @author admin
 *
 * @since 19 апр. 2016 г.
 */
public class GameTest {
	private static UserAction userAction;

	public static void main(String... args) {
		userAction = new UserActionImpl(new UIField(), new CellsGenerator() {
			public Cell[][] generate() {
				return new Cell[][] { { new UICell(false), new UICell(true), new UICell(false) },
						{ new UICell(true), new UICell(false), new UICell(false) } };
			}
		}, new LogicImpl());
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				userAction.startGame();
			}
		});
	}

}
