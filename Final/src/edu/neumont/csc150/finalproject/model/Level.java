package edu.neumont.csc150.finalproject.model;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.util.ArrayList;

/*
 * TODO move the Image background to an ArrayList in the GameManager class, one for each level
 * 
 * This will prevent the NotSerializableException fo image
 */
public class Level implements Serializable {

	private static final long serialVersionUID = -5658795115954727298L;
	
	private int id;
	private static int counterID = 0;
	private ArrayList<Platform> platforms;
	private ArrayList<Dimension> initPlatformPos = new ArrayList<>();
	private ArrayList<Laser> lasers;
	private ArrayList<Boolean> initLaserOn = new ArrayList<>();
	private Door finalDoor;
	private BoxCharacter player;
	private Dimension initPlayerPos;
	private ArrayList<Button> buttons;

	public Level(ArrayList<Platform> platforms, ArrayList<Laser> lasers, Door finalDoor, BoxCharacter player, ArrayList<Button> buttons) {
		this.platforms = platforms;
		for (Platform p : platforms) {
			initPlatformPos.add(new Dimension(p.getxPos(), p.getyPos()));
		}

		this.lasers = lasers;
		for (Laser l : lasers) {
			initLaserOn.add(l.isOn());
		}

		this.finalDoor = finalDoor;
		this.player = player;
		initPlayerPos = new Dimension(player.getxPos(), player.getyPos());

		this.buttons = buttons;
		setId(counterID);
		counterID++;
	}

	public void playerPowerActivate(int keyCodePressed) {
		boolean isFarFromPlatform = false;
		for (Platform p : platforms) {
			if (isFarFromPlatform) {
				break;
			}

			// checks the right side of Casey
			isFarFromPlatform = keyCodePressed == KeyEvent.VK_D
					&& !checkForPlayerCollision(p.getxPos() + Casey.TELEPORT_DISTANCE,
							p.getxPos() + p.getWidth() + Casey.TELEPORT_DISTANCE, p.getyPos(),
							p.getyPos() + p.getHeight());

			if (isFarFromPlatform) {
				break;
			}

			// checks the left side of Casey
			isFarFromPlatform = keyCodePressed == KeyEvent.VK_A
					&& !checkForPlayerCollision(p.getxPos() - Casey.TELEPORT_DISTANCE,
							p.getxPos() + p.getWidth() - Casey.TELEPORT_DISTANCE, p.getyPos(),
							p.getyPos() + p.getHeight());

			if (isFarFromPlatform) {
				break;
			}

			// checks the bottom side of Casey
			isFarFromPlatform = keyCodePressed == KeyEvent.VK_S && !checkForPlayerCollision(p.getxPos(),
					p.getxPos() + p.getWidth(), p.getyPos() + Casey.TELEPORT_DISTANCE,
					p.getyPos() + p.getHeight() + Casey.TELEPORT_DISTANCE);

			if (isFarFromPlatform) {
				break;
			}

			// checks the top side of Casey
			isFarFromPlatform = keyCodePressed == KeyEvent.VK_W && !checkForPlayerCollision(p.getxPos(),
					p.getxPos() + p.getWidth(), p.getyPos() - Casey.TELEPORT_DISTANCE,
					p.getyPos() + p.getHeight() - Casey.TELEPORT_DISTANCE);

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

			platformToReset.setxPos(initPos.width);
			platformToReset.setyPos(initPos.height);
			platformToReset.reset();
		}

		for (int i = 0; i < lasers.size(); i++) {
			Laser laserToReset = lasers.get(i);
			boolean isOn = initLaserOn.get(i);

			laserToReset.setOn(isOn);
		}

		finalDoor.close();

		player.reset(initPlayerPos.width, initPlayerPos.height);
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

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
}