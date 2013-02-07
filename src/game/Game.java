package game;

import game.graphics.Screen;
import game.level.Level;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	
	public static int width = 480;
	public static int height = 270;
	public static int scale = 2;
	public static String title = "A Game";
	public static final Dimension DIMENSIONS = new Dimension(width*scale, height*scale);
	
	private Thread thread;
	private JFrame frame;
	
	private boolean running = false;
	
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	
	private Screen screen;
	private InputHandler input;
	
	private Level level;
	
	public Game() {
		setPreferredSize(DIMENSIONS);
		frame = new JFrame();
		frame.setResizable(false);
		frame.add(this);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		init();
	}
	
	public void init() {
		screen = new Screen(width, height);
		input = new InputHandler(this);
		level = new Level("/level.png");
	}
	
	public synchronized void start() {
		running = true;
		thread = new Thread(this, title + "_main");
		thread.start();
	}
	
	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000D / 60D;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		requestFocus();
		
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime)/ns;
			lastTime = now;
			while (delta >= 1) {
				update();
				updates++;
				delta--;
			}
			render();
			frames++;
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frame.setTitle(title + " | " + updates + " ups, " + frames + " fps");
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}
	
	public void update() {
		input.update();
	}
	
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		screen.clear();
		screen.render();
		
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}
		
		level.render(screen);
		
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image,  0,  0,  getWidth(), getHeight(), null);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Verdana", 0, 10));
		g.drawString(title, 0, 100);
		g.drawString("Andrew Giannopoulos", 0, 111);
		g.setColor(Color.RED);
		g.dispose();
		bs.show();
		
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.start();
	}
	
}
