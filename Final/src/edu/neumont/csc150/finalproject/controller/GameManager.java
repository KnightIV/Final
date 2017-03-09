package edu.neumont.csc150.finalproject.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.Timer;

import edu.neumont.csc150.finalproject.model.BoxCharacter;
import edu.neumont.csc150.finalproject.model.Button;
import edu.neumont.csc150.finalproject.model.Casey;
import edu.neumont.csc150.finalproject.model.Crateon;
import edu.neumont.csc150.finalproject.model.Door;
import edu.neumont.csc150.finalproject.model.Game;
import edu.neumont.csc150.finalproject.model.GravityDirection;
import edu.neumont.csc150.finalproject.model.Laser;
import edu.neumont.csc150.finalproject.model.Level;
import edu.neumont.csc150.finalproject.model.Platform;
import edu.neumont.csc150.finalproject.view.MainGUI;

/**
 * Overall logic management for the game
 * 
 * @author Jacob Adams
 * @author Julie Babylon
 * @author Ramon Caballero Villegas
 *
 */
public class GameManager implements ActionListener {

	/**
	 * The refresh rate of the screen
	 */
	public static final int FRAME_RATE = (int) 60.0 / 3;

	private Game curGame;
	private static final File FILE_SAVE = new File("save.box");
	private Timer timer;
	private ArrayList<Level> levels = new ArrayList<>();
	private int indexLevel = 0;
	private MainGUI view;
	private ArrayList<Button> buttonsPressed = new ArrayList<>();

	/**
	 * Default constructor of the game manager, which assembles all of the
	 * levels
	 */
	public GameManager() {
		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		try {
			createLevels();
		} catch (IOException e) {
			e.printStackTrace();
		}
		timer = new Timer(FRAME_RATE, this);
	}

	private void createLevels() throws IOException {
		levels.add(level1());
		levels.add(level2());
		levels.add(level3());
	}

	private Level level1() throws IOException {
		ArrayList<Platform> levelPlatforms = new ArrayList<>();
		ArrayList<Laser> levelLasers = new ArrayList<>();
		ArrayList<Button> levelButtons = new ArrayList<>();
		Door doorBlock = null;
		BoxCharacter player = null;

		// copy and paste the code generated from the level code generator
		levelPlatforms.add(new Platform(0, 0, 2560, 135));
		levelPlatforms.add(new Platform(0, 120, 125, 1200));
		levelPlatforms.add(new Platform(717, 120, 363, 120));
		levelPlatforms.add(new Platform(2435, 138, 125, 1167));
		levelPlatforms.add(new Platform(127, 354, 378, 84));
		levelPlatforms.add(new Platform(127, 641, 328, 95));
		levelPlatforms.add(new Platform(1141, 641, 629, 190));
		levelPlatforms.add(new Platform(145, 818, 145, 500));
		levelPlatforms.add(new Platform(648, 1072, 176, 250));
		levelPlatforms.add(new Platform(1612, 1223, 145, 95));
		levelPlatforms.add(new Platform(1759, 1122, 301, 183));
		levelPlatforms.add(new Platform(2062, 1033, 372, 272));
		levelPlatforms.add(new Platform(0, 1307, 2560, 133));

		levelLasers.add(new Laser(124, 790, 1017, 18, true));
		levelLasers.add(new Laser(1080, 165, 1354, 17, true));
		levelLasers.add(new Laser(1447, 137, 17, 28, true));
		levelLasers.add(new Laser(1447, 182, 17, 465, true));
		levelLasers.add(new Laser(1651, 832, 18, 391, true));
		levelLasers.add(new Laser(2390, 137, 17, 28, true));
		levelLasers.add(new Laser(2390, 182, 17, 851, true));
		levelLasers.add(new Laser(2407, 164, 1, 1, true));

		doorBlock = new Door(177, 165);

		ArrayList<Laser> secondButtonLasers = new ArrayList<>();
		secondButtonLasers.add(levelLasers.get(4));

		ArrayList<Laser> thirdButtonLasers = new ArrayList<>();
		thirdButtonLasers.add(levelLasers.get(2));
		thirdButtonLasers.add(levelLasers.get(3));

		levelButtons.add(new Button(202, 619, doorBlock, null));
		levelButtons.add(new Button(289, 1215, null, secondButtonLasers));
		levelButtons.add(new Button(1302, 831, null, thirdButtonLasers));

		player = new Crateon(1057, 1253);

		return new Level(levelPlatforms, levelLasers, doorBlock, player, levelButtons);
	}

	private Level level2() throws IOException {
		ArrayList<Platform> levelPlatforms = new ArrayList<>();
		ArrayList<Laser> levelLasers = new ArrayList<>();
		ArrayList<Button> levelButtons = new ArrayList<>();
		Door doorBlock = null;
		BoxCharacter player = null;
		// copy and paste the code generated from the level code generator
		levelPlatforms.add(new Platform(2, 104, 121, 1172));
		levelPlatforms.add(new Platform(2, 1278, 2476, 99));
		levelPlatforms.add(new Platform(3, 3, 2474, 99));
		levelPlatforms.add(new Platform(124, 315, 230, 291));
		levelPlatforms.add(new Platform(191, 760, 253, 23));
		levelPlatforms.add(new Platform(347, 390, 199, 216));
		levelPlatforms.add(new Platform(615, 1213, 293, 63));
		levelPlatforms.add(new Platform(909, 1152, 323, 124));
		levelPlatforms.add(new Platform(1233, 1020, 269, 300));
		levelPlatforms.add(new Platform(1380, 589, 189, 19));
		levelPlatforms.add(new Platform(1502, 1021, 104, 300));
		levelPlatforms.add(new Platform(1515, 1020, 91, 1));
		levelPlatforms.add(new Platform(2092, 555, 120, 134));
		levelPlatforms.add(new Platform(2108, 284, 250, 20));
		levelPlatforms.add(new Platform(2205, 555, 158, 234));
		levelPlatforms.add(new Platform(2364, 104, 114, 1200));
		levelPlatforms.add(new Platform(645, 1039, 194, 20, -25, 0, false, true, 2));
		levelPlatforms.add(new Platform(926, 300, 166, 20, 12, 0, false, true, 1));
		levelPlatforms.add(new Platform(1810, 817, 166, 20, 0, -8, true, false, 1));

		levelLasers.add(new Laser(123, 1026, 1110, 13, true));
		levelLasers.add(new Laser(123, 1056, 1110, 13, true));
		levelLasers.add(new Laser(123, 1082, 1110, 13, true));
		levelLasers.add(new Laser(487, 606, 13, 420, true));
		levelLasers.add(new Laser(487, 1039, 13, 17, true));
		levelLasers.add(new Laser(487, 1069, 13, 13, true));
		levelLasers.add(new Laser(487, 1095, 13, 183, true));
		levelLasers.add(new Laser(1429, 102, 13, 918, true));
		levelLasers.add(new Laser(1454, 102, 13, 918, true));
		levelLasers.add(new Laser(1478, 102, 13, 918, true));
		levelLasers.add(new Laser(1502, 102, 13, 919, true));
		levelLasers.add(new Laser(1526, 102, 13, 918, true));
		levelLasers.add(new Laser(1549, 102, 13, 918, true));
		levelLasers.add(new Laser(1574, 102, 13, 918, true));

		ArrayList<Laser> firstButtonLasers = new ArrayList<>();
		firstButtonLasers.add(levelLasers.get(3));
		firstButtonLasers.add(levelLasers.get(4));
		firstButtonLasers.add(levelLasers.get(5));
		firstButtonLasers.add(levelLasers.get(6));

		ArrayList<Laser> thirdButtonLasers = new ArrayList<>();
		thirdButtonLasers.add(levelLasers.get(13));
		thirdButtonLasers.add(levelLasers.get(12));
		thirdButtonLasers.add(levelLasers.get(11));
		thirdButtonLasers.add(levelLasers.get(10));
		thirdButtonLasers.add(levelLasers.get(9));
		thirdButtonLasers.add(levelLasers.get(8));
		thirdButtonLasers.add(levelLasers.get(7));
		firstButtonLasers.add(levelLasers.get(0));

		doorBlock = new Door(183, 1080);

		levelButtons.add(new Button(142, 297, null, firstButtonLasers));
		levelButtons.add(new Button(227, 742, doorBlock, null));
		levelButtons.add(new Button(2279, 266, null, thirdButtonLasers));

		player = new Casey(1925, 1230);

		return new Level(levelPlatforms, levelLasers, doorBlock, player, levelButtons);
	}

	private Level level3() {
		ArrayList<Platform> levelPlatforms = new ArrayList<>();
		ArrayList<Laser> levelLasers = new ArrayList<>();
		ArrayList<Button> levelButtons = new ArrayList<>();
		Door doorBlock = null;
		BoxCharacter player = null;
		// copy and paste the code generated from the level code generator
		levelPlatforms.add(new Platform(2, 90, 121, 1172));
		levelPlatforms.add(new Platform(2, 1250, 2600, 200));
		levelPlatforms.add(new Platform(3, 3, 2600, 99));
		levelPlatforms.add(new Platform(110, 685, 270, 239));
		levelPlatforms.add(new Platform(319, 342, 750, 119));
		levelPlatforms.add(new Platform(372, 685, 283, 121));
		levelPlatforms.add(new Platform(553, 1160, 1392, 130));
		levelPlatforms.add(new Platform(808, 95, 290, 365));
		levelPlatforms.add(new Platform(996, 1050, 771, 120));
		levelPlatforms.add(new Platform(1269, 1010, 258, 90));
		levelPlatforms.add(new Platform(1360, 562, 428, 192));
		levelPlatforms.add(new Platform(1665, 754, 373, 71));
		levelPlatforms.add(new Platform(1788, 650, 250, 104));
		levelPlatforms.add(new Platform(2037, 305, 325, 53));
		levelPlatforms.add(new Platform(2090, 890, 200, 30, 0, -10, true, false, 1));
		levelPlatforms.add(new Platform(2364, 104, 200, 1172));

		levelLasers.add(new Laser(655, 711, 705, 13, true));
		levelLasers.add(new Laser(1415, 754, 13, 255, true));
		levelLasers.add(new Laser(2006, 102, 13, 548, false));
		levelLasers.add(new Laser(2140, 102, 13, 203, true));
		levelLasers.add(new Laser(2341, 358, 13, 920, true));

		doorBlock = new Door(2215, 120);
		player = new Crateon(271, 1215);

		ArrayList<Laser> firstButtonLasers = new ArrayList<>();
		firstButtonLasers.add(levelLasers.get(0));
		firstButtonLasers.add(levelLasers.get(2));

		ArrayList<Laser> secondButtonLasers = new ArrayList<>();
		secondButtonLasers.add(levelLasers.get(1));

		ArrayList<Laser> thirdButtonLasers = new ArrayList<>();
		thirdButtonLasers.add(levelLasers.get(3));

		levelButtons.add(new Button(476, 806, null, firstButtonLasers));
		levelButtons.add(new Button(723, 317, null, secondButtonLasers));
		levelButtons.add(new Button(1093, 190, doorBlock, thirdButtonLasers));

		return new Level(levelPlatforms, levelLasers, doorBlock, player, levelButtons);
	}

	/**
	 * Starts the application by going to the main menu
	 */
	public void run() {
		view = new MainGUI(this, levels.get(indexLevel));

		// call the main menu to display from the GUI
		view.goToMainMenu();
		view.setVisible();
		
	}

	/**
	 * Saves the current state of the game to a predetermined relative file path
	 * 
	 * @throws IOException
	 */
	public void autoSave() throws IOException {
		ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream(FILE_SAVE));

		save.writeObject(curGame);
		save.close();
	}

	/**
	 * Loads the game from a predetermined relative file path
	 * 
	 * @throws IOException
	 */
	public void load() throws IOException {
		ObjectInputStream load = null;

		try {
			load = new ObjectInputStream(new FileInputStream(FILE_SAVE));
		} catch (FileNotFoundException ex) {
			view.showErrorMessage("No saved game exists!");
			ex.printStackTrace();
			return;
		}

		try {
			curGame = (Game) load.readObject();
		} catch (ClassNotFoundException e) {
			view.showErrorMessage("No saved game exists!");
			e.printStackTrace();
			load.close();
			return;
		}

		load.close();
		indexLevel = curGame.getCurLevel().getId() - 1;
		if (indexLevel + 1 == levels.size()) {
			indexLevel = -1;
		}
		switchLevel();
	}

	/**
	 * Pauses the game
	 */
	public void pause() {
		timer.stop();
	}

	/**
	 * Resumes the game
	 */
	public void resume() {
		timer.start();
	}

	/**
	 * Goes to the next level that the player was on
	 */
	public void switchLevel() {
		indexLevel++;
		if (indexLevel < levels.size()) {
			curGame.swapLevel(levels.get(indexLevel));
			view.setGame(curGame);
			view.swapLevel(levels.get(indexLevel));
			view.goToLevel();
			timer.start();
			view.initListener();
			curGame.reset();
		} else {
			// put story
			view.goToMainMenu();
		}
	}

	private void startNewGame() {
		indexLevel = -1;
		curGame = new Game();
		switchLevel();
	}

	/**
	 * Handles main menu selections, as well as collisions and special
	 * conditions in the level
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(timer)) {
			// render the game through the GUI
			view.render();

			Level curLevel = curGame.getCurLevel();
			BoxCharacter curPlayer = curLevel.getPlayer();

			curPlayer.setyPos(curPlayer.getyPos() + curPlayer.getOwnYVector() + curPlayer.getOtherYVector());
			curPlayer.setxPos(curPlayer.getxPos() + curPlayer.getOwnXVector() + curPlayer.getOtherXVector());

			if (curLevel.isEndLevel()) {
				switchLevel();
				try {
					autoSave();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

			if (curPlayer.getxPos() < -curLevel.getPlayer().getWidth() || curPlayer.getxPos() > view.getWindowWidth()
					|| curPlayer.getyPos() < -curLevel.getPlayer().getHeight()
					|| curPlayer.getyPos() > view.getWindowHeight()) {
				view.goToDeathScreen();
				pause();
			}

			for (Laser l : curLevel.getLasers()) {
				if (curLevel.checkForPlayerCollision(l.getXPos(), l.getXPos() + l.getWidth(), l.getYPos(),
						l.getYPos() + l.getHeight()) && l.isOn()) {
					view.goToDeathScreen();
					pause();
					break;
				}
			}

			// checks all the buttons in the level to see if they have been
			// triggered
			for (Button b : curLevel.getButtons()) {
				if (curLevel.checkForPlayerCollision(b.getXPos(), b.getXPos() + b.getWidth(), b.getYPos(),
						b.getYPos() + b.getHeight())) {
					if (!buttonsPressed.contains(b)) {
						buttonsPressed.add(b);
						b.setPlayerOnButton(true);
					}
				} else if (buttonsPressed.contains(b)) {
					buttonsPressed.remove(b);
					b.setPlayerOnButton(false);
				}
			}

			for (Button bPressed : buttonsPressed) {
				if (bPressed.isPlayerOnButton()) {
					bPressed.trigger();
					bPressed.setPlayerOnButton(false);
				}
			}

			for (Platform p : curLevel.getPlatforms()) {

				Crateon crateon = null;

				if (curPlayer instanceof Crateon) {
					crateon = (Crateon) curPlayer;
				}

				// checks the upper hitbox
				if (curLevel.checkForPlayerCollision(p.getxPos() + 1, p.getxPos() + p.getHitBox(false).width - 1,
						p.getyPos(), p.getyPos())) {
					curLevel.stopPlayer(true);
					curPlayer.setyPos(p.getyPos() - curLevel.getPlayer().getHeight() - 1);
					if (crateon != null && crateon.getGravityDirection() == GravityDirection.DOWN) {
						crateon.setHasJumped(false);
					} else if (curPlayer instanceof Casey) {
						curPlayer.setHasJumped(false);
					}
					curPlayer.setOtherXVector(p.getXVector());
				}
				// checks the lower hitbox
				else if (curLevel.checkForPlayerCollision(p.getxPos() + 1, p.getxPos() + p.getHitBox(false).width - 1,
						p.getyPos() + p.getHeight(), p.getyPos() + p.getHeight() + 1)) {
					curLevel.stopPlayer(true);
					curPlayer.setyPos(p.getyPos() + p.getHeight() + 1);
					if (crateon != null && crateon.getGravityDirection() == GravityDirection.UP) {
						crateon.setHasJumped(false);
					}
				}

				// checks the right hitbox
				if (curLevel.checkForPlayerCollision(p.getxPos() + p.getWidth(), p.getxPos() + p.getWidth() + 1,
						p.getyPos() + 1, p.getyPos() + p.getHeight() - 1)) {
					curLevel.stopPlayer(false);
					curPlayer.setxPos(p.getxPos() + p.getWidth() + 1);
					if (crateon != null && crateon.getGravityDirection() == GravityDirection.LEFT) {
						crateon.setHasJumped(false);
					}
				}
				// checks the left hitbox of the platform
				else if (curLevel.checkForPlayerCollision(p.getxPos() - 1, p.getxPos(), p.getyPos() + 1,
						p.getyPos() + p.getHeight() - 1)) {
					curLevel.stopPlayer(false);
					curPlayer.setxPos(p.getxPos() - curLevel.getPlayer().getWidth() - 1);
					if (crateon != null && crateon.getGravityDirection() == GravityDirection.RIGHT) {
						curPlayer.setHasJumped(false);
					}
				}
			}

			// main menu options
		} else if (e.getSource() instanceof JButton) {
			JButton button = (JButton) e.getSource();

			// cases for the main menu
			switch (button.getText()) {
			case "New Game":
				startNewGame();
				break;

			case "Load Game":
				try {
					load();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				break;

			case "Manual":
				view.goToManual();
				break;

			case "Quit Game":
				System.exit(0);
				break;
			}

			// cases for the death screen
			switch (button.getText()) {
			case "Restart Level":
				curGame.reset();
				view.goToLevel();
				view.initListener();
				resume();
				break;

			case "Quit to Main Menu":
				view.goToMainMenu();
				break;
			}
		}
	}
}