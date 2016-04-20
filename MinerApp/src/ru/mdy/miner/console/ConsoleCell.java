/**
 * TODO: comments
 */
package ru.mdy.miner.console;

import java.io.PrintStream;

import ru.mdy.miner.logic.Cell;

/**
 * TODO: comments
 * 
 * @author admin
 *
 * @since 17 апр. 2016 г.
 */
public class ConsoleCell implements Cell<PrintStream> {

	private boolean bomb;
	private boolean suggestBomb;
	private boolean suggestEmpty;

	/**
	 * @param bomb
	 */
	public ConsoleCell(boolean bomb) {
		super();
		this.bomb = bomb;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.mdy.miner.logic.Cell#isBomb()
	 */
	public boolean isBomb() {
		return this.bomb;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.mdy.miner.logic.Cell#isSuggestBomb()
	 */
	public boolean isSuggestBomb() {
		return this.suggestBomb;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.mdy.miner.logic.Cell#isSuggestEmpty()
	 */
	public boolean isSuggestEmpty() {
		return this.suggestEmpty;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.mdy.miner.logic.Cell#suggestBomb()
	 */
	public void suggestBomb() {
		this.suggestBomb = true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.mdy.miner.logic.Cell#suggestEmpty()
	 */
	public void suggestEmpty() {
		this.suggestEmpty = true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.mdy.miner.logic.Cell#draw(java.lang.Object, boolean)
	 */
	public void draw(PrintStream paint, boolean hidden) {
		if (!hidden) {
			if (this.isBomb())
				paint.print("[*] ");
			else
				paint.print("[ ] ");
		} else {
			if (this.suggestBomb)
				paint.print("[?] ");
			else if (this.suggestEmpty)
				paint.print("[ ] ");
			else
				paint.print("[X] ");
		}
	}

}
