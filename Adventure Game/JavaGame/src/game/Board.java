package game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

import game.models.Boss;
import game.models.ColliderBox;
import game.models.RectangleBox;
import game.models.Scene;

public class Board extends JPanel implements ActionListener{

	private final int DELAY = 10;
	private Timer timer;
	private Boss boss;
	private RectangleBox box;
	private ColliderBox block;
	private Rectangle playerHitBox;
	private Rectangle blockHitBox;
	private Rectangle blockHitBox1;
	private Scene scene;
	private Stroke stroke = new BasicStroke(6f);
	
	public Board() {
		addKeyListener(new TAdapter());
		setPreferredSize(new Dimension(350, 250));
		setFocusable(true);
		
		boss = new Boss();
		scene = new Scene();
		box = new RectangleBox();
		block = new ColliderBox();
		timer = new Timer(DELAY, this);
		timer.start();
		
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		Toolkit.getDefaultToolkit().sync();
		g2d.drawImage(scene.getImage(), scene.getX(), scene.getY(), this);
		g2d.drawImage(box.getImage(), box.getX(), box.getY(), box.getWidth(), box.getHeight(), this);//sprite dentro da hitbox g2d.drawImage(boss.getImage(), boss.getX(), boss.getY(), this);
		g2d.setColor(Color.RED);
		g2d.setStroke(stroke);
		g2d.drawRect(285,  0, 45, 345);
		repaint();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		step();
	}
	private void step() {
		// TODO Auto-generated method stub
		box.boxMove();
		playerHitBox = box.getBounds(box.getX(), box.getY());
		blockHitBox = block.getBounds(285, 0, 45, 345);
		checkCollision();
		repaint();
	}
	public void checkCollision() {
		if(playerHitBox.intersects(blockHitBox)) {
			if(box.lastMove == "UP") {
				playerHitBox = box.getBounds(box.getX(), box.getY() + 2);
			}
			if(box.lastMove == "DOWN") {
				playerHitBox = box.getBounds(box.getX(), box.getY() - 2);
			}
			if(box.lastMove == "LEFT") {
				playerHitBox = box.getBounds(box.getX() + 2, box.getY());
			}
			if(box.lastMove == "RIGHT") {
				playerHitBox = box.getBounds(box.getX() - 2, box.getY());
			}
		}
	}
	private class TAdapter extends KeyAdapter{
		
		@Override
		public void keyPressed(KeyEvent e) {
			box.keyPressed(e);
		}
		@Override
		public void keyReleased(KeyEvent e) {
			box.keyReleased(e);
		}
	}
	
}
