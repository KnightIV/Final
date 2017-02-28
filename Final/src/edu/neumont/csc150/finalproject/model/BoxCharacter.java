package edu.neumont.csc150.finalproject.model;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

abstract public class BoxCharacter implements ActionListener {
	
	private static final int GRAVITY = 6;
	private int xPos, yPos, ownXVector, ownYVector, otherYVector, otherXVector, width, height;
	private Image image;
	private Timer jumpTimer;
	private String name;
	
	public BoxCharacter() {
		jumpTimer = new Timer((int) 50.0/3, this);
	}
	
	public void moveRight() {
		xPos += ownXVector + otherXVector;
	}
	
	public void moveLeft() {
		moveRight();
	}
	
	public void jump() {
		ownYVector = -30;
	}
	
	public void reset(int initXPos, int initYPos) {
		setyPos(initYPos);
		setxPos(initXPos);
	}

	/**
	 * @return the xPos
	 */
	public int getxPos() {
		return xPos;
	}

	/**
	 * @param xPos the xPos to set
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
	 * @param yPos the yPos to set
	 */
	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	/**
	 * @return the ownXVector
	 */
	public int getOwnXVector() {
		return ownXVector;
	}

	/**
	 * @param ownXVector the ownXVector to set
	 */
	public void setOwnXVector(int ownXVector) {
		this.ownXVector = ownXVector;
	}

	/**
	 * @return the ownYVector
	 */
	public int getOwnYVector() {
		return ownYVector;
	}

	/**
	 * @param ownYVector the ownYVector to set
	 */
	public void setOwnYVector(int ownYVector) {
		this.ownYVector = ownYVector;
	}

	/**
	 * @return the otherYVector
	 */
	public int getOtherYVector() {
		return otherYVector;
	}

	/**
	 * @param otherYVector the otherYVector to set
	 */
	public void setOtherYVector(int otherYVector) {
		this.otherYVector = otherYVector;
	}

	/**
	 * @return the otherXVector
	 */
	public int getOtherXVector() {
		return otherXVector;
	}

	/**
	 * @param otherXVector the otherXVector to set
	 */
	public void setOtherXVector(int otherXVector) {
		this.otherXVector = otherXVector;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the image
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(Image image) {
		this.image = image;
	}

	/**
	 * @return the jumpTimer
	 */
	public Timer getJumpTimer() {
		return jumpTimer;
	}

	/**
	 * @param jumpTimer the jumpTimer to set
	 */
	public void setJumpTimer(Timer jumpTimer) {
		this.jumpTimer = jumpTimer;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		ownYVector += GRAVITY / ((int) 50.0/3);
	}
}
