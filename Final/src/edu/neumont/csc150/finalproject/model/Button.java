package edu.neumont.csc150.finalproject.model;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Button {

	// placeholder dimensions
	private final int WIDTH = 10, HEIGHT = 10;
	
	private int xPos, yPos;
	private ImageIcon texture;
	private Door doorLink;
	private ArrayList<Laser> laserLinks;

	public Button(int x, int y, Door doorLink, ArrayList<Laser> laserLinks) {
		xPos = x;
		yPos = y;
		this.doorLink = doorLink;
		this.laserLinks = laserLinks;
	}
	
	/**
	 * @return the xPos
	 */
	public int getXPos() {
		return xPos;
	}

	/**
	 * @param xPos
	 *            the xPos to set
	 */
	public void setXPos(int xPos) {
		this.xPos = xPos;
	}

	/**
	 * @return the yPos
	 */
	public int getYPos() {
		return yPos;
	}

	/**
	 * @param yPos
	 *            the yPos to set
	 */
	public void setYPos(int yPos) {
		this.yPos = yPos;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return WIDTH;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return HEIGHT;
	}

	/**
	 * @return the texture
	 */
	public ImageIcon getTexture() {
		return texture;
	}

	/**
	 * @param texture
	 *            the texture to set
	 */
	public void setTexture(ImageIcon texture) {
		this.texture = texture;
	}

	public void trigger() {
		// activate all doors and lasers that this button is linked to (ie. open
		// a closed door and vice versa, or shut off a laser if it's on, and
		// vice versa)
	}
}
