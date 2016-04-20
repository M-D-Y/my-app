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
public class UserActionImpl implements UserAction {
	private CellsField field;
	private CellsGenerator generator;
	private Logic logic;

	/*
	 * @param field минное поле
	 * 
	 * @param generator генератор ячеек
	 * 
	 * @param logic логика игры
	 */
	public UserActionImpl(CellsField field, CellsGenerator generator, Logic logic) {
		super();
		this.field = field;
		this.generator = generator;
		this.logic = logic;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.mdy.miner.logic.UserAction#select(int, int, boolean)
	 */
	public void select(int x, int y, boolean isBomb) {
		logic.suggest(x, y, isBomb);
		field.drawCell(x, y);
		if (logic.shouldBang(x, y))
			field.drawBang();
		if (logic.finish())
			field.drawCongratulations();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.mdy.miner.logic.UserAction#startGame()
	 */
	public void startGame() {
		final Cell[][] cells = this.generator.generate();
		field.drawField(cells);
		logic.loadField(cells);
	}

}
