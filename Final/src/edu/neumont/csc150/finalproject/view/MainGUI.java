package edu.neumont.csc150.finalproject.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.neumont.csc150.finalproject.controller.GameManager;
import edu.neumont.csc150.finalproject.controller.InputControl;
import edu.neumont.csc150.finalproject.model.Game;
import edu.neumont.csc150.finalproject.model.Level;

public class MainGUI {
	private JFrame frame;
	private Game curGame;
	private JPanel curDisplay;
	private Manual manual;
	private MainMenu mainMenu;
	private LevelDisplay levelDisplay;
	private InputControl input;

	public MainGUI(GameManager gameManager, Level curLevel) {
		initGUI(gameManager, curLevel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
	}

	public void initGUI(GameManager gameManager, Level curLevel) {
		frame = new JFrame("Final Project Game");
		mainMenu = new MainMenu(gameManager);
		manual = new Manual(gameManager);
		levelDisplay = new LevelDisplay(curLevel);

		goToMainMenu();
//		goToLevel();
		frame.getContentPane().add(curDisplay);
	}

	public void render() {
		levelDisplay.repaint();
	}

	public void setGame(Game curGame) {
		this.curGame = curGame;
	}
	
	public void initListener() {
		input = new InputControl(curGame);
		levelDisplay.setFocusable(true);
		levelDisplay.requestFocusInWindow();
		levelDisplay.addKeyListener(input);		
	}

	public void swapLevel(Level curLevel) {
		this.curGame.swapLevel(curLevel);
		levelDisplay.swapLevel(curLevel);
	}

	public void goToMainMenu() {
		curDisplay = mainMenu;
		frame.getContentPane().remove(mainMenu);
		frame.getContentPane().add(mainMenu);
		frame.validate();
		mainMenu.repaint();
	}

	public void goToManual() {
		curDisplay = manual;
	}

	public void goToLevel() {
		curDisplay = levelDisplay;
		frame.getContentPane().removeAll();
		frame.getContentPane().add(levelDisplay);
		frame.validate();
		levelDisplay.repaint();
	}

	public void setVisible() {
		frame.setVisible(true);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	public int getWindowWidth() {
		return levelDisplay.getWidth();
	}
	
	public int getWindowHeight() {
		return levelDisplay.getHeight();
	}
}