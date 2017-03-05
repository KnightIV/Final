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

import edu.neumont.csc150.finalproject.model.*;
import edu.neumont.csc150.finalproject.view.*;

public class GameManager implements ActionListener {

	private Game curGame;
	private static final File FILE_SAVE = new File("save.box");
	private Timer timer;
	private ArrayList<Level> levels = new ArrayList<>();
	private int indexLevel = 0;
	private MainGUI view;

	public GameManager() {
		createLevels();
	}

	private void createLevels() {
		levels.add(level1());
		// levels.add(level2());
		// levels.add(level3());
	}

	private Level level1() {
		ArrayList<Platform> levelPlatforms = new ArrayList<>();
		ArrayList<Laser> levelLasers = new ArrayList<>();
		ArrayList<Button> levelButtons = new ArrayList<>();
		Door doorBlock = null;
		BoxCharacter player = null;

		// copy and paste the code generated from the level code generator
		levelPlatforms.add(new Platform(28, 26, 654, 50, null));
		levelPlatforms.add(new Platform(28, 53, 50, 1348, null));
		levelPlatforms.add(new Platform(54, 1375, 501, 50, null));
		levelPlatforms.add(new Platform(55, 267, 466, 50, null));
		levelPlatforms.add(new Platform(55, 529, 379, 50, null));
		levelPlatforms.add(new Platform(55, 1124, 344, 50, null));
		levelPlatforms.add(new Platform(205, 818, 350, 50, null));
		levelPlatforms.add(new Platform(275, 755, 160, 62, null));
		levelPlatforms.add(new Platform(435, 529, 50, 100, null));
		levelPlatforms.add(new Platform(461, 602, 344, 50, null));
		levelPlatforms.add(new Platform(556, 818, 50, 583, null));
		levelPlatforms.add(new Platform(579, 877, 204, 50, null));
		levelPlatforms.add(new Platform(683, 26, 50, 102, null));
		levelPlatforms.add(new Platform(709, 101, 341, 50, null));
		levelPlatforms.add(new Platform(784, 877, 23, 65, null));
		levelPlatforms.add(new Platform(806, 602, 25, 102, null));
		levelPlatforms.add(new Platform(808, 916, 342, 26, null));
		levelPlatforms.add(new Platform(832, 678, 340, 26, null));
		levelPlatforms.add(new Platform(1051, 101, 25, 124, null));
		levelPlatforms.add(new Platform(1077, 199, 352, 26, null));
		levelPlatforms.add(new Platform(1151, 916, 22, 176, null));
		levelPlatforms.add(new Platform(1173, 678, 26, 122, null));
		levelPlatforms.add(new Platform(1174, 1067, 355, 25, null));
		levelPlatforms.add(new Platform(1200, 775, 352, 25, null));
		levelPlatforms.add(new Platform(1430, 199, 25, 160, null));
		levelPlatforms.add(new Platform(1456, 334, 355, 25, null));
		levelPlatforms.add(new Platform(1530, 1067, 23, 188, null));
		levelPlatforms.add(new Platform(1553, 775, 25, 160, null));
		levelPlatforms.add(new Platform(1554, 1230, 278, 25, null));
		levelPlatforms.add(new Platform(1579, 909, 355, 26, null));
		levelPlatforms.add(new Platform(1812, 334, 25, 295, null));
		levelPlatforms.add(new Platform(1833, 1230, 22, 173, null));
		levelPlatforms.add(new Platform(1838, 517, 638, 25, null));
		levelPlatforms.add(new Platform(1856, 1377, 620, 26, null));
		levelPlatforms.add(new Platform(1935, 909, 25, 209, null));
		levelPlatforms.add(new Platform(1961, 1092, 145, 26, null));
		levelPlatforms.add(new Platform(2107, 908, 23, 210, null));
		levelPlatforms.add(new Platform(2477, 517, 23, 886, null));
		levelLasers.add(new Laser(1174, 995, 760, 25, true));
		levelLasers.add(new Laser(1200, 713, 1276, 25, true));

		ArrayList<Laser> firstButtonLasers = new ArrayList<>();
		firstButtonLasers.add(levelLasers.get(1));

		ArrayList<Laser> secondButtonLasers = new ArrayList<>();
		secondButtonLasers.add(levelLasers.get(0));

		levelButtons.add(new Button(195, 515, null, null));
		levelButtons.add(new Button(450, 804, null, secondButtonLasers));
		levelButtons.add(new Button(2019, 1079, null, firstButtonLasers));
		doorBlock = new Door(65, 58);
		player = new Crateon(156, 1267);

		return new Level(levelPlatforms, levelLasers, doorBlock, player, null, levelButtons);
	}

	private Level level2() {
		ArrayList<Platform> levelPlatforms = new ArrayList<>();
		ArrayList<Laser> levelLasers = new ArrayList<>();
		ArrayList<Button> levelButtons = new ArrayList<>();
		Door doorBlock = null;
		BoxCharacter player = null;
		// copy and paste the code generated from the level code generator

		return new Level(levelPlatforms, levelLasers, doorBlock, player, null, levelButtons);
	}

	private Level level3() {
		ArrayList<Platform> levelPlatforms = new ArrayList<>();
		ArrayList<Laser> levelLasers = new ArrayList<>();
		ArrayList<Button> levelButtons = new ArrayList<>();
		Door doorBlock = null;
		BoxCharacter player = null;
		// copy and paste the code generated from the level code generator

		return new Level(levelPlatforms, levelLasers, doorBlock, player, null, levelButtons);
	}

	public void run() {
		view = new MainGUI(this, levels.get(indexLevel));

		// call the main menu to display from the GUI
		view.goToMainMenu();
		view.setVisible();
		// startNewGame();
	}

	public void autoSave() throws IOException {
		ObjectOutputStream save = null;

		try {
			save = new ObjectOutputStream(new FileOutputStream(FILE_SAVE));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		save.writeObject(curGame);

		// display something to let the player know that the game has been saved
	}

	public void load() throws IOException {
		ObjectInputStream load = null;

		try {
			load = new ObjectInputStream(new FileInputStream(FILE_SAVE));
			load.close();
		} catch (FileNotFoundException e) {
			// let the player know that no save data exists

			e.printStackTrace();
			return;
		}

		try {
			curGame = (Game) load.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		/*
		 * let the player know that the game has been loaded, and then go to the
		 * level that they were on
		 */
		indexLevel = levels.indexOf(curGame.getCurLevel());
		curGame.reset();
		view.setGame(curGame);
		view.swapLevel(curGame.getCurLevel());
		view.goToLevel();
	}

	public void pause() {
		timer.stop();
	}

	public void resume() {
		timer.start();
	}

	public void switchLevel() {
		levels.remove(indexLevel);
		indexLevel++;
		curGame.swapLevel(levels.get(indexLevel));
	}

	private void startNewGame() {
		curGame = new Game(levels.get(indexLevel));
		view.setGame(curGame);
		view.swapLevel(levels.get(indexLevel));
		view.goToLevel();
		timer = new Timer((int) 50.0 / 3, this);
		timer.start();
		view.initListener();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(timer)) {
			// render the game through the GUI
			view.render();

			Level curLevel = curGame.getCurLevel();
			BoxCharacter curPlayer = curLevel.getPlayer();

			curPlayer.setyPos(curLevel.getPlayer().getyPos() + curLevel.getPlayer().getOwnYVector());
			curPlayer.setxPos(curLevel.getPlayer().getxPos() + curLevel.getPlayer().getOwnXVector());

			if (curLevel.isEndLevel()) {
				switchLevel();
			}

			// resets the game if the player falls out of the screen
			if (curPlayer.getxPos() < -curLevel.getPlayer().getWidth()
					|| curPlayer.getxPos() > view.getWindowWidth()
					|| curPlayer.getyPos() < -curLevel.getPlayer().getHeight()
					|| curPlayer.getyPos() > view.getWindowHeight()) {
				curGame.reset();
			}

			for (Laser l : curLevel.getLasers()) {
				if (curLevel.checkForPlayerCollision(l.getXPos(), l.getXPos() + l.getWidth(), l.getYPos(),
						l.getYPos() + l.getHeight()) && l.isOn()) {
					// display the death screen in the GUI

					break;
				}
			}

			// checks all the buttons in the level to see if they have been
			// triggered

			for (Button b : curLevel.getButtons()) {
				boolean isOnButton = curLevel.checkForPlayerCollision(b.getXPos(), b.getXPos() + b.getWidth(),
						b.getYPos(), b.getYPos() + b.getHeight());

				if (isOnButton && !curPlayer.isOnButton()) {
					b.trigger();
					curPlayer.setIsOnButton(true);
					break;
				} else if (!isOnButton) {
					curPlayer.setIsOnButton(false);
				}
			}

			// boolean hasTriggered = curLevel.checkForButtonTriggered();
			// if (hasTriggered && curLevel.getPlayer().isOnButton()) {
			// curLevel.getPlayer().setIsOnButton(true);
			// } else {
			// curLevel.getPlayer().setIsOnButton(false);
			// }

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
					if (crateon.getGravityDirection() == GravityDirection.DOWN) {
						curPlayer.setHasJumped(false);						
					}
				}
				// checks the lower hitbox
				else if (curLevel.checkForPlayerCollision(p.getXPos() + 1, p.getXPos() + p.getHitBox(false).width - 1,
						p.getYPos() + p.getHeight(), p.getYPos() + p.getHeight() + 1)) {
					curLevel.stopPlayer(true);
					curPlayer.setyPos(p.getYPos() + p.getHeight() + 1);
					if (crateon.getGravityDirection() == GravityDirection.UP) {
						curPlayer.setHasJumped(false);						
					}
				}

				// checks the right hitbox
				if (curLevel.checkForPlayerCollision(p.getXPos() + p.getWidth(), p.getXPos() + p.getWidth() + 1,
						p.getYPos() + 1, p.getYPos() + p.getHeight() - 1)) {
					curLevel.stopPlayer(false);
					curPlayer.setxPos(p.getXPos() + p.getWidth() + 2);
					if (crateon.getGravityDirection() == GravityDirection.LEFT) {
						curPlayer.setHasJumped(false);						
					}
				}
				// checks the left hitbox of the platform
				else if (curLevel.checkForPlayerCollision(p.getXPos() - 1, p.getXPos(), p.getYPos() + 1,
						p.getYPos() + p.getHeight() - 1)) {
					curLevel.stopPlayer(false);
					curPlayer.setxPos(p.getXPos() - curLevel.getPlayer().getWidth() - 2);
					if (crateon.getGravityDirection() == GravityDirection.RIGHT) {
						curPlayer.setHasJumped(false);						
					}
				}
			}

			// main menu options
		} else if (e.getSource() instanceof JButton) {
			JButton mainMenuButton = (JButton) e.getSource();

			switch (mainMenuButton.getText()) {
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
		}
	}
}
