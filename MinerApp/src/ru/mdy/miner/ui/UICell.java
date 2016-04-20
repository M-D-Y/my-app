/**
 * TODO: comments
 */
package ru.mdy.miner.ui;

import java.awt.Graphics;
import java.awt.Rectangle;

import ru.mdy.miner.logic.Cell;

/**
 * TODO: comments
 * 
 * @author admin
 *
 * @since 19 апр. 2016 г.
 */
public class UICell implements Cell<Graphics> {
	private boolean bomb;
	private boolean suggestBomb;
	private boolean suggestEmpty;

	/**
	 * @param bomb
	 */
	public UICell(boolean bomb) {
		super();
		this.bomb = bomb;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.mdy.miner.logic.Cell#isBomb()
	 */
	public boolean isBomb() {
		
		return bomb;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.mdy.miner.logic.Cell#isSuggestBomb()
	 */
	public boolean isSuggestBomb() {
		
		return suggestBomb;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.mdy.miner.logic.Cell#isSuggestEmpty()
	 */
	public boolean isSuggestEmpty() {
		
		return suggestEmpty;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.mdy.miner.logic.Cell#suggestBomb()
	 */
	public void suggestBomb() {
		bomb = true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.mdy.miner.logic.Cell#suggestEmpty()
	 */
	public void suggestEmpty() {
		suggestEmpty = true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.mdy.miner.logic.Cell#draw(java.lang.Object, boolean)
	 */
	public void draw(Graphics paint, boolean real) {
		Rectangle rect = paint.getClipBounds();
		System.out.println(rect);
		paint.draw3DRect(10, 30, 100, 100, false);
	}

}
