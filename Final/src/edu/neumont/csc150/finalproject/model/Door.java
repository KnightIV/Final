package edu.neumont.csc150.finalproject.model;

import java.io.Serializable;

/**
 * Model class representing a door
 * 
 * @author Jacob Adams
 * @author Julie Babylon
 * @author Ramon Caballero Villegas
 *
 */
public class Door implements Serializable {

	private static final long serialVersionUID = -2797463060716394555L;

	private int width = 100, height = 180;
	private int xPos, yPos;
	private boolean isOpen;

	/**
	 * Initializes a door object
	 * 
	 * @param xPos
	 *            - the door's x position
	 * @param yPos
	 *            - the door's y position
	 */
	public Door(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
		isOpen = false;
	}

	/**
	 * Toggles whether or not the door is open
	 */
	public void toggleDoor() {
		isOpen = !isOpen;
	}

	/**
	 * Closes the door
	 */
	public void close() {
		isOpen = false;
	}

	/**
	 * 
	 * @return the door's x position
	 */
	public int getXPos() {
		return xPos;
	}

	/**
	 * @return the door's width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * 
	 * @return the door's y position
	 */
	public int getYPos() {
		return yPos;
	}

	/**
	 * 
	 * @return the door's height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * 
	 * @return whether or not the door is open
	 */
	public boolean isOpen() {
		return isOpen;
	}
}