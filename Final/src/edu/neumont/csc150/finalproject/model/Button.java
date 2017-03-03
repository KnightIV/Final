package edu.neumont.csc150.finalproject.model;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Button {

	private int width = 30, height = 30, xPos, yPos;
	private ImageIcon texture;
	private Door doorLink;
	private ArrayList<Laser> laserLinks;

	public Button(int x, int y, Door doorLink, ArrayList<Laser> laserLinks) {
		xPos = x;
		yPos = y;
		this.doorLink = doorLink;
		this.laserLinks = laserLinks;
		// width = texture.getIconWidth();
		// height = texture.getIconHeight();
	}

	public void trigger() {
		if (laserLinks != null) {
			for (Laser link : laserLinks) {
				link.toggleLaser();
			}
		}
		
		if (doorLink != null) {
			doorLink.toggleDoor();
		}
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
		return width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
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
}
