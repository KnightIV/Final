package edu.neumont.csc150.finalproject.view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JPanel;

import edu.neumont.csc150.finalproject.controller.GameManager;

public class Manual extends JPanel{
	
	private static final long serialVersionUID = 4556139318257082454L;
	
	private GameManager gameManager;
	private Image texture;
	private JButton quitToMainMenu;
	
	public Manual(GameManager game){
		this.gameManager = game;
		initManual();
	}
	
	public void initManual() {
		quitToMainMenu = new JButton("Quit To Main Menu");
		quitToMainMenu.addActionListener(gameManager);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(texture, 0, 0, null);
	}
}
