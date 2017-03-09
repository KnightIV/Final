package edu.neumont.csc150.finalproject.model;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.Timer;

import edu.neumont.csc150.finalproject.controller.GameManager;

/**
 * Model class for a platform in the game
 * 
 * @author Jacob Adams
 * @author Julie Babylon
 * @author Ramon Caballero Villegas
 *
 */
public class Platform implements ActionListener, Serializable {

	private static final long serialVersionUID = 7397853236720804514L;

	private Dimension sideHitBox, topBottomHitBox;

	private int xPos, xVector, xDisplacement, yPos, yDisplacement, yVector, width, height, speed;
	private Timer moveTimer;
	private double counter = 0;
	private boolean isVerticalMove;
	private boolean isHorizontalMove;

	/**
	 * Constructor for a moving platform
	 * 
	 * @param x
	 *            - the initial x position
	 * @param y
	 *            - the initial y position
	 * @param width
	 *            - the platform's width
	 * @param height
	 *            - the platform's height
	 * @param xDisplacement
	 *            - how far the platform will go across the x axis
	 * @param yDisplacement
	 *            - how far the platform will go across the y axis
	 * @param isVerticalMove
	 *            - whether or not the platform will move vertically
	 * @param isHorizontalMove
	 *            - whether or not the platform will move horizontally
	 * @param speed
	 *            - the speed of the platform
	 */
	public Platform(int x, int y, int width, int height, int xDisplacement, int yDisplacement, boolean isVerticalMove,
			boolean isHorizontalMove, int speed) {
		this.setxPos(x);
		this.setyPos(y);
		this.setWidth(width);
		this.setHeight(height);
		this.speed = speed;

		this.sideHitBox = new Dimension(width / 4, height);
		this.topBottomHitBox = new Dimension(width, height / 2);

		this.xDisplacement = xDisplacement;
		this.yDisplacement = yDisplacement;
		this.isVerticalMove = isVerticalMove;
		this.isHorizontalMove = isHorizontalMove;
		initTimer();
	}

	/**
	 * Constructor for a stationary platform
	 * 
	 * @param x
	 *            - the platform's x position
	 * @param y
	 *            - the platform's y position
	 * @param width
	 *            - the platform's width
	 * @param height
	 *            - the platform's height
	 */
	public Platform(int x, int y, int width, int height) {
		this.setxPos(x);
		this.setyPos(y);
		this.setWidth(width);
		this.setHeight(height);

		this.sideHitBox = new Dimension(width / 4, height);
		this.topBottomHitBox = new Dimension(width, height / 2);
	}

	/**
	 * Resets the counter for the movement of the platforms
	 */
	public void reset() {
		counter = 0;
	}

	private void initTimer() {
		moveTimer = new Timer(GameManager.FRAME_RATE, this);
		moveTimer.start();
	}

	/**
	 * @return the xPos
	 */
	public int getxPos() {
		return xPos;
	}

	/**
	 * @param xPos
	 *            the xPos to set
	 */
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	/**
	 * @return the yPos
	 */
	public int getyPos() {
		return yPos;
	}

	/**
	 * @param yPos
	 *            the yPos to set
	 */
	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width
	 *            the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the xDisplacement
	 */
	public int getxDisplacement() {
		return xDisplacement;
	}

	/**
	 * @return the yDisplacement
	 */
	public int getyDisplacement() {
		return yDisplacement;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the isVerticalMove
	 */
	public boolean isVerticalMove() {
		return isVerticalMove;
	}

	/**
	 * @return the isHorizontalMove
	 */
	public boolean isHorizontalMove() {
		return isHorizontalMove;
	}

	/**
	 * 
	 * @return the platform's horizontal velocity
	 */
	public int getXVector() {
		return xVector;
	}

	/**
	 * 
	 * @param isSide
	 *            - true if the desired hitbox is the one for left and right
	 *            hitboxes; false if for the top-bottom hitbox
	 * @return the specified hitbox
	 */
	public Dimension getHitBox(boolean isSide) {
		if (isSide) {
			return sideHitBox;
		}
		return topBottomHitBox;
	}

	/**
	 * Moves the platform if the platform is a moving platform
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (isHorizontalMove) {
			xVector = (int) -(xDisplacement * Math.cos(counter / 2));
			setxPos(getxPos() + xVector);
		}

		if (isVerticalMove) {
			yVector = (int) -(yDisplacement * Math.cos(counter / 2));
			setyPos(getyPos() + yVector);
		}

		if (counter == Integer.MAX_VALUE) {
			counter = 0;
		} else {
			counter += speed / 10.0;
		}
	}
}