package edu.neumont.csc150.finalproject.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import edu.neumont.csc150.finalproject.controller.InputControl;
import edu.neumont.csc150.finalproject.model.Button;
import edu.neumont.csc150.finalproject.model.Laser;
import edu.neumont.csc150.finalproject.model.Level;
import edu.neumont.csc150.finalproject.model.Platform;

public class LevelDisplay extends JPanel {

	private static final long serialVersionUID = 7970298263117969411L;

	private Level curLevel;
	private InputControl input;

	public LevelDisplay(Level curLevel) {
		swapLevel(curLevel);
		// this.input = new InputControl(curGame);
		// this.addKeyListener(this.input);
		// this.setFocusable(true);
	}

	public void swapLevel(Level curLevel) {
		this.curLevel = curLevel;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		this.setBackground(Color.black);

		g.drawImage(curLevel.getBackground(), 0, 0, null);

		g.setColor(Color.pink);
		g.fillRect(curLevel.getDoor().getXPos(), curLevel.getDoor().getYPos(), curLevel.getDoor().getWidth(),
				curLevel.getDoor().getHeight());

		g.setColor(Color.yellow);
		for (Button b : curLevel.getButtons()) {
			g.fillRect(b.getXPos(), b.getYPos(), b.getWidth(), b.getHeight());
		}

		g.setColor(Color.blue);
		for (Platform p : curLevel.getPlatforms()) {
			g.fillRect(p.getXPos(), p.getYPos(), p.getWidth(), p.getHeight());

			// g.drawImage(p.getTexture().getImage(), p.getXPos(), p.getYPos(),
			// p.getWidth(), p.getHeight(), null);
		}

		g.setColor(Color.red);
		for (Laser l : curLevel.getLasers()) {
			if (l.isOn()) {
				g.fillRect(l.getXPos(), l.getYPos(), l.getWidth(), l.getHeight());

				// g.drawImage(l.getTexture().getImage(), l.getXPos(),
				// l.getYPos(),
				// l.getWidth(), l.getHeight(), null);
			}
		}

		g.setColor(Color.white);
		g.fillRect(curLevel.getDoor().getXPos(), curLevel.getDoor().getYPos(), curLevel.getDoor().getWidth(),
				curLevel.getDoor().getHeight());

		// g.drawImage(curLevel.getDoor().getTexture().getImage(),
		// curLevel.getDoor().getXPos(),
		// curLevel.getDoor().getYPos(), null);

		g.setColor(Color.cyan);
		g.fillRect(curLevel.getPlayer().getxPos(), curLevel.getPlayer().getyPos(), curLevel.getPlayer().getWidth(),
				curLevel.getPlayer().getHeight());

		// g.drawImage(curLevel.getPlayer().getImage(),
		// curLevel.getPlayer().getxPos(), curLevel.getPlayer().getyPos(),
		// null);

	}

}