package edu.neumont.csc150.finalproject.model;

public class Casey extends BoxCharacter {

	private static final int TELEPORT_DISTANCE = 30;
	private boolean hasTeleported;

	public Casey() {
		super();
	}

	public void teleportVertical(boolean isUp) {
		if (!hasTeleported) {
			if (isUp) {
				this.setyPos(this.getyPos() - TELEPORT_DISTANCE);
			} else {
				this.setyPos(this.getyPos() + TELEPORT_DISTANCE);
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
		}
	}
	
	public void rest(int initXPos, int initYPos) {
		super.reset(initXPos, initYPos);
		hasTeleported = false;
	}
	
	public void toggleTeleported() {
		hasTeleported = !hasTeleported;
	}
}
