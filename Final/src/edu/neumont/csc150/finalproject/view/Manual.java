package edu.neumont.csc150.finalproject.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import edu.neumont.csc150.finalproject.controller.GameManager;

/**
 * View class representing the game's manual
 * 
 * @author Jacob Adams
 * @author Julie Babylon
 * @author Ramon Caballero Villegas
 *
 */
public class Manual extends JPanel {

	private static final long serialVersionUID = 4556139318257082454L;

	private GameManager gameManager;
	private Image texture;
	private JButton quitToMainMenu;

	/**
	 * Initializes the manual
	 * 
	 * @param gameManager
	 *            - the game manager to use as an action listener
	 */
	public Manual(GameManager gameManager) {
		this.gameManager = gameManager;
		try {
			texture = ImageIO.read(new File("./resources/Manual.png"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		initManual();
	}

	private void initManual() {
		this.setLayout(new GridLayout(7, 7));

		quitToMainMenu = new JButton("Quit to Main Menu");
		quitToMainMenu.addActionListener(gameManager);
		
		this.setBackground(Color.white);

		for (int i = 0; i < 45; i++) {
			JPanel blank = new JPanel();
			blank.setBackground(Color.white);
			this.add(blank);
		}
		this.add(quitToMainMenu);
	}

	/**
	 * Draws the picture of the manual
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(texture, 0, 0, this.getWidth(), this.getHeight() - quitToMainMenu.getHeight(), null);
	}
}
