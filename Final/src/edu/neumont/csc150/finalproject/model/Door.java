package edu.neumont.csc150.finalproject.model;

import java.io.Serializable;

import javax.swing.ImageIcon;

public class Door implements Serializable {
	
	private static final long serialVersionUID = -2797463060716394555L;
	
	private int width = 60, height = 220;
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