package edu.neumont.csc150.finalproject.model;

import java.io.Serializable;

public class Game implements Serializable{

	private static final long serialVersionUID = 6110841132960516050L;
	
	private Level curLevel;
	
	public Game() {
		
	}
	
	public Game(Level curLevel) {
		this.curLevel = curLevel;
	}
	
	public void movePlayer(boolean isRight) {
		curLevel.movePlayer(isRight);
	}
	
	public void stopHorizontalPlayer() {
		curLevel.stopPlayer(false);
	}
	
	public void jump() {
		curLevel.playerJump();
	}
	
	public void playerPowerActivate(int keyCodePressed) {
		curLevel.playerPowerActivate(keyCodePressed);
	}
	
	public void swapLevel(Level newLvl) {
		curLevel = newLvl;
	}
	
	public Level getCurLevel() {
		return curLevel;
	}
	
	public void reset() {
		curLevel.resetLevel();
	}
}
