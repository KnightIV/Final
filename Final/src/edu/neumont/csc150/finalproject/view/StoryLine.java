package edu.neumont.csc150.finalproject.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class StoryLine extends JPanel  implements ActionListener{

	private static final long serialVersionUID = 4253378657443516918L;

	private Image[] images = new Image[4];
    
    private Timer moveTimer;
    private int counter = 0;
    private int switchScreen = 2000;
    private JButton proceed;
    
    public StoryLine() {
    	initImages();
    	initTimer();
    }
    
    public void initTimer() {
        moveTimer = new Timer(switchScreen, this);
    }
    
    public void initGUI() {
    	this.setLayout(new GridLayout(7, 7));
		
		this.setBackground(Color.white);

		for (int i = 0; i < 45; i++) {
			JPanel blank = new JPanel();
			blank.setBackground(Color.white);
			this.add(blank);
		}
		this.add(proceed);
    }
    
    public void initImages() {
         
    }
    
    public void resumeStory() {
    	moveTimer.start();
    }
    
    public void pauseStory() {
    	moveTimer.stop();
    }
    
    @Override
    public void paint(Graphics g) {
    	super.paint(g);
    	g.drawImage(images[counter], 0, 0, this.getWidth(), this.getHeight() - proceed.getHeight(), null);
    }
    
    @Override
    public void actionPerformed(ActionEvent arg0) {
        
    }
}