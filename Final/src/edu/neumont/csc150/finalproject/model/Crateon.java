package edu.neumont.csc150.finalproject.model;

import java.awt.event.ActionEvent;

public class Crateon extends BoxCharacter {

	private GravityDirection gravityDir;

	public Crateon() {
		super();
		gravityDir = GravityDirection.DOWN;
	}

	public void gravityChange(GravityDirection newDir) {
		if (newDir == null) {
			throw new IllegalArgumentException("newDir cannot be null");
		}
		gravityDir = newDir;
	}

	public void moveRight() {
		if (gravityDir == GravityDirection.UP || gravityDir == GravityDirection.DOWN) {
			this.setOwnXVector(10);
		} else if (gravityDir == GravityDirection.RIGHT) {
			this.setOwnYVector(10);
		} else if (gravityDir == GravityDirection.LEFT) {
			this.setOwnYVector(-10);
		}
	}

	public void moveLeft() {
		if (gravityDir == GravityDirection.UP || gravityDir == GravityDirection.DOWN) {
			this.setOwnXVector(-10);
		} else if (gravityDir == GravityDirection.RIGHT) {
			this.setOwnYVector(-10);
		} else if (gravityDir == GravityDirection.LEFT) {
			this.setOwnYVector(10);
		}
	}

	public void jump() {
		if (gravityDir == GravityDirection.UP) {
			this.setOwnYVector(30);
		} else if (gravityDir == GravityDirection.DOWN) {
			this.setOwnYVector(-30);
		} else if (gravityDir == GravityDirection.LEFT) {
			this.setOwnXVector(30);
		} else if (gravityDir == GravityDirection.RIGHT) {
			this.setOwnXVector(-30);
		}
	}

	public void reset(int initXPos, int initYPos) {
		super.reset(initXPos, initYPos);
		gravityDir = GravityDirection.DOWN;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (gravityDir) {
		case UP:
			
			break;
			
		case DOWN:
			
			break;
			
		case LEFT:
			
			break;
			
		case RIGHT:
			
			break;
		}
	}
}
