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

/**
 * Class to hold all the options for the main menu
 * @author Jacob Adams
 * @author Julie Babylon
 * @author Ramon Caballero Villegas
 *
 */
public class MainMenu extends JPanel{
	
	private static final long serialVersionUID = 6810141084380699742L;
	
	private GameManager gameManager;
	private JButton newGame, loadGame, quitGame, manual;
	private ImagePanel menu;
	private Image background;
	
	/**
	 * Constructor for the main menu
	 * @param gameManager - the game manager to use for the action listener for the buttons
	 */
	public MainMenu(GameManager gameManager) {
		this.gameManager = gameManager;
		this.setLayout(new BorderLayout());
		try {
			background = ImageIO.read(new File("./resources/maingui1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		initMenu();
	}
	
	private void initMenu() {
		Dimension buttonSize = new Dimension(300, 70);
		menu = new ImagePanel(background);
		menu.getCont().setLayout(new BoxLayout(menu.getCont(), BoxLayout.Y_AXIS));;
		
		menu.repaint();
		
		newGame = new JButton("New Game");
		newGame.addActionListener(gameManager);
		newGame.setAlignmentX(Component.CENTER_ALIGNMENT);
		newGame.setPreferredSize(buttonSize);
		newGame.setMaximumSize(buttonSize);
		
		loadGame = new JButton("Load Game");
		loadGame.addActionListener(gameManager);
		loadGame.setAlignmentX(Component.CENTER_ALIGNMENT);
		loadGame.setPreferredSize(buttonSize);
		loadGame.setMaximumSize(buttonSize);
		
		quitGame = new JButton("Quit Game");
		quitGame.addActionListener(gameManager);
		quitGame.setAlignmentX(Component.CENTER_ALIGNMENT);
		quitGame.setPreferredSize(buttonSize);
		quitGame.setMaximumSize(buttonSize);
		
		manual = new JButton("Manual");
		manual.addActionListener(gameManager);
		manual.setAlignmentX(Component.CENTER_ALIGNMENT);
		manual.setPreferredSize(buttonSize);
		manual.setMaximumSize(buttonSize);
		
		menu.getCont().add(new Box.Filler(new Dimension(0, 50), new Dimension(0, 300), new Dimension(0, 350)));
		menu.getCont().add(newGame);
		menu.getCont().add(new Box.Filler(new Dimension(0, 50), new Dimension(0, 300), new Dimension(0, 200)));
		
		menu.getCont().add(loadGame);

		menu.getCont().add(new Box.Filler(new Dimension(0, 50), new Dimension(0, 300), new Dimension(0, 200)));
		menu.getCont().add(manual);		
		menu.getCont().add(new Box.Filler(new Dimension(0, 50), new Dimension(0, 300), new Dimension(0, 200)));
		menu.getCont().add(quitGame);
		menu.getCont().add(new Box.Filler(new Dimension(0, 50), new Dimension(0, 300), new Dimension(0, 200)));
		
		this.add(menu);
		
		menu.repaint();
	}
}
