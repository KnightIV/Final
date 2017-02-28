package edu.neumont.csc150.finalproject.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Platform implements ActionListener {

	private int xPos;
	private int xVector;
	private int xDisplacement;
	private int yPos;
	private int yDisplacement;
	private int yVector;
	private int width;
	private int height;
	private ImageIcon texture;
	private Timer moveTimer;
	private double counter = 0;
	private boolean isVerticalMove;
	private boolean isHorizontalMove;

	public Platform(int x, int y, int width, int height, ImageIcon texture, int xDisplacement, int yDisplacement,
			boolean isVerticalMove, boolean isHorizontalMove) {
		this.xPos = x;
		this.yPos = y;
		this.width = width;
		this.height = height;
		this.texture = texture;
		this.xDisplacement = xDisplacement;
		this.yDisplacement = yDisplacement;
		this.isVerticalMove = isVerticalMove;
		this.isHorizontalMove = isHorizontalMove;
		initTimer();
	}

	public Platform(int x, int y, int width, int height, ImageIcon texture) {
		this.xPos = x;
		this.yPos = y;
		this.width = width;
		this.height = height;
		this.texture = texture;
	}

	public void initTimer() {
		moveTimer = new Timer((int) 100.0 / 3, this);
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

	public ImageIcon getTexture() {
		return texture;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (isVerticalMove) {
			xPos += (int) (xDisplacement / 10 * Math.sin(counter / 2));
			xVector = (int) (xDisplacement / 10 * Math.cos(counter / 2));
		}

		if (isHorizontalMove) {
			yPos += (int) (yDisplacement / 10 * Math.sin(counter / 2));
			yVector = (int) (yDisplacement / 10 * Math.cos(counter / 2));
		}

		if (counter == Integer.MAX_VALUE) {
			counter = 0;
		} else {
			counter += 0.1;
		}
	}
}
