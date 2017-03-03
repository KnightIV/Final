package edu.neumont.csc150.finalproject.view;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JPanel;

import edu.neumont.csc150.finalproject.controller.GameManager;

public class MainMenu extends JPanel{
	
	private static final long serialVersionUID = 6810141084380699742L;
	
	private GameManager gameManager;
	private JButton newGame, loadGame, quitGame, manual;
	private Image background;
	
	public MainMenu(GameManager gameManager) {
		this.gameManager = gameManager;
		this.setLayout(new GridLayout(4, 3));
		initMenu();
	}
	
	public void initMenu() {
		newGame = new JButton("New Game");
		newGame.addActionListener(gameManager);
		loadGame = new JButton("Load Game");
		loadGame.addActionListener(gameManager);
		quitGame = new JButton("Quit Game");
		quitGame.addActionListener(gameManager);
		manual = new JButton("Manual");
		manual.addActionListener(gameManager);
		
		this.add(new JPanel());
		this.add(newGame);
		this.add(new JPanel());
		
		this.add(new JPanel());
		this.add(loadGame);
		this.add(new JPanel());
		
		this.add(new JPanel());
		this.add(manual);
		this.add(new JPanel());
		
		this.add(new JPanel());
		this.add(quitGame);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(background, 0, 0, null);
	}
}
