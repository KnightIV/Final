package edu.neumont.csc150.finalproject.model;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class Crateon extends BoxCharacter {

	private GravityDirection gravityDir;

	public Crateon(int startX, int startY) {
		super(startX, startY);
		gravityDir = GravityDirection.DOWN;
	}

	public void gravityChange(GravityDirection newDir) {
		if (newDir == null) {
			throw new IllegalArgumentException("newDir cannot be null");
		}
		gravityDir = newDir;
	}

	public void playerPowerActivate(int keyCodePressed) {
		switch (keyCodePressed) {
		case KeyEvent.VK_W:
			gravityChange(GravityDirection.UP);
			this.setyPos(this.getyPos() + 3);
			break;

		case KeyEvent.VK_S:
			gravityChange(GravityDirection.DOWN);
			this.setyPos(this.getyPos() - 3);
			break;

		case KeyEvent.VK_D:
			gravityChange(GravityDirection.RIGHT);
			this.setxPos(this.getxPos() + 3);
			break;

		case KeyEvent.VK_A:
			gravityChange(GravityDirection.LEFT);
			this.setxPos(this.getxPos() - 3);
			break;
		}
	}

	public void moveRight() {
		if (gravityDir == GravityDirection.UP || gravityDir == GravityDirection.DOWN) {
			this.setOwnXVector(MOVE);
		} else if (gravityDir == GravityDirection.RIGHT) {
			this.setOwnYVector(-MOVE);
		} else if (gravityDir == GravityDirection.LEFT) {
			this.setOwnYVector(MOVE);
		}
	}

	public void moveLeft() {
		if (gravityDir == GravityDirection.UP || gravityDir == GravityDirection.DOWN) {
			this.setOwnXVector(-MOVE);
		} else if (gravityDir == GravityDirection.RIGHT) {
			this.setOwnYVector(MOVE);
		} else if (gravityDir == GravityDirection.LEFT) {
			this.setOwnYVector(-MOVE);
		}
	}

	public void jump() {
		if (!this.hasJumped) {
			if (gravityDir == GravityDirection.UP) {
				this.setyPos(this.getyPos() + 3);
				this.setOwnYVector(JUMP);
			} else if (gravityDir == GravityDirection.DOWN) {
				this.setyPos(this.getyPos() - 3);
				this.setOwnYVector(-JUMP);
			} else if (gravityDir == GravityDirection.LEFT) {
				this.setxPos(this.getxPos() + 3);
				this.setOwnXVector(JUMP);
			} else if (gravityDir == GravityDirection.RIGHT) {
				this.setxPos(this.getxPos() - 3);
				this.setOwnXVector(-JUMP);
			}
			this.hasJumped = true;
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
			if (Math.abs(this.getOwnYVector()) < MAX_FALL_SPEED) {
				setOwnYVector(getOwnYVector() - GRAVITY);
			}
			break;

		case DOWN:
			if (Math.abs(this.getOwnYVector()) < MAX_FALL_SPEED) {
				setOwnYVector(getOwnYVector() + GRAVITY);
			}
			break;

		case LEFT:
			if (Math.abs(this.getOwnXVector()) < MAX_FALL_SPEED) {
				setOwnXVector(getOwnXVector() - GRAVITY);
			}
			break;

		case RIGHT:
			if (Math.abs(this.getOwnXVector()) < MAX_FALL_SPEED) {
				setOwnXVector(getOwnXVector() + GRAVITY);
			}
			break;
		}
	}
	
	public GravityDirection getGravityDirection() {
		return gravityDir;
	}
}
