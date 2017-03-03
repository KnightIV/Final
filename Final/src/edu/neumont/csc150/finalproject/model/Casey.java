package edu.neumont.csc150.finalproject.model;

import java.awt.event.KeyEvent;

public class Casey extends BoxCharacter {

	public static final int TELEPORT_DISTANCE = 30;
	private boolean hasTeleported;

	public Casey(int startX, int startY) {
		super(startX, startY);
	}

	public void playerPowerActivate(int keyCodePressed) {
		switch(keyCodePressed) {
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

	public void teleportVertical(boolean isUp) {
		if (!hasTeleported) {
			if (isUp) {
				this.setyPos(this.getyPos() - TELEPORT_DISTANCE);
			} else {
				this.setyPos(this.getyPos() + TELEPORT_DISTANCE);
			}
			toggleTeleported();

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			toggleTeleported();
		}
	}

	public void teleportHorizontal(boolean isRight) {
		if (!hasTeleported) {
			if (isRight) {
				this.setxPos(this.getxPos() + TELEPORT_DISTANCE);
			} else {
				this.setxPos(this.getxPos() - TELEPORT_DISTANCE);
			}
			toggleTeleported();
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			toggleTeleported();
		}
	}

	public void reset(int initXPos, int initYPos) {
		super.reset(initXPos, initYPos);
		hasTeleported = false;
	}

	public void toggleTeleported() {
		hasTeleported = !hasTeleported;
	}
}
