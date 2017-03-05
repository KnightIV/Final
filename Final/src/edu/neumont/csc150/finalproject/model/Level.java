package edu.neumont.csc150.finalproject.model;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Level {

	private ArrayList<Platform> platforms;
	private ArrayList<Dimension> initPlatformPos = new ArrayList<>();
	private ArrayList<Laser> lasers;
	private ArrayList<Boolean> initLaserOn = new ArrayList<>();
	private Door finalDoor;
	private BoxCharacter player;
	private Dimension initPlayerPos;
	private Image background;
	private ArrayList<Button> buttons;

	public Level(ArrayList<Platform> platforms, ArrayList<Laser> lasers, Door finalDoor, BoxCharacter player,
			Image background, ArrayList<Button> buttons) {
		this.platforms = platforms;
		for (Platform p : platforms) {
			initPlatformPos.add(new Dimension(p.getXPos(), p.getYPos()));
		}

		this.lasers = lasers;
		for (Laser l : lasers) {
			initLaserOn.add(l.isOn());
		}

		this.finalDoor = finalDoor;
		this.player = player;
		initPlayerPos = new Dimension(player.getxPos(), player.getyPos());

		this.background = background;

		this.buttons = buttons;
	}

	public void playerPowerActivate(int keyCodePressed) {
		boolean isFarFromPlatform = false;
		for (Platform p : platforms) {
			if (isFarFromPlatform) {
				break;
			}

			// checks the right side of Casey
			isFarFromPlatform = keyCodePressed == KeyEvent.VK_D
					&& !checkForPlayerCollision(p.getXPos() + Casey.TELEPORT_DISTANCE,
							p.getXPos() + p.getWidth() + Casey.TELEPORT_DISTANCE, p.getYPos(),
							p.getYPos() + p.getHeight());

			if (isFarFromPlatform) {
				break;
			}

			// checks the left side of Casey
			isFarFromPlatform = keyCodePressed == KeyEvent.VK_A
					&& !checkForPlayerCollision(p.getXPos() - Casey.TELEPORT_DISTANCE,
							p.getXPos() + p.getWidth() - Casey.TELEPORT_DISTANCE, p.getYPos(),
							p.getYPos() + p.getHeight());

			if (isFarFromPlatform) {
				break;
			}

			// checks the bottom side of Casey
			isFarFromPlatform = keyCodePressed == KeyEvent.VK_S && !checkForPlayerCollision(p.getXPos(),
					p.getXPos() + p.getWidth(), p.getYPos() + Casey.TELEPORT_DISTANCE,
					p.getYPos() + p.getHeight() + Casey.TELEPORT_DISTANCE);

			if (isFarFromPlatform) {
				break;
			}

			// checks the top side of Casey
			isFarFromPlatform = keyCodePressed == KeyEvent.VK_W && !checkForPlayerCollision(p.getXPos(),
					p.getXPos() + p.getWidth(), p.getYPos() - Casey.TELEPORT_DISTANCE,
					p.getYPos() + p.getHeight() - Casey.TELEPORT_DISTANCE);

		}
		if (player instanceof Casey && isFarFromPlatform) {
			player.playerPowerActivate(keyCodePressed);
		} else if (player instanceof Crateon) {
			player.playerPowerActivate(keyCodePressed);
		}
	}

	public boolean checkForPlayerCollision(int leftObjX, int rightObjX, int upObjY, int downObjY) {
		return (player.getxPos() <= rightObjX) && (player.getxPos() + player.getWidth() >= leftObjX)
				&& (player.getyPos() <= downObjY) && (player.getyPos() + player.getHeight() >= upObjY);
	}

	public boolean isEndLevel() {
		return checkForPlayerCollision(finalDoor.getXPos(), finalDoor.getXPos() + finalDoor.getWidth(),
				finalDoor.getYPos(), finalDoor.getYPos() + finalDoor.getHeight()) && finalDoor.isOpen();
	}

	public void movePlayer(boolean isRight) {
		if (isRight) {
			player.moveRight();
		} else {
			player.moveLeft();
		}
	}

	public void stopPlayer(boolean verticalStop) {
		player.stop(verticalStop);
	}

	public void playerJump() {
		player.jump();
	}

	public void resetLevel() {
		for (int i = 0; i < platforms.size(); i++) {
			Dimension initPos = initPlatformPos.get(i);
			Platform platformToReset = platforms.get(i);

			platformToReset.setXPos(initPos.width);
			platformToReset.setYPos(initPos.height);
		}

		for (int i = 0; i < lasers.size(); i++) {
			Laser laserToReset = lasers.get(i);
			boolean isOn = laserToReset.isOn();

			laserToReset.setOn(isOn);
		}

		finalDoor.close();

		player.setxPos(initPlayerPos.width);
		player.setyPos(initPlayerPos.height);
	}

	public Image getBackground() {
		return background;
	}

	public ArrayList<Platform> getPlatforms() {
		return platforms;
	}

	public ArrayList<Laser> getLasers() {
		return lasers;
	}

	public Door getDoor() {
		return finalDoor;
	}

	public BoxCharacter getPlayer() {
		return player;
	}

	public ArrayList<Button> getButtons() {
		return buttons;
	}
}
