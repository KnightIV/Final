package edu.neumont.csc150.finalproject.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import edu.neumont.csc150.finalproject.controller.GameManager;

public class DeathScreen extends JPanel {

	private static final long serialVersionUID = 4165782181652962456L;

	private ImagePanel deathScreen;
	private GameManager gameManager;
	private JButton restartLevel, quitToMainMenu;
	private Image background;

	/**
	 * Constructor for the death screen
	 * 
	 * @param gameManager
	 *            - the game manager to use for the action listener for the
	 *            buttons
	 */
	public DeathScreen(GameManager gameManager) {
		this.gameManager = gameManager;
		this.setLayout(new BorderLayout());
		try {
			background = ImageIO.read(new File("./resources/DeathScreen.png"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		deathScreen = new ImagePanel(background);
		initDeathScreen();
	}

	private void initDeathScreen() {
		Dimension buttonSize = new Dimension(400, 100);
		deathScreen = new ImagePanel(background);
		deathScreen.getCont().setLayout(new BoxLayout(deathScreen.getCont(), BoxLayout.Y_AXIS));;
		deathScreen.repaint();
		
		restartLevel = new JButton("Restart Level");
		restartLevel.addActionListener(gameManager);
		restartLevel.setAlignmentX(Component.CENTER_ALIGNMENT);
		restartLevel.setPreferredSize(buttonSize);
		restartLevel.setMaximumSize(buttonSize);
		
		quitToMainMenu = new JButton("Quit to Main Menu");
		quitToMainMenu.addActionListener(gameManager);
		quitToMainMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
		quitToMainMenu.setPreferredSize(buttonSize);
		quitToMainMenu.setMaximumSize(buttonSize);
		
		deathScreen.getCont().add(new Box.Filler(new Dimension(0, 50), new Dimension(0, 300), new Dimension(0, 350)));
		deathScreen.getCont().add(restartLevel);
		
		deathScreen.getCont().add(new Box.Filler(new Dimension(0, 50), new Dimension(0, 300), new Dimension(0, 250)));
		deathScreen.getCont().add(quitToMainMenu);
		
		this.add(deathScreen);
		
		deathScreen.repaint();
	}
}