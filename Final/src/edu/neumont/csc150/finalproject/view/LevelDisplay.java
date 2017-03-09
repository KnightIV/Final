package edu.neumont.csc150.finalproject.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import edu.neumont.csc150.finalproject.model.BoxCharacter;
import edu.neumont.csc150.finalproject.model.Button;
import edu.neumont.csc150.finalproject.model.Crateon;
import edu.neumont.csc150.finalproject.model.Laser;
import edu.neumont.csc150.finalproject.model.Level;
import edu.neumont.csc150.finalproject.model.Platform;

/**
 * View class in charge of displaying the level
 * 
 * @author Jacob Adams
 * @author Julie Babylon
 * @author Ramon Caballero Villegas
 *
 */
public class LevelDisplay extends JPanel {

	private static final long serialVersionUID = 7970298263117969411L;

	private Level curLevel;
	private Image platformTexture, caseyImage, crateonImage, doorImage;

	/**
	 * Constructor for the level display
	 * 
	 * @param curLevel
	 *            - the current level to display
	 * @param levelImage
	 *            - the background of the current level
	 */
	public LevelDisplay(Level curLevel) {
		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		swapLevel(curLevel);
		try {
			platformTexture = ImageIO.read(new File("./resources/platformTile.png"));
			caseyImage = ImageIO.read(new File("./resources/Casey.png"));
			crateonImage = ImageIO.read(new File("./resources/Crateon.png"));
			doorImage = ImageIO.read(new File("./resources/DoorTile.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Switches which level to display
	 * 
	 * @param curLevel
	 *            - the new level to display
	 */
	public void swapLevel(Level curLevel) {
		this.curLevel = curLevel;
	}

	/**
	 * Paints all visual aspects of the level
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		this.setBackground(Color.black);

		if (curLevel.getDoor().isOpen()) {
			g.setColor(Color.white);
			g.fillRect(curLevel.getDoor().getXPos(), curLevel.getDoor().getYPos(), curLevel.getDoor().getWidth(),
					curLevel.getDoor().getHeight());
		} else {
			g.drawImage(doorImage, curLevel.getDoor().getXPos(), curLevel.getDoor().getYPos(),
					curLevel.getDoor().getWidth(), curLevel.getDoor().getHeight(), null);
		}

		BoxCharacter player = curLevel.getPlayer();

		if (player instanceof Crateon) {
			g.drawImage(crateonImage, player.getxPos(), player.getyPos(), player.getWidth(), player.getHeight(), null);
			;
		} else {
			g.drawImage(caseyImage, player.getxPos(), player.getyPos(), player.getWidth(), player.getHeight(), null);
			;
		}

		if (curLevel.getDoor().isOpen()) {
			g.setColor(Color.pink);
			g.fillRect(curLevel.getDoor().getXPos(), curLevel.getDoor().getYPos(), curLevel.getDoor().getWidth(),
					curLevel.getDoor().getHeight());
		}

		g.setColor(Color.yellow);
		for (Button b : curLevel.getButtons()) {
			g.fillRect(b.getXPos(), b.getYPos(), b.getWidth(), b.getHeight());
		}

		g.setColor(Color.blue);
		for (Platform p : curLevel.getPlatforms()) {
			g.drawImage(platformTexture, p.getxPos(), p.getyPos() - 2, p.getWidth(), p.getHeight() + 2, null);
		}

		g.setColor(Color.red);
		for (Laser l : curLevel.getLasers()) {
			if (l.isOn()) {
				g.fillRect(l.getXPos(), l.getYPos(), l.getWidth(), l.getHeight());
			}
		}
	}
}