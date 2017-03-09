package edu.neumont.csc150.finalproject.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 * Model class for a level's buttons
 * 
 * @author Jacob Adams
 * @author Julie Babylon
 * @author Ramon Caballero Villegas
 *
 */
public class Button implements Serializable {

	private static final long serialVersionUID = 7104657014048498506L;

	private int width = 30, height = 30, xPos, yPos;
	private ImageIcon texture;
	private Door doorLink;
	private ArrayList<Laser> laserLinks;
	private boolean isPlayerOnButton = false;

	/**
	 * Initializes the button
	 * 
	 * @param x
	 *            - the button's x position
	 * @param y
	 *            - the button's y position
	 * @param doorLink
	 *            - the door that this button links to; can be null if it does
	 *            not need to link to a door
	 * @param laserLinks
	 *            - the lasers that this button links to; can be null if it does
	 *            not need to link to lasers
	 */
	public Button(int x, int y, Door doorLink, ArrayList<Laser> laserLinks) {
		xPos = x;
		yPos = y;
		this.doorLink = doorLink;
		this.laserLinks = laserLinks;
	}

	/**
	 * Activates or deactivates every laser and door that the button is linked
	 * to
	 */
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

	/**
	 * @return the isPlayerOnButton
	 */
	public boolean isPlayerOnButton() {
		return isPlayerOnButton;
	}

	/**
	 * @param isPlayerOnButton
	 *            the isPlayerOnButton to set
	 */
	public void setPlayerOnButton(boolean isPlayerOnButton) {
		this.isPlayerOnButton = isPlayerOnButton;
	}
}
