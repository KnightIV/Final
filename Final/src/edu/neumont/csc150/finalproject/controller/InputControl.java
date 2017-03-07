package edu.neumont.csc150.finalproject.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import edu.neumont.csc150.finalproject.model.Game;

public class InputControl implements KeyListener {

	private Game curGame;
	private ArrayList<Integer> keysPressed;

	public InputControl(Game curGame) {
		keysPressed = new ArrayList<>();
		this.curGame = curGame;
	}

	private void keyControls() {
		if (keysPressed.contains(KeyEvent.VK_UP)) {
			curGame.jump();
		}

		if (keysPressed.contains(KeyEvent.VK_RIGHT)) {
			curGame.movePlayer(true);
		} else if (keysPressed.contains(KeyEvent.VK_LEFT)) {
			curGame.movePlayer(false);
		} else {
			curGame.stopHorizontalPlayer();
		}

		for (int key : keysPressed) {
			if (key == KeyEvent.VK_W || key == KeyEvent.VK_S || key == KeyEvent.VK_A || key == KeyEvent.VK_D) {
				curGame.playerPowerActivate(key);
				break;
			}
		}
	}
	
	public void reset() {
		while (keysPressed.size() > 0) {
			keysPressed.remove(0);
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if (!keysPressed.contains(arg0.getKeyCode())) {
			keysPressed.add(arg0.getKeyCode());
		}
		keyControls();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		if (keysPressed.contains(arg0.getExtendedKeyCode())) {
			keysPressed.remove((Integer) arg0.getKeyCode());
		}
		keyControls();
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
}