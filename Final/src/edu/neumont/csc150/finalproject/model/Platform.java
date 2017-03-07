package edu.neumont.csc150.finalproject.model;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.Timer;

import edu.neumont.csc150.finalproject.controller.GameManager;

public class Platform implements ActionListener, Serializable {

	private static final long serialVersionUID = 7397853236720804514L;

	private Dimension sideHitBox, topBottomHitBox;
	
	private int xPos, xVector, xDisplacement, yPos, yDisplacement, yVector, width, height, speed;
	private Timer moveTimer;
	private double counter = 0;
	private boolean isVerticalMove;
	private boolean isHorizontalMove;

	public Platform(int x, int y, int width, int height, int xDisplacement, int yDisplacement,
			boolean isVerticalMove, boolean isHorizontalMove, int speed) {
		this.xPos = x;
		this.yPos = y;
		this.width = width;
		this.height = height;
		this.speed = speed;
		
		this.sideHitBox = new Dimension(width/4, height);
		this.topBottomHitBox = new Dimension(width, height/2);
		
//		this.sideHitBox = new Dimension(texture.getIconWidth()/4, texture.getIconHeight());
//		this.topBottomHitBox = new Dimension(texture.getIconWidth()/2, texture.getIconHeight()/2);
		
		this.xDisplacement = xDisplacement;
		this.yDisplacement = yDisplacement;
		this.isVerticalMove = isVerticalMove;
		this.isHorizontalMove = isHorizontalMove;
		initTimer();
	}

	public Platform(int x, int y, int width, int height) {
		this.xPos = x;
		this.yPos = y;
		this.width = width;
		this.height = height;
		
		this.sideHitBox = new Dimension(width/4, height);
		this.topBottomHitBox = new Dimension(width, height/2);
		
//		this.sideHitBox = new Dimension(texture.getIconWidth()/4, texture.getIconHeight());
//		this.topBottomHitBox = new Dimension(texture.getIconWidth()/2, texture.getIconHeight()/2);
	}
	
	public void reset() {
		counter = 0;
	}

	public void initTimer() {
		moveTimer = new Timer(GameManager.FRAME_RATE, this);
		moveTimer.start();
	}

	public int getXPos() {
		return xPos;
	}

	public void setXPos(int newX) {
		this.xPos = newX;
	}

	public int getXVector() {
		return xVector;
	}

	public int getYPos() {
		return yPos;
	}

	public void setYPos(int newY) {
		this.yPos = newY;
	}

	public int getYVector() {
		return yVector;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
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

	public Dimension getHitBox(boolean isSide) {
		if (isSide) {
			return sideHitBox;
		}
		return topBottomHitBox;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (isHorizontalMove) {
			xVector = (int) - (xDisplacement * Math.cos(counter / 2));
			xPos += xVector;
		}

		if (isVerticalMove) {
			yPos += (int) (yDisplacement * Math.sin(counter / 2));
			yVector = (int) (yDisplacement * Math.cos(counter / 2));
		}

		if (counter == Integer.MAX_VALUE) {
			counter = 0;
		} else {
			counter += speed/10.0;
		}
	}
}