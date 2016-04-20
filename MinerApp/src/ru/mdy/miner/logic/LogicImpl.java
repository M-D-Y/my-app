/**
 * TODO: comments
 */
package ru.mdy.miner.logic;

/**
 * TODO: comments
 * 
 * @author admin
 *
 * @since 17 апр. 2016 г.
 */
public class LogicImpl implements Logic {
	private Cell[][] cells;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.mdy.miner.logic.Logic#finish()
	 */
	public boolean finish() {
		boolean result = false;
		for (Cell[] cellsRow : cells) {
			for (Cell cell : cellsRow) {
				result = (cell.isBomb() && cell.isSuggestBomb()) || (!cell.isBomb() && cell.isSuggestEmpty());
				if (!result)
					break;
			}
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.mdy.miner.logic.Logic#loadField(ru.mdy.miner.logic.Cell[][])
	 */
	public void loadField(Cell[][] cells) {
		this.cells = cells;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.mdy.miner.logic.Logic#shouldBang(int, int)
	 */
	public boolean shouldBang(int x, int y) {
		final Cell selectedCell = cells[x][y];
		return selectedCell.isBomb() && !selectedCell.isSuggestBomb();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.mdy.miner.logic.Logic#suggest(int, int, boolean)
	 */
	public void suggest(int x, int y, boolean bomb) {
		if (bomb)
			cells[x][y].suggestBomb();
		else
			cells[x][y].suggestEmpty();
	}

}
