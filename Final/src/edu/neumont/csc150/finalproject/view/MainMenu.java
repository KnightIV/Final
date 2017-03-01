package edu.neumont.csc150.finalproject.view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JPanel;

import edu.neumont.csc150.finalproject.controller.GameManager;

public class MainMenu extends JPanel{
	
	private GameManager gameManager;
	private JButton newGame, loadGame, quitGame, manual;
	private Image background;
	
	public MainMenu(GameManager gameManager) {
		this.gameManager = gameManager;
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
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(background, 0, 0, null);
	}
	
}
