package edu.neumont.csc150.finalproject.gen;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import edu.neumont.csc150.finalproject.model.Button;
import edu.neumont.csc150.finalproject.model.Casey;
import edu.neumont.csc150.finalproject.model.Crateon;
import edu.neumont.csc150.finalproject.model.Door;
import edu.neumont.csc150.finalproject.model.Laser;
import edu.neumont.csc150.finalproject.model.Platform;

public class LevelGenerator {

	private int[] pixels;
	private int[][] pixels2D;
	private int width = 0, height = 0;

	private int platformColor = 0x3F48CC;
	private int horizontalMovingPlatformColor = 10;
	private int verticalMovingPlatformColor = 11;
	private int doorColor = 0xA349A4;
	private int buttonColor = 0xB97A57;
	private int laserColor = 0xED1C24;
	private int crateonColor = 0x22B14C;
	private int caseyColor = 9;

	private ArrayList<Platform> platformBlocks = new ArrayList<>();
	private ArrayList<Platform> horizontalMovingPlatformBlocks = new ArrayList<>();
	private ArrayList<Platform> verticalMovingPlatformBlocks = new ArrayList<>();
	private ArrayList<Button> buttonBlocks = new ArrayList<>();
	private ArrayList<Laser> laserBlocks = new ArrayList<>();
	private Door doorBlock;
	private Crateon crateonBlock;
	private Casey caseyBlock;

	public static void main(String[] args) {
		LevelGenerator l = new LevelGenerator();
		l.getPixels();
		l.searchPixels();
		l.outputCode();
	}

	public void getPixels() {
		try {
			BufferedImage level = ImageIO.read(new File("Levels/Level1.png"));
			width = level.getWidth();
			height = level.getHeight();
			pixels = new int[width * height];
			pixels2D = new int[width][height];
			level.getRGB(0, 0, width, height, pixels, 0, width);
			for (int i = 0; i < pixels.length; i++) {
				pixels2D[i % width][i / width] = (pixels[i] + 0x1000000);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void searchPixels() {
		System.out.println("Searching for objects...");
		int w, h;
		ImageIcon background = new ImageIcon();

		String name = "";
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				if (pixels2D[x][y] == platformColor) {
					name = "platform";
				} else if (pixels2D[x][y] == doorColor) {
					name = "door";
				} else if (pixels2D[x][y] == buttonColor) {
					name = "button";
				} else if (pixels2D[x][y] == laserColor) {
					name = "laser";
				} else if (pixels2D[x][y] == crateonColor) {
					name = "crateon";
				} else if (pixels2D[x][y] == caseyColor) {
					name = "casey";
				} else
					continue;
				w = readW(x, y);
				h = readH(x, y);
				if (name.equals("platform")) {
					platformBlocks.add(new Platform(x, y, w, h, background));
				} else if(name.equals("horizontalMovingPlatformColor")) {
					horizontalMovingPlatformBlocks.add(new Platform(x, y, w, h, background, 10, 0, false, true));
				}else if(name.equals("verticalMovingPlatformColor")) {
					verticalMovingPlatformBlocks.add(new Platform(x, y, w, h, background, 0, 10, true, false));
				}else if (name.equals("button")) {
					buttonBlocks.add(new Button(x, y, null, null));
				} else if (name.equals("laser")) {
					laserBlocks.add(new Laser(x, y, w, h, true));
				} else if (name.equals("door")) {
					doorBlock = new Door(x, y);
				} else if (name.equals("crateon")) {
					crateonBlock = new Crateon(x, y);
				} else if (name.equals("casey")) {
					caseyBlock = new Casey(x, y);
				}

				for (int i = x; i < x + w; i++) {
					for (int j = y; j < y + h; j++) {
						pixels2D[i][j] = 0;
					}
				}
				System.out.println(
						"Found " + name + " object with the size " + w + " X " + h + " at location : " + x + ", " + y);
			}
		}
	}

	public int readW(int x, int y) {
		int count = 0;
		int color = pixels2D[x][y];
		while (pixels2D[x][y] == color) {
			count++;
			x++;
		}
		return count;
	}

	public int readH(int x, int y) {
		int count = 0;
		int color = pixels2D[x][y];
		while (pixels2D[x][y] == color) {
			count++;
			y++;
		}
		return count;
	}

	public void outputCode() {
		System.out.println("\nOutput\n");
		for (Platform p : platformBlocks) {
			System.out.println("levelPlatforms.add(new Platform(" + p.getXPos() + ", " + p.getYPos() + ", "
					+ p.getWidth() + ", " + p.getHeight() + ", " + "null" + "));");
		}
		for (Platform h : horizontalMovingPlatformBlocks) {
			System.out.println("levelPlatforms.add(new Platform(" + h.getXPos() + ", " + h.getYPos() + ", "
					+ h.getWidth() + ", " + h.getHeight() + ", " + "null" + ", "  + h.getxDisplacement() + ", "  + h.getyDisplacement()
					+ ", " + h.isVerticalMove() + ", "  + h.isHorizontalMove() + "));");
		}
		for (Platform v : verticalMovingPlatformBlocks) {
			System.out.println("levelPlatforms.add(new Platform(" + v.getXPos() + ", " + v.getYPos() + ", "
					+ v.getWidth() + ", " + v.getHeight() + ", " + "null" + ", "  + v.getxDisplacement() + ", "  + v.getyDisplacement()
					+ ", " + v.isVerticalMove() + ", "  + v.isHorizontalMove() + "));");
		}
		for (Button b : buttonBlocks) {
			System.out.println("levelButtons.add(new Button(" + b.getXPos() + ", " + b.getYPos() + ", " + "null, "
					+ "null" + "));");
		}
		for (Laser l : laserBlocks) {
			System.out.println("levelLasers.add(new Laser(" + l.getXPos() + ", " + l.getYPos() + ", " + l.getWidth()
					+ ", " + l.getHeight() + ", " + "true" + "));");
		}
		System.out.println("doorBlock = new Door(" + doorBlock.getXPos() + ", " + doorBlock.getYPos() + ");");
		if (crateonBlock != null) {
			System.out.println("player = new Crateon(" + crateonBlock.getxPos() + ", " + crateonBlock.getyPos() + ");");
		} else if (caseyBlock != null) {
			System.out.println("player = new Casey(" + caseyBlock.getxPos() + ", " + caseyBlock.getyPos() + ");");
		}
		System.out.println("\nEnd of level");
	}
}