package edu.neumont.csc150.finalproject.model;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * Model class for one of the game's playable protagonists, the gravity shifter
 * 
 * @author Jacob Adams
 * @author Julie Babylon
 * @author Ramon Caballero Villegas
 *
 */
public class Crateon extends BoxCharacter {

	private static final long serialVersionUID = 3113030185585293023L;

	private GravityDirection gravityDir;

	/**
	 * Constructor for Crateon player
	 * 
	 * @param startX
	 *            - the player's initial x position
	 * @param startY
	 *            - the player's initial y position
	 */
	public Crateon(int startX, int startY) {
		super(startX, startY);
		this.setWidth(800 / 13);
		this.setHeight(800 / 13);
		gravityDir = GravityDirection.DOWN;
	}

	private void gravityChange(GravityDirection newDir) {
		gravityDir = newDir;
	}

	/**
	 * Activates Crateon's power of gravity shifts
	 */
	public void playerPowerActivate(int keyCodePressed) {
		switch (keyCodePressed) {
		case KeyEvent.VK_W:
			this.setOwnYVector(this.getOwnYVector() - 1);
			this.setyPos(this.getyPos() + 5);
			gravityChange(GravityDirection.UP);
			break;

		case KeyEvent.VK_S:
			this.setOwnYVector(this.getOwnYVector() + 1);
			this.setyPos(this.getyPos() - 5);
			gravityChange(GravityDirection.DOWN);
			break;

		case KeyEvent.VK_D:
			this.setOwnXVector(this.getOwnXVector() + 1);
			this.setxPos(this.getxPos() + 5);
			gravityChange(GravityDirection.RIGHT);
			break;

		case KeyEvent.VK_A:
			this.setOwnXVector(this.getOwnXVector() - 1);
			this.setxPos(this.getxPos() - 5);
			gravityChange(GravityDirection.LEFT);
			break;
		}
	}

	/**
	 * Moves Crateon to the right depending on it's gravity orientation
	 */
	public void moveRight() {
		if (gravityDir == GravityDirection.UP || gravityDir == GravityDirection.DOWN) {
			this.setOwnXVector(MOVE);
		} else if (gravityDir == GravityDirection.RIGHT) {
			this.setOwnYVector(-MOVE);
		} else if (gravityDir == GravityDirection.LEFT) {
			this.setOwnYVector(MOVE);
		}
	}

	/**
	 * Moves Crateon to the left depending on it's gravity orientation
	 */
	public void moveLeft() {
		if (gravityDir == GravityDirection.UP || gravityDir == GravityDirection.DOWN) {
			this.setOwnXVector(-MOVE);
		} else if (gravityDir == GravityDirection.RIGHT) {
			this.setOwnYVector(MOVE);
		} else if (gravityDir == GravityDirection.LEFT) {
			this.setOwnYVector(-MOVE);
		}
	}

	/**
	 * Makes Crateon jump based on its gravitational orientation
	 */
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

	/**
	 * @see super{@link #reset(int, int)} Resets Crateon's gravitational
	 *      orientation to down
	 */
	public void reset(int initXPos, int initYPos) {
		gravityDir = GravityDirection.DOWN;
		super.reset(initXPos, initYPos);
	}

	/**
	 * @see super{@link #stop(boolean)}
	 */
	public void stop(boolean verticalMove) {
		switch (gravityDir) {
		case UP:
		case DOWN:
			super.stop(verticalMove);
			break;

		case LEFT:
		case RIGHT:
			super.stop(!verticalMove);
			break;
		}
	}

	/**
	 * @see super{@link #actionPerformed(ActionEvent)} Depends on Crateon's
	 *      gravitational orientation
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (gravityDir) {
		case UP:
			if (Math.abs(this.getOwnYVector()) < MAX_FALL_SPEED) {
				setOwnYVector(getOwnYVector() - GRAVITY);
			}
			break;

		case DOWN:
			super.actionPerformed(e);
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

	/**
	 * 
	 * @return Crateon's current gravitational orientation
	 */
	public GravityDirection getGravityDirection() {
		return gravityDir;
	}
}
