package edu.neumont.csc150.finalproject.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
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

public class GameManager implements ActionListener {

	public static final int FRAME_RATE = (int) 50.0 / 3;
	private Game curGame;
	private static final File FILE_SAVE = new File("save.box");
	private Timer timer;
	private ArrayList<Level> levels = new ArrayList<>();
	private int indexLevel = 0;
	private MainGUI view;
	private ArrayList<Button> buttonsPressed = new ArrayList<>();

	public GameManager() {
		try {
			createLevels();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void createLevels() throws IOException {
		levels.add(test());

		levels.add(level1());
		levels.add(level2());
		// levels.add(level3());
	}

	private Level test() throws IOException {
		ArrayList<Platform> levelPlatforms = new ArrayList<>();
		ArrayList<Laser> levelLasers = new ArrayList<>();
		ArrayList<Button> levelButtons = new ArrayList<>();
		Door doorBlock = null;
		BoxCharacter player = null;

		// copy and paste the code generated from the level code generator
		levelPlatforms.add(new Platform(28, 26, 654, 26));
		levelPlatforms.add(new Platform(28, 53, 26, 1348));
		levelPlatforms.add(new Platform(54, 1375, 501, 26));
		levelPlatforms.add(new Platform(55, 267, 466, 30));
		levelPlatforms.add(new Platform(55, 529, 379, 27));
		levelPlatforms.add(new Platform(55, 1124, 344, 26));
		levelPlatforms.add(new Platform(205, 818, 350, 25));
		levelPlatforms.add(new Platform(275, 755, 160, 65));
		levelPlatforms.add(new Platform(435, 529, 25, 100));
		levelPlatforms.add(new Platform(461, 602, 344, 27));
		levelPlatforms.add(new Platform(556, 818, 22, 583));
		levelPlatforms.add(new Platform(579, 877, 204, 26));
		levelPlatforms.add(new Platform(683, 26, 25, 102));
		levelPlatforms.add(new Platform(709, 101, 341, 27));
		levelPlatforms.add(new Platform(784, 877, 23, 65));
		levelPlatforms.add(new Platform(806, 602, 25, 102));
		levelPlatforms.add(new Platform(808, 916, 342, 26));
		levelPlatforms.add(new Platform(832, 678, 340, 26));
		levelPlatforms.add(new Platform(1051, 101, 25, 124));
		levelPlatforms.add(new Platform(1077, 199, 352, 26));
		levelPlatforms.add(new Platform(1151, 916, 22, 176));
		levelPlatforms.add(new Platform(1173, 678, 26, 122));
		levelPlatforms.add(new Platform(1174, 1067, 355, 25));
		levelPlatforms.add(new Platform(1200, 775, 352, 25));
		levelPlatforms.add(new Platform(1430, 199, 25, 160));
		levelPlatforms.add(new Platform(1456, 334, 355, 25));
		levelPlatforms.add(new Platform(1530, 1067, 23, 188));
		levelPlatforms.add(new Platform(1553, 775, 25, 160));
		levelPlatforms.add(new Platform(1554, 1230, 278, 25));
		levelPlatforms.add(new Platform(1579, 909, 355, 26));
		levelPlatforms.add(new Platform(1812, 334, 25, 295));
		levelPlatforms.add(new Platform(1833, 1230, 22, 173));
		levelPlatforms.add(new Platform(1838, 517, 638, 25));
		levelPlatforms.add(new Platform(1856, 1377, 620, 26));
		levelPlatforms.add(new Platform(1935, 909, 25, 209));
		levelPlatforms.add(new Platform(1961, 1092, 145, 26));
		levelPlatforms.add(new Platform(2107, 908, 23, 210));
		levelPlatforms.add(new Platform(2477, 517, 23, 886));

		levelLasers.add(new Laser(1174, 995, 760, 25, true));
		levelLasers.add(new Laser(1200, 713, 1276, 25, true));

		doorBlock = new Door(65, 58);

		ArrayList<Laser> firstButtonLasers = new ArrayList<>();
		firstButtonLasers.add(levelLasers.get(1));

		ArrayList<Laser> secondButtonLasers = new ArrayList<>();
		secondButtonLasers.add(levelLasers.get(0));

		doorBlock = new Door(65, 58);

		levelButtons.add(new Button(195, 515, doorBlock, null));
		levelButtons.add(new Button(450, 804, null, secondButtonLasers));
		levelButtons.add(new Button(2019, 1079, null, firstButtonLasers));
		player = new Casey(156, 1267);
		// player = new Crateon(156, 1267);

		return new Level(levelPlatforms, levelLasers, doorBlock, player, levelButtons);
	}

	private Level level1() throws IOException {
		ArrayList<Platform> levelPlatforms = new ArrayList<>();
		ArrayList<Laser> levelLasers = new ArrayList<>();
		ArrayList<Button> levelButtons = new ArrayList<>();
		Door doorBlock = null;
		BoxCharacter player = null;

		// copy and paste the code generated from the level code generator
		levelPlatforms.add(new Platform(0, 0, 2560, 135));
		levelPlatforms.add(new Platform(0, 138, 125, 1167));
		levelPlatforms.add(new Platform(717, 138, 363, 83));
		levelPlatforms.add(new Platform(2435, 138, 125, 1167));
		levelPlatforms.add(new Platform(127, 354, 378, 84));
		levelPlatforms.add(new Platform(127, 641, 328, 95));
		levelPlatforms.add(new Platform(1141, 641, 629, 190));
		levelPlatforms.add(new Platform(145, 818, 145, 487));
		levelPlatforms.add(new Platform(648, 1072, 176, 233));
		levelPlatforms.add(new Platform(1612, 1223, 145, 82));
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

		doorBlock = new Door(177, 225);

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
		levelPlatforms.add(new Platform(124, 315, 222, 291));
		levelPlatforms.add(new Platform(191, 760, 253, 23));
		levelPlatforms.add(new Platform(347, 390, 199, 216));
		levelPlatforms.add(new Platform(615, 1213, 293, 63));
		levelPlatforms.add(new Platform(909, 1152, 323, 124));
		levelPlatforms.add(new Platform(1233, 1020, 269, 256));
		levelPlatforms.add(new Platform(1240, 589, 189, 19));
		levelPlatforms.add(new Platform(1502, 1021, 104, 255));
		levelPlatforms.add(new Platform(1515, 1020, 91, 1));
		levelPlatforms.add(new Platform(2092, 555, 112, 134));
		levelPlatforms.add(new Platform(2108, 284, 250, 20));
		levelPlatforms.add(new Platform(2205, 555, 158, 234));
		levelPlatforms.add(new Platform(2364, 104, 114, 1172));
		levelPlatforms.add(new Platform(645, 1039, 194, 20, -25, 0, false, true, 2));
		levelPlatforms.add(new Platform(926, 234, 166, 20, 12, 0, false, true, 1));
		levelPlatforms.add(new Platform(1810, 817, 166, 20, 0, -8, true, false, 1));

		levelButtons.add(new Button(142, 297, null, null));
		levelButtons.add(new Button(227, 742, null, null));
		levelButtons.add(new Button(2279, 266, null, null));

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

		doorBlock = new Door(183, 1148);

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

		return new Level(levelPlatforms, levelLasers, doorBlock, player, levelButtons);
	}

	public void run() {
		view = new MainGUI(this, levels.get(indexLevel));

		// call the main menu to display from the GUI
		view.goToMainMenu();
		view.setVisible();
		// startNewGame();
	}

	public void autoSave() throws IOException {
		ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream(FILE_SAVE));

		save.writeObject(curGame);
		save.close();

		// display something to let the player know that the game has been saved
	}

	public void load() throws IOException {
		ObjectInputStream load = new ObjectInputStream(new FileInputStream(FILE_SAVE));

		try {
			curGame = (Game) load.readObject();
		} catch (ClassNotFoundException e) {
			// let the player know that there is no file to load
			e.printStackTrace();
			load.close();
			return;
		}

		/*
		 * let the player know that the game has been loaded, and then go to the
		 * level that they were on
		 */
		load.close();
		indexLevel = curGame.getCurLevel().getId() - 1;
		if (indexLevel + 1 == levels.size()) {
			indexLevel = -1;
		}
		switchLevel();
	}

	public void pause() {
		timer.stop();
	}

	public void resume() {
		timer.start();
	}

	public void switchLevel() {
		indexLevel++;
		if (indexLevel != levels.size()) {
			curGame.swapLevel(levels.get(indexLevel));
			view.setGame(curGame);
			view.swapLevel(levels.get(indexLevel));
			view.goToLevel();
			timer = new Timer(FRAME_RATE, this);
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

			// resets the game if the player falls out of the screen
			if (curPlayer.getxPos() < -curLevel.getPlayer().getWidth() || curPlayer.getxPos() > view.getWindowWidth()
					|| curPlayer.getyPos() < -curLevel.getPlayer().getHeight()
					|| curPlayer.getyPos() > view.getWindowHeight()) {
				curGame.reset();
			}

			for (Laser l : curLevel.getLasers()) {
				if (curLevel.checkForPlayerCollision(l.getXPos(), l.getXPos() + l.getWidth(), l.getYPos(),
						l.getYPos() + l.getHeight()) && l.isOn()) {
					// display the death screen in the GUI
					view.goToDeathScreen();
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
				if (curLevel.checkForPlayerCollision(p.getXPos() + 1, p.getXPos() + p.getHitBox(false).width - 1,
						p.getYPos(), p.getYPos())) {
					curLevel.stopPlayer(true);
					curPlayer.setyPos(p.getYPos() - curLevel.getPlayer().getHeight() - 1);
					if (crateon != null && crateon.getGravityDirection() == GravityDirection.DOWN) {
						crateon.setHasJumped(false);
					} else if (curPlayer instanceof Casey) {
						curPlayer.setHasJumped(false);
					}
					curPlayer.setOtherXVector(p.getXVector());
				}
				// checks the lower hitbox
				else if (curLevel.checkForPlayerCollision(p.getXPos() + 1, p.getXPos() + p.getHitBox(false).width - 1,
						p.getYPos() + p.getHeight(), p.getYPos() + p.getHeight() + 1)) {
					curLevel.stopPlayer(true);
					curPlayer.setyPos(p.getYPos() + p.getHeight() + 1);
					if (crateon != null && crateon.getGravityDirection() == GravityDirection.UP) {
						crateon.setHasJumped(false);
					}
				}

				// checks the right hitbox
				if (curLevel.checkForPlayerCollision(p.getXPos() + p.getWidth(), p.getXPos() + p.getWidth() + 1,
						p.getYPos() + 1, p.getYPos() + p.getHeight() - 1)) {
					curLevel.stopPlayer(false);
					curPlayer.setxPos(p.getXPos() + p.getWidth() + 1);
					if (crateon != null && crateon.getGravityDirection() == GravityDirection.LEFT) {
						crateon.setHasJumped(false);
					}
				}
				// checks the left hitbox of the platform
				else if (curLevel.checkForPlayerCollision(p.getXPos() - 1, p.getXPos(), p.getYPos() + 1,
						p.getYPos() + p.getHeight() - 1)) {
					curLevel.stopPlayer(false);
					curPlayer.setxPos(p.getXPos() - curLevel.getPlayer().getWidth() - 1);
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
				break;

			case "Quit to Main Menu":
				view.goToMainMenu();
				break;
			}
		}
	}
}