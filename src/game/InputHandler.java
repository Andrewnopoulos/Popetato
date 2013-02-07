package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class InputHandler implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener{

	/**
	 * adds KeyListener, MouseListener and MouseMotionListeners to game
	 */
	public InputHandler(Game game) {
		game.addMouseListener(this);
		game.addKeyListener(this);
		game.addMouseMotionListener(this);
		game.addMouseWheelListener(this);
	}
	
	/**
	 * boolean array that represent if each key is being pressed
	 */
	private boolean[] keys = new boolean[120];
	
	/**
	 * booleans that tell if the up, down, left and right keys are being pressed
	 */
	public boolean up, down, left, right;
	
	public void update() {
		up = keys[KeyEvent.VK_UP]  || keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_DOWN]  || keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_LEFT]  || keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_RIGHT]  || keys[KeyEvent.VK_D];
		
		
//		for (int i = 0; i < keys.length; i++) {
//			if (keys[i]) {
//				System.out.println("KEY: " + i);
//			}
//		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		
	}
	
}
