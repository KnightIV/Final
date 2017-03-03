package edu.neumont.csc150.finalproject.model;

import javax.swing.ImageIcon;

public class Laser {

	private int xPos, yPos, width, height;
	private ImageIcon texture;
	private boolean isOn;
	
	public Laser(int x, int y, int width, int height, boolean isOn) {
		this.xPos = x;
		this.yPos = y;
		this.width = width;
		this.height = height;
		this.isOn = isOn;
	}
	
	public void toggleLaser() {
		isOn = !isOn;
	}
	
	public int getXPos() {
		return xPos;
	}
	
	public int getYPos() {
		return yPos;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	/**
	 * @return the isOn
	 */
	public boolean isOn() {
		return isOn;
	}
	
	public void setOn(boolean isOn) {
		this.isOn = isOn;
	}

	/**
	 * @return the texture
	 */
	public ImageIcon getTexture() {
		return texture;
	}
}
