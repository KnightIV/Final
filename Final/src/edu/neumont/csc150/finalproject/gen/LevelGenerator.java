package edu.neumont.csc150.finalproject.gen;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import edu.neumont.csc150.finalproject.model.Button;
import edu.neumont.csc150.finalproject.model.Laser;
import edu.neumont.csc150.finalproject.model.Platform;

public class LevelGenerator {

	private int[] pixels;
	private int[][] pixels2D;
	private int width = 0, height = 0;

	private int platformColor = 0x6372204;
	private int doorColor = 0x16373164;
	private int buttonColor = 0x18512287;
	private int laserColor = 0x2372836;
	private int characterColor = 0x3417776;

	private ArrayList<Platform> platformBlocks = new ArrayList<>();
	private ArrayList<Button> buttonBlocks = new ArrayList<>();
	private ArrayList<Laser> laserBlocks = new ArrayList<>();
	 

	public static void main(String[] args) {

	}

	public void getPixels(String filename) {
		System.out.println("Reading \"" + filename + "\"...");
		try {
			BufferedImage level = ImageIO.read(new File(filename));
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
		System.out.println("\nSearching for objects...");
		int w, h;
		URL backgroundLoc = null;
		try {
			backgroundLoc = new URL("Assets/Untitled.png");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		ImageIcon background = new ImageIcon(backgroundLoc); 
		
		String name = "";
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (pixels2D[i][j] == platformColor) {
					name = "platform";
				}
				else if(pixels2D[i][j] == doorColor){
                    name = "door";
                }
                else if(pixels2D[i][j] == buttonColor){ 
                    name = "button";
                }
                else if(pixels2D[i][j] == laserColor){
                    name = "laser";
                }
                else if(pixels2D[i][j] == characterColor){
                    name = "character";
                }
                else continue;
				w = readW(i,j); 
                h = readH(i,j); 
                if(name.equals("platform")) {
                	platformBlocks.add(new Platform(i, j, w, h, background));
                }
                else if (name.equals("button")) {
                	
                }
                
			}
		}
	}
	
	public int readW(int i, int j){ 
        int count = 0; 
        int color = pixels2D[i][j];
        while(pixels2D[i][j] == color){
            count++;
            i++;
        }
        return count;
    }
	
	public int readH(int i, int j){ 
        int count = 0; 
        int color = pixels2D[i][j];
        while(pixels2D[i][j] == color){
            count++;
            j++;
        }
        return count;
    }

}
