package edu.neumont.csc150.finalproject.view;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JPanel;

import edu.neumont.csc150.finalproject.controller.GameManager;

public class DeathScreen extends JPanel {

	private static final long serialVersionUID = 4165782181652962456L;

	private GameManager gameManager;
	private JButton restartLevel, quitToMainMenu;
	private Image background;

	public DeathScreen(GameManager gameManager) {
		this.gameManager = gameManager;
		this.setLayout(new GridLayout(8, 5));
		initDeathScreen();
	}

	private void initDeathScreen() {
		restartLevel = new JButton("Restart Level");
		restartLevel.addActionListener(gameManager);
		quitToMainMenu = new JButton("Quit to Main Menu");
		quitToMainMenu.addActionListener(gameManager);

		for (int i = 0; i < 10; i++) {
			this.add(new JPanel());
		}
		this.add(restartLevel);
		for (int i = 0; i < 5; i++) {
			this.add(new JPanel());
		}
		this.add(quitToMainMenu);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(background, 0, 0, null);
	}

}