/**
 * TODO: comments
 */
package ru.mdy.miner.console;

import ru.mdy.miner.logic.Cell;
import ru.mdy.miner.logic.CellsField;

/**
 * TODO: comments
 * 
 * @author admin
 *
 * @since 17 апр. 2016 г.
 */
public class ConsoleField implements CellsField {
	private Cell[][] cells;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.mdy.miner.logic.CellsField#drawBang()
	 */
	public void drawBang() {
		System.out.println("############# BANG #############");
		reDraw(true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.mdy.miner.logic.CellsField#drawCongratulations()
	 */
	public void drawCongratulations() {
		System.out.println("************* CONGRATULATIONS!!! YOU WIN!!! *************");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.mdy.miner.logic.CellsField#drawField(ru.mdy.miner.logic.Cell[][])
	 */
	public void drawField(Cell[][] cells) {
		this.cells = cells;
		reDraw(false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.mdy.miner.logic.CellsField#drawCell(int, int)
	 */
	public void drawCell(int x, int y) {
		System.out.println("------------- SELECT -------------");
		reDraw(false);
	}

	private void reDraw(boolean real) {
		for (Cell[] cellsRow : this.cells) {
			for (Cell cell : cellsRow) {
				cell.draw(System.out, real);
			}
			System.out.println();
		}
		System.out.println();
	}
}
