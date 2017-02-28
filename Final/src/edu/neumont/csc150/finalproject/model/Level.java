package edu.neumont.csc150.finalproject.model;

import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;

public class Level {

	private ArrayList<Platform> platforms;
	private ArrayList<Dimension> initPlatformPos;
	private ArrayList<Laser> lasers;
	private ArrayList<Boolean> initLaserOn;
	private Door finalDoor;
	private BoxCharacter player;
	private Dimension initPlayerPos;
	private Image background;
	private ArrayList<Button> buttons;

	public Level(ArrayList<Platform> platforms, ArrayList<Laser> lasers, Door finalDoor, BoxCharacter player,
			Image background) {
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
	}

	private boolean checkForPlayerCollision(int leftObjX, int rightObjX, int upObjY, int downObjY) {
		return (player.getxPos() <= rightObjX) && (player.getxPos() + player.getWidth() >= leftObjX)
				&& (player.getyPos() <= downObjY) && (player.getyPos() + player.getHeight() >= upObjY);
	}

	public boolean isEndLevel() {
		return checkForPlayerCollision(finalDoor.getXPos(), finalDoor.getXPos() + finalDoor.getWidth(),
				finalDoor.getYPos(), finalDoor.getYPos() + finalDoor.getHeight());
	}

	public void checkForButtonTriggered() {
		for (Button b : buttons) {
			if (checkForPlayerCollision(b.getXPos(), b.getXPos() + b.getWidth(), b.getYPos(), b.getYPos() + b.getHeight())) {
				b.trigger();
				return;
			}
		}
	}
	
	public void movePlayer(boolean isRight) {
		if (isRight) {
			player.moveRight();
		} else {
			player.moveLeft();
		}
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
}
