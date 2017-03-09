package edu.neumont.csc150.finalproject.view;

import java.awt.Font;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import edu.neumont.csc150.finalproject.controller.GameManager;
import edu.neumont.csc150.finalproject.controller.InputControl;
import edu.neumont.csc150.finalproject.model.Game;
import edu.neumont.csc150.finalproject.model.Level;

/**
 * Class housing all GUI compartments for the game
 * 
 * @author Jacob Adams
 * @author Julie Babylon
 * @author Ramon Caballero Villegas
 *
 */
public class MainGUI {
	private JFrame frame;
	private Game curGame;
	
	private Manual manual;
	private MainMenu mainMenu;
	private LevelDisplay levelDisplay;
	private DeathScreen deathScreen;
	private StoryLine storyLine;
	
	private InputControl input;
	private AudioInputStream audioInputStream;
	private Clip clip;

	/**
	 * Constructor for the GUI
	 * 
	 * @param gameManager
	 *            - the game manager to use as the ActionListener
	 * @param curLevel
	 *            - the current level the game is in
	 */
	public MainGUI(GameManager gameManager, Level curLevel) {
		initGUI(gameManager, curLevel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
	}

	private void initGUI(GameManager gameManager, Level curLevel) {
		UIManager.put("Button.font", new Font("Comic Sans MS", Font.BOLD, 30));
		UIManager.put("OptionPane.messageFont", new Font("Comic Sans MS", Font.BOLD, 45));
		frame = new JFrame("Think Inside the Box");
		mainMenu = new MainMenu(gameManager);
		manual = new Manual(gameManager);
		levelDisplay = new LevelDisplay(curLevel);
		deathScreen = new DeathScreen(gameManager);

		goToMainMenu();
	}

	/**
	 * Renders the level
	 */
	public void render() {
		levelDisplay.repaint();
	}

	/**
	 * Sets the current game playing
	 * 
	 * @param curGame
	 *            - the current game
	 */
	public void setGame(Game curGame) {
		this.curGame = curGame;
	}

	/**
	 * Initializes the keyboard listener for the game. Should be called after a
	 * new level is set
	 */
	public void initListener() {
		levelDisplay.removeKeyListener(input);
		input = new InputControl(curGame);
		levelDisplay.setFocusable(true);
		levelDisplay.requestFocusInWindow();
		levelDisplay.addKeyListener(input);
	}

	/**
	 * Swaps out the current level with the next level that the player is on
	 * 
	 * @param curLevel
	 *            - the level the player is going to
	 */
	public void swapLevel(Level curLevel) {
		levelDisplay.swapLevel(curLevel);
	}

	/**
	 * Displays the main menu
	 */
	public void goToMainMenu() {
		playSong(new File("./Music/mainmenu.wav"));
		frame.getContentPane().removeAll();
		frame.getContentPane().add(mainMenu);
		frame.validate();
		mainMenu.repaint();
	}

	/**
	 * Displays the manual
	 */
	public void goToManual() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(manual);
		frame.validate();
		manual.repaint();
	}

	/**
	 * Displays the current level
	 */
	public void goToLevel() {
		playSong(new File("./Music/levelmusic.wav"));
		frame.getContentPane().removeAll();
		frame.getContentPane().add(levelDisplay);
		frame.validate();
		levelDisplay.repaint();
	}

	/**
	 * Displays the death screen
	 */
	public void goToDeathScreen() {
		playSong(new File("./Music/deathscreen2.wav"));
		frame.getContentPane().removeAll();
		frame.getContentPane().add(deathScreen);
		frame.validate();
		deathScreen.repaint();
	}

	/**
	 * Displays part of the story
	 */
	public void goToStoryLine() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(storyLine);
		frame.validate();
		storyLine.repaint();
	}

	/**
	 * Sets the window to visible
	 */
	public void setVisible() {
		frame.setVisible(true);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	/**
	 * Plays a specified song in .wav form from a file
	 * 
	 * @param song
	 *            - the file in which the song is located
	 */
	public void playSong(File song) {
		if (clip != null) {
			clip.close();
		}
		try {
			audioInputStream = AudioSystem.getAudioInputStream(song);
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Displays an error for the player
	 * 
	 * @param err
	 *            - the string to display
	 */
	public void showErrorMessage(String err) {
		JOptionPane.showMessageDialog(null, err, "ERROR", JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * 
	 * @return the width of the window
	 */
	public int getWindowWidth() {
		return levelDisplay.getWidth();
	}

	/**
	 * 
	 * @return the height of the window
	 */
	public int getWindowHeight() {
		return levelDisplay.getHeight();
	}
}