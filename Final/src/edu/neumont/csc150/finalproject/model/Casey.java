package edu.neumont.csc150.finalproject.model;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import edu.neumont.csc150.finalproject.controller.GameManager;

/**
 * Model class for Casey, one of the game's protagonists, the teleporter
 * 
 * @author Jacob Adams
 * @author Julie Babylon
 * @author Ramon Caballero Villegas
 *
 */
public class Casey extends BoxCharacter {

	private static final long serialVersionUID = -7279892218969746473L;

	/**
	 * The distance, in pixels, that Casey can teleport
	 */
	public static final int TELEPORT_DISTANCE = 200;

	private boolean hasTeleported = true;
	private double teleportTime = -2;

	/**
	 * @see BoxCharacter#BoxCharacter(int, int)
	 */
	public Casey(int startX, int startY) {
		super(startX, startY);
		this.setWidth(375 / 8);
		this.setHeight(713 / 10);
	}

	/**
	 * Teleports Casey in the specified direction
	 * 
	 * @param keyCodePressed
	 *            - the int value corresponding to the key the player presses
	 */
	public void playerPowerActivate(int keyCodePressed) {
		switch (keyCodePressed) {
		case KeyEvent.VK_W:
			teleportVertical(true);
			break;

		case KeyEvent.VK_S:
			teleportVertical(false);
			break;

		case KeyEvent.VK_A:
			teleportHorizontal(false);
			break;

		case KeyEvent.VK_D:
			teleportHorizontal(true);
			break;
		}
	}

	private void teleportVertical(boolean isUp) {
		if (!hasTeleported) {
			if (isUp) {
				this.setyPos(this.getyPos() - TELEPORT_DISTANCE);
			} else {
				this.setyPos(this.getyPos() + TELEPORT_DISTANCE);
			}
			toggleTeleported();
			teleportTime = GameManager.FRAME_RATE;
		}
	}

	private void teleportHorizontal(boolean isRight) {
		if (!hasTeleported) {
			if (isRight) {
				this.setxPos(this.getxPos() + TELEPORT_DISTANCE);
			} else {
				this.setxPos(this.getxPos() - TELEPORT_DISTANCE);
			}
			toggleTeleported();
			teleportTime = GameManager.FRAME_RATE;
		}
	}

	/**
	 * @see BoxCharacter#reset(int, int)
	 */
	public void reset(int initXPos, int initYPos) {
		super.reset(initXPos, initYPos);
		hasTeleported = false;
	}

	/**
	 * Toggles whether or not Casey has teleported recently
	 */
	public void toggleTeleported() {
		hasTeleported = !hasTeleported;
	}

	/**
	 * Continuously counts down until Casey can teleport once again
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		super.actionPerformed(arg0);
		if (teleportTime <= 0 && hasTeleported) {
			toggleTeleported();
		} else if (teleportTime > 0) {
			teleportTime -= 1;
		}
	}
}
