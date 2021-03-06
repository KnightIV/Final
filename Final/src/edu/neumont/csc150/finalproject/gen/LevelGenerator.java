package edu.neumont.csc150.finalproject.gen;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

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
	private int horizontalMovingPlatformColor = 0xfff200;
	private int verticalMovingPlatformColor = 0x22cae5;
	private int doorColor = 0xA349A4;
	private int buttonColor = 0xB97A57;
	private int laserColor = 0xED1C24;
	private int crateonColor = 0x22B14C;
	private int caseyColor = 0xfb71f0;

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
		try {
			l.searchPixels();
		} catch (IOException e) {
			e.printStackTrace();
		}
		l.outputCode();
	}

	public void getPixels() {
		try {
			BufferedImage level = ImageIO.read(new File("Levels/Level3.png"));
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

	public void searchPixels() throws IOException {
		System.out.println("Searching for objects...");
		int w, h;
		
		String name = "";
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				if (pixels2D[x][y] == platformColor) {
					name = "platform";
				} else if (pixels2D[x][y] == horizontalMovingPlatformColor) {
					name = "horizontal platform";
				} else if (pixels2D[x][y] == verticalMovingPlatformColor) {
					name = "vertical platform";
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
					platformBlocks.add(new Platform(x, y, w, h));
				} else if (name.equals("horizontal platform")) {
					horizontalMovingPlatformBlocks.add(new Platform(x, y, w, h, 10, 0, false, true, 0));
				} else if (name.equals("vertical platform")) {
					verticalMovingPlatformBlocks.add(new Platform(x, y, w, h, 0, 10, true, false, 0));
				} else if (name.equals("button")) {
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
		while (x < 2560 && pixels2D[x][y] == color) {
			count++;
			x++;
		}
		return count;
	}

	public int readH(int x, int y) {
		int count = 0;
		int color = pixels2D[x][y];
		while (y < 1440 && pixels2D[x][y] == color) {
			count++;
			y++;
		}
		return count;
	}

	public void outputCode() {
		System.out.println("\nOutput\n");
		for (Platform p : platformBlocks) {
			System.out.println("levelPlatforms.add(new Platform(" + p.getxPos() + ", " + p.getyPos() + ", "
					+ p.getWidth() + ", " + p.getHeight() + "));");
		}
		for (Platform h : horizontalMovingPlatformBlocks) {
			System.out.println("levelPlatforms.add(new Platform(" + h.getxPos() + ", " + h.getyPos() + ", "
					+ h.getWidth() + ", " + h.getHeight() + ", " + h.getxDisplacement() + ", "
					+ h.getyDisplacement() + ", " + h.isVerticalMove() + ", " + h.isHorizontalMove() + "));");
		}
		for (Platform v : verticalMovingPlatformBlocks) {
			System.out.println("levelPlatforms.add(new Platform(" + v.getxPos() + ", " + v.getyPos() + ", "
					+ v.getWidth() + ", " + v.getHeight() + ", " + v.getxDisplacement() + ", "
					+ v.getyDisplacement() + ", " + v.isVerticalMove() + ", " + v.isHorizontalMove() + "));");
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