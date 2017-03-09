package edu.neumont.csc150.finalproject.model;

import java.io.Serializable;

/**
 * Model class representing a laser obstacle
 * 
 * @author Jacob Adams
 * @author Julie Babylon
 * @author Ramon Caballero Villegas
 *
 */
public class Laser implements Serializable {

	private static final long serialVersionUID = 7774685546288721788L;

	private int xPos, yPos, width, height;
	private boolean isOn;

	/**
	 * Initializes a laser obstacle
	 * 
	 * @param x
	 *            - the laser's x position
	 * @param y
	 *            - the laser's y position
	 * @param width
	 *            - the laser's width
	 * @param height
	 *            - the laser's height
	 * @param isOn
	 *            - whether or not the laser is on at the start of the level
	 */
	public Laser(int x, int y, int width, int height, boolean isOn) {
		this.xPos = x;
		this.yPos = y;
		this.width = width;
		this.height = height;
		this.isOn = isOn;
	}

	/**
	 * Toggles the laser's on position
	 */
	public void toggleLaser() {
		isOn = !isOn;
	}

	/**
	 * 
	 * @return the laser's x position
	 */
	public int getXPos() {
		return xPos;
	}

	/**
	 * 
	 * @return the laser's y position
	 */
	public int getYPos() {
		return yPos;
	}

	/**
	 * 
	 * @return the laser's width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * 
	 * @return the laser's height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @return whether or not the laser is on
	 */
	public boolean isOn() {
		return isOn;
	}

	/**
	 * Sets the laser to be on or off
	 * 
	 * @param isOn
	 *            whether or not the laser is on
	 */
	public void setOn(boolean isOn) {
		this.isOn = isOn;
	}
}
