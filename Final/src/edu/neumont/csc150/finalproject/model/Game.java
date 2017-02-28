package edu.neumont.csc150.finalproject.model;

public class Game {

	private Level curLevel;
	private Casey casey;
	private Crateon crateon;
	
	public Game() {
		
	}
	
	public Game(Level curLevel) {
		this.curLevel = curLevel;
	}
	
	public void movePlayer(boolean isRight) {
		curLevel.movePlayer(isRight);
	}
	
	public void jump() {
		curLevel.playerJump();
	}
	
	public void setCurLevel(Level newLvl) {
		curLevel = newLvl;
	}
	
	public Level getCurLevel() {
		return curLevel;
	}
	
	public void reset() {
		curLevel.resetLevel();
	}
}
