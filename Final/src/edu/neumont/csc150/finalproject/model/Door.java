package edu.neumont.csc150.finalproject.model;

import javax.swing.ImageIcon;

public class Door {
	private int width = 80, height = 200;
	private int xPos, yPos;
	private ImageIcon texture;
	private boolean isOpen;
	
	public Door(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
		isOpen = false;
//		this.width = texture.getIconWidth();
//		this.height = texture.getIconHeight();
	}

	public void toggleDoor() {
		isOpen = !isOpen;
	}
	
	public void close() {
		isOpen = false;
	}
	
	public int getXPos() {
		return xPos;
	}

	public int getWidth() {
		return width;
	}

	public int getYPos() {
		return yPos;
	}
	
	public int getHeight() {
		return height;
	}
	
	public boolean isOpen() {
		return isOpen;
	}
	
	public ImageIcon getTexture() {
		return texture;
	}
}