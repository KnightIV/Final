package edu.neumont.csc150.finalproject.view;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class ImagePanel extends JPanel{

	private static final long serialVersionUID = -808074234392022231L;
	
	private Image imgDisplay;
	private Container cont;
	
	public ImagePanel(Image i) {
		imgDisplay = i;
		cont = new Container();
		this.add(cont);
	}
	
	public Container getCont() {
		return cont;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(imgDisplay, 0, 0, 2560, 1440, null);
		super.paintComponents(g);
	}
}
