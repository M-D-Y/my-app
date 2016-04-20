/**
 * TODO: comments
 */
package ru.mdy.miner.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ru.mdy.miner.logic.Cell;
import ru.mdy.miner.logic.CellsField;

/**
 * TODO: comments
 * 
 * @author admin
 *
 * @since 19 апр. 2016 г.
 */
public class UIField extends JFrame implements CellsField, ActionListener, MouseListener {
	private JPanel panel;
	private Cell[][] cells;

	/**
	 * 
	 */
	public UIField() {
		super();
		createAndShowGUI();
	}

	@Override
	public void paintComponents(Graphics g) {
		super.paintComponents(g);
		reDraw(true);
	}
	
	private void createAndShowGUI() {
		//panel.addMouseListener(this);
		getContentPane().addMouseListener(this);
		//getContentPane().
		//add(panel, BorderLayout.NORTH);
		
		JButton button = new JButton("Start game");
		button.addActionListener(this);
		//getContentPane().
		add(button, BorderLayout.SOUTH);
		setTitle("Miner game sample");
		// setSize(300, 300);
		setPreferredSize(new Dimension(400, 400));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.NORMAL);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.mdy.miner.logic.CellsField#drawBang()
	 */
	public void drawBang() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.mdy.miner.logic.CellsField#drawCongratulations()
	 */
	public void drawCongratulations() {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub

	}

	private void reDraw(boolean hidden) {
		for (Cell[] cellsRow : this.cells) {
			for (Cell cell : cellsRow) {
				cell.draw(this.getGraphics(), hidden);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("mouseClicked");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("mousePressed");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("mouseReleased");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("mouseEntered");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("mouseExited");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Button clicked");
	}

}
