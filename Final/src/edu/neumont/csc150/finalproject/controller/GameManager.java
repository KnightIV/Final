package edu.neumont.csc150.finalproject.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.Timer;

import edu.neumont.csc150.finalproject.model.Game;
import edu.neumont.csc150.finalproject.model.Level;
import edu.neumont.csc150.finalproject.view.MainGUI;

public class GameManager implements ActionListener {

	private Game curGame;
	private static final File FILE_SAVE = new File("save.box");
	private Timer timer;
	private ArrayList<Level> levels;
	private int indexLevel;
	private MainGUI view;
	private InputControl input;
	
	public GameManager() {
		createLevels();
	}
	
	private void createLevels() {
		// copy and paste the code generated from the level code generator
	}
	
	public void run() {
		// call the main menu to display from the GUI
	}
	
	public void autoSave() throws IOException {
		ObjectOutputStream save = null;
		
		try {
			save = new ObjectOutputStream(new FileOutputStream(FILE_SAVE));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
		save.writeObject(curGame);
		
		// display something to let the player know that the game has been saved
	}
	
	public void load() throws IOException {
		ObjectInputStream load = null;
		
		try {
			load = new ObjectInputStream(new FileInputStream(FILE_SAVE));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			curGame = (Game) load.readObject();
		} catch (ClassNotFoundException e) {
			// let the player know that no save data exists
			
			e.printStackTrace();
		}
		
		/*
		 * let the player know that the game has been loaded, and then go to the level that they were on
		 */
		
		indexLevel = levels.indexOf(curGame.getCurLevel());
		curGame.reset();
	}
	
	public void pause() {
		timer.stop();
	}
	
	public void resume() {
		timer.start();
	}
	
	public void switchLevel() {
		indexLevel++;
		curGame.setCurLevel(levels.remove(indexLevel));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
